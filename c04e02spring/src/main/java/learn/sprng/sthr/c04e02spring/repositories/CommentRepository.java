package learn.sprng.sthr.c04e02spring.repositories;

import learn.sprng.sthr.c04e02spring.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);
}
