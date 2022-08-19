package learn.sprng.sthr.c02e01beans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("A Poppo instance with the attribute name having the value Poppo has been added to the Context")
    void testPoppoIsInTheSpringContext() {
        Parrot p = context.getBean("parrot", Parrot.class);
        assertEquals("Poppo", p.getName());
    }

    @Test
    @DisplayName("A Parrot instance named riki has the name Riki.")
    public void testParrot2HasTheNameRiki() {
        Parrot p = context.getBean("riki", Parrot.class);
        assertEquals("Riki", p.getName());
    }

    @Test
    @DisplayName("The String 'hello' has been added to the Spring context.")
    public void testHelloIsInTheSpringContext() {
        String s = context.getBean(String.class);
        assertEquals("Hello", s);
    }

    @Test
    @DisplayName("Test that the Integer 20 has been added to the Spring context.")
    public void test10IsInTheSpringContext() {
        Integer i = context.getBean(Integer.class);
        assertEquals(20, i);
    }
}
