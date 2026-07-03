package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("""
                    0 -> Exit
                    1 -> Add Item
                    2 -> Remove Item
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 0:
                    exit = true;
                    break;

                case 1:
                    System.out.println("Enter item(s):");
                    addItems(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Enter item(s):");
                    removeItems(scanner.nextLine());
                    break;

                default:
                    System.out.println("Invalid option.");
            }

            printSorted();
        }

        scanner.close();
    }

    public static void addItems(String input) {

        String[] items = input.split(",");

        for (String item : items) {

            item = item.trim();

            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {

        String[] items = input.split(",");

        for (String item : items) {

            item = item.trim();

            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {

        return groceryList.contains(product);
    }

    public static void printSorted() {

        Collections.sort(groceryList);

        System.out.println("Grocery List");

        for (String product : groceryList) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        startGrocery();
    }
}