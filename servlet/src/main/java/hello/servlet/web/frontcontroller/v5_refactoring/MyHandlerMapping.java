package hello.servlet.web.frontcontroller.v5_refactoring;

import hello.servlet.web.frontcontroller.v5_refactoring.MyHandlerAdapter;

import javax.servlet.http.HttpServletRequest;

public interface MyHandlerMapping {
    boolean canMappingToHandler(HttpServletRequest request);

    public Object getHandler(HttpServletRequest request);
}
