package basics.core.xml;

import basics.core.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.support.GenericXmlContextLoader;

import java.security.GeneralSecurityException;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext gac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = gac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
