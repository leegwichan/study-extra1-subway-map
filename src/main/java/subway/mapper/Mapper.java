package subway.mapper;

import subway.domain.Line;
import subway.domain.Station;
import subway.dto.LineDto;
import subway.dto.StationDto;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static List<LineDto> linesToLineDtos(List<Line> lines) {
        return lines.stream()
                .map(line -> lineToLineDto(line))
                .collect(Collectors.toList());
    }

    public static LineDto lineToLineDto(Line line) {
        return new LineDto(
                line.getName(),
                stationsToStationDtos(line.getStations())
        );
    }
    
    public static StationDto stationToStationDto(Station station) {
        return new StationDto(station.getName());
    }

    public static List<StationDto> stationsToStationDtos(List<Station> stations) {
        return stations.stream()
                .map(station -> stationToStationDto(station))
                .collect(Collectors.toList());
    }
}
