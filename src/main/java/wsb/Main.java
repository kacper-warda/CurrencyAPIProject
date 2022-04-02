package wsb;

public class Main {
    public static void main(String[] args) {
        CurrencyAPIConnector connector = new CurrencyAPIConnector();
        System.out.println(connector.getHistoricalData("USD", "2022-01-01"));
    }
}

