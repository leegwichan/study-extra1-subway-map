package subway.repository;

import subway.domain.Station;
import subway.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private final List<Station> stations = new ArrayList<>();

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        if (isInStationRepository(station.getName())) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_IN_REPOSITORY.getMessage());
        }
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        if (isInStationRepository(name)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_OUT_REPOSITORY.getMessage());
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public Station getStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        throw new IllegalArgumentException(ExceptionMessage.STATION_OUT_REPOSITORY.getMessage());
    }

    private boolean isInStationRepository(String name) {
        for (Station stationInRepository : stations) {
            if (stationInRepository.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
