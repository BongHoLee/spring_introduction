package hello.servlet.web.frontcontroller.v2_view;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2_view.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2_view.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2_view.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        // 요청 URI를 얻어온다.
        String requestURI = request.getRequestURI();

        // 요청 URI에 해당하는 controller를 Map에서 가져온다.
        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 요청에 해당하는 컨트롤러에 메시지를 전송하고 MyView를 반환받는다.
        MyView myView = controller.process(request, response);


        myView.render(request, response);
    }
}
