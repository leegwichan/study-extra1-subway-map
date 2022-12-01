package subway.domin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subway.domain.Station;

public class StationTest {

    @ParameterizedTest(name = "createNormalCaseTest : {0}")
    @CsvSource(value = {"매봉역", "잠실새내역"})
    void createNormalCaseTest(String name) {
        Station station = new Station(name);

        assertThat(station.getName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "createAbnormalCaseTest : {0}")
    @CsvSource(value = {"매봉소", "가역"})
    void createAbnormalCaseTest(String name) {
        String exceptionMessage = "[ERROR] 지하철 역 이름은 3글자 이상이며 \'역\'으로 끝나야 합니다.";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {new Station(name);});
        assertThat(exception.getMessage()).isEqualTo(exceptionMessage);
    }
}
