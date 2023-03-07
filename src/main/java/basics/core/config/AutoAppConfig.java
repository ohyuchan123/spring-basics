package basics.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION)
)
public class AutoAppConfig {

    //컴포넌트 스캔을 사용하려면 먼저 @ComponentScan 을 설정 정보에 붙여주면 된다.
    //기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다!

    /*
    * @Bean(name = "memoryMemberRepository")
    * MemberRepository memberRepository(){
    *   return new MemoryMemberRepository();
    * } */

}
