package subway.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subway.domain.Line;
import subway.domain.Station;
import java.util.List;

public class LineRepositoryTest {

    private static final String LINE_NAME1 = "1호선";
    private static final String LINE_NAME2 = "2호선";
    private static final Line LINE1 = new Line(LINE_NAME1,
            List.of(new Station("11역"), new Station("22역")));
    private static final Line LINE2 = new Line(LINE_NAME2,
            List.of(new Station("33역"), new Station("44역")));
    private static final String ANOTHER_LINE_NAME = "3호선";
    private static final Line ANOTHER_LINE = new Line(ANOTHER_LINE_NAME,
            List.of(new Station("11역"), new Station("22역")));

    LineRepository initialLineRepository() {
        LineRepository repository = new LineRepository();
        repository.addLine(LINE1);
        repository.addLine(LINE2);
        return repository;
    }

    @Test
    void addLineTest() {
        LineRepository repository = initialLineRepository();

        repository.addLine(ANOTHER_LINE);

        assertThat(repository.lines().size()).isEqualTo(3);
    }

    @Test
    void addLineTest_Exception() {
        LineRepository repository = initialLineRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.addLine(LINE1));

    }

    @Test
    void deleteLineTest() {
        LineRepository repository = initialLineRepository();

        repository.deleteLine(LINE_NAME1);

        assertThat(repository.lines().size()).isEqualTo(1);
    }

    @Test
    void deleteLineTest_Exception() {
        LineRepository repository = initialLineRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.deleteLine(ANOTHER_LINE_NAME));
    }

    @ParameterizedTest(name = "isInRepositoryTest Case : {0}")
    @CsvSource(value = {"1호선,true", "3호선,false"})
    void isInRepositoryTest(String lineName, boolean expected) {
        LineRepository repository = initialLineRepository();

        assertThat(repository.isInRepository(lineName)).isEqualTo(expected);
    }

    @Test
    void getLineTest() {
        LineRepository repository = initialLineRepository();

        Line result = repository.getLine(LINE_NAME1);

        assertThat(result.getName()).isEqualTo(LINE_NAME1);
        assertThat(result.getStations().get(0).getName()).isEqualTo("11역");
    }

    @Test
    void getLineTest_Exception() {
        LineRepository repository = initialLineRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.getLine(ANOTHER_LINE_NAME));
    }

    @ParameterizedTest(name = "isEnrollStationTest Case : {0}")
    @CsvSource(value = {"11역,true", "55역,false"})
    void isEnrollStationTest(String stationName, boolean expected) {
        LineRepository repository = initialLineRepository();
        Station station = new Station(stationName);

        assertThat(repository.isEnrollStation(station)).isEqualTo(expected);
    }
}
