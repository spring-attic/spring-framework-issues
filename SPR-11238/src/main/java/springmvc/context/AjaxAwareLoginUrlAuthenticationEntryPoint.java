package springmvc.context;

import java.io.IOException;
import java.nio.charset.Charset;  //before JDK1.7
//import java.nio.charset.StandardCharsets;//JDK 1.7
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.StringUtils;

/**
 *
 * @author Kent Yeh
 */
public class AjaxAwareLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private static Logger logger = LogManager.getLogger(AjaxAwareLoginUrlAuthenticationEntryPoint.class);
    @Autowired(required = false)
    @Qualifier("messageAccessor")
    MessageSourceAccessor messageAccessor;
    private String accessDenied = "Access denied! 人員未登錄，禁止存取 !";
    Map<String, Charset> charsets = Charset.availableCharsets(); //<JDK1.7

    public AjaxAwareLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        if (messageAccessor != null) {
            accessDenied = messageAccessor.getMessage("AbstractAccessDecisionManager.accessDenied", accessDenied);
        }
        //before JDK1.7
        accessDenied = new String(accessDenied.getBytes(charsets.get("UTF-8")), charsets.get("ISO-8859-1"));
        //JDK 1.7
        //accessDenied = new String(accessDenied.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));

    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            logger.debug("Ajax fail owing forbidden!");
            response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDenied);
        } else {
            String pathInfo = request.getServletPath();
            if (StringUtils.hasText(pathInfo) && pathInfo.contains("/json")) {
                logger.debug("Ajax fail owing forbidden!");
                response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDenied);
            } else {
                super.commence(request, response, authException);
            }
        }
    }
}