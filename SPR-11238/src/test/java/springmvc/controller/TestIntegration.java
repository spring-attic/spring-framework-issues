package springmvc.controller;

import com.thoughtworks.selenium.DefaultSelenium;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Kent Yeh
 */
@Test(groups = {"integrate"})
public class TestIntegration {

    private static Logger logger = LogManager.getLogger(TestIntegration.class);
    protected DefaultSelenium selenium = null;
    private int httpPort = 80;
    private String contextPath = "";

    @BeforeClass
    @Parameters({"browser", "http.port","contextPath"})
    public void setup(@Optional("iexplore") String browser, @Optional("http.port") int httpPort, @Optional("contextPath") String contextPath) {
        logger.debug("Selenium client starting with {} ...", browser);
        this.httpPort = httpPort;
        logger.debug("http port is {}", httpPort);
        selenium = new DefaultSelenium("localhost", 4444, "*" + browser, String.format("http://localhost:%d/%s/index", httpPort, contextPath));
        this.contextPath = contextPath;
        selenium.start();
        selenium.setTimeout("600000");
    }

    @AfterClass
    public void tearDown() {
        if (selenium != null) {
            selenium.stop();
            logger.debug("Selenium client stoped");
        }
    }

    @Test
    public void logout() {
        String url=String.format("http://localhost:%d/%s/j_spring_security_logout", httpPort,contextPath);
        logger.debug("Integration Test: logout with {}",url);
        selenium.open(url);
        selenium.waitForPageToLoad("300000");
        logger.debug("logout redirect to {}", selenium.getLocation());
        assertThat("logout failed ", selenium.getLocation(), is(containsString("/index")));
    }

    @Test
    public void test404() {
        String url = String.format("http://localhost:%d/%s/unknownpath/404.html", httpPort,contextPath);
        logger.debug("Integration Test: test404 with {}",url);
        selenium.open(url);
        selenium.waitForPageToLoad("30000");
        assertThat("Failed to show error page", selenium.getTitle(), is(equalTo("Error Prone")));
    }

    @Test
    public void testMyInfo() {
        logger.debug("Integration Test: testMyinfo");
        selenium.open(String.format("http://localhost:%d/%s/user/myinfo", httpPort,contextPath));
        selenium.waitForPageToLoad("60000");
        selenium.type("id=userid", "admin");
        selenium.type("id=password", "admin");
        selenium.click("css=input[type=\"submit\"]");
        selenium.waitForPageToLoad("60000");
        assertThat("Fail to get My Info", selenium.getText("//h1"), is(containsString("admin")));
    }
}
