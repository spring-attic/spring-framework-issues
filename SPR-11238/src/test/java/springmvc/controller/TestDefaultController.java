package springmvc.controller;

import bsh.ParseException;
import springmvc.model.Member;
import javax.servlet.http.HttpServletRequest;
import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.springframework.test.util.JsonPathExpectationsHelper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import springdao.DaoManager;
import springdao.RepositoryManager;

/**
 *
 * @author kent
 */
@WebAppConfiguration
@ContextConfiguration(classes = springmvc.context.TestContext.class)
public class TestDefaultController extends AbstractTestNGSpringContextTests {

    private static Logger logger = LogManager.getLogger(TestDefaultController.class);
    @Autowired
    WebApplicationContext wac;
    private MockMvc mockMvc;
    @DaoManager
    private RepositoryManager<Member> memberManager;

    @BeforeClass
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
    }

    @Test
    void testDevice() throws Exception {
        MvcResult mvcResult =mockMvc.perform(get("/").param("device", "mobile")).andExpect(request().asyncStarted())
                .andExpect(request().asyncResult("index")).andReturn();
        mockMvc.perform(asyncDispatch(mvcResult)).andExpect(model().attribute("device", is(equalTo("mobile"))));
    }

    public <T> ResultMatcher asyncJsonPath(final String expression, final Matcher<T> matcher) {
        return new ResultMatcher() {
            @Override
            public void match(MvcResult result) throws ParseException, java.text.ParseException {
                HttpServletRequest request = result.getRequest();
                assertThat("Async not started.", request.isAsyncStarted());
                Object res = result.getAsyncResult();
                assertThat("Not string return.", res, is(instanceOf(String.class)));
                new JsonPathExpectationsHelper(expression).assertValue((String) res, matcher);
            }
        };
    }
    
    
    @Test
    public void testListuser() throws Exception {
        String ql = new StringBuilder("SELECT COUNT(").append(memberManager.getAliasName()).append(") FROM ")
                .append(memberManager.getEntityName()).append(" AS ").append(memberManager.getAliasName())
                .append(" WHERE ").append(memberManager.getAliasName()).append(".enabled=?1").toString();
        int count = memberManager.findUniqueByQL(Long.class, ql, "Y").intValue();
        mockMvc.perform(post("/admin/users")).andExpect(request().asyncStarted())
                .andExpect(asyncJsonPath("$.total", is(equalTo(count)))).andDo(print());
    }

    @Test
    public void testMyinfo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/user/myinfo").principal(new TestingAuthenticationToken("admin", null)))
                .andExpect(request().asyncStarted()).andExpect(request().asyncResult(is(not(isEmptyOrNullString())))).andReturn();
        mvcResult = mockMvc.perform(asyncDispatch(mvcResult)).andReturn();
        Member member = (Member) mvcResult.getRequest().getAttribute("member");
        logger.debug("My account is \"{}\" and my name is {}", member.getId(), member.getName());
        assertThat("Test UserInfo error ", "admin", is(equalTo(member.getId())));
    }

    @Test
    public void testUserInfo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/admin/user/{account}", "admin"))
                .andExpect(request().asyncStarted()).andExpect(request().asyncResult(is(not(isEmptyOrNullString())))).andReturn();
        mvcResult = mockMvc.perform(asyncDispatch(mvcResult)).andReturn();
        Member member = (Member) mvcResult.getRequest().getAttribute("member");
        logger.debug("account \"{}\" name is {}", member.getId(), member.getName());
        assertThat("Test UserInfo error ", "admin", is(equalTo(member.getId())));
    }
}
