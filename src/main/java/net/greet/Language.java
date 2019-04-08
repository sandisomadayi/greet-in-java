package net.greet;

public enum  Language {
    xhosa("Molo"),
    zulu("Sawubona"),
    sotho("Dumela"),
    venda("Ndaa"),
    english("Hello"),
    afrikaans("Hallo"),
    pedi("Thobela"),
    tswana(""),
    tsonga(""),
    swati(""),
    ndebele("Lotjhani");

    private String greeting;
    Language(String greeting) {
        this.greeting = greeting;
    }
    public String getGreeting() {
        return greeting;
    }
}
