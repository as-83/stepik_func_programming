package stepic.t4s1;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

final class CommentUtils {
    /**
     * An example string that fits the format "15-03-2020 10:20:34".
     * Use it to print the comments.
     */
    public static final SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private CommentUtils() { }

    /**
     * It processes a given list of comments by removing old comments and shortening the text length
     */
    public static void handleComments(List<Comment> comments, Date thresholdDate, int maxTextLength) {

        comments.removeIf(comment ->  comment.getCreated().after(thresholdDate));

        comments.forEach(comment -> {
            if (comment.getText().length() > maxTextLength ) {
                Comment newComment = new Comment(comment.getCreated(), comment.getText().substring(0, maxTextLength));
                comments.set(comments.indexOf(comment),newComment);
            }
        });

    }

    /**
     * It prints each comment in the following format:
     * [14-03-2020 10:20:34] What a beautiful photo! Where is it?
     * [16-03-2020 15:35:18] I do not know, I just found it on the internet!
     * [20-03-2020 19:10:22] Is anyone here?
     * Please, use the formatter above to fit the format.
     */
    public static void printComments(List<Comment> comments) {
        comments.forEach(c -> System.out.println("[" + TEXT_FORMATTER.format(c.getCreated()) +
                "] " + c.getText()));
    }
}

class Comment {
    private final Date created;
    private final String text;

    public Comment(Date created, String text) {
        this.created = created;
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public String getText() {
        return text;
    }
}
