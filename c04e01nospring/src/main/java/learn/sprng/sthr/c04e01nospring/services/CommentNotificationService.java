package learn.sprng.sthr.c04e01nospring.services;

import learn.sprng.sthr.c04e01nospring.model.Comment;

public interface CommentNotificationService {

    void sendComment(Comment comment);
}
