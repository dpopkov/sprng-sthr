package learn.sprng.sthr.c03e02constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private Parrot parrot;

    /** This constructor is here to demonstrate the need for the Autowired annotation
        on the 2nd constructor. */
    public Person() {
    }

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    @Override
    public String toString() {
        return "Person: " + name + " with " + parrot;
    }
}
