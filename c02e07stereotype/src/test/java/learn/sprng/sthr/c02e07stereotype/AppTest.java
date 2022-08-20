package learn.sprng.sthr.c02e07stereotype;

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
    @DisplayName("Test that a Parrot instance with the name Sparrow has been added to the Spring context.")
    void testParrotWasAdded() {
        Parrot p = context.getBean(Parrot.class);
        assertEquals("Sparrow", p.getName());
    }
}
