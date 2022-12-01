package subway.domain;

import subway.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name, List<Station> stations) {
        validateName(name);
        validateStations(stations);
        this.name = name;
        this.stations.addAll(stations);
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

    public List<Station> getStations() {
        List<Station> copyStations = new ArrayList<>();
        copyStations.addAll(stations);

        return copyStations;
    }

    public void addStation(int index, Station station) {
        if (isStationInLine(station)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_IN_LINE.getMessage());
        }
        stations.add(index, station);
    }

    public void deleteStation(Station station) {
        if (!isStationInLine(station)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_OUT_LINE.getMessage());
        }
        if (stations.size() <= 2 ) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_STATIONS_SIZE.getMessage());
        }

        stations.removeIf(stationInLine ->
                Objects.equals(stationInLine.getName(), station.getName()));
    }

    private boolean isStationInLine(Station station) {
        for (Station stationInLine : stations) {
            if (stationInLine.getName().equals(station.getName())) {
                return true;
            }
        }
        return false;
    }
}
