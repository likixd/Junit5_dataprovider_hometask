package data;

public enum Language {
//    RU("Появился телеграм-чат Gymkhana GP"),
//    EN("Появился телеграм-чат Gymkhana GP");
    RU("ru_RU", "Появился телеграм-чат Gymkhana GP"),
    EN("en-US", "Появился телеграм-чат Gymkhana GP"),
    CN("zh-CH", "Появился телеграм-чат Gymkhana GP");

    public final String code;
    public final String description;

    Language(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

