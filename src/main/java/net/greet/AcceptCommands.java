package net.greet;

public class AcceptCommands {
    private String input; String userName; String language; String command;
    private String[] inputSplit;

    public AcceptCommands(String inputFromUser) {
        this.input = inputFromUser;
        splitInput();
    }

    public void splitInput() {
        try {
            inputSplit = input.split(" ");
            if(inputSplit.length == 1) {
                command = inputSplit[0].toLowerCase();
            }
            else if (inputSplit.length == 2) {
                command = inputSplit[0].toLowerCase();
                userName = inputSplit[1].toLowerCase();
            }
            else if (inputSplit.length == 3) {
                command = inputSplit[0].toLowerCase();
                userName = inputSplit[1].toLowerCase();
                language = inputSplit[2].toLowerCase();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
