package learn.sprng.sthr.c06e06order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("James");
        comment.setText("Test text");

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
