package net.greet;


import java.util.Scanner;

public class Greeter {

    public static void main(String[] args) {
        Greet greet = new Greet("", Language.english);
        Scanner scanner = new Scanner(System.in);
        //greet.useScanner();
        while (true) {
            System.out.println("Enter a command");
            String input = scanner.nextLine();
            String[] inputs = input.split(" ");
            String command = inputs[0].toLowerCase();

            if (inputs.length == 1) {
                if (command.equals("exit")) {
                    break;
                }
                else if (command.equals("help")) {
                    System.out.println(greet.help());
                }
                else if (command.equals("greeted")) {
                    System.out.println(greet.greeted());
                }
                else if (command.equals("clear")) {
                    greet.clearMap();
                }
                else if (command.equals("count")) {
                    System.out.println(greet.counter());
                }
                else {
                    System.out.println("Invalid command!");
                    System.out.println(greet.help());
                }
            }
            else if (inputs.length == 2) {
                String name = inputs[1].toLowerCase();
                if (command.equals("greet")) {
                    System.out.println(greet.greet(name, "english"));
                }
                else if (input.equals("clear " + name)) {
                    greet.clearUserName(name);
                }
                else if (input.equals("greeted " + name)) {
                    System.out.println(greet.greeted(name));
                }
                else {
                    System.out.println("Invalid command!");
                    System.out.println(greet.help());
                }
            }
            else if (inputs.length == 3) {
                if (command.equals("greet")) {
                    String name = inputs[1].toLowerCase();
                    String language = inputs[2].toLowerCase();
                    System.out.println(greet.greet(name, language));
                }
                else {
                    System.out.println("Invalid command!");
                    System.out.println(greet.help());
                }
            }
        }
    }
}
