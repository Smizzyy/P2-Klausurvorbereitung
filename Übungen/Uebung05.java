enum TransactionType {
    DEPOSIT,
    WITHDRAWAL;
}

class BankAccount {

    // statische Klasse
    static class Transaction {
        double amont;
        TransactionType type;
    }

    // innere Klasse
    class AccountHolder {
        String name;
        int age;
    }
}
