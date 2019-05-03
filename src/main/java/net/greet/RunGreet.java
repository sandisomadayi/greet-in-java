package net.greet;


import java.util.Scanner;

public class RunGreet {

    private static final String GREEN = "\033[1;32m";
    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[1;33m";  // YELLOW
    private static final String BLUE = "\033[1;34m";    // BLUE
    private static final String PURPLE = "\033[1;35m";  // PURPLE
    private static final String CYAN = "\033[1;36m";    // CYAN
    private static final String RED = "\033[1;31m";

    public static void main(String[] args) {

//        Greeting greeting = new Greet("", Language.xhosa);
        Greeting greeting = new JDBCGreet();

//        JDBCGreet jdbcGreet = new JDBCGreet();
//
//        System.out.println(jdbcGreet.greeted(null));
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
                    System.out.println(YELLOW + greeting.help() + RESET);
                }
                else if (command.equals("count")) {
                    System.out.println(CYAN + greeting.counter() + RESET);
                }
                else if (command.equals("greeted")) {
                    try {
                        String name = inputs[1].toLowerCase();
                        if (name.equals(null)) {
                            System.out.println(BLUE+ greeting.greeted(null) + RESET);
                        }
                        else {
                            System.out.println(CYAN + greeting.greeted(name) + RESET);
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
//                        String name = inputs[1].toLowerCase();
                        System.out.println(BLUE + greeting.greeted(null) + RESET);
                    }
                }
                else if (command.equals("clear")) {
                    try {
                        String name = inputs[1].toLowerCase();
                        if (name.equals(null)) {
                            System.out.println(RED + greeting.clear(null) + RESET);
                        }
                        else {
                            System.out.println(RED + greeting.clear(name) + RESET);
                        }
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(greeting.clear(null));
                    }
                }

                else {
                    System.out.println(RED +"Invalid command!" + RESET);
                    System.out.println(GREEN + greeting.help() + RESET);
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
                    System.out.println(RED +"Invalid command!" + RESET);
                    System.out.println(GREEN + greeting.help() + RESET);
                }
            }
            else if (inputs.length == 3) {
                if (command.equals("greet")) {
                    String name = inputs[1].toLowerCase();
                    String language = inputs[2].toLowerCase();
                    System.out.println(YELLOW + greeting.greet(name, language) + RESET);
                }
                else {
                    System.out.println(RED +"Invalid command!" + RESET);
                    System.out.println(GREEN + greeting.help() + RESET);
                }
            }
            else {
                System.out.println(RED +"Invalid command!" + RESET);
                System.out.println(GREEN + greeting.help() + RESET);
            }
        }
    }
}
