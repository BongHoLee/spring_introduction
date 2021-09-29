package userorder.userorder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 기존에 @Configuration으로 등록한 AppConfig 등을 컴포넌트 스캔 대상에서 제외하기 위해 임의로 추가함.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
