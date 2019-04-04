package greet;

public enum  Language {
    Xhosa("Molo"),
    Zulu("Sawubona"),
    Sotho("Dumela"),
    Venda("Ndaa"),
    English("Hello"),
    Afrikaans("Hallo"),
    Pedi("Thobela"),
    Tswana(""),
    Tsonga(""),
    Swati(""),
    Ndebele("Lotjhani");

    private String greeting;
    Language(String greeting) {
        this.greeting = greeting;
    }
    public String getGreeting() {
        return greeting;
    }
}
