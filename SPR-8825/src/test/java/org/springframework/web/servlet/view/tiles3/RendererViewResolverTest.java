package org.springframework.web.servlet.view.tiles3;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.render.Renderer;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;

public class RendererViewResolverTest {

    private RendererViewResolver testTarget;
    private ApplicationContext tilesContext;
    private WebApplicationContext springContext;
    private AutowireCapableBeanFactory beanFactory;
    private ServletContext servletContext;
    private Renderer renderer;
    private String contentType;
    private Locale locale;

    @Before
    public void setUp() {
        tilesContext = createMock(ApplicationContext.class);
        springContext = createMock(WebApplicationContext.class);
        servletContext = createMock(ServletContext.class);
        beanFactory = createMock(AutowireCapableBeanFactory.class);
        renderer = createMock(Renderer.class);
        expect(springContext.getServletContext()).andReturn(servletContext).anyTimes();
        expect(springContext.getAutowireCapableBeanFactory()).andReturn(beanFactory).anyTimes();
        contentType = "application/test";
        locale = Locale.ITALY;
        testTarget = new RendererViewResolver();
        testTarget.setTilesContext(tilesContext);
        testTarget.setRenderer(renderer);
        testTarget.setContentType(contentType);
    }

    @Test
    public void testResolve() throws Exception {
        expect(renderer.isRenderable(eq("/template.test"), isA(Request.class))).andReturn(true);
        expect(renderer.isRenderable(eq("/nonexistent.test"), isA(Request.class))).andReturn(false);
        expect(beanFactory.initializeBean(isA(RendererView.class), eq("/template.test")))
                .andAnswer(new IAnswer<RendererView>() {

                    @Override
                    public RendererView answer() throws Throwable {
                        return (RendererView)EasyMock.getCurrentArguments()[0];
                    }

                });
        replay(tilesContext, springContext, servletContext, beanFactory, renderer);
        testTarget.setApplicationContext(springContext);
        assertTrue(testTarget.resolveViewName("/template.test", locale) instanceof RendererView);
        assertNull(testTarget.resolveViewName("/nonexistent.test", locale));
        verify(tilesContext, springContext, servletContext, beanFactory, renderer);
    }
}
