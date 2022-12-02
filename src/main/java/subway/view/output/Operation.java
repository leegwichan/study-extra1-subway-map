package subway.view.output;

public enum Operation {
    ENROLL_STATION("지하철 역이 등록되었습니다."),
    DELETE_STATION("지하철 역이 삭제되었습니다."),
    ENROLL_LINE("지하철 노선이 등록되었습니다."),
    DELETE_LINE("지하철 노선이 삭제되었습니다."),
    ENROLL_SECTION("구간이 등록되었습니다."),
    DELETE_SECTION("구간이 삭제되었습니다."),
    ;

    private final String text;

    Operation(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
