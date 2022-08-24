package learn.sprng.sthr.c04e01nospring.services;

import learn.sprng.sthr.c04e01nospring.model.Comment;

public class EmailCommentNotificationService implements CommentNotificationService {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }
}
