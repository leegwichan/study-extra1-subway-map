package subway.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;
import subway.dto.LineDto;
import subway.dto.StationDto;
import java.util.List;

public class MapperTest {

    private static final Station STATION1 = new Station("11역");
    private static final Station STATION2 = new Station("22역");

    private static final Line LINE1 = new Line("1호선", List.of(STATION1, STATION2));
    private static final Line LINE2 = new Line("2호선", List.of(STATION2, STATION1));

    @Test
    void lineToLineDtoTest() {
        LineDto result = Mapper.lineToLineDto(LINE1);

        assertThat(result.getName()).isEqualTo(LINE1.getName());
        assertThat(result.getStations().get(0).getName()).isEqualTo(STATION1.getName());
    }

    @Test
    void linesToLineDtosTest() {
        List<LineDto> result = Mapper.linesToLineDtos(List.of(LINE1, LINE2));

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(1).getStations().get(0).getName()).isEqualTo(STATION2.getName());
    }

    @Test
    void stationToStationDto() {
        StationDto result = Mapper.stationToStationDto(STATION1);

        assertThat(result.getName()).isEqualTo(STATION1.getName());
    }

    @Test
    void stationsToStationsDtos() {
        List<StationDto> result = Mapper.stationsToStationDtos(List.of(STATION1, STATION2));

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(1).getName()).isEqualTo(STATION2.getName());
    }
}
