package subway.dto;

import java.util.List;

public class LineDto {

    private final String name;
    private final List<StationDto> stations;

    public LineDto(String name, List<StationDto> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<StationDto> getStations() {
        return stations;
    }
}
