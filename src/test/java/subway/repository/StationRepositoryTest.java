package subway.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import subway.domain.Station;

public class StationRepositoryTest {

    private static final String STATION_NAME1 = "11역";
    private static final String STATION_NAME2 = "22역";
    private static final String ANOTHER_NAME = "33역";

    StationRepository initialStationRepository() {
        StationRepository stationRepository = new StationRepository();
        stationRepository.addStation(new Station(STATION_NAME1));
        stationRepository.addStation(new Station(STATION_NAME2));
        return stationRepository;
    }

    @Test
    void addStationTest() {
        StationRepository repository = initialStationRepository();

        repository.addStation(new Station(ANOTHER_NAME));

        assertThat(repository.stations().size()).isEqualTo(3);
    }

    @Test
    void addStationTest_Exception() {
        StationRepository repository = initialStationRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.addStation(new Station(STATION_NAME1)));
    }

    @Test
    void deleteStationTest() {
        StationRepository repository = initialStationRepository();

        repository.deleteStation(STATION_NAME1);

        assertThat(repository.stations().size()).isEqualTo(1);
    }

    @Test
    void deleteStationTest_Exception() {
        StationRepository repository = initialStationRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.deleteStation(ANOTHER_NAME));
    }

    @Test
    void getStationTest() {
        StationRepository repository = initialStationRepository();

        Station result = repository.getStation(STATION_NAME1);

        assertThat(result.getName()).isEqualTo(STATION_NAME1);
    }

    @Test
    void getStationTest_Exception() {
        StationRepository repository = initialStationRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.deleteStation(ANOTHER_NAME));
    }
}
