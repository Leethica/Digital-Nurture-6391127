public class NotificationService {

    interface Notifier {
        void send(String to, String message);
    }

    static class UserService {
        private Notifier notifier;

        public UserService(Notifier notifier) {
            this.notifier = notifier;
        }

        public void registerUser(String name, String email) {

            System.out.println("User registered: " + name);

            notifier.send(email, "Welcome " + name + "!");
        }
    }

    static class MockNotifier implements Notifier {
        public String lastTo = null;
        public String lastMessage = null;
        public boolean sendCalled = false;

        @Override
        public void send(String to, String message) {
            sendCalled = true;
            lastTo = to;
            lastMessage = message;
        }
    }

    public static void main(String[] args) {
        MockNotifier mock = new MockNotifier();
        UserService userService = new UserService(mock);

        userService.registerUser("Alice", "alice@example.com");

        if (mock.sendCalled &&
            "alice@example.com".equals(mock.lastTo) &&
            "Welcome Alice!".equals(mock.lastMessage)) {
            System.out.println("testInteractionVerification passed");
        } else {
            System.out.println("testInteractionVerification failed");
            System.out.println("sendCalled: " + mock.sendCalled);
            System.out.println("to: " + mock.lastTo);
            System.out.println("msg: " + mock.lastMessage);
        }
    }
}
