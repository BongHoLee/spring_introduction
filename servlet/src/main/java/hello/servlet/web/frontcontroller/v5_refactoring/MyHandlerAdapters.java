package hello.servlet.web.frontcontroller.v5_refactoring;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyHandlerAdapters {
    private final List<MyHandlerAdapter> adapters = new ArrayList<>();
    private final List<MyHandlerMapping> mappings = new ArrayList<>();

    public MyHandlerAdapters() {
        init();
    }

    private void init() {
        initAdapters();
        initMappings();
    }

    private void initAdapters() {

    }

    private void initMappings() {

    }

    // 두 가지 작업처럼 보이는 것들의 추상화 수준이 동등하다고 판단.
    // 그리고 문맥이 동일하여 한 가지 책임을 수행한다고 판단.
    public ModelView adapt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청을 처리할 핸들러 매핑
        Object handler = clientRequestMappingToHandler(request);

        // 핸들러와 협력할 어댑터를 찾아 처리 메시지 전송
        return adaptHandler(handler, request, response);

    }

    private Object clientRequestMappingToHandler(HttpServletRequest request) {
        for (MyHandlerMapping mapping : mappings) {
            if (mapping.canMappingToHandler(request)) {
                return mapping.getHandler(request);
            }
        }

        throw new IllegalArgumentException("요청을 매핑할 수 없슴둥 " + request);
    }

    private ModelView adaptHandler(Object handler, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (MyHandlerAdapter adapter : adapters) {
            if (adapter.supports(handler)) {
                return adapter.handle(handler, request, response);
            }
        }

        throw new IllegalArgumentException("핸들러 어댑터를 찾을 수 없슴둥 " + handler);
    }

}
