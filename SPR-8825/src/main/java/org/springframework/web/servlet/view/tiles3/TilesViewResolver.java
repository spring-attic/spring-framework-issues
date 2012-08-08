package org.springframework.web.servlet.view.tiles3;

import java.util.Locale;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.renderer.DefinitionRenderer;

/**
 * 
 */
public class TilesViewResolver extends RendererViewResolver {

    @Override
    protected RendererView loadView(String viewName, Locale locale) throws Exception {
        if(getRenderer() == null) {
            setRenderer(new DefinitionRenderer(TilesAccess.getContainer(getTilesContext())));
        }
        return super.loadView(viewName, locale);
    }
}
