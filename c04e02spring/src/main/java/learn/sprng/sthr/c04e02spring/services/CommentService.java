package learn.sprng.sthr.c04e02spring.services;

import learn.sprng.sthr.c04e02spring.model.Comment;
import learn.sprng.sthr.c04e02spring.repositories.CommentRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationService commentNotificationService;

    public CommentService(CommentRepository commentRepository, CommentNotificationService commentNotificationService) {
        this.commentRepository = commentRepository;
        this.commentNotificationService = commentNotificationService;
        System.out.println("CommentService instance created.");
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationService.sendComment(comment);
    }
}
