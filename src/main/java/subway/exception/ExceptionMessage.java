package subway.exception;

public enum ExceptionMessage {
    STATION_FORM("지하철 역 이름은 3글자 이상이며 \'역\'으로 끝나야 합니다."),
    LINE_NAME_FORM("노선 이름은 3글자 이상이며 \'선\'으로 끝나야 합니다."),
    LINE_STATIONS_SIZE("노선에는 적어도 2개 이상의 역이 존재해야 합니다."),

    STATION_IN_LINE("해당 노선에 이미 있는 역입니다."),
    STATION_OUT_LINE("해당 노선에 없는 역입니다."),
    STATION_IN_REPOSITORY("해당 역은 이미 있는 역입니다."),
    STATION_OUT_REPOSITORY("해당 역은 없는 역입니다."),
    ;

    ExceptionMessage(String message) {
        this.message = message;
    }

    private static final String PREFIX = "[ERROR] ";

    private String message;

    public String getMessage() {
        return PREFIX + message;
    }
}
