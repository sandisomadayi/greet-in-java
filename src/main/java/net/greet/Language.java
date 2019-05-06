package net.greet;

public enum  Language {
    xhosa("Molo, "),
    zulu("Sawubona, "),
    sotho("Dumela, "),
    venda("Ndaa, "),
    english("Hello, "),
    afrikaans("Hallo, "),
    pedi("Thobela, "),
    tswana("Dumela, "),
    tsonga("Avuxeni, "),
    swati("Sawubona, "),
    ndebele("Lotjhani, "),
    french("Bonjour, "),
    portuguese("Olá"),
    spanish("Hola, "),
    chinese("Nǐ hǎo, "),
    japanese("Kon'nichiwa");

    private String greeting;
    Language(String greeting) {
        this.greeting = greeting;
    }
    public String getGreeting() {
        return greeting;
    }
}
