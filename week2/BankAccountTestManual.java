    public class BankAccountTestManual {

    static class BankAccount {
        private String owner;
        private double balance;

        public BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            }
        }

        public double getBalance() {
            return balance;
        }

        public String getOwner() {
            return owner;
        }
    }

    BankAccount account;

    void setUp() {
        account = new BankAccount("Alice", 1000.0);
        System.out.println("Setup complete");
    }

    void tearDown() {
        System.out.println("Teardown complete\n");
    }

    void testDeposit() {
        setUp(); 
        account.deposit(500.0); 
        if (account.getBalance() == 1500.0) { 
            System.out.println("testDeposit passed");
        } else {
            System.out.println("testDeposit failed");
        }
        tearDown();
    }

    void testWithdraw() {
        setUp();
        account.withdraw(300.0);
        if (account.getBalance() == 700.0) {
            System.out.println("testWithdraw passed");
        } else {
            System.out.println("testWithdraw failed");
        }
        tearDown();
    }

    void testOverWithdraw() {
        setUp();
        account.withdraw(2000.0);
        if (account.getBalance() == 1000.0) {
            System.out.println("testOverWithdraw passed");
        } else {
            System.out.println("testOverWithdraw failed");
        }
        tearDown();
    }

    public static void main(String[] args) {
        BankAccountTestManual tester = new BankAccountTestManual();
        tester.testDeposit();
        tester.testWithdraw();
        tester.testOverWithdraw();
    }
}
