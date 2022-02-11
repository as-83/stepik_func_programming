package stepic.t6s1;

import java.util.stream.Stream;

public class UserGenerator {
    public static void main(String[] args) {
        Utils.generateUsers(3).forEach(user-> System.out.println(user.getId()+" "+user.getEmail()));
    }
}

final class Utils {

    private Utils() { }

    public static Stream<User> generateUsers(int numberOfUsers) {
        return Stream.iterate(1, i -> i <= numberOfUsers,i -> i + 1)
                .map(i -> new User(i, "user" + i + "@gmail.com"));
    }
}

class User {
    private final long id;
    private final String email;

    User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
