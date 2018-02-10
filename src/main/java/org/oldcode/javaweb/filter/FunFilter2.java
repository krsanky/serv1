package org.oldcode.javaweb.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FunFilter2 implements Filter {
    private static final Logger log = LogManager.getLogger(FunFilter2.class);
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("FunFilter2 init()...");
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        log.debug("FunFilter2 doFilter()...");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		log.debug("ff2 Requested Resource::"+uri);

		HttpSession session = req.getSession(false);

		//if( session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))) {
		//	this.context.log("Unauthorized access request");
		//	res.sendRedirect("login.html");
		//} else {
		//	// pass the request along the filter chain
		//	chain.doFilter(request, response);
		//}

        chain.doFilter(request, response);
	}

    @Override
    public void destroy() {
        log.debug("FunFilter2 destroy()...");
    }

}
