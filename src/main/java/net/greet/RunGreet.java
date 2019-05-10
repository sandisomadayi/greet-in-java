package net.greet;

import java.util.Scanner;

public class RunGreet {

    public static void main(String[] args) {

//        Greeting greeting = new Greet("", Language.xhosa);
        Greeting greeting = new JDBCGreet();
        Scanner scanner = new Scanner(System.in);

        JDBCGreet jdbcGreet = new JDBCGreet();
        Processor processor = new Processor(greeting, jdbcGreet);

        boolean menuStatus = true;

        while (menuStatus) {
            System.out.println("Enter a command");
            String input = scanner.nextLine();
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
