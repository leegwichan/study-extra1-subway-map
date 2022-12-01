package subway.repository;

import subway.domain.Station;
import subway.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (isInStationRepository(station)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_IN_REPOSITORY.getMessage());
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean isInStationRepository(Station station) {
        for (Station stationInRepository :  stations) {
            if (stationInRepository.getName().equals(station.getName())) {
                return true;
            }
        }
        return false;
    }
}
