package hello.servlet.web.frontcontroller.v5_refactoring;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    ModelView handle(Object handler, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
