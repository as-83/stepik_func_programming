package stepic.t7s1.p2;

class Notifier {
    private NotificationStrategy notificationStrategy;
    public Notifier(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void makeNotify(User user) {
        notificationStrategy.notifyCustomer(user);
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }
}

interface NotificationStrategy {
    void notifyCustomer(User user);
}
// create NotificationStrategy interface and Notifier class here
interface SMSService {

    void sendSMS(User user);
}

interface EmailService {

    void sendEmail(User user);
}
//in the Application class run method that accepts a user, send an email and after that
// change the strategy and send SMS.
// Use functional approach (lambdas and method references) while implementing the pattern
class Application {

    private EmailService emailService;
    private SMSService smsService;

    public Application(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void run(User user) {
        // write your code here
        Notifier notifier = new Notifier((user1) -> smsService.sendSMS(user1));
        notifier.makeNotify(user);
        notifier.setNotificationStrategy((user1) -> emailService.sendEmail(user1));
        notifier.makeNotify(user);
    }
}

class User {
    private final String email;
    private final String phoneNumber;

    User(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
