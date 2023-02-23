package view;

import domain.Participant;
import domain.Participants;
import domain.Result;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResultView {
    private final static String ALL_GAME_RESULT_FORMAT = "%s : %s";

    public static String formatGameResult(Result result) {
        return result.getValue();
    }

    public static String formatAllGameResults(Participants participants, Map<Participant, Result> results) {
        return participants.getParticipants().stream()
                .map(p -> GameResultView.printNameWithResult(p, results.get(p)))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String printNameWithResult(Participant participant, Result result) {
        return String.format(ALL_GAME_RESULT_FORMAT, participant.getName(), result.getValue());
    }
}