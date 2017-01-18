package filters;

/**
 * Created by olexandra on 18.01.17.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogFilter implements Filter {
    static int countRequests = 0;
    static String filetOutput;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init() method is called once when the filter is initialized.");
        String contRequests = filterConfig.getInitParameter("countRequests");
        if (contRequests != "0") {
            this.countRequests = 0;
        }
//        this.filetOutput = "LogFilter";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Request of type " + ((HttpServletRequest) servletRequest).getMethod()
                + " is passing from the URL: " + ((HttpServletRequest) servletRequest).getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Number of requests is: " + ++countRequests);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy filter LogFilter");
    }
}
