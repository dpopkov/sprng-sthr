package learn.sprng.sthr.c02e01beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*
            If specifying only a class you will get NoUniqueBeanDefinitionException.
         */
        Parrot p = context.getBean("parrot", Parrot.class);
        System.out.println(p.getName());
        Parrot p2 = context.getBean("riki", Parrot.class);
        System.out.println(p2.getName());
        Parrot p3 = context.getBean("tiki", Parrot.class);
        System.out.println(p3.getName());

        String h = context.getBean(String.class);
        System.out.println(h);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
