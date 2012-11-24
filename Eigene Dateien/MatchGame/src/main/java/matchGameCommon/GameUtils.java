package matchGameCommon;

/*
 * Project: MatchGame
 * Class: GameUtils
 * Author:  Sascha Lorenz
 * Last Change:
 *    by:   $Author: SL
 *    date: $Date:   03. Nov. 2012
 * Purpose: Utility methods and constants for match game
 */

import java.util.Scanner;

public class GameUtils {

	// Constants for match numbers to avoid magic numbers

	private static final int MIN_MATCH_COUNT_SELECT = 1;
	private static final int MAX_MATCH_COUNT_SELECT = 3;

	private static final int MIN_MATCH_COUNT_TOTAL = 30;
	private static final int MAX_MATCH_COUNT_TOTAL = 40;

	private static int matchNumberTotal;

	private static int selectedNumberHuman;
	private static int selectedNumberComputer;

	/**
	 * @param matchNumberTotal
	 * @param selectedNumber
	 * @return matchNumberTotal
	 */
	public static int decrementMatchNumber(int matchNumberTotal, int selectedNumber) {
		matchNumberTotal -= selectedNumber;
		return matchNumberTotal;
	}

	/**
	 * Initialize game with random match number
	 * 
	 * @return matchNumberTotal
	 */
	public static int initializeGame() {
		int matchNumberTotal;
		matchNumberTotal = randomMatch(MIN_MATCH_COUNT_TOTAL, MAX_MATCH_COUNT_TOTAL);
		System.out.println(MatchGameTextGerman.MATCHES_IN_GAME + matchNumberTotal + MatchGameTextGerman.MATCH_PLURAL);
		return matchNumberTotal;
	}

	/**
	 * Computer selects random match between MIN and MAX
	 * 
	 * @return selectedNumberComputer
	 */
	public static int computerSelectMatch() {

		selectedNumberComputer = randomMatch(MIN_MATCH_COUNT_SELECT, MAX_MATCH_COUNT_SELECT);

		if (selectedNumberComputer == MIN_MATCH_COUNT_SELECT) {
			System.out.println(MatchGameTextGerman.COMPUTER_HAS + selectedNumberComputer + MatchGameTextGerman.MATCH_SINGULAR + MatchGameTextGerman.SELECTED);
		} else {
			System.out.println(MatchGameTextGerman.COMPUTER_HAS + selectedNumberComputer + MatchGameTextGerman.MATCH_PLURAL + MatchGameTextGerman.SELECTED);
		}
		return selectedNumberComputer;
	}

	/**
	 * Returns rounded random number for initial number of matches and allowed
	 * range for selected matches
	 * 
	 * @return selected Number
	 */
	public static int randomMatch(int min, int max) {

		int selectedNumber = (int) (Math.random() * (max - min) + min);
		return selectedNumber;
	}

	/**
	 * Reads user input from console
	 * 
	 * @param scan
	 * @return i
	 */
	public static int readInput() {
		Scanner scanner = new Scanner(System.in);
		int i;
		i = scanner.nextInt();
		return i;
	}

	// Getters and setters

	public static int getMatchNumberTotal() {
		return matchNumberTotal;
	}

	public static void setMatchNumberTotal(int matchNumberTotal) {
		GameUtils.matchNumberTotal = matchNumberTotal;
	}

	public static int getSelectedNumberHuman() {
		return selectedNumberHuman;
	}

	public static void setSelectedNumberHuman(int selectedNumberHuman) {
		GameUtils.selectedNumberHuman = selectedNumberHuman;
	}

	public static int getSelectedNumberComputer() {
		return selectedNumberComputer;
	}

	public static void setSelectedNumberComputer(int selectedNumberComputer) {
		GameUtils.selectedNumberComputer = selectedNumberComputer;
	}

	public static int getMinMatchCountSelect() {
		return MIN_MATCH_COUNT_SELECT;
	}

	public static int getMaxMatchCountSelect() {
		return MAX_MATCH_COUNT_SELECT;
	}

	public static int getMinMatchCountTotal() {
		return MIN_MATCH_COUNT_TOTAL;
	}

	public static int getMaxMatchCountTotal() {
		return MAX_MATCH_COUNT_TOTAL;
	}

}
