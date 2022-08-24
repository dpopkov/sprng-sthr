package learn.sprng.sthr.c04e02spring.services;

import learn.sprng.sthr.c04e02spring.model.Comment;
import learn.sprng.sthr.c04e02spring.repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationService commentNotificationService;

    public CommentService(CommentRepository commentRepository, CommentNotificationService commentNotificationService) {
        this.commentRepository = commentRepository;
        this.commentNotificationService = commentNotificationService;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationService.sendComment(comment);
    }
}
