package learn.sprng.sthr.c04e01nospring.main;

import learn.sprng.sthr.c04e01nospring.model.Comment;
import learn.sprng.sthr.c04e01nospring.repositories.CommentRepository;
import learn.sprng.sthr.c04e01nospring.repositories.DbCommentRepository;
import learn.sprng.sthr.c04e01nospring.services.CommentNotificationService;
import learn.sprng.sthr.c04e01nospring.services.CommentService;
import learn.sprng.sthr.c04e01nospring.services.EmailCommentNotificationService;

public class Main {

    public static void main(String[] args) {
        CommentRepository commentRepository = new DbCommentRepository();
        CommentNotificationService commentNotificationService = new EmailCommentNotificationService();

        CommentService commentService = new CommentService(commentRepository, commentNotificationService);

        Comment comment = new Comment();
        comment.setAuthor("James");
        comment.setText("Test comment");

        commentService.publishComment(comment);
    }
}
