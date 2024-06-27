import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        final String adminName = "admin";
        final String adminPass = "1234";
        boolean continue_ = true;

        File file = new File("admin.txt");
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("apple\n" + "orange\n" + "mango\n" + "banana\n" + "watermelon\n" + "pineapple\n" + "grapes\n");
            writer.close();
            // ArrayList<String> list = new ArrayList<>();
        }
        File file1 = new File("consumer.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }

        System.out.println("\n----------------Fruity Shop----------------");
        System.out.print("Enter \"admin\" or \"consumer\": ");
        String login = input.next();
        if (login.equalsIgnoreCase("admin")) {
            System.out.print("Username: ");
            String name = input.next();
            System.out.print("Password: ");
            String password = input.next();
            if ((name.equals(adminName)) && (password.equals(adminPass))) {
                System.out.println("\n--------------------------------------------");
                while (continue_) {
                    System.out.println("[1] View fruits");
                    System.out.println("[2] Add fruit");
                    System.out.println("[3] Delete fruit");
                    System.out.println("[4] Search fruit");
                    System.out.print("Input a number: ");
                    String choice = input.next();
                    if (choice.equals("1"))
                        viewFruit();
                    if (choice.equals("2"))
                        addFruit();
                    // if (choice.equals("3"))
                    // deleteFruit();
                    // if (choice.equals("4"))
                    // searchFruit();
                    System.out.print("\nDo you want to Continue [Y/N]: ");
                    continue_ = isContinue(input.next());
                    System.out.println();
                }
            } else if ((!name.equals(adminName)) && (!password.equals(adminPass))) {
                System.out.println("Invalid username and input");
            } else if (!name.equals(adminName)) {
                System.out.println("Invalid username");
            } else if (!password.equals(adminPass)) {
                System.out.println("Invalid password");
            } else {
                System.out.println("No Input");
            }
        }
    }

    public static boolean isContinue(String choice) {
        if (choice.equalsIgnoreCase("y"))
            return true;
        else
            return false;
    }

    public static void viewFruit() throws FileNotFoundException {
        System.out.println();
        System.out.println("----------------Fruity Shop----------------");
        Scanner reader = new Scanner(new FileReader("admin.txt"));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        reader.close();
    }

    public static void addFruit() throws Exception {
        System.out.print("Enter Fruit: ");
        String fruit = input.next();

        FileWriter writer = new FileWriter("admin.txt", true);
        writer.write(fruit);
        writer.close();
        System.out.println("You have successfully added a record!");
    }
}
