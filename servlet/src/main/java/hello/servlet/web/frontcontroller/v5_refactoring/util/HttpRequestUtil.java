package hello.servlet.web.frontcontroller.v5_refactoring.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestUtil {
    public static Map<String, String> paramMapOf(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }

    public static String uriOf(HttpServletRequest request) {
        return request.getRequestURI();
    }
}
