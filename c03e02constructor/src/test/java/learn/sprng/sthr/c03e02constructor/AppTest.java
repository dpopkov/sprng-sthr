package learn.sprng.sthr.c03e02constructor;

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
    @DisplayName("Person owns injected Parrot and the same Parrot is maintained by context")
    void testThatPersonOwnsInjectedParrot() {
        Person person = context.getBean(Person.class);
        Parrot parrot = person.getParrot();
        assertNotNull(parrot);
        assertEquals("Sparrow", parrot.getName());
        Parrot bean = context.getBean(Parrot.class);
        assertSame(parrot, bean);
    }
}
