package learn.sprng.sthr.c04e02spring.main;

import learn.sprng.sthr.c04e02spring.config.ProjectConfig;
import learn.sprng.sthr.c04e02spring.model.Comment;
import learn.sprng.sthr.c04e02spring.services.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("James");
        comment.setText("Test comment");

        System.out.println("Before retrieving the CommentService");
        CommentService commentService = context.getBean(CommentService.class);
        System.out.println("After retrieving the CommentService");
        commentService.publishComment(comment);
    }
}
