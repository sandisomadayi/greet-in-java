package net.greet;


import java.util.Scanner;

public class Greeter {

    private static final String BLUE = "\033[0;34m";
    private static final String RESET = "\033[0m";

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
                    System.out.println(BLUE + greet.help() + RESET);
                }
                else if (command.equals("count")) {
                    System.out.println(greet.counter());
                }
                else if (command.equals("greeted")) {
                    try {
                        String name = inputs[1].toLowerCase();
                        if (name.equals(null)) {
                            System.out.println(greet.greeted(null));
                        }
                        else {
                            System.out.println(greet.greeted(name));
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
//                        String name = inputs[1].toLowerCase();
                        System.out.println(greet.greeted(null));
                    }
                }
                else if (command.equals("clear")) {
                    try {
                        String name = inputs[1].toLowerCase();
                        if (name.equals(null)) {
                            System.out.println(greet.clear(null));
                        }
                        else {
                            System.out.println(greet.clear(name));
                        }
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(greet.clear(null));
                    }
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
                else if (command.equals("clear")) {
                    greet.clear(name);
                }
                else if (command.equals("greeted")) {
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
