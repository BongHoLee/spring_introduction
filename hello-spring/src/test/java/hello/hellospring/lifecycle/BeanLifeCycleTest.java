package hello.hellospring.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        NetworkClient networkClient = ac.getBean(NetworkClient.class);

        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean(initMethod = "init")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();

            // 이처럼 먼저 객체를 생성하고 나서 외부에서 설정 값을 주입해야 하는 경우가 많다.
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }

    }
}
