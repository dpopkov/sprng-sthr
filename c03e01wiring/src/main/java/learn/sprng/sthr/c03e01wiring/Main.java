package learn.sprng.sthr.c03e01wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person1 = context.getBean("person1", Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println(person1);
        System.out.println(parrot);

        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);
    }
}
