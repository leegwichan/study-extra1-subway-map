package subway.helper;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import java.util.List;

public class RepositoryInitializer {

    private static final List<Station> initialStations =
            List.of(new Station("교대역"), new Station("강남역"), new Station("역삼역"),
                    new Station("남부터미널역"), new Station("양재역"), new Station("매봉역"),
                    new Station("양재시민의숲역"));
    private static final List<Line> initialLine =
            List.of(new Line("2호선", List.of(new Station("교대역"), new Station("강남역"),
                                new Station("역삼역"))),
            new Line("3호선", List.of(new Station("교대역"),new Station("남부터미널역"),
                                new Station("양재역"), new Station("매봉역"))),
            new Line("신분당선", List.of(new Station("강남역"), new Station("양재역"),
                                new Station("양재시민의숲"))));

    public static void initialize(StationRepository stationRepository, LineRepository lineRepository) {
        initializeStationRepository(stationRepository);
        initializeLineRepository(lineRepository);
    }

    private static void initializeStationRepository(StationRepository stationRepository) {
        for (Station station : initialStations) {
            stationRepository.addStation(station);
        }
    }

    private static void initializeLineRepository(LineRepository lineRepository) {
        for (Line line : initialLine) {
            lineRepository.addLine(line);
        }
    }

}
