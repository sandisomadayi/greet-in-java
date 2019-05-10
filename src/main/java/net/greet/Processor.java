package net.greet;

public class Processor {

//    AcceptCommands acceptCommands = new AcceptCommands("greeted sandiso zulu");
//    JDBCGreet jdbcGreet = new JDBCGreet();

    private static final String GREEN = "\033[1;32m";
    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[1;33m";  // YELLOW
    private static final String BLUE = "\033[1;34m";    // BLUE
    private static final String PURPLE = "\033[1;35m";  // PURPLE
    private static final String CYAN = "\033[1;36m";    // CYAN
    private static final String RED = "\033[1;31m";

    private JDBCGreet jdbcGreet;
    private Greeting greeting;

    public Processor(Greeting greeting, JDBCGreet jdbcGreet) {
        this.jdbcGreet = jdbcGreet;
        this.greeting = greeting;
    }

    public String processCommands(AcceptCommands acceptCommands) {
        if (acceptCommands.getCommand().equals("greet")) {
            if (acceptCommands.getUserName() == null) {
                return "greet works with a name";
            }
            return jdbcGreet.greet(acceptCommands.getUserName(), acceptCommands.getLanguage());
        }
        else if (acceptCommands.getCommand().equals("greeted")) {
            return jdbcGreet.greeted(acceptCommands.getUserName());
        }
        else if (acceptCommands.getCommand().equals("count")) {
            return jdbcGreet.counter();
        }
        else if (acceptCommands.getCommand().equals("clear")) {
            return jdbcGreet.clear(acceptCommands.getUserName());
        }
        else if (acceptCommands.getCommand().equals("help")) {
            return jdbcGreet.help();
        }
        else if (acceptCommands.getCommand().equals("exit")) {
            return "Good bye";
        }
        else {
            return "Command entered not valid!\n" + jdbcGreet.help();
        }
    }
}
