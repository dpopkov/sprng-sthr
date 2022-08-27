package learn.sprng.sthr.c06e01aspects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.mockito.BDDMockito.atLeastOnce;
import static org.mockito.BDDMockito.then;

@ExtendWith( {SpringExtension.class, MockitoExtension.class} )
@ContextConfiguration(classes = { ProjectConfig.class })
class AppTest {

    @Mock
    private Logger serviceLogger;
    @Mock
    private Logger aspectLogger;

    @Autowired
    private LoggingAspect loggingAspect;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    void setUp() {
        commentService.setLogger(serviceLogger);
        loggingAspect.setLogger(aspectLogger);
    }

    @Test
    @DisplayName("The aspect intercepts and alters the execution of the publishComment() method.")
    void testAspectInterceptsPublishCommentMethod() {
        Comment comment = new Comment();
        comment.setAuthor("Test author");
        comment.setText("Test text");

        commentService.publishComment(comment);

        then(aspectLogger).should(atLeastOnce()).info("Method will execute");
        then(serviceLogger).should().info("Publishing comment: " + comment.getText());
        then(aspectLogger).should(atLeastOnce()).info("Method executed");
    }

    @Test
    @DisplayName("The aspect intercepts and alters the execution of the publishCommentRet() method.")
    void testAspectInterceptsPublishCommentRetMethod() {
        Comment comment = new Comment();
        comment.setAuthor("Test author");
        comment.setText("Test text");

        commentService.publishCommentRet(comment);

        then(aspectLogger).should(atLeastOnce()).info("Method publishCommentRet with parameters ["
                + comment + "] will execute");
        final String changedText = "Changed text";
        then(serviceLogger).should().info("Publishing comment: " + changedText);
        then(aspectLogger).should(atLeastOnce()).info("Method executed and returned SUCCESS");
    }
}
