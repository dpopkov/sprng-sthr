package learn.sprng.sthr.c04e01nospring.services;

import learn.sprng.sthr.c04e01nospring.model.Comment;
import learn.sprng.sthr.c04e01nospring.repositories.CommentRepository;

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
