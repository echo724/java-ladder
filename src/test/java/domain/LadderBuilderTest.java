package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.util.Point;
import domain.util.PointGenerator;

class LadderBuilderTest {

	class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}

	@Test
	@DisplayName("사다리 생성 테스트")
	void buildLadderTest() {
		int height = 3;
		int width = 3;
		LadderBuilder builder = new LadderBuilder();
		Ladder ladder = builder.build(height, width, new PresentPointGenerator());
		assertThat(ladder.getLines().get(0).getPoints()).containsExactly(
			Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
		);
		assertThat(ladder.getLines().get(1).getPoints()).containsExactly(
			Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
		);
		assertThat(ladder.getLines().get(2).getPoints()).containsExactly(
			Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
		);
	}
}