package com.saschalorenz.main;

import matchGameCommon.GameUtils;
import matchGameCommon.MatchGameTextGerman;

/*
 * Project: MatchGame
 * Class: MatchGame
 * Author:  Sascha Lorenz
 * Last Change:
 *    by:   $Author: SL
 *    date: $Date:   03. Nov. 2012
 * Purpose: Main method with game loop for match game
 */

public class MatchGame {

	// Main method as start point for application
	public static void main(String[] args) {

		// initialize game with number of matches in game
		GameUtils.setMatchNumberTotal(GameUtils.initializeGame());

		// game loop (loops as long as more than 0 matches are in game)
		do {
			System.out.println(MatchGameTextGerman.HOW_MANY_MATCHES);

			// reads user input
			while (true) {
				GameUtils.setSelectedNumberHuman(GameUtils.readInput());
				if (GameUtils.getSelectedNumberHuman() <= GameUtils.getMaxMatchCountSelect() && GameUtils.getSelectedNumberHuman() >= GameUtils.getMinMatchCountSelect())
					break;
				System.out.println(MatchGameTextGerman.TOO_MUCH_PRE + GameUtils.getMinMatchCountSelect() + " - " + GameUtils.getMaxMatchCountSelect() + MatchGameTextGerman.TOO_MUCH_POST);
			}

			// decrements number of matches according to user selection
			GameUtils.setMatchNumberTotal(GameUtils.decrementMatchNumber(GameUtils.getMatchNumberTotal(), GameUtils.getSelectedNumberHuman()));

			// checks if human player has lost the game (picked the last match)
			if (GameUtils.getMatchNumberTotal() <= 0) {
				System.out.println(MatchGameTextGerman.GAME_OVER);
				System.out.println(MatchGameTextGerman.YOU_LOST);
				break;
			}

			// Computer selects matches
			GameUtils.setSelectedNumberComputer(GameUtils.computerSelectMatch());

			// decrements number of matches according to computers selection
			GameUtils.setMatchNumberTotal(GameUtils.decrementMatchNumber(GameUtils.getMatchNumberTotal(), GameUtils.getSelectedNumberComputer()));

			// checks if computer player has lost the game
			if (GameUtils.getMatchNumberTotal() <= 0) {
				System.out.println(MatchGameTextGerman.GAME_OVER);
				System.out.println(MatchGameTextGerman.COMPUTER_LOST);
				break;
			}

			// checks how many matches are left
			if (GameUtils.getMatchNumberTotal() == GameUtils.getMinMatchCountSelect()) {
				System.out.println(MatchGameTextGerman.MATCHES_IN_GAME + MatchGameTextGerman.STILL + GameUtils.getMatchNumberTotal() + MatchGameTextGerman.MATCH_SINGULAR);
			} else {
				System.out.println(MatchGameTextGerman.MATCHES_IN_GAME + MatchGameTextGerman.STILL + GameUtils.getMatchNumberTotal() + MatchGameTextGerman.MATCH_PLURAL);
			}
		} while (GameUtils.getMatchNumberTotal() > 0);

	}
}
