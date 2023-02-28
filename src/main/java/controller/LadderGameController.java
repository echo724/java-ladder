package controller;

import domain.Collection.Participant;
import domain.Collection.Participants;
import domain.Collection.Result;
import domain.Collection.Results;
import domain.Ladder.Ladder;
import domain.Ladder.LadderHeight;
import domain.Ladder.LadderWidth;
import domain.LadderGame.LadderGame;
import domain.LadderGame.ResultCommand;
import domain.util.PointGenerator;
import java.util.List;
import view.CollectionFormatter;
import view.GameResultFormatter;
import view.InputView;
import view.LadderFormatter;
import view.OutputView;

public class LadderGameController {
    
    
    private final LadderGame ladderGame;
    private ResultCommand command;
    
    public LadderGameController(PointGenerator pointGenerator) {
        this.ladderGame = this.buildLadderGame(pointGenerator);
    }
    
    private LadderGame buildLadderGame(PointGenerator pointGenerator) {
        Participants participants = this.retrieveParticipants();
        Results results = this.retrieveResults();
        Ladder ladder = this.buildLadder(pointGenerator, participants);
        return new LadderGame(participants, results, ladder);
    }
    
    private Ladder buildLadder(PointGenerator pointGenerator, Participants participants) {
        LadderHeight ladderHeight = this.retrieveHeight();
        LadderWidth ladderWidth = this.retrieveWidth(participants);
        return Ladder.create(ladderHeight, ladderWidth, pointGenerator);
    }
    
    public void runGame() {
        this.displayLadder();
        this.ladderGame.run();
        this.displayResult();
    }
    
    private void displayResult() {
        String name = this.retrieveNameToFind();
        while (this.command == ResultCommand.NAME) {
            this.displayGameResult(name);
            name = this.retrieveNameToFind();
        }
        if (this.command == ResultCommand.ALL) {
            this.displayAllGameResults();
        }
    }
    
    private Participants retrieveParticipants() {
        try {
            List<String> names = InputView.readNames();
            return Participants.of(names);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return this.retrieveParticipants();
        }
    }
    
    private void displayGameResult(String name) {
        Participant participant = Participant.from(name);
        Result result = this.ladderGame.getResultFrom(participant);
        String formattedResult = GameResultFormatter.formatGameResult(result);
        OutputView.printGameResult(formattedResult);
    }
    
    private LadderHeight retrieveHeight() {
        try {
            int height = InputView.readHeight();
            return LadderHeight.from(height);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return this.retrieveHeight();
        }
    }
    
    private void displayAllGameResults() {
        String allGameResults = GameResultFormatter.formatAllGameResults(this.ladderGame.getParticipants(),
                this.ladderGame.getAllGameResult());
        OutputView.printAllGameResults(allGameResults);
    }
    
    private String retrieveNameToFind() {
        try {
            String name = InputView.readNameToFind();
            this.command = this.ladderGame.validateNameToFind(name);
            return name;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return this.retrieveNameToFind();
        }
    }
    
    private Results retrieveResults() {
        try {
            List<String> strings = InputView.readResults();
            return Results.of(strings);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return this.retrieveResults();
        }
    }
    
    private LadderWidth retrieveWidth(Participants participants) {
        return LadderWidth.from(participants.getSize() - 1);
    }
    
    private void displayLadder() {
        String names = CollectionFormatter.formatParticipants(this.ladderGame.getParticipants());
        String ladder = LadderFormatter.formatLadder(this.ladderGame.getLadder());
        String results = CollectionFormatter.formatResults(this.ladderGame.getResults());
        OutputView.printLadderResult(names, ladder, results);
    }
}
