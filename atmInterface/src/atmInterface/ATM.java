package atmInterface;

public class ATM {
    public static void main(String[] args) {
        Account userAccount = new Account("123456789", 1000.0);
        User user = new User("user1", "1234", userAccount);

        ATMService atmService = new ATMService();
        atmService.start(user);
    }
}
