package learn.sprng.sthr.c06e06order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

@ExtendWith({ SpringExtension.class, MockitoExtension.class })
@ContextConfiguration(classes = { ProjectConfig.class })
class AppTest {
    @Mock
    Logger securityLogger;
    @Mock
    Logger loggingLogger;
    @Mock
    Logger serviceLogger;
    @Autowired
    SecurityAspect securityAspect;
    @Autowired
    LoggingAspect loggingAspect;
    @Autowired
    CommentService commentService;

    @BeforeEach
    void setUp() {
        loggingAspect.setLogger(loggingLogger);
        securityAspect.setLogger(securityLogger);
        commentService.setLogger(serviceLogger);
    }

    @Test
    @DisplayName("Security Aspect intercepts before Logging Aspect")
    void testThatAspectsInterceptInOrder() {
        Comment comment = new Comment();
        comment.setAuthor("Author");
        comment.setText("Using Order annotation");

        commentService.publishComment(comment);

        InOrder inOrder = Mockito.inOrder(securityLogger, loggingLogger, serviceLogger);
        inOrder.verify(securityLogger).info("Security Aspect: Calling the intercepted method");
        inOrder.verify(loggingLogger).info("Logging Aspect: Calling the intercepted method");
        inOrder.verify(serviceLogger).info("Publishing comment: Using Order annotation");
        inOrder.verify(loggingLogger).info("Logging Aspect: Method executed and returned SUCCESS");
        inOrder.verify(securityLogger).info("Security Aspect: Method executed and returned SUCCESS");
    }
}
