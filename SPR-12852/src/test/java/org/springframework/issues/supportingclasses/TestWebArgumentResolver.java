package org.springframework.issues.supportingclasses;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class TestWebArgumentResolver implements WebArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest nativeWebRequest) throws Exception {
        return null;
    }

}
