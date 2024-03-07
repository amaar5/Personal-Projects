import java.io.*;
import java.util.*;

public class LoginSystem {
    private static final String USERS_FILE = "users.txt";

    public static void main(String[] args) {
        Map<String, String> users = loadUsers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register(users, scanner);
                    break;
                case "2":
                    login(users, scanner);
                    break;
                case "3":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Map<String, String> loadUsers() {
        Map<String, String> users = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                users.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            // File does not exist yet, return empty map
        }
        return users;
    }

    private static void saveUser(String username, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE, true))) {
            writer.println(username + " " + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register(Map<String, String> users, Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        saveUser(username, password);
        System.out.println("Registration successful.");
    }

    private static void login(Map<String, String> users, Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
