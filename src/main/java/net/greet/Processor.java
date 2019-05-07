package net.greet;

public class Processor {

//    AcceptCommands acceptCommands = new AcceptCommands("greeted sandiso zulu");
//    JDBCGreet jdbcGreet = new JDBCGreet();
    private Greet greet;
    private Greeting greeting;

    public Processor(Greeting greeting, Greet greet) {
        this.greet = greet;
        this.greeting = greeting;
    }

    public String processCommands(AcceptCommands acceptCommands) {


        if(acceptCommands.getCommand().equals("greet")){
            return greet.greet(acceptCommands.getUserName(),acceptCommands.getLanguage());
        }
        return "exit";




//        if (acceptCommands.getCommand().equals("greet")) {
//            if (acceptCommands.getUserName().equals(null)) {
//                return "greet works with a name";
//            }
//            return jdbcGreet.greet(acceptCommands.getUserName(), acceptCommands.getLanguage());
//        }
//        else if (acceptCommands.getCommand().equals("greeted")) {
//            return jdbcGreet.greeted(acceptCommands.getUserName());
//        }
//        else if (acceptCommands.getCommand().equals("count")) {
//            return jdbcGreet.counter();
//        }
//        else if (acceptCommands.getCommand().equals("clear")) {
//            return jdbcGreet.clear(acceptCommands.getUserName());
//        }
//        else if (acceptCommands.getCommand().equals("help")) {
//            return jdbcGreet.help();
//        }
//        else {
//            return "Command entered not valid!";
//        }
    }
}
