package subway.view.output;

import subway.domain.Station;
import java.util.List;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";

    public void printView(View view) {
        print(view.getText());
    }

    private void printDoSuccess(Operation operation) {
        printResult(operation.getText());
    }

    public void printStations(List<Station> stations) {
        for (Station station : stations) {
            printStation(station);
        }
    }

    private void printStation(Station station) {
        printResult(station.getName());
    }

    private void printResult(String string) {
        print(INFO_PREFIX + string);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
