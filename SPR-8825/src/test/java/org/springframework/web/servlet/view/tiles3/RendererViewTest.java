package org.springframework.web.servlet.view.tiles3;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.impl.BasicTilesContainer;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.render.Renderer;
import org.easymock.Capture;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.theme.FixedThemeResolver;

public class RendererViewTest {
    private RendererView testTarget;
    private ApplicationContext applicationContext;
    private Renderer renderer;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Object> model;
    private String path;
    private String contentType;
    private Locale locale;
    private StaticWebApplicationContext springContext;

    @Before
    public void setUp() {
        springContext = new StaticWebApplicationContext();
        springContext.setServletContext(new MockServletContext());
        springContext.refresh();

        path = "/template.test";
        contentType = "application/test";
        locale = Locale.ITALY;

        request = new MockHttpServletRequest();
        request.setAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE, springContext);
        request.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE, new AcceptHeaderLocaleResolver());
        request.setAttribute(DispatcherServlet.THEME_RESOLVER_ATTRIBUTE, new FixedThemeResolver());

        response = new MockHttpServletResponse();
        response.setContentType(contentType);

        applicationContext = createMock(ApplicationContext.class);
        Map<String, Object> appScope = new HashMap<String, Object>();
        appScope.put(TilesAccess.CONTAINER_ATTRIBUTE, new BasicTilesContainer());
        expect(applicationContext.getApplicationScope()).andReturn(appScope).anyTimes();
        renderer = createMock(Renderer.class);
        model = new HashMap<String, Object>();
        model.put("modelAttribute", "modelValue");
        testTarget = new RendererView();
        testTarget.setTilesApplicationContext(applicationContext);
        testTarget.setRenderer(renderer);
        testTarget.setUrl(path);
        testTarget.setLocale(locale);
    }

    @Test
    public void testRender() throws Exception {
        request.setAttribute("modelAttribute", "modelValue");
        Capture<Request> renderableRequest = new Capture<Request>();
        expect(renderer.isRenderable(eq(path), and(isA(Request.class), capture(renderableRequest)))).andReturn(true);
        Capture<Request> renderRequest = new Capture<Request>();
        renderer.render(eq(path), and(isA(Request.class), capture(renderRequest)));
        replay(applicationContext, renderer);
        testTarget.setApplicationContext(springContext);
        testTarget.setContentType(contentType);
        testTarget.render(model, request, response);
        assertEquals(renderableRequest.getValue().getRequestLocale(), locale);
        assertSame("isRenderable and render received different requests", renderableRequest.getValue(),
                renderRequest.getValue());
        verify(applicationContext, renderer);
    }

    @Test
    public void testRenderNoAttributes() throws Exception {
        Capture<Request> renderableRequest = new Capture<Request>();
        expect(renderer.isRenderable(eq(path), and(isA(Request.class), capture(renderableRequest)))).andReturn(true);
        Capture<Request> renderRequest = new Capture<Request>();
        renderer.render(eq(path), and(isA(Request.class), capture(renderRequest)));
        replay(applicationContext, renderer);
        testTarget.setApplicationContext(springContext);
        testTarget.setContentType(contentType);
        testTarget.setExposeModelInRequest(false);
        testTarget.render(model, request, response);
        assertEquals(renderableRequest.getValue().getRequestLocale(), locale);
        assertSame("isRenderable and render received different requests", renderableRequest.getValue(),
                renderRequest.getValue());
        verify(applicationContext, renderer);
    }

    @Test
    public void testNotRenderable() throws Exception {
        expect(renderer.isRenderable(eq(path), isA(Request.class))).andReturn(false);
        replay(applicationContext, renderer);
        testTarget.setApplicationContext(springContext);
        testTarget.setContentType(contentType);
        testTarget.setExposeModelInRequest(false);
        testTarget.render(model, request, response);
        verify(applicationContext, renderer);
    }
}
