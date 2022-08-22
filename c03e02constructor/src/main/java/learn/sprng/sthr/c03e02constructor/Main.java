package learn.sprng.sthr.c03e02constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot);

        Person person = context.getBean(Person.class);
        person.setName("Alice");
        System.out.println(person);
    }
}
