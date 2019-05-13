package net.greet;

public class ResultGet {
    String message;
    boolean menuStatus = true;

    public ResultGet(String message) {
        this.message = message;
//        this.menuStatus = menuStatus;

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
