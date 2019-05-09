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
        Scanner scanner = new Scanner(System.in);

        JDBCGreet jdbcGreet = new JDBCGreet();
        Processor processor = new Processor(greeting, jdbcGreet);

        while (true) {
            System.out.println("Enter a command");
            String input = scanner.nextLine();
//            String input = "greeted me";
            AcceptCommands acceptCommands = new AcceptCommands(input);

            if(acceptCommands.getCommand().equals("exit")){
                break;
            }
            else {
                System.out.println(processor.processCommands(acceptCommands));
            }
        }
    }
}
