package learn.sprng.sthr.c03e10qualifier;

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
    ApplicationContext context;

    @Test
    @DisplayName("Test that the Person owns a qualified Parrot")
    void testThatPersonOwnsParrot() {
        Person p = context.getBean(Person.class);
        assertNotNull(p);
        Parrot parrot = p.getParrot();
        assertNotNull(parrot);
        assertEquals("Sparrow", parrot.getName());
    }
}
