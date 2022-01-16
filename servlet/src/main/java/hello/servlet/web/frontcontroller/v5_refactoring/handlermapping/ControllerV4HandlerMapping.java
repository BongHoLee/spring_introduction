package hello.servlet.web.frontcontroller.v5_refactoring.handlermapping;

import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet.web.frontcontroller.v5_refactoring.MyHandlerMapping;
import hello.servlet.web.frontcontroller.v5_refactoring.util.HttpRequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerMapping implements MyHandlerMapping {
    private final Map<String, ControllerV4> handlerMap = new HashMap<>();

    public ControllerV4HandlerMapping() {
        init();
    }

    private void init() {
        handlerMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
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
