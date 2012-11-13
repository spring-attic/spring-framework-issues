package org.springframework.web.servlet.view.tiles3;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.render.Renderer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.StaticWebApplicationContext;

public class RendererViewResolverTest {

    private RendererViewResolver testTarget;
    private ApplicationContext tilesContext;
    private StaticWebApplicationContext springContext;
    private AutowireCapableBeanFactory beanFactory;
    private TilesContainer tilesContainer;
    private Renderer renderer;
    private String contentType;
    private Locale locale;

    @Before
    public void setUp() {
        tilesContext = createMock(ApplicationContext.class);

		springContext = new StaticWebApplicationContext();
		springContext.setServletContext(new MockServletContext());
		springContext.refresh();

        beanFactory = createMock(AutowireCapableBeanFactory.class);
        tilesContainer = createMock(TilesContainer.class);
        renderer = createMock(Renderer.class);
        Map<String,Object> appScope = new HashMap<String,Object>();
        appScope.put(TilesAccess.CONTAINER_ATTRIBUTE, tilesContainer);
        expect(tilesContext.getApplicationScope()).andReturn(appScope).anyTimes();
        expect(tilesContext.getContext()).andReturn(springContext).anyTimes();
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
        replay(tilesContext, beanFactory, renderer);
        testTarget.setApplicationContext(springContext);
        assertTrue(testTarget.resolveViewName("/template.test", locale) instanceof RendererView);
        assertNull(testTarget.resolveViewName("/nonexistent.test", locale));
        verify(tilesContext, beanFactory, renderer);
    }
}
