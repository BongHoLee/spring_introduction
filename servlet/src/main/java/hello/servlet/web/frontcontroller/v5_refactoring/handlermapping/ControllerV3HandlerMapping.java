package hello.servlet.web.frontcontroller.v5_refactoring.handlermapping;

import hello.servlet.web.frontcontroller.v3_viewandmodel.ControllerV3;
import hello.servlet.web.frontcontroller.v3_viewandmodel.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3_viewandmodel.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3_viewandmodel.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet.web.frontcontroller.v5_refactoring.MyHandlerMapping;
import hello.servlet.web.frontcontroller.v5_refactoring.util.HttpRequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerMapping implements MyHandlerMapping {
    private final Map<String, ControllerV3> handlerMap = new HashMap<>();

    public ControllerV3HandlerMapping() {
        init();
    }

    private void init() {
        handlerMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }

    @Override
    public boolean canMappingToHandler(HttpServletRequest request) {
        return handlerMap.containsKey(HttpRequestUtil.uriOf(request));
    }

    @Override
    public Object getHandler(HttpServletRequest request) {
        return handlerMap.get(HttpRequestUtil.uriOf(request));
    }
}
