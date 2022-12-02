package subway.domain;

import subway.exception.ExceptionMessage;
import subway.helper.RepositoryInitializer;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import java.util.List;

public class SubwayMap {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository= new LineRepository();

    SubwayMap() {
        RepositoryInitializer.initialize(stationRepository, lineRepository);
    }

    public void enrollStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public void deleteStation(String stationName) {
        if (lineRepository.isInRepository(stationName)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_STATION_DELETE.getMessage());
        }
        stationRepository.deleteStation(stationName);
    }

    public List<Station> getStations() {
        return stationRepository.stations();
    }

    public void enrollLine(String lineName, String upStationName, String downStationName) {
        Station upStation = stationRepository.getStation(upStationName);
        Station downStation = stationRepository.getStation(downStationName);

        lineRepository.addLine(new Line(lineName, List.of(upStation, downStation)));
    }

    public void deleteLine(String lineName) {
        lineRepository.deleteLine(lineName);
    }

    public Line getLine(String lineName) {
        return lineRepository.getLine(lineName);
    }

    public void enrollSection(String lineName, String stationName, int sectionOrder) {
        Line line = lineRepository.getLine(lineName);
        Station station = stationRepository.getStation(stationName);
        line.addStation(sectionOrder, station);
        lineRepository.updateLine(line);
    }

    public void deleteSection(String lineName, String stationName) {
        Line line = lineRepository.getLine(lineName);
        Station station = stationRepository.getStation(stationName);
        line.deleteStation(station);
        lineRepository.updateLine(line);
    }

    public List<Line> getLines() {
        return lineRepository.lines();
    }
}
