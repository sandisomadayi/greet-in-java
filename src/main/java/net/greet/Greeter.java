package net.greet;


import net.greet.languages.Language;

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

            if (inputs.length < 2) {
                if (command.equals("exit")) {
                    break;
                } else if (command.equals("help")) {
                    System.out.println(greet.help());
                } else if (command.equals("greeted")) {
                    System.out.println(greet.greeted());
                }
                else if (command.equals("clear")) {
                    greet.clearMap();
                }
                else if (command.equals("count")) {
                    System.out.println(greet.counter());
                }

            }
            else {
                String name = inputs[1].toLowerCase();
                if (command.equals("greet")) {
                    if (inputs.length == 2) {
                        String language = "Venda";
                        System.out.println(greet.greet(name, language));
                    } else if (inputs.length == 3) {
                        String language = inputs[2];
                        System.out.println(greet.greet(name, language));
                    } else {
                        System.out.println("Invalid command!");
                    }
                }
                else if (command.equals("clear " + name)) {
                    greet.clear();
                }
                else if (input.equals("greeted " + name)) {
                    System.out.println(greet.greeted(name));
                }
                else {
                    System.out.println("Invalid command!");
                    System.out.println(greet.help());
                }
            }
        }
    }
}
