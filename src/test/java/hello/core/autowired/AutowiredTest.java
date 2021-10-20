package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        AutowiredBean autowiredBean = ac.getBean("autowiredBean", AutowiredBean.class);
        System.out.println("autowiredBean = " + autowiredBean);
    }

    @ComponentScan(
            basePackages = "hello.core.autowired"
    )
    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired(required = false)
        public void setNoBean2(AutowiredBean autowiredBean) {
            System.out.println("autowiredBean = " + autowiredBean);
        }

        @Autowired
        public void setNoBean3(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean4(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }

        @Autowired
        public void setNoBean5(Optional<AutowiredBean> autowiredBean) {
            System.out.println("noBean4 = " + autowiredBean);
        }

    }
}
