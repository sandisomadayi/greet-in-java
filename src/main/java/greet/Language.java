package greet;

public enum  Language {
    Xhosa("Molo"),
    Zulu("Sawubona"),
    Sotho("Dumela"),
    Venda("Ndaa"),
    English("Hello"),
    Afrikaans(""),
    Pedi(""),
    Tswana(""),
    Tsonga(""),
    Swati(""),
    Ndebele("");

    private String greeting;
    Language(String greeting) {
        this.greeting = greeting;
    }
}
