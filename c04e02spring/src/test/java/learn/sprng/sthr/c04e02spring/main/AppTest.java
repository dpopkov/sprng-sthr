package learn.sprng.sthr.c04e02spring.main;

import learn.sprng.sthr.c04e02spring.model.Comment;
import learn.sprng.sthr.c04e02spring.repositories.CommentRepository;
import learn.sprng.sthr.c04e02spring.services.CommentNotificationService;
import learn.sprng.sthr.c04e02spring.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AppTest {

    @Mock
    CommentRepository commentRepository;
    @Mock
    CommentNotificationService commentNotificationService;
    @InjectMocks
    CommentService commentService;

    @Test
    @DisplayName("Verify that dependencies of the CommentService are correctly called.")
    void testCommentService() {
        Comment comment = new Comment();

        commentService.publishComment(comment);

        then(commentRepository).should().storeComment(comment);
        then(commentNotificationService).should().sendComment(comment);
    }
}
