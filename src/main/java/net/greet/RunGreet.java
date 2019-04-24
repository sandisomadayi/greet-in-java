package net.greet;


import java.util.Scanner;

public class RunGreet {

    private static final String RED = "\033[1;31m";
    private static final String RESET = "\033[0m";

    public static void main(String[] args) {

        Greeting greeting = new Greet("", Language.xhosa);
//        Greeting greeting = new DataBaseMethods();

        Scanner scanner = new Scanner(System.in);

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
                    System.out.println(greeting.help());
                }
                else if (command.equals("count")) {
                    System.out.println(greeting.counter());
                }
                else if (command.equals("greeted")) {
                    try {
                        String name = inputs[1].toLowerCase();
                        if (name.equals(null)) {
                            System.out.println(greeting.greeted(null));
                        }
                        else {
                            System.out.println(greeting.greeted(name));
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
//                        String name = inputs[1].toLowerCase();
                        System.out.println(greeting.greeted(null));
                    }
                }
                else if (command.equals("clear")) {
                    try {
                        String name = inputs[1].toLowerCase();
                        if (name.equals(null)) {
                            System.out.println(greeting.clear(null));
                        }
                        else {
                            System.out.println(greeting.clear(name));
                        }
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(greeting.clear(null));
                    }
                }
                else {
                    System.out.println(RED + "Invalid command!" + RESET);
                    System.out.println(greeting.help());
                }
            }
            else if (inputs.length == 2) {
                String name = inputs[1].toLowerCase();
                if (command.equals("greet")) {
                    System.out.println(greeting.greet(name, "english"));
                }
                else if (command.equals("clear")) {
                    greeting.clear(name);
                }
                else if (command.equals("greeted")) {
                    System.out.println(greeting.greeted(name));
                }
                else {
                    System.out.println(RED + "Invalid command!" + RESET);
                    System.out.println(greeting.help());
                }
            }
            else if (inputs.length == 3) {
                if (command.equals("greet")) {
                    String name = inputs[1].toLowerCase();
                    String language = inputs[2].toLowerCase();
                    System.out.println(greeting.greet(name, language));
                }
                else {
                    System.out.println(RED + "Invalid command!" + RESET);
                    System.out.println(greeting.help());
                }
            }
        }
    }
}
