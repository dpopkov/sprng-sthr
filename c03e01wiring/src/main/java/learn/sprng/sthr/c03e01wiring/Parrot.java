package learn.sprng.sthr.c03e01wiring;

public class Parrot {
    private String name;

    public Parrot() {
        System.out.println("Parrot created.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
