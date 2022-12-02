package subway.view.output;

import subway.domain.Station;
import subway.dto.LineDto;
import subway.dto.StationDto;
import java.util.List;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";
    private static final String STATION_PRINT_TEXT = "## 역 목록";
    private static final String LINE_PRINT_TEXT = "## 노선 목록";

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

    public void printLines(List<LineDto> lines) {
        print(LINE_PRINT_TEXT);
        for (LineDto lineDto : lines) {
            printLine(lineDto);
        }
    }

    private void printStation(StationDto station) {
        printResult(station.getName());
    }

    private void printLine(LineDto lineDto) {
        printResult(lineDto.getName());
    }

    private void printResult(String string) {
        print(INFO_PREFIX + string);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
