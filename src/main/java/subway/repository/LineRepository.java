package subway.repository;

import subway.domain.Line;
import subway.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (isInRepository(line.getName())) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_IN_REPOSITORY.getMessage());
        }
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        if (!isInRepository(name)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_OUT_REPOSITORY.getMessage());
        }
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isInRepository(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
