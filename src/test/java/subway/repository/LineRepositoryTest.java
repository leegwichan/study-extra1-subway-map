package subway.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;
import java.util.List;

public class LineRepositoryTest {

    private static final String LINE_NAME1 = "1호선";
    private static final String LINE_NAME2 = "2호선";
    private static final Line LINE1 = new Line(LINE_NAME1,
            List.of(new Station("11역"), new Station("22역")));
    private static final Line LINE2 = new Line(LINE_NAME2,
            List.of(new Station("33역"), new Station("44역")));
    private static final String ANOTHER_LINE_NAME = "3호선";
    private static final Line ANOTHER_LINE = new Line(ANOTHER_LINE_NAME,
            List.of(new Station("11역"), new Station("22역")));

    LineRepository initialLineRepository() {
        LineRepository repository = new LineRepository();
        repository.addLine(LINE1);
        repository.addLine(LINE2);
        return repository;
    }

    @Test
    void addLineTest() {
        LineRepository repository = initialLineRepository();

        repository.addLine(ANOTHER_LINE);

        assertThat(repository.lines().size()).isEqualTo(3);
    }

    @Test
    void addLineTest_Exception() {
        LineRepository repository = initialLineRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.addLine(LINE1));

    }
}
