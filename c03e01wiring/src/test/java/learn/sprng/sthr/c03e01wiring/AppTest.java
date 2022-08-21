package learn.sprng.sthr.c03e01wiring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class})
class AppTest {

    @Autowired
    ApplicationContext context;

    @Test
    @DisplayName("Test that the Person instance in the Spring context owns the Parrot instance from the Spring context")
    void testThatPersonHasParrot() {
        Person person = context.getBean("person1", Person.class);
        assertNotNull(person);
        Parrot parrot = person.getParrot();
        assertNotNull(parrot);
        assertEquals("Sparrow", parrot.getName());
        Parrot bean = context.getBean(Parrot.class);
        assertSame(bean, parrot);
    }

    @Test
    @DisplayName("Test that two Person instances own the same Parrot instance from the Spring context")
    void testThatTwoPersonsHaveTheSameInjectedParrot() {
        Person person1 = context.getBean("person1", Person.class);
        assertNotNull(person1);
        Person person2 = context.getBean("person2", Person.class);
        assertNotNull(person2);

        assertSame(person1.getParrot(), person2.getParrot());
    }
}
