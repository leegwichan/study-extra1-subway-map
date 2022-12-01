package subway.domain;

import subway.exception.ExceptionMessage;

public class Station {
    private String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 3 || !name.endsWith("역")){
            throw new IllegalArgumentException(ExceptionMessage.STATION_FORM.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
