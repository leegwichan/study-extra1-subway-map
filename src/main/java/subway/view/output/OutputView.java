package subway.view.output;

import subway.domain.Station;
import subway.dto.LineDto;
import subway.dto.StationDto;
import java.util.List;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";
    private static final String STATION_PRINT_TEXT = "## 역 목록";
    private static final String LINE_PRINT_TEXT = "## 노선 목록";
    private static final String SECTION_LINE = "---";
    private static final String BLANK = "";

    public void printView(View view) {
        print(view.getText());
    }

    private void printDoSuccess(Operation operation) {
        printResult(operation.getText());
    }

    public void printStations(List<StationDto> stations) {
        print(STATION_PRINT_TEXT);
        printStationsName(stations);
    }

    public void printLines(List<LineDto> lines) {
        print(LINE_PRINT_TEXT);
        printLinesName(lines);
    }

    public void printSubwayMap(List<LineDto> lines) {
        for (LineDto line : lines) {
            printResult(line.getName());
            printResult(SECTION_LINE);
            printStationsName(line.getStations());
            print(BLANK);
        }
    }

    private void printStationsName(List<StationDto> stations) {
        for (StationDto station : stations) {
            printResult(station.getName());
        }
    }

    private void printLinesName(List<LineDto> lines) {
        for (LineDto lineDto : lines) {
            printResult(lineDto.getName());
        }
    }

    private void printResult(String string) {
        print(INFO_PREFIX + string);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
