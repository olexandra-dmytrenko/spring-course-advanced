package filters;

/**
 * Created by olexandra on 18.01.17.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogFilter implements Filter {
    static int countRequests = 0;
    static int countResponses = 0;
    static String filetOutput;
    private FilterConfig filerConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init() method is called once when the filter is initialized.");
        String contRequests = filterConfig.getInitParameter("countRequests");
        if (contRequests != "0") {
            this.countRequests = 0;
        }
//        this.filetOutput = "LogFilter";
        this.filerConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Server info: " + this.filerConfig.getServletContext().getServerInfo().toString());
        System.out.println("Request of type " + ((HttpServletRequest) servletRequest).getMethod()
                + " is passing from the URL: " + ((HttpServletRequest) servletRequest).getRequestURL());
        System.out.println("Number of requests is: " + ++countRequests);
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Response of type " + ((HttpServletResponse) servletResponse).getStatus()
                + " and headers " + ((HttpServletResponse) servletResponse).getHeaderNames());
        //filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Number of responses is: " + ++countResponses);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy filter LogFilter");
    }
}
