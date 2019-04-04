package greet;

import static greet.Language.*;


import java.util.Scanner;

public class RunGreet {

    public static void main(String[] args) {
        Greet greet = new Greet("", English);
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

            }
            else {
                String name = inputs[1].toLowerCase();
                String language = inputs[2].toLowerCase();
                if (command.equals("greet")) {
                    System.out.println(greet.greet(name, Pedi));
                }
                else if (input.equals("greeted " + name)) {
                    System.out.println(greet.greeted(name));
                }
                else {
                    System.out.println("Invalid command! Please Enter a valid command");
                }
            }
        }
    }
}
