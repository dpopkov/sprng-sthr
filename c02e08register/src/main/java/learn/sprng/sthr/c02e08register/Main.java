package learn.sprng.sthr.c02e08register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot x = new Parrot();
        x.setName("James");

        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean("parrot",
                Parrot.class,
                parrotSupplier,
                beanDefinition -> beanDefinition.setPrimary(true));

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}
