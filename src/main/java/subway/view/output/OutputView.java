package subway.view.output;

import subway.domain.Station;
import subway.dto.StationDto;
import java.util.List;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";
    private static final String STATION_PRINT_TEXT = "## 역 목록";

    public void printView(View view) {
        print(view.getText());
    }

    private void printDoSuccess(Operation operation) {
        printResult(operation.getText());
    }

    public void printStations(List<StationDto> stations) {
        print(STATION_PRINT_TEXT);
        for (StationDto station : stations) {
            printStation(station);
        }
    }

    private void printStation(StationDto station) {
        printResult(station.getName());
    }

    private void printResult(String string) {
        print(INFO_PREFIX + string);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
