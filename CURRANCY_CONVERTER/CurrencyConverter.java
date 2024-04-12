import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>();

    static {
        //  exchange rates
        EXCHANGE_RATES.put("USD", 1.0); // Base currency
        EXCHANGE_RATES.put("EUR", 0.85);
        EXCHANGE_RATES.put("GBP", 0.72);
        EXCHANGE_RATES.put("JPY", 110.45);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies: USD, EUR, GBP, JPY");
        System.out.println("Enter the base currency:");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the target currency:");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    public static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double baseRate = EXCHANGE_RATES.getOrDefault(baseCurrency, 1.0);
        double targetRate = EXCHANGE_RATES.getOrDefault(targetCurrency, 1.0);

        // Convert the amount from the base currency to the target currency
        return amount * (targetRate / baseRate);
    }
}
