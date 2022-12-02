package subway.domain;

import subway.helper.RepositoryInitializer;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SubwayMap {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository= new LineRepository();

    SubwayMap() {
        RepositoryInitializer.initialize(stationRepository, lineRepository);
    }




}
