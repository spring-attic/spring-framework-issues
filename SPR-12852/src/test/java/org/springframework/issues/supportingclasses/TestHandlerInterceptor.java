package org.springframework.issues.supportingclasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestHandlerInterceptor extends HandlerInterceptorAdapter {
    Logger log = LoggerFactory.getLogger(TestHandlerInterceptor.class);


}
