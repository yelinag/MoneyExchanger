import manager.Exchanger;

public class Main {

    static final String RATES_FILE = "rates.csv";
    static final String TRANSACTIONS_FILE = "transactions.csv";
    static final String OUTPUT_FILE = "expected-output.csv";

    public static void main(String[] args){
        Exchanger exchanger = new Exchanger(RATES_FILE, TRANSACTIONS_FILE,
                OUTPUT_FILE);
        exchanger.process();
    }

}
