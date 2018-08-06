import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Competition{
	public List<Team> teams;
	public List<Result> results;
	public List<Fixture> fixtures;
	
	String nameComplete;
	String code;
	int div;
	int year;
	boolean extra;
	String[] abr;
	String[] abrFix;
	
	public List<Comparison> winHomeRatings, winAwayRatings,
							overHomeRatings, overAwayRatings,
							bttsHomeRatings, bttsAwayRatings,
							cornersHomeRatings, cornersAwayRatings,
							fixtureWinRatings,
							fixtureOverRatings,
							fixtureBttsRatings,
							fixtureCornerRatings;
	
	public int matches=0,
				goalsHome=0,
				goalsAway=0,
				goals=0,
				
				winHome=0,
				winAway=0,
				draw=0,
				
				btts=0,
				over=0,
				bOver=0,
				
				goals01=0,
				goals23=0,
				goals46=0,
				goals7=0;
	
	public double	goalsHomeAvg=0,
					goalsAwayAvg=0,
					goalsAvg=0,
					
					winHomePer=0, 
					winAwayPer=0, 
					drawPer=0,
					
					bttsPer=0,
					overPer=0,
					bOverPer=0,
					
					goals01Per=0,
					goals23Per=0,
					goals46Per=0,
					goals7Per=0,
		
					betHome=0,
					betAway=0,
					betDraw=0;
	public int matchesNoBetInfo=0;
	public int[][] scores;	
	public double[][] scoresPer;
	
	public Competition(List<Result> results, List<Fixture> fixtures, String name, String code, int div, int year,
			boolean extra, String[] abr, String[] abrFix){
		this.nameComplete=name+"-"+div+" "+year;
		this.code=code;
		this.div=div;
		this.year=year;
		this.extra=extra;
		this.abr=abr;
		this.abrFix=abrFix;
		
		this.results = new ArrayList<Result>(results);
		if(fixtures!=null)
		this.fixtures = new ArrayList<Fixture>(fixtures);
		matches=results.size();
		createTeams();
		createGoalStatsPer();
		createRatingLists();
		createFixtures();
		createBetStats();
		}	

	public void createTeams() {
		teams = new ArrayList<Team>();
		for (int i = 0; i < results.size(); i++) {
			String teamName = results.get(i).homeTeam;
			for (int j = 0; j <= teams.size(); j++) {
				if (j < teams.size()) {
					if (teamName.equals(teams.get(j).name)) {
						break;
					}
				} else if (teams.size() == j) {
					teams.add(new Team(teamName, results));
					break;
				}
			}

			teamName = results.get(i).awayTeam;
			for (int j = 0; j <= teams.size(); j++) {
				if (j < teams.size()) {
					if (teamName.equals(teams.get(j).name)) {
						break;
					}
				} else if (teams.size() == j) {
					teams.add(new Team(teamName, results));
					break;
				}
			}
		}
	}

	public void createGoalStatsPer() {
		scores = new int[15][15];
		scoresPer = new double[15][15];
		for (int i = 1; i < results.size(); i++) {
			int sumTemp = results.get(i).FTHG + results.get(i).FTAG;
			goalsHome += results.get(i).FTHG;
			goalsAway += results.get(i).FTAG;
			goals += results.get(i).FTHG + results.get(i).FTAG;
			if (results.get(i).FTHG > 0 && results.get(i).FTAG > 0)
				btts++;
			if (sumTemp > 2)
				over++;
			if (sumTemp > 2 && (results.get(i).FTHG > 0 && results.get(i).FTAG > 0))
				bOver++;
			if (sumTemp < 2)
				goals01++;
			if (sumTemp > 1 && sumTemp < 4)
				goals23++;
			if (sumTemp > 3 && sumTemp < 7)
				goals46++;
			if (sumTemp > 6)
				goals7++;
			if (results.get(i).FTHG > results.get(i).FTAG)
				winHome++;
			if (results.get(i).FTHG < results.get(i).FTAG)
				winAway++;
			if (results.get(i).FTHG == results.get(i).FTAG)
				draw++;
			scores[results.get(i).FTHG][results.get(i).FTAG]++;
		}
	
		goalsHomeAvg = (double) (goalsHome) / matches;
		goalsAwayAvg = (double) (goalsAway) / matches;
		goalsAvg = (double) (goals) / matches;
		winHomePer = (100.0 * winHome) / matches;
		winAwayPer = (100.0 * winAway) / matches;
		drawPer = (100.0 * draw) / matches;
		bttsPer = (100.0 * btts) / matches;
		overPer = (100.0 * over) / matches;
		bOverPer = (100.0 * bOver) / matches;
		goals01Per = (100.0 * goals01) / matches;
		goals23Per = (100.0 * goals23) / matches;
		goals46Per = (100.0 * goals46) / matches;
		goals7Per = (100.0 * goals7) / matches;
		for (int i = 0; i < scoresPer.length; i++) {
			for (int j = 0; j < scoresPer[i].length; j++)
				scoresPer[i][j] = (100.0 * scores[i][j]) / matches;
		}
	}
			
	public void createRatingLists() {
		winHomeRatings = new ArrayList<Comparison>();
		winAwayRatings = new ArrayList<Comparison>();
		overHomeRatings = new ArrayList<Comparison>();
		overAwayRatings = new ArrayList<Comparison>();
		bttsHomeRatings = new ArrayList<Comparison>();
		bttsAwayRatings = new ArrayList<Comparison>();
		cornersHomeRatings = new ArrayList<Comparison>();
		cornersAwayRatings = new ArrayList<Comparison>();

		for (int i = 0; i < teams.size(); i++) {
			winHomeRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.winHomeRating));
			winAwayRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.winAwayRating));
			overHomeRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.overHomeRating));
			overAwayRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.overAwayRating));
			bttsHomeRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.bttsHomeRating));
			bttsAwayRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.bttsAwayRating));
			cornersHomeRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.cornersHomeRating));
			cornersAwayRatings.add(new Comparison(teams.get(i).name, teams.get(i).stats.cornersAwayRating));
		}
		Common.sort(winHomeRatings);
		Common.sort(winAwayRatings);
		Common.sort(overHomeRatings);
		Common.sort(overAwayRatings);
		Common.sort(bttsHomeRatings);
		Common.sort(bttsAwayRatings);
		Common.sort(cornersHomeRatings);
		Common.sort(cornersAwayRatings);
	}

	
	public void createFixtures(){
		if(fixtures!=null)
			if(fixtures.size()>0) {
				for(int i=0;i<fixtures.size();i++){
					for(int j=0;j<teams.size();j++){
						if (fixtures.get(i).homeTeam.equals(teams.get(j).name)) {
							if (teams.get(j).stats.winHomeRating != 0 || teams.get(j).stats.overHomeRating != 0
									|| teams.get(j).stats.bttsHomeRating != 0
									|| teams.get(j).stats.cornersHomeRating != 0)
								fixtures.get(i).hasData = true;
							else if(teams.get(j).stats.matchesHome>0)System.out.println("Alert");
							fixtures.get(i).ratingWin += teams.get(j).stats.winHomeRating;
							fixtures.get(i).ratingOver += teams.get(j).stats.overHomeRating;
							fixtures.get(i).ratingBtts += teams.get(j).stats.bttsHomeRating;
							fixtures.get(i).ratingCorners += ((teams.get(j).stats.cornersHomeRating));
						}

						if (fixtures.get(i).awayTeam.equals(teams.get(j).name)) {
							if (teams.get(j).stats.winAwayRating != 0 || teams.get(j).stats.overAwayRating != 0
									|| teams.get(j).stats.bttsAwayRating != 0
									|| teams.get(j).stats.cornersAwayRating != 0)
								fixtures.get(i).hasData = true;
							else if(teams.get(j).stats.matchesAway>0)System.out.println("Alert");
							fixtures.get(i).ratingWin -= teams.get(j).stats.winAwayRating;
							fixtures.get(i).ratingOver += teams.get(j).stats.overAwayRating;
							fixtures.get(i).ratingBtts += teams.get(j).stats.bttsAwayRating;
							fixtures.get(i).ratingCorners += ((teams.get(j).stats.cornersAwayRating));
						}
					}
				}
				
				fixtureWinRatings = new ArrayList<Comparison>();
				fixtureOverRatings = new ArrayList<Comparison>();
				fixtureBttsRatings = new ArrayList<Comparison>();
				fixtureCornerRatings = new ArrayList<Comparison>();
				for (int i = 0; i < fixtures.size(); i++) {
					fixtureWinRatings.add(new Comparison(code+div+" "+fixtures.get(i).homeTeam + " - " + fixtures.get(i).awayTeam,
							fixtures.get(i).ratingWin, fixtures.get(i).date, fixtures.get(i).hasData));
					fixtureOverRatings.add(new Comparison(code+div+" "+fixtures.get(i).homeTeam + " - " + fixtures.get(i).awayTeam,
							fixtures.get(i).ratingOver, fixtures.get(i).date, fixtures.get(i).hasData));
					fixtureBttsRatings.add(new Comparison(code+div+" "+fixtures.get(i).homeTeam + " - " + fixtures.get(i).awayTeam,
							fixtures.get(i).ratingBtts, fixtures.get(i).date, fixtures.get(i).hasData));
					fixtureCornerRatings.add(new Comparison(code+div+" "+fixtures.get(i).homeTeam + " - " + fixtures.get(i).awayTeam,
							fixtures.get(i).ratingCorners, fixtures.get(i).date, fixtures.get(i).hasData));
				}
				Common.sort(fixtureWinRatings);
				Common.sort(fixtureOverRatings);
				Common.sort(fixtureBttsRatings);
				Common.sort(fixtureCornerRatings);
				}
	}
	
	public void createBetStats() {
		if (!(abr[23].equalsIgnoreCase("X") || abr[24].equalsIgnoreCase("X") || abr[25].equalsIgnoreCase("X"))) {
			for (int i = 1; i < results.size(); i++) {
				if (results.get(i).HODDS != -1 && results.get(i).AODDS != -1 && results.get(i).DODDS != -1) {
					if (results.get(i).FTHG > results.get(i).FTAG) {
						betHome += (results.get(i).HODDS - 1.00);
						betAway--;
						betDraw--;
					}
					if (results.get(i).FTHG < results.get(i).FTAG) {
						betHome--;
						betAway += (results.get(i).AODDS - 1.00);
						betDraw--;
					}
					if (results.get(i).FTHG == results.get(i).FTAG) {
						betHome--;
						betAway--;
						betDraw+= (results.get(i).DODDS - 1.00);
					}
				}else {
				 matchesNoBetInfo++;
				}
			}
		}
	}

	public void printCompetitionAll(){
		printCompetitionBet();

		printCompetitionStats();
		printCompetitionScores();
		
		printAllRatingsLists();
		printAllFixturesStats();
		printAllFixturesRatingsList();
		
		printTeamNames();
		printAllTeamStats();
		printAllTeamScores();
	}
	
	public void printCompetitionBet() {
		System.out.println(nameComplete+" (" + matches + "): ");
		//System.out.println("Bet: H:"+Common.df11.format(betHome)+" A:"+Common.df11.format(betAway)+" D:"+Common.df11.format(betDraw));

		System.out.println("BetHome:"+Common.df11.format(betHome));
		System.out.println("BetDraw:"+Common.df11.format(betDraw));
		System.out.println("BetAway:"+Common.df11.format(betAway));
		
		System.out.println();	
	}

	public void printCompetitionStats(){
		System.out.println(nameComplete+":");
		System.out.println("Played:\t"+matches);
		
		System.out.println("1:\t"+winHome+"("+Common.df11.format(winHomePer)+"%)");
		System.out.println("X:\t"+draw+"("+Common.df11.format(drawPer)+"%)");
		System.out.println("2:\t"+winAway+"("+Common.df11.format(winAwayPer)+"%)");
		
		System.out.println("HomeG:\t"+goalsHome+"("+Common.df12.format(goalsHomeAvg)+")");
		System.out.println("AwayG:\t"+goalsAway+"("+Common.df12.format(goalsAwayAvg)+")");
		System.out.println("TotalG:\t"+goals+"("+Common.df12.format(goalsAvg)+")");
		
		System.out.println("Over:\t"+over+"("+Common.df11.format(overPer)+"%)");
		System.out.println("Btts:\t"+btts+"("+Common.df11.format(bttsPer)+"%)");
		System.out.println("bOver:\t"+bOver+"("+Common.df11.format(bOverPer)+"%)");
		
		System.out.println("0-1:\t"+goals01+"("+Common.df11.format(goals01Per)+"%)");
		System.out.println("2-3:\t"+goals23+"("+Common.df11.format(goals23Per)+"%)");
		System.out.println("4-6:\t"+goals46+"("+Common.df11.format(goals46Per)+"%)");
		System.out.println("7+:\t"+goals7+"("+Common.df11.format(goals7Per)+"%)");
		
		System.out.println();
	}

	public void printCompetitionScores() {
		System.out.print(nameComplete + " scores(" + matches + "): ");
		int tempSum = 0;
		for (int i = 0; i < scores.length; i++) {
			tempSum = 0;
			for (int j = 0; j < scores[i].length; j++) {
				if (scores[i][j] > 0) {
					if (tempSum == 0)
						System.out.println();
					System.out.print(
							i + "-" + j + ": " + scores[i][j] + "(" + Common.df21.format(scoresPer[i][j]) + "%)\t");
					tempSum++;
				}
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public void printAllRatingsLists(){
		System.out.print(nameComplete+" form ratings:\n");
		System.out.println("WinHomeRatings:");
		Common.printList(winHomeRatings);
		System.out.println();
		System.out.println("WinAwayRatings:");
		Common.printList(winAwayRatings);
		System.out.println();
		System.out.println("OverHomeRatings:");
		Common.printList(overHomeRatings);
		System.out.println();
		System.out.println("OverAwayRatings:");
		Common.printList(overAwayRatings);
		System.out.println();
		System.out.println("BttsHomeRatings:");
		Common.printList(bttsHomeRatings);
		System.out.println();
		System.out.println("BttsAwayRatings:");
		Common.printList(bttsAwayRatings);
		System.out.println();	
		System.out.println("CornersHomeRatings:");
		Common.printList(cornersHomeRatings);
		System.out.println();
		System.out.println("CornersAwayRatings:");
		Common.printList(cornersAwayRatings);
		System.out.println();
		
	}

	public void printAllFixturesStats() {
		if (fixtures != null)
			if (fixtures.size() > 0) {
				System.out.println(nameComplete + " fixtures stats:");
				for (int i = 0; i < fixtures.size(); i++) {
					System.out.println(fixtures.get(i).homeTeam + "-" + fixtures.get(i).awayTeam + ":");
					System.out.print("Win:" + fixtures.get(i).ratingWin);
					System.out.print("\tOver:" + fixtures.get(i).ratingOver);
					System.out.print("\tBtts:" + fixtures.get(i).ratingBtts);
					System.out.println("\tCorn:" + fixtures.get(i).ratingCorners);
					System.out.println();
				}
			}
	}

	public void printAllFixturesRatingsList() {
		if (fixtures != null)
			if (fixtures.size() > 0) {
				System.out.println(nameComplete + " fixtures ratings:");
				if (fixtures.size() > 0) {
					System.out.println("Fixture Win Ratings:");
					Common.printList(fixtureWinRatings);
					System.out.println();
					System.out.println("Fixture Over Ratings:");
					Common.printList(fixtureOverRatings);
					System.out.println();
					System.out.println("Fixture Btts Ratings:");
					Common.printList(fixtureBttsRatings);
					System.out.println("");
					System.out.println("Fixture Corner Ratings:");
					Common.printList(fixtureCornerRatings);
					System.out.println("");
				}
			}
	}

	public void printTeamNames(){
		System.out.println(nameComplete+" teams names:");
		for(int i=0;i<teams.size();i++){
			System.out.println(i+": "+teams.get(i).name);
		}
		System.out.println();
	}

	public void printAllTeamStats(){
		System.out.println(nameComplete+" teams stats:");
		System.out.println("________________________________________________________");
		System.out.println();
		for(int i=0;i<teams.size();i++){
			teams.get(i).printTeamStats();
			System.out.println("________________________________________________________\n");
		}
	}

	public void printAllTeamScores(){
		System.out.println(nameComplete+" teams scores:");
		for(int i=0;i<teams.size();i++){
			teams.get(i).printTeamScores();
		}
	}


	public int findTeam(String name) {
		for (int i = 0; i < teams.size(); i++) {
			if (name.equalsIgnoreCase(teams.get(i).name))
				return i;
		}
		return -1;
	}

	public void printTeamAll(int i){
		teams.get(i).printAll();
	}

		
}