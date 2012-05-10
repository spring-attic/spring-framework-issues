package org.springframework.web.servlet.view.tiles3;

import java.util.Locale;

import org.apache.tiles.request.DefaultRequestWrapper;
import org.apache.tiles.request.Request;

public class SpringRequest extends DefaultRequestWrapper {

    private Locale locale;

    protected SpringRequest(Request context, Locale locale) {
        super(context);
        this.locale = locale;
    }

    @Override
    public Locale getRequestLocale() {
        return locale;
    }
}