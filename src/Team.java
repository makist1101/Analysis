import java.text.DecimalFormat;
import java.util.*;

public class Team {
	public String name;
	public List<Result> results, teamResultsHome, teamResultsAway, teamResults,
						formResultsHome, formResultsAway, formResults;
	Stats stats;
	
	public Team(String name, List<Result> results) {
		this.name = name;
		this.results = new ArrayList<Result>(results);
		stats = new Stats(name);
		createStats();
		}

	public void createStats() {
		teamResultsHome = new ArrayList<Result>();
		teamResultsAway = new ArrayList<Result>();
		teamResults = new ArrayList<Result>();
		formResultsHome = new ArrayList<Result>();
		formResultsAway = new ArrayList<Result>();
		formResults = new ArrayList<Result>();

		for (int i = 0; i < results.size(); i++) {
			if (name.equals(results.get(i).homeTeam)) {
				teamResultsHome.add(results.get(i));
				teamResults.add(results.get(i));
			} else if (name.equals(results.get(i).awayTeam)) {
				teamResultsAway.add(results.get(i));
				teamResults.add(results.get(i));
			}
		}
		int sizeFormTemp;
		if (teamResults.size() < 5) {
			sizeFormTemp = teamResults.size();
		} else
			sizeFormTemp = 5;
		for (int i = teamResults.size() - 1; i > teamResults.size() - 1 - sizeFormTemp; i--) {
			formResults.add(teamResults.get(i));
		}

		if (teamResultsHome.size() < 3) {
			sizeFormTemp = teamResultsHome.size();
		} else
			sizeFormTemp = 3;
		for (int i = teamResultsHome.size() - 1; i > teamResultsHome.size() - 1 - sizeFormTemp; i--) {
			formResultsHome.add(teamResultsHome.get(i));
		}

		if (teamResultsAway.size() < 3) {
			sizeFormTemp = teamResultsAway.size();
		} else
			sizeFormTemp = 3;
		for (int i = teamResultsAway.size() - 1; i > teamResultsAway.size() - 1 - sizeFormTemp; i--) {
			formResultsAway.add(teamResultsAway.get(i));
		}
		
		for (int i = 0; i < teamResults.size(); i++) {
			stats.addResult(teamResults.get(i));
		}

		stats.createPer();
		stats.createFormStats(formResultsHome, formResultsAway, formResults);
	}

	public void printAll() {
		printTeamScores();
		printTeamStats();
		printTeamForm();
	}
	
	
	public void printTeamScores() {
		System.out.print(name + " scores(" + stats.matches + "): ");
		int tempSum = 0;
		for (int i = 0; i < stats.scores.length; i++) {
			tempSum = 0;
			for (int j = 0; j < stats.scores[i].length; j++) {
				if (stats.scores[i][j] > 0) {
					if (tempSum == 0)
						System.out.println();
					System.out.print(i + "-" + j + ": " + stats.scores[i][j] + "("+ Common.df21.format(stats.scoresPer[i][j]) + "%)\t");
					tempSum++;
				}
			}
		}
		System.out.println();
		System.out.println();
	}

	public void printTeamStats() {
		System.out.println(name + " stats:");
		System.out.println("\t\tTotal\t\tHome\t\tAway");
		System.out.println("Matches\t\t" + stats.matches + "\t\t" + stats.matchesHome + "\t\t" + stats.matchesAway);
		System.out.println("Scored\t\t" + stats.goalsSco + "(" + Common.df22.format(stats.goalsScoAvg) + ")\t"
				+ stats.goalsScoHome + "(" + Common.df22.format(stats.goalsScoHomeAvg) + ")\t" + stats.goalsScoAway + "("
				+ Common.df22.format(stats.goalsScoAwayAvg) + ")");
		System.out.println("Conceded\t" + stats.goalsCon + "(" + Common.df22.format(stats.goalsConAvg) + ")\t"
				+ stats.goalsConHome + "(" + Common.df22.format(stats.goalsConHomeAvg) + ")\t" + stats.goalsConAway + "("
				+ Common.df22.format(stats.goalsConAwayAvg) + ")");
		System.out.println("Won\t\t" + stats.won + "(" + Common.df21.format(stats.wonPer) + "%)\t" + stats.wonHome + "("
				+ Common.df21.format(stats.wonHomePer) + "%)\t" + stats.wonAway + "("
				+ Common.df21.format(stats.wonAwayPer) + "%)");
		System.out.println("Draw\t\t" + stats.draw + "(" + Common.df21.format(stats.drawPer) + "%)\t" + stats.drawHome
				+ "(" + Common.df21.format(stats.drawHomePer) + "%)\t" + stats.drawAway + "("
				+ Common.df21.format(stats.drawAwayPer) + "%)");
		System.out.println("Lost\t\t" + stats.lost + "(" + Common.df21.format(stats.lostPer) + "%)\t" + stats.lostHome
				+ "(" + Common.df21.format(stats.lostHomePer) + "%)\t" + stats.lostAway + "("
				+ Common.df21.format(stats.lostAwayPer) + "%)");
		System.out.println("Over\t\t" + stats.over + "(" + Common.df21.format(stats.overPer) + "%)\t" + stats.overHome
				+ "(" + Common.df21.format(stats.overHomePer) + "%)\t" + stats.overAway + "("
				+ Common.df21.format(stats.overAwayPer) + "%)");
		System.out.println("Btts\t\t" + stats.btts + "(" + Common.df21.format(stats.bttsPer) + "%)\t" + stats.bttsHome
				+ "(" + Common.df21.format(stats.bttsHomePer) + "%)\t" + stats.bttsAway + "("
				+ Common.df21.format(stats.bttsAwayPer) + "%)");
		System.out.println("bOver\t\t" + stats.bOver + "(" + Common.df21.format(stats.bOverPer) + "%)\t"
				+ stats.bOverHome + "(" + Common.df21.format(stats.bOverHomePer) + "%)\t" + stats.bOverAway + "("
				+ Common.df21.format(stats.bOverAwayPer) + "%)");
		System.out.println("0-1\t\t" + stats.goals01 + "(" + Common.df21.format(stats.goals01Per) + "%)\t"
				+ stats.goals01Home + "(" + Common.df21.format(stats.goals01HomePer) + "%)\t" + stats.goals01Away + "("
				+ Common.df21.format(stats.goals01AwayPer) + "%)");
		System.out.println("2-3\t\t" + stats.goals23 + "(" + Common.df21.format(stats.goals23Per) + "%)\t"
				+ stats.goals23Home + "(" + Common.df21.format(stats.goals23HomePer) + "%)\t" + stats.goals23Away + "("
				+ Common.df21.format(stats.goals23AwayPer) + "%)");
		System.out.println("4-6\t\t" + stats.goals46 + "(" + Common.df21.format(stats.goals46Per) + "%)\t"
				+ stats.goals46Home + "(" + Common.df21.format(stats.goals46HomePer) + "%)\t" + stats.goals46Away + "("
				+ Common.df21.format(stats.goals46AwayPer) + "%)");
		System.out.println("7+\t\t" + stats.goals7 + "(" + Common.df21.format(stats.goals7Per) + "%)\t"
				+ stats.goals7Home + "(" + Common.df21.format(stats.goals7HomePer) + "%)\t" + stats.goals7Away + "("
				+ Common.df21.format(stats.goals7AwayPer) + "%)");
		System.out.println();
	}

	public void printTeamForm() {
		System.out.println(name + " form:");
		System.out.println("Form Scores: ");
		for (int i = 0; i < formResults.size(); i++) {
			System.out.println(formResults.get(i).homeTeam + " " + formResults.get(i).FTHG + "-"
					+ formResults.get(i).FTAG + " " + formResults.get(i).awayTeam + "\t");
		}
		System.out.println("\nForm Home Scores: ");
		for (int i = 0; i < formResultsHome.size(); i++) {
			System.out.println(formResultsHome.get(i).homeTeam + " " + formResultsHome.get(i).FTHG + "-"
					+ formResultsHome.get(i).FTAG + " " + formResultsHome.get(i).awayTeam + "\t");
		}
		System.out.println("\nForm Away Scores: ");
		for (int i = 0; i < formResultsAway.size(); i++) {
			System.out.println(formResultsAway.get(i).homeTeam + " " + formResultsAway.get(i).FTHG + "-"
					+ formResultsAway.get(i).FTAG + " " + formResultsAway.get(i).awayTeam + "\t");
		}
		System.out.println();
		System.out.println(name + " form stats:");
		System.out.println("\t\tTotal\t\tHome\t\tAway");
		System.out.println(
				"Matches\t\t" + formResults.size() + "\t\t" + formResultsHome.size() + "\t\t" + formResultsAway.size());
		System.out.println(
				"fPoints\t\t" + stats.form5Points + "\t\t" + stats.form3PointsHome + "\t\t" + stats.form3PointsAway);
		System.out.println("fGoalsS\t\t" + stats.form5GoalsSco + "\t\t" + stats.form3GoalsScoHome + "\t\t"
				+ stats.form3GoalsScoAway);
		System.out.println("fGoalsC\t\t" + stats.form5GoalsCon + "\t\t" + stats.form3GoalsConHome + "\t\t"
				+ stats.form3GoalsConAway);
		System.out.println("fOver\t\t" + stats.form5Over + "\t\t" + stats.form3OverHome + "\t\t" + stats.form3OverAway);
		System.out.println("fBtts\t\t" + stats.form5Btts + "\t\t" + stats.form3BttsHome + "\t\t" + stats.form3BttsAway);
		System.out.println("WinHomeR:  " + stats.winHomeRating + "\t\tWinAwayR:  " + stats.winAwayRating);
		System.out.println("OverHomeR: " + stats.overHomeRating + "\t\tOverAwayR: " + stats.overAwayRating);
		System.out.println("BttsHomeR: " + stats.bttsHomeRating + "\t\tBttsAwayR: " + stats.bttsAwayRating);
		System.out.println();
	}
}