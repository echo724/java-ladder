package domain;

import domain.Collection.Participant;
import domain.Collection.Participants;
import domain.Collection.Result;
import domain.Collection.Results;
import domain.Ladder.Ladder;
import domain.Ladder.LadderHeight;
import domain.Ladder.LadderWidth;
import domain.LadderGame.LadderGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;
    @BeforeEach
    void generateLadderGame(){
        Participants participants = Participants.of("echo", "modi", "neo");
        Results results = Results.of("3000", "꽝", "5000");
        Ladder ladder = Ladder.create(LadderHeight.from(1), LadderWidth.from(2), new FixedPresencePointGenerator());
        ladderGame = new LadderGame(participants, results, ladder);
    }
    @Test
    @DisplayName("사다리 게임을 실행하면 사다리를 읽으며 순서를 변화시킨다.")
    void runLadderGameTest() {
        ladderGame.run();
    }

    @Test
    @DisplayName("사다리 게임을 실행하면 참가자들과 결과 맵을 생성한다.")
    void getLadderGameResultMap(){

        assertThat(ladderGame.getAllGameResult().get(Participant.from("echo"))).isEqualTo(Result.from("5000"));
    }
}
