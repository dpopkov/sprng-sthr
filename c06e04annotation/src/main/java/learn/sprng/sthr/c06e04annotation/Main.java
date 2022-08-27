package learn.sprng.sthr.c06e04annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("James");
        comment.setText("Test text");

        CommentService service = context.getBean(CommentService.class);
        service.editComment(comment);
        service.publishComment(comment);
        service.deleteComment(comment);
    }
}
