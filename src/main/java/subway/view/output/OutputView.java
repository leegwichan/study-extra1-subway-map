package subway.view.output;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";

    public void printView(View view) {
        print(view.getText());
    }

    private void printDoSuccess(Operation operation) {
        printResult(operation.getText());
    }

    private void printResult(String string) {
        print(INFO_PREFIX + string);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
