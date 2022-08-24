package learn.sprng.sthr.c04e02spring.services;

import learn.sprng.sthr.c04e02spring.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationService implements CommentNotificationService {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }
}
