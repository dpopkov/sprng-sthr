package learn.sprng.sthr.c06e04annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.mockito.BDDMockito.then;

@ExtendWith({ SpringExtension.class, MockitoExtension.class })
@ContextConfiguration(classes = { ProjectConfig.class })
class AppTest {

    @Autowired
    CommentService service;
    @Autowired
    LoggingAspect aspect;
    @Mock
    Logger serviceLogger;
    @Mock
    Logger aspectLogger;

    @BeforeEach
    void setUp() {
        service.setLogger(serviceLogger);
        aspect.setLogger(aspectLogger);
    }

    @Test
    void testThatDeleteCommentIsLogged() {
        Comment comment = new Comment();
        comment.setAuthor("Author");
        comment.setText("Text");

        service.deleteComment(comment);

        then(aspectLogger).should().info("Method deleteComment with parameters ["
                + comment + "] will execute");
        then(serviceLogger).should().info("Deleting comment: Text");
        then(aspectLogger).should().info("Method executed and returned " + comment);
    }
}
