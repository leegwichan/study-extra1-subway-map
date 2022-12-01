package subway.domain;

import subway.exception.ExceptionMessage;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> stations) {
        validateName(name);
        validateStations(stations);
        this.name = name;
        this.stations = stations;
    }

    private void validateName(String name) {
        if (name.length() < 3 || !name.endsWith("선")) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_FORM.getMessage());
        }
    }

    private void validateStations(List<Station> stations) {
        if (stations.size() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_STATIONS_SIZE.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
