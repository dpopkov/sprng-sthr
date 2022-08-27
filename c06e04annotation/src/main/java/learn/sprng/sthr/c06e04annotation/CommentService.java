package learn.sprng.sthr.c06e04annotation;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }

    @ToLog
    public Comment deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
        return comment;
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
