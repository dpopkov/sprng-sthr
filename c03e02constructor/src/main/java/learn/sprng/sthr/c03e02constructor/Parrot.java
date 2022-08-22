package learn.sprng.sthr.c03e02constructor;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private final String name = "Sparrow";

    public Parrot() {
        System.out.println("Parrot created.");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
