package org.springframework.web.servlet.view.tiles3;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Locale;

import org.apache.tiles.request.Request;
import org.junit.Before;
import org.junit.Test;

public class SpringRequestTest {
    private Request request;
    private SpringRequest testTarget;

    @Before
    public void setUp() {
        request = createMock(Request.class);
        testTarget = new SpringRequest(request, Locale.ITALY);
    }

    @Test
    public void testGetRequestLocale() {
        // do not expect(request.getRequestLocale()).andReturn(Locale.ENGLISH);
        replay(request);
        assertEquals(Locale.ITALY, testTarget.getRequestLocale());
        verify(request);
    }
}
