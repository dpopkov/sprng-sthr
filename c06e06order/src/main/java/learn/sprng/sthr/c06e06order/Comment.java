package learn.sprng.sthr.c06e06order;

public class Comment {
    private String text;
    private String author;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
