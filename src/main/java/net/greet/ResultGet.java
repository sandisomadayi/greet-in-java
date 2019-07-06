package net.greet;

public class ResultGet {
    String message;
    boolean menuStatus;

    public ResultGet(String message) {
        this.message = message;

        if (message.equals("Good bye")) {
            menuStatus = false;
        }
        else {
            menuStatus = true;
        }
    }

    public String getMessage() {
        return message;
    }

    public boolean getMenuStatus() {
        return menuStatus;
    }
}
