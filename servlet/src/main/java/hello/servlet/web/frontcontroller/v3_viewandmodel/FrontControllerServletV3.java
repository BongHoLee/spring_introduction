package hello.servlet.web.frontcontroller.v3_viewandmodel;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3_viewandmodel.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3_viewandmodel.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3_viewandmodel.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        // 요청 URI를 얻어온다.
        String requestURI = request.getRequestURI();

        // 요청 URI에 해당하는 controller를 Map에서 가져온다.
        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // request로부터 요청 파라미터를 map에 담는다.
        Map<String, String> paramMap = createParamMap(request);

        // 파라미터를 담은 map과 함께 컨트롤러에 메시지를 전송하여 ModelView를 반환받는다.
        ModelView mv = controller.process(paramMap);

        // 반환받은 model로부터 view의 '논리 이름'을 가져온다.
        String viewName = mv.getViewName();

        // view의 '논리 이름'으로부터 '물리 위치'를 반환받기 위해 viewResolver를 호출하여 MyView를 반환받는다.
        MyView view = viewResolver(viewName);

        // 최종적으로 MyView에 model을 담아 메시지를 전송한다.
        view.render(mv.getModel(), request, response);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
