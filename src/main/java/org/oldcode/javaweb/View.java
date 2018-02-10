package org.oldcode.javaweb;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class View {
    private static final Logger log = LogManager.getLogger(View.class);
    static final String TEMPLATE_ENGINE_KEY = "org.oldcode.javaweb.templateEngine";

    public static void Render(
            HttpServletRequest request,
            HttpServletResponse response,
            String template,
            Map<String, Object> context) {
        try {
            // engine has a cache for the template instances, so lets just use one of them:
            ServletContext ctx = request.getServletContext();
            PebbleEngine engine = (PebbleEngine) request.getServletContext().getAttribute(TEMPLATE_ENGINE_KEY);
            if (engine == null) {
                engine = new PebbleEngine.Builder().build();
                ctx.setAttribute(TEMPLATE_ENGINE_KEY, engine);
            }
            PebbleTemplate ptemplate = engine.getTemplate("template/" + template);

            Writer w = null;
            w = response.getWriter();
            ptemplate.evaluate(w, context);
            //w.flush();
            //w.close();
        } catch (Exception e) {
            log.debug("EXC:" + e.getMessage());
        }
    }
}
