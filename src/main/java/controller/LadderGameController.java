package controller;

import domain.*;
import domain.util.PointGenerator;
import view.*;

public class LadderGameController {

	private final LadderGame ladderGame;

	public LadderGameController() {
		Participants participants = retrieveParticipants();
		Results results = retrieveResults();
		LadderHeight ladderHeight = retrieveHeight();
		LadderWidth ladderWidth = new LadderWidth(participants.getParticipantsNum() - 1);
		Ladder ladder = Ladder.create(ladderHeight, ladderWidth, PointGenerator.getInstance(true));
		this.ladderGame = new LadderGame(participants, results, ladder);
	}

	public void runGame() {
		displayLadder();
		ladderGame.run();
		String name = retrieveNameToFind();
		while (!name.equals("all")) {
			displayGameResult(name);
			name = retrieveNameToFind();
		}
		displayAllGameResults();
	}

	private Participants retrieveParticipants() {
		try {
			String[] names = InputView.readNames();
			return Participants.of(names);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveParticipants();
		}
	}

	private Results retrieveResults() {
		try {
			String[] results = InputView.readResults();
			return Results.of(results);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveResults();
		}
	}

	// TODO: LadderHeight, LadderWidth -> Singleton
	private LadderHeight retrieveHeight() {
		try {
			int height = InputView.readHeight();
			return new LadderHeight(height);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveHeight();
		}
	}

	private String retrieveNameToFind() {
		try {
			String name = InputView.readNameToFind();
			if (name.equals("all")) {
				return name;
			}
			Participant.contains(name);
			return name;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveNameToFind();
		}
	}

	private void displayAllGameResults() {
		String allGameResults = GameResultView.formatAllGameResults(ladderGame.getParticipants(), ladderGame.getAllGameResult());
		OutputView.printAllGameResults(allGameResults);
	}

	private void displayGameResult(String name) {
		Participant participant = Participant.from(name);
		Result result = ladderGame.getResultFrom(participant);
		String formattedResult = GameResultView.formatGameResult(result);
		OutputView.printGameResult(formattedResult);
	}

	private void displayLadder() {
		String names = CollectionView.formatParticipants(ladderGame.getParticipants());
		String ladder = LadderView.formatLadder(ladderGame.getLadder());
		String results = CollectionView.formatResults(ladderGame.getResults());
		OutputView.printLadderResult(names, ladder, results);
	}
}
