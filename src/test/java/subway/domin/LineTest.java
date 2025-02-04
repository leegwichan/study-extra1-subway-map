package subway.domin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import subway.domain.Line;
import subway.domain.Station;
import java.util.List;
import java.util.stream.Stream;

public class LineTest {

    @ParameterizedTest(name = "Case {0}")
    @ArgumentsSource(LineCreateTestNormalData.class)
    void createLineNormalTest(String name, List<Station> stations) {
        Line line = new Line(name, stations);

        assertThat(line.getName()).isEqualTo(name);
    }

    static class LineCreateTestNormalData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("1호선", List.of(new Station("11역"), new Station("22역"))),
                    Arguments.of("경기선", List.of(new Station("양재역"), new Station("청평역")))
            );
        }
    }

    @ParameterizedTest(name = "Case {0}")
    @ArgumentsSource(LineCreateTestAbnormalData.class)
    void createLineAbnormalTest(String name, List<Station> stations, String exceptionMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Line(name, stations);});
        assertThat(exception.getMessage()).isEqualTo(exceptionMessage);
    }

    static class LineCreateTestAbnormalData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("1호호", List.of(new Station("11역"), new Station("22역")),
                            "[ERROR] 노선 이름은 3글자 이상이며 \'선\'으로 끝나야 합니다."),
                    Arguments.of("경선", List.of(new Station("양재역"), new Station("청평역")),
                            "[ERROR] 노선 이름은 3글자 이상이며 \'선\'으로 끝나야 합니다."),
                    Arguments.of("경기선", List.of(new Station("양재역")),
                            "[ERROR] 노선에는 적어도 2개 이상의 역이 존재해야 합니다.")
                    );
        }
    }

    @Test
    void addStationNormalTest() {
        Line line = new Line("1호선", List.of(new Station("11역"), new Station("22역")));

        line.addStation(1, new Station("33역"));

        assertThat(line.getStations().get(1).getName()).isEqualTo("33역");
    }

    @Test
    void addStationAbnormalTest() {
        Line line = new Line("1호선", List.of(new Station("11역"), new Station("22역")));
        String exceptionMessage = "[ERROR] 해당 노선에 이미 있는 역입니다.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            line.addStation(1, new Station("11역"));});
        assertThat(exception.getMessage()).isEqualTo(exceptionMessage);
    }

    @Test
    void deleteStationNormalTest() {
        Line line = new Line("1호선", List.of(new Station("11역"), new Station("22역"),
                new Station("33역")));

        line.deleteStation(new Station("11역"));

        assertThat(line.getStations().get(0).getName()).isEqualTo("22역");
        assertThat(line.getStations().get(1).getName()).isEqualTo("33역");
    }

    @Test
    void deleteStationAbnormalTest_whenNotExist() {
        Line line = new Line("1호선", List.of(new Station("11역"), new Station("22역"),
                new Station("33역")));
        String exceptionMessage = "[ERROR] 해당 노선에 없는 역입니다.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            line.deleteStation(new Station("44역"));});
        assertThat(exception.getMessage()).isEqualTo(exceptionMessage);
    }

    @Test
    void deleteStationAbnormalTest_whenSizeIs2() {
        Line line = new Line("1호선", List.of(new Station("11역"), new Station("22역")));
        String exceptionMessage = "[ERROR] 노선에는 적어도 2개 이상의 역이 존재해야 합니다.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            line.deleteStation(new Station("11역"));});
        assertThat(exception.getMessage()).isEqualTo(exceptionMessage);
    }
}
