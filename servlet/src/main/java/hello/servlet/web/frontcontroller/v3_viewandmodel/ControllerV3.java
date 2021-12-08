package hello.servlet.web.frontcontroller.v3_viewandmodel;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    // 기존의 서블릿 종속성(HttpServletRequest, HttpServletResponse)를 제거
    ModelView process(Map<String, String> paramMap);
}
