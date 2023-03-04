package basics.core.beanfind;

import basics.core.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] bf = ac.getBeanDefinitionNames();

        for (String s : bf) {
            Object bean = ac.getBean(s);
            System.out.println("name = " + s+"object"+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();

        for (String getBeanDefinitionName : BeanDefinitionNames) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(getBeanDefinitionName);

            //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(getBeanDefinitionName);
                System.out.println("name=" + BeanDefinitionNames + " object=" +
                        bean);
            }
        }
    }

}
