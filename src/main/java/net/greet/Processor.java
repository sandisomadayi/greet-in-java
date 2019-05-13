package net.greet;

public class Processor {

//    AcceptCommands acceptCommands = new AcceptCommands("greeted sandiso zulu");
//    greeting greeting = new greeting();

    private static final String GREEN = "\033[1;32m";
    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[1;33m";  // YELLOW
    private static final String BLUE = "\033[1;34m";    // BLUE
    private static final String PURPLE = "\033[1;35m";  // PURPLE
    private static final String CYAN = "\033[1;36m";    // CYAN
    private static final String RED = "\033[1;31m";
    
    private Greeting greeting;

    public Processor(Greeting greeting) {
        this.greeting = greeting;
    }

    public String processCommands(AcceptCommands acceptCommands) {
        if (acceptCommands.getCommand().equals("greet")) {
            if (acceptCommands.getUserName() == null) {
                return "greet works with a name";
            }
            return greeting.greet(acceptCommands.getUserName(), acceptCommands.getLanguage());
        }
        else if (acceptCommands.getCommand().equals("greeted")) {
            return greeting.greeted(acceptCommands.getUserName());
        }
        else if (acceptCommands.getCommand().equals("count")) {
            return greeting.counter();
        }
        else if (acceptCommands.getCommand().equals("clear")) {
            return greeting.clear(acceptCommands.getUserName());
        }
        else if (acceptCommands.getCommand().equals("help")) {
            return greeting.help();
        }
        else if (acceptCommands.getCommand().equals("exit")) {
            return "Good bye";
        }
        else {
            return "Command entered not valid!\n" + greeting.help();
        }
    }
}
