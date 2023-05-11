package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printHeaders(req);

        String method = req.getMethod();
        String protocol = req.getProtocol();
        String queryString = req.getQueryString();
        String contentType = req.getContentType();
        int contentLength = req.getContentLength();

        System.out.println("protocol = " + protocol);
        System.out.println("method = " + method);
        System.out.println("queryString = " + queryString);
        System.out.println("contentType = " + contentType);
        System.out.println("contentLength = " + contentLength);
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- Header ---");

        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));
    }
}
