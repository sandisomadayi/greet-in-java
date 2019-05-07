package net.greet;

public class AcceptCommands {
    private String input; String userName; String language; String command;
    private String[] inputSplit;

    public AcceptCommands(String inputFromUser) {
        input = inputFromUser;
        splitInput();
    }

    public void splitInput() {
        inputSplit = input.split(" ");
        command = inputSplit[0].toLowerCase();
        userName = inputSplit[1].toLowerCase();
        language = inputSplit[2].toLowerCase();
    }

    public String getCommand() {
        return command;
    }
    public String getUserName() {
        return userName;
    }
    public String getLanguage() {
        return language;
    }
}
