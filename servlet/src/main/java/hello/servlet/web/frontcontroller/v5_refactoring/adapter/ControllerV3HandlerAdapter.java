package hello.servlet.web.frontcontroller.v5_refactoring.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3_viewandmodel.ControllerV3;
import hello.servlet.web.frontcontroller.v5_refactoring.MyHandlerAdapter;
import hello.servlet.web.frontcontroller.v5_refactoring.util.HttpRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof ControllerV3;
    }

    @Override
    public ModelView handle(Object handler, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = HttpRequestUtil.paramMapOf(request);

        ModelView mv = controller.process(paramMap);

        return mv;
    }
}
