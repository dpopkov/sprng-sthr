package learn.sprng.sthr.c04e02spring.services;

import learn.sprng.sthr.c04e02spring.model.Comment;

public interface CommentNotificationService {

    void sendComment(Comment comment);
}
