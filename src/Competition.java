import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Competition{
	public List<Team> teams;
	public List<Result> results;
	public List<Fixture> fixtures;
	
	static int matchesCounter=0;
	String nameComplete;
	String name;
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
				
				wonHome=0,
				wonAway=0,
				draw=0,
				
				btts=0,
				over=0,
				bOver=0,
				
				goals01=0,
				goals23=0,
				goals46=0,
				goals7=0,
				goals12=0,
				goals13=0,
				goals24=0,

				cornersHome=0,
				cornersAway=0,
				corners=0,
				
				shotsHome=0,
				shotsAway=0,
				shots=0,
				
				shotsOnTargetHome=0,
				shotsOnTargetAway=0,
				shotsOnTarget=0,
				
				foulsHome=0,
				foulsAway=0,
				fouls=0,
				
				yellowsHome=0,
				yellowsAway=0,
				yellows=0,
				
				redsHome=0,
				redsAway=0,
				reds=0,

				goalsHomeFH=0,
				goalsAwayFH=0,
				goalsFH=0,
				wonHomeFH=0,
				wonAwayFH=0,
				drawFH=0,
				bttsFH=0,
				overFH=0,
				bOverFH=0,
				goals0FH=0,
				goals1FH=0,
				goals12FH=0,
			
				goalsHomeSH=0,
				goalsAwaySH=0,
				goalsSH=0,
				wonHomeSH=0,
				wonAwaySH=0,
				drawSH=0,
				bttsSH=0,
				overSH=0,
				bOverSH=0,
				goals0SH=0,
				goals1SH=0,
				goals12SH=0,
				
				hfHH=0,
				hfHX=0,
				hfHA=0,
				hfXH=0,
				hfXX=0,
				hfXA=0,
				hfAH=0,
				hfAX=0,
				hfAA=0;

	
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
					goals12Per=0,
					goals13Per=0,
					goals24Per=0,
				
					cornersHomeAvg=0,
					cornersAwayAvg=0,
					cornersAvg=0,
					
					shotsHomeAvg=0,
					shotsAwayAvg=0,
					shotsAvg=0,
					
					shotsOnTargetHomeAvg=0,
					shotsOnTargetAwayAvg=0,
					shotsOnTargetAvg=0,
					
					foulsHomeAvg=0,
					foulsAwayAvg=0,
					foulsAvg=0,
					
					yellowsHomeAvg=0,
					yellowsAwayAvg=0,
					yellowsAvg=0,
					
					redsHomeAvg=0,
					redsAwayAvg=0,
					redsAvg=0,
				
					goalsHomeFHAvg=0,
					goalsAwayFHAvg=0,
					goalsFHAvg=0,
					wonHomeFHPer=0,
					wonAwayFHPer=0,
					drawFHPer=0,
					bttsFHPer=0,
					overFHPer=0,
					bOverFHPer=0,
					goals0FHPer=0,
					goals1FHPer=0,
					goals12FHPer=0,
				
					goalsHomeSHAvg=0,
					goalsAwaySHAvg=0,
					goalsSHAvg=0,
					wonHomeSHPer=0,
					wonAwaySHPer=0,
					drawSHPer=0,
					bttsSHPer=0,
					overSHPer=0,
					bOverSHPer=0,
					goals0SHPer=0,
					goals1SHPer=0,
					goals12SHPer=0,
					
					hfHHPer=0,
					hfHXPer=0,
					hfHAPer=0,
					hfXHPer=0,
					hfXXPer=0,
					hfXAPer=0,
					hfAHPer=0,
					hfAXPer=0,
					hfAAPer=0;
	
	public int matchesCornersInfo=0,
			matchesShotsInfo=0,
			matchesShotsOnTargetInfo=0,
			matchesFoulsInfo=0,
			matchesYellowsInfo=0,
			matchesRedsInfo=0,
			matchesHalfInfo=0;
	
	public double matchesPerTeam=0;
	public int[][] scores;	
	public double[][] scoresPer;
	
	public Competition(List<Result> results, List<Fixture> fixtures, String name, String code, int div, int year,
			boolean extra, String[] abr, String[] abrFix){
		this.nameComplete=name+"-"+div+" "+year;
		this.name=name;
		this.code=code;
		this.div=div;
		this.year=year;
		this.extra=extra;
		this.abr=abr;
		this.abrFix=abrFix;
		
		this.results = new ArrayList<Result>(results);
		if(fixtures!=null)
		this.fixtures = new ArrayList<Fixture>(fixtures);
		matchesCounter+=results.size();
		matches=results.size();
		createTeams();
		matchesPerTeam=((double)2*matches)/teams.size();
		createGoalStatsPer();
		createOtherStatsPer();
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
			if (sumTemp > 0 && sumTemp < 3)
				goals12++;
			if (sumTemp > 0 && sumTemp < 4)
				goals13++;
			if (sumTemp > 1 && sumTemp < 5)
				goals24++;
			
			
			if (results.get(i).FTHG > results.get(i).FTAG)
				wonHome++;
			if (results.get(i).FTHG < results.get(i).FTAG)
				wonAway++;
			if (results.get(i).FTHG == results.get(i).FTAG)
				draw++;
			scores[results.get(i).FTHG][results.get(i).FTAG]++;
		}
	
		goalsHomeAvg = (double) (goalsHome) / matches;
		goalsAwayAvg = (double) (goalsAway) / matches;
		goalsAvg = (double) (goals) / matches;
		winHomePer = (100.0 * wonHome) / matches;
		winAwayPer = (100.0 * wonAway) / matches;
		drawPer = (100.0 * draw) / matches;
		bttsPer = (100.0 * btts) / matches;
		overPer = (100.0 * over) / matches;
		bOverPer = (100.0 * bOver) / matches;
		goals01Per = (100.0 * goals01) / matches;
		goals23Per = (100.0 * goals23) / matches;
		goals46Per = (100.0 * goals46) / matches;
		goals7Per = (100.0 * goals7) / matches;
		goals12Per = (100.0 * goals12) / matches;
		goals13Per = (100.0 * goals13) / matches;
		goals24Per = (100.0 * goals24) / matches;
		
		for (int i = 0; i < scoresPer.length; i++) {
			for (int j = 0; j < scoresPer[i].length; j++)
				scoresPer[i][j] = (100.0 * scores[i][j]) / matches;
		}
	}
			
	public void createOtherStatsPer() {
		for(int i=0;i<results.size();i++) {
		if(results.get(i).HTHG !=-1 && results.get(i).HTAG !=-1){
				matchesHalfInfo++;
				
				goalsHomeFH+=results.get(i).HTHG;
				goalsAwayFH+=results.get(i).HTAG;
				int sumTemp1=results.get(i).HTHG+results.get(i).HTAG;
				if(results.get(i).HTHG>0 && results.get(i).HTAG>0) {bttsFH++;}
				if(sumTemp1>2) {overFH++;}
				if(results.get(i).HTHG>0 && results.get(i).HTAG>0 && sumTemp1>2) {bOverFH++;}
				if(sumTemp1==0) {goals0FH++;}
				if(sumTemp1==1) {goals1FH++;}
				if(sumTemp1>0 && sumTemp1<3) {goals12FH++;}
				
				goalsHomeSH+=results.get(i).FTHG-results.get(i).HTHG;
				goalsAwaySH+=results.get(i).FTAG-results.get(i).HTAG;
				int sumTemp2=(results.get(i).FTHG+results.get(i).FTHG)-(results.get(i).HTHG+results.get(i).HTAG);
				if(results.get(i).FTHG-results.get(i).HTHG>0 && results.get(i).FTAG-results.get(i).HTAG>0) {bttsSH++;}
				if(sumTemp2>2) {overSH++;}
				if(results.get(i).FTHG-results.get(i).HTHG>0 && results.get(i).FTAG-results.get(i).HTAG>0 && sumTemp2>2) {bOverSH++;}
				if(sumTemp2==0) {goals0SH++;}
				if(sumTemp2==1) {goals1SH++;}
				if(sumTemp2>0 && sumTemp2<3) {goals12SH++;}
				
				if(results.get(i).HTHG>results.get(i).HTAG) {wonHomeFH++;}
				if(results.get(i).HTHG<results.get(i).HTAG) {wonAwayFH++;}
				if(results.get(i).HTHG==results.get(i).HTAG) {drawFH++;}
				if(results.get(i).FTHG-results.get(i).HTHG>results.get(i).FTAG-results.get(i).HTAG) {wonHomeSH++;}
				if(results.get(i).FTHG-results.get(i).HTHG<results.get(i).FTAG-results.get(i).HTAG)	{wonAway++;}
				if(results.get(i).FTHG-results.get(i).HTHG==results.get(i).FTAG-results.get(i).HTAG) {drawSH++;}
				if(results.get(i).HTHG>results.get(i).HTAG) {
					if(results.get(i).FTHG>results.get(i).FTAG) {hfHH++;}
					if(results.get(i).FTHG<results.get(i).FTAG)	{hfHA++;}
					if(results.get(i).FTHG==results.get(i).FTAG) {hfHX++;}
				}
				if(results.get(i).HTHG<results.get(i).HTAG) {
					if(results.get(i).FTHG>results.get(i).FTAG) {hfAH++;}
					if(results.get(i).FTHG<results.get(i).FTAG)	{hfAA++;}
					if(results.get(i).FTHG==results.get(i).FTAG) {hfAX++;}
				}
				if(results.get(i).HTHG==results.get(i).HTAG) {
					if(results.get(i).FTHG>results.get(i).FTAG) {hfXH++;}
					if(results.get(i).FTHG<results.get(i).FTAG)	{hfXA++;}
					if(results.get(i).FTHG==results.get(i).FTAG) {hfXX++;}
				}
			}	
		
		
			if (results.get(i).HC != -1 && results.get(i).AC != -1) {
				matchesCornersInfo++;
				cornersHome += results.get(i).HC;
				cornersAway += results.get(i).AC;
				corners += results.get(i).HC+results.get(i).AC;
			
			}

			if (results.get(i).HS != -1 && results.get(i).AS != -1) {
				matchesShotsInfo++;
				shotsHome += results.get(i).HS;
				shotsAway += results.get(i).AS;
				shots += results.get(i).HS + results.get(i).AS;

			}

			if (results.get(i).HST != -1 && results.get(i).AST != -1) {
				matchesShotsOnTargetInfo++;
				shotsOnTargetHome += results.get(i).HST;
				shotsOnTargetAway += results.get(i).AST;
				shotsOnTarget += results.get(i).HST+results.get(i).AST;
			
			}

			if (results.get(i).HY != -1 && results.get(i).AY != -1) {
				matchesYellowsInfo++;
				yellowsHome += results.get(i).HY;
				yellowsAway += results.get(i).AY;
				yellows += results.get(i).HY+results.get(i).AY;

			}

			if (results.get(i).HR != -1 && results.get(i).AR != -1) {
				matchesRedsInfo++;
				redsHome += results.get(i).HR;
				redsAway += results.get(i).AR;
				reds += results.get(i).HR+results.get(i).AR;

			}
			if (results.get(i).HF != -1 && results.get(i).AF != -1) {
				matchesFoulsInfo++;
				foulsHome += results.get(i).HF;
				foulsAway += results.get(i).AF;
				fouls += results.get(i).HF+results.get(i).AF;

			}
		}
		if(matchesCornersInfo>0) {
		cornersHomeAvg = ((double) cornersHome) / matchesCornersInfo;
		cornersAwayAvg = ((double) cornersAway) / matchesCornersInfo;
		cornersAvg = ((double) corners) / matchesCornersInfo;
		}
		if(matchesShotsInfo>0) {
		shotsHomeAvg = ((double) shotsHome) / matchesShotsInfo;
		shotsAwayAvg = ((double) shotsAway) / matchesShotsInfo;
		shotsAvg = ((double) shots) / matchesShotsInfo;
		}
		if(matchesShotsOnTargetInfo>0) {
		shotsOnTargetHomeAvg = ((double) shotsOnTargetHome) / matchesShotsOnTargetInfo;
		shotsOnTargetAwayAvg = ((double) shotsOnTargetAway) / matchesShotsOnTargetInfo;
		shotsOnTargetAvg = ((double) shotsOnTarget) / matchesShotsOnTargetInfo;
		}
		if(matchesFoulsInfo>0) {
		foulsHomeAvg = ((double) foulsHome) / matchesFoulsInfo;
		foulsAwayAvg = ((double) foulsAway) / matchesFoulsInfo;
		foulsAvg = ((double) fouls) / matchesFoulsInfo;
		}
		if(matchesYellowsInfo>0) {
		yellowsHomeAvg = ((double) yellowsHome) / matchesYellowsInfo;
		yellowsAwayAvg = ((double) yellowsAway) / matchesYellowsInfo;
		yellowsAvg = ((double) yellows) / matchesYellowsInfo;
		}
		if(matchesRedsInfo>0) {
		redsHomeAvg = ((double) redsHome) / matchesRedsInfo;
		redsAwayAvg = ((double) redsAway) / matchesRedsInfo;
		redsAvg = ((double) reds) / matchesRedsInfo;
		}
		if(matchesHalfInfo>0) {
		goalsHomeFHAvg = ((double) goalsHomeFH) / matchesHalfInfo;
		goalsAwayFHAvg = ((double) goalsAwayFH) / matchesHalfInfo;
		goalsFHAvg = ((double) goalsFH) / matchesHalfInfo;
		wonHomeFHPer = (100.0 * wonHomeFH) / matchesHalfInfo;
		wonAwayFHPer = (100.0 * wonAwayFH) / matchesHalfInfo;
		drawFHPer = (100.0 * drawFH) / matchesHalfInfo;
		bttsFHPer = (100.0 * bttsFH) / matchesHalfInfo;
		overFHPer = (100.0 * overFH) / matchesHalfInfo;
		bOverFHPer = (100.0 * bOverFH) / matchesHalfInfo;
		goals0FHPer = (100.0 * goals0FH) / matchesHalfInfo;
		goals1FHPer = (100.0 * goals1FH) / matchesHalfInfo;
		goals12FHPer = (100.0 * goals12FH) / matchesHalfInfo;

		goalsHomeSHAvg = ((double) goalsHomeSH) / matchesHalfInfo;
		goalsAwaySHAvg = ((double) goalsAwaySH) / matchesHalfInfo;
		goalsSHAvg = ((double) goalsSH) / matchesHalfInfo;
		wonHomeSHPer = (100.0 * wonHomeSH) / matchesHalfInfo;
		wonAwaySHPer = (100.0 * wonAwaySH) / matchesHalfInfo;
		drawSHPer = (100.0 * drawSH) / matchesHalfInfo;
		bttsSHPer = (100.0 * bttsSH) / matchesHalfInfo;
		overSHPer = (100.0 * overSH) / matchesHalfInfo;
		bOverSHPer = (100.0 * bOverSH) / matchesHalfInfo;
		goals0SHPer = (100.0 * goals0SH) / matchesHalfInfo;
		goals1SHPer = (100.0 * goals1SH) / matchesHalfInfo;
		goals12SHPer = (100.0 * goals12SH) / matchesHalfInfo;

		hfHHPer = (100.0 * hfHH) / matchesHalfInfo;
		hfHXPer = (100.0 * hfHX) / matchesHalfInfo;
		hfHAPer = (100.0 * hfHA) / matchesHalfInfo;
		hfXHPer = (100.0 * hfXH) / matchesHalfInfo;
		hfXXPer = (100.0 * hfXX) / matchesHalfInfo;
		hfXAPer = (100.0 * hfXA) / matchesHalfInfo;
		hfAHPer = (100.0 * hfAH) / matchesHalfInfo;
		hfAXPer = (100.0 * hfAX) / matchesHalfInfo;
		hfAAPer = (100.0 * hfAA) / matchesHalfInfo;
	}}

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
							else if(teams.get(j).stats.matchesHome>0){
								//System.out.println("Alert awkward ratings "+teams.get(j).name);
								}
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
							else if(teams.get(j).stats.matchesAway>0) {
								//System.out.println("Alert awkward ratings "+teams.get(j).name);
							}
							fixtures.get(i).ratingWin -= teams.get(j).stats.winAwayRating;
							fixtures.get(i).ratingOver += teams.get(j).stats.overAwayRating;
							fixtures.get(i).ratingBtts += teams.get(j).stats.bttsAwayRating;
							fixtures.get(i).ratingCorners += ((teams.get(j).stats.cornersAwayRating));
							fixtures.get(i).multi();
						}
					}
				}
				
				fixtureWinRatings = new ArrayList<Comparison>();
				fixtureOverRatings = new ArrayList<Comparison>();
				fixtureBttsRatings = new ArrayList<Comparison>();
				fixtureCornerRatings = new ArrayList<Comparison>();
				for (int i = 0; i < fixtures.size(); i++) {
					fixtureWinRatings.add(new Comparison(Common.df12.format(Math.abs(fixtures.get(i).HODDS)) + "/"
									+ Common.df12.format(Math.abs(fixtures.get(i).AODDS))+" "+(Math.abs(fixtures.get(i).ratingOver))+ " " + code + div + " "
									+ Common.df21.format(matchesPerTeam) + " " + fixtures.get(i).homeTeam + " - "
									+ fixtures.get(i).awayTeam,
							fixtures.get(i).ratingWin, fixtures.get(i).date, fixtures.get(i).hasData));
					fixtureOverRatings.add(new Comparison(
							Common.df12.format(Math.abs(fixtures.get(i).OODDS)) + " " + code + div + " "
									+ Common.df21.format(matchesPerTeam) + " " + fixtures.get(i).homeTeam + " - "
									+ fixtures.get(i).awayTeam,
							fixtures.get(i).ratingOver, fixtures.get(i).date, fixtures.get(i).hasData));
					fixtureBttsRatings.add(new Comparison(
							code + div + " " + Common.df21.format(matchesPerTeam) + " " + fixtures.get(i).homeTeam
									+ " - " + fixtures.get(i).awayTeam,
							fixtures.get(i).ratingBtts, fixtures.get(i).date, fixtures.get(i).hasData));
					fixtureCornerRatings.add(new Comparison(
							code + div + " " + Common.df21.format(matchesPerTeam) + " " + fixtures.get(i).homeTeam
									+ " - " + fixtures.get(i).awayTeam,
							fixtures.get(i).ratingCorners, fixtures.get(i).date, fixtures.get(i).hasData));
				}
				Common.sort(fixtureWinRatings);
				Common.sort(fixtureOverRatings);
				Common.sort(fixtureBttsRatings);
				Common.sort(fixtureCornerRatings);
			}
	}
	
	public void createBetStats() {

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
		System.out.println(nameComplete+" (" + matches + "): Currently empty");
	}

	public void printCompetitionStats(){
		System.out.println(nameComplete+":");
		System.out.println("Played:\t"+matches);
		
		System.out.println("1:\t"+wonHome+"("+Common.df11.format(winHomePer)+"%)");
		System.out.println("X:\t"+draw+"("+Common.df11.format(drawPer)+"%)");
		System.out.println("2:\t"+wonAway+"("+Common.df11.format(winAwayPer)+"%)");
		
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