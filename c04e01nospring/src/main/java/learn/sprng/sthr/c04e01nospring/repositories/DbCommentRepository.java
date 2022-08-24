package learn.sprng.sthr.c04e01nospring.repositories;

import learn.sprng.sthr.c04e01nospring.model.Comment;

public class DbCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
