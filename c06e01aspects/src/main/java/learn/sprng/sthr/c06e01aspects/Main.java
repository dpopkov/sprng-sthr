package learn.sprng.sthr.c06e01aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("James");
        comment.setText("Test text");

        CommentService service = context.getBean(CommentService.class);
        service.publishComment(comment);

        String result = service.publishCommentRet(comment);
        logger.info(result);
    }
}
