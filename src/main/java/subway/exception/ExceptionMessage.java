package subway.exception;

public enum ExceptionMessage {
    STATION_FORM("지하철 역 이름은 3글자 이상이며 \'역\'으로 끝나야 합니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private static final String PREFIX = "[ERROR] ";

    private String message;

    public String getMessage() {
        return PREFIX + message;
    }
}
