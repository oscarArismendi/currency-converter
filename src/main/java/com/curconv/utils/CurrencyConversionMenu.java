package com.curconv.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.curconv.exchangeRateAPI.domain.entity.ExchangeRate;

public class CurrencyConversionMenu {
    private static final int PAGE_SIZE = 10;

    public static void showMenu(ExchangeRate exchangeRate) {
        Map<String, Double> conversionRates = exchangeRate.getConversionRates();
        if (conversionRates == null || conversionRates.isEmpty()) {
            System.out.println("No rates available for conversion.");
            return;
        }

        // Sort currencies alphabetically
        List<String> sortedCurrencies = new ArrayList<>(conversionRates.keySet());
        Collections.sort(sortedCurrencies);

        Scanner scanner = new Scanner(System.in);
        int currentPage = 0;

        while (true) {
            // Calculate start and end indices for the current page
            int start = currentPage * PAGE_SIZE;
            int end = Math.min(start + PAGE_SIZE, sortedCurrencies.size());

            // Display the menu
            System.out.println("\nAvailable Currencies (Page " + (currentPage + 1) + "):");
            for (int i = start; i < end; i++) {
                System.out.printf("%d. %s%n", (i % PAGE_SIZE) + 1, sortedCurrencies.get(i));
            }

            int optionIndex = end - start + 1; // Next available option number
            int extra = 0;
            if (currentPage > 0) {
                System.out.printf("%d. Previous%n", optionIndex+extra);
                extra++;
            }
            if (end < sortedCurrencies.size() - 10) {
                System.out.printf("%d. Next%n", optionIndex+extra);
                extra++;
            }
            System.out.printf("%d. Exit%n", optionIndex+extra);

            // Prompt the user for a choice
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == optionIndex + extra) {
                // Exit
                System.out.println("Exiting menu.");
                break;
            } else if (currentPage > 0 && choice == 11 && start > 0) {
                // Previous page
                currentPage--;
            } else if (end < sortedCurrencies.size() - 10 && choice == 11 && extra == 1) {
                // Next page
                currentPage++;
            } else if (end < sortedCurrencies.size() - 10 && choice == 12 && extra == 2) {
                // Next page
                currentPage++;
            } else if (choice >= 1 && choice <= (end - start)) {
                // Select a currency
                String selectedCurrency = sortedCurrencies.get(start + choice - 1);
                double conversionRate = conversionRates.get(selectedCurrency);
                System.out.printf("Conversion Rate for %s: %.4f%n", selectedCurrency, conversionRate);
                System.out.println("Input the value USD that you want to convert:");
                Double dollars;
                while (true) {
                    System.out.print("$ ");
                    if (scanner.hasNextDouble()) {
                        dollars = scanner.nextDouble();
                        if (dollars < 0) {
                            System.out.println("Amount cannot be less than zero. Please try again.");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Clear the invalid input
                    }
                }
                System.out.printf("$%.4f USD are $%.4f %s%n",dollars, conversionRate * dollars, selectedCurrency);
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
