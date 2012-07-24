package org.springframework.web.servlet.view.tiles3;

import java.util.Locale;

import org.apache.tiles.request.DispatchRequest;
import org.apache.tiles.request.DispatchRequestWrapper;

public class SpringRequest extends DispatchRequestWrapper {

    private Locale locale;

    protected SpringRequest(DispatchRequest context, Locale locale) {
        super(context);
        this.locale = locale;
    }

    @Override
    public Locale getRequestLocale() {
        return locale;
    }
}