package domain;

import domain.util.Point;
import domain.util.PointGenerator;

public class FixedPresencePointGenerator implements PointGenerator {
    @Override
    public Point generate() {
        return Point.from(true);
    }
}
