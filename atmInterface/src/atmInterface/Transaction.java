package atmInterface;

class Transaction {
    private String type;
    private double amount;
    private double postBalance;

    public Transaction(String type, double amount, double postBalance) {
        this.type = type;
        this.amount = amount;
        this.postBalance = postBalance;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount + ", Balance after transaction: " + postBalance;
    }
}
