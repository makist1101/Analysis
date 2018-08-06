import java.util.ArrayList;
import java.util.List;

public class Stats {
	
	public String name;

	public int matchesHome=0,
			matchesAway=0,
			matches=0,
			
			goalsScoHome=0,
			goalsScoAway=0,
			goalsSco=0,
			
			goalsConHome=0,
			goalsConAway=0,
			goalsCon=0,
			
			wonHome=0,
			wonAway=0,
			won=0,
	
			lostHome=0,
			lostAway=0,
			lost=0,
			
			drawHome=0,
			drawAway=0,
			draw=0,
				
			bttsHome=0,
			bttsAway=0,
			btts=0,

			overHome=0,
			overAway=0,
			over=0,
			
			bOverHome=0,
			bOverAway=0,
			bOver=0,
	
			goals01Home=0,
			goals01Away=0,
			goals01=0,
					
			goals23Home=0,
			goals23Away=0,
			goals23=0,
			
			goals46Home=0,
			goals46Away=0,
			goals46=0,
			
			goals7Home=0,
			goals7Away=0,
			goals7=0,
			
			cornersWonHome=0,
			cornersWonAway=0,
			cornersWon=0,
			
			cornersConHome=0,
			cornersConAway=0,
			cornersCon=0;
			
			
	public double goalsScoHomeAvg=0,
			goalsScoAwayAvg=0,
			goalsScoAvg=0,
			
			goalsConHomeAvg=0,
			goalsConAwayAvg=0,
			goalsConAvg=0,
			
			wonHomePer=0,
			wonAwayPer=0,
			wonPer=0,
			
			lostHomePer=0,
			lostAwayPer=0,
			lostPer=0,		
	
			drawHomePer=0,
			drawAwayPer=0,
			drawPer=0,
			
			bttsHomePer=0,
			bttsAwayPer=0,
			bttsPer=0,
			
			overHomePer=0,
			overAwayPer=0,
			overPer=0,
			
			bOverHomePer=0,
			bOverAwayPer=0,
			bOverPer=0,
	
			goals01HomePer=0,
			goals01AwayPer=0,
			goals01Per=0,
					
			goals23HomePer=0,
			goals23AwayPer=0,
			goals23Per=0,
			
			goals46HomePer=0,
			goals46AwayPer=0,
			goals46Per=0,
			
			goals7HomePer=0,
			goals7AwayPer=0,
			goals7Per=0,
			
			cornersWonHomeAvg=0,
			cornersWonAwayAvg=0,
			cornersWonAvg=0,
			
			cornersConHomeAvg=0,
			cornersConAwayAvg=0,
			cornersConAvg=0;
			
	public int form3PointsHome=0,
			form3PointsAway=0,
			form5Points=0,
			
			form3GoalsScoHome=0,
			form3GoalsScoAway=0,
			form5GoalsSco=0,
			
			form3GoalsConHome=0,
			form3GoalsConAway=0,
			form5GoalsCon=0,
			
			form3BttsHome=0,
			form3BttsAway=0,
			form5Btts=0,
			
			form3OverHome=0,
			form3OverAway=0,
			form5Over=0,
			
			matchesFormHome=0,
			matchesFormAway=0,
			matchesForm=0,
						
			
			winHomeRating=0,
			winAwayRating=0,
			
			overHomeRating=0,
			overAwayRating=0,
			
			bttsHomeRating=0,
			bttsAwayRating=0,

			cornersHomeRating=0,
			cornersAwayRating=0,
					
			matchesNoCornersInfoHome=0,
			matchesNoCornersInfoAway=0,
			matchesNoCornersInfo=0,
			
			matchesNoGoalsInfo=0;
			

	public int scoresHome[][],
			scoresAway[][],
			scores[][]; //this team is always left
	
	public double scoresHomePer[][],
	scoresAwayPer[][],
	scoresPer[][]; //this team is always left

	private boolean checkGoalsInfo(Result result) {
		if(result.FTHG==-1 || result.FTAG==-1) {
			matchesNoGoalsInfo++;
			System.out.println(name+"->NoGoalsInfo:"+matchesNoGoalsInfo);
			return false;
		}
		else return true;
		}
		
	private void createTeamGoalStats(Result result) {
		if(checkGoalsInfo(result)){
			if(name.equals(result.homeTeam)) {
				goalsScoHome+=result.FTHG;
				goalsSco+=result.FTHG;
				goalsConHome+=result.FTAG;
				goalsCon+=result.FTAG;
				matchesHome++;
				matches++;
				
				int sumTemp=result.FTHG+result.FTAG;
				
				if(result.FTHG>0 && result.FTAG>0) {bttsHome++; btts++;}
				if(sumTemp>2) {overHome++; over++;}
				if(result.FTHG>0 && result.FTAG>0 && sumTemp>2) {bOverHome++; bOver++;}
				if(sumTemp<2) {goals01Home++; goals01++;}
				if(sumTemp>1 && sumTemp<4) {goals23Home++; goals23++;}
				if(sumTemp>3 && sumTemp<7) {goals46Home++; goals46++;}
				if(sumTemp>6) {goals7Home++; goals7++;}
				
				if(result.FTHG>result.FTAG) {wonHome++; won++;}
				if(result.FTHG<result.FTAG) {lostHome++; lost++;}
				if(result.FTHG==result.FTAG) {drawHome++; draw++;}
				
				scoresHome[result.FTHG][result.FTAG]++;
				scores[result.FTHG][result.FTAG]++;
				} else if(name.equals(result.awayTeam)) {
				goalsScoAway+=result.FTAG;
				goalsSco+=result.FTAG;
				goalsConAway+=result.FTHG;
				goalsCon+=result.FTHG;
				matchesAway++;
				matches++;
				
				int sumTemp=result.FTHG+result.FTAG;
				
				if(result.FTHG>0 && result.FTAG>0) {bttsAway++; btts++;}
				if(sumTemp>2) {overAway++; over++;}
				if(result.FTHG>0 && result.FTAG>0 && sumTemp>2) {bOverAway++; bOver++;}
				if(sumTemp<2) {goals01Away++; goals01++;}
				if(sumTemp>1 && sumTemp<4) {goals23Away++; goals23++;}
				if(sumTemp>3 && sumTemp<7) {goals46Away++; goals46++;}
				if(sumTemp>6) {goals7Away++; goals7++;}
				
				if(result.FTHG<result.FTAG) {wonAway++; won++;}
				if(result.FTHG>result.FTAG) {lostAway++; lost++;}
				if(result.FTHG==result.FTAG) {drawAway++; draw++;}
				scoresAway[result.FTAG][result.FTHG]++;
				scores[result.FTAG][result.FTHG]++;
				}
			}
		}
	
	private void createTeamGoalPer() {
		if(matchesHome>0) {
			goalsScoHomeAvg=(double)goalsScoHome/matchesHome;
			goalsConHomeAvg=(double)goalsConHome/matchesHome;
			wonHomePer=(100.0*wonHome)/matchesHome;
			lostHomePer=(100.0*lostHome)/matchesHome;
			drawHomePer=(100.0*drawHome)/matchesHome;
			bttsHomePer=(100.0*bttsHome)/matchesHome;
			overHomePer=(100.0*overHome)/matchesHome;
			bOverHomePer=(100.0*bOverHome)/matchesHome;
			goals01HomePer=(100.0*goals01)/matches;
			goals23HomePer=(100.0*goals23)/matches;
			goals46HomePer=(100.0*goals46)/matches;
			goals7HomePer=(100.0*goals7)/matches;
			for (int i = 0; i < scoresHomePer.length; i++) {
				for (int j = 0; j < scoresHomePer[i].length; j++)
					scoresHomePer[i][j] =(100.0*scoresHome[i][j])/ matchesHome;
			}
		}
		if(matchesAway>0) {
			goalsScoAwayAvg=(double)goalsScoAway/matchesAway;
			goalsConAwayAvg=(double)goalsConAway/matchesAway;
			wonAwayPer=(100.0*wonAway)/matchesAway;
			lostAwayPer=(100.0*lostAway)/matchesAway;
			drawAwayPer=(100.0*drawAway)/matchesAway;
			bttsAwayPer=(100.0*bttsAway)/matchesAway;
			overAwayPer=(100.0*overAway)/matchesAway;
			bOverAwayPer=(100.0*bOverAway)/matchesAway;
			goals01AwayPer=(100.0*goals01)/matches;
			goals23AwayPer=(100.0*goals23)/matches;
			goals46AwayPer=(100.0*goals46)/matches;
			goals7AwayPer=(100.0*goals7)/matches;
			for (int i = 0; i < scoresAwayPer.length; i++) {
				for (int j = 0; j < scoresAwayPer[i].length; j++)
					scoresAwayPer[i][j] =(100.0*scoresAway[i][j])/ matchesAway;
			}
		}
		
		if(matches>0) {			
			goalsScoAvg=(double)goalsSco/matches;
			goalsConAvg=(double)goalsCon/matches;
			wonPer=(100.0*won)/matches;
			lostPer=(100.0*lost)/matches;
			drawPer=(100.0*draw)/matches;
			bttsPer=(100.0*btts)/matches;
			overPer=(100.0*over)/matches;
			bOverPer=(100.0*bOver)/matches;
			goals01Per=(100.0*goals01)/matches;
			goals23Per=(100.0*goals23)/matches;
			goals46Per=(100.0*goals46)/matches;
			goals7Per=(100.0*goals7)/matches;
			for (int i = 0; i < scoresPer.length; i++) {
				for (int j = 0; j < scoresPer[i].length; j++)
					scoresPer[i][j] =(100.0*scores[i][j])/ matches;
			}
		}
		}
	
	private boolean checkCornersInfo(Result result) {	
		if(result.HC==-1 || result.AC==-1) {
			if(result.homeTeam.equalsIgnoreCase(name)) {
				matchesNoCornersInfoHome++;
				matchesNoCornersInfo++;
			} else {
				matchesNoCornersInfoAway++;	
				matchesNoCornersInfo++;
			}
			//System.out.println("NoCornersInfo:"+matchesNoCornersInfo);
			return false;
		}
		else return true;
		}

	
	private void createTeamCornerStats(Result result) {
		if(checkCornersInfo(result)) {
			if(name.equals(result.homeTeam)) {
				cornersWonHome+=result.HC;
				cornersWon+=result.HC;
				cornersConHome+=result.AC;
				cornersCon+=result.AC;
			} else if(name.equals(result.awayTeam)) {
				cornersWonAway+=result.AC;
				cornersWon+=result.AC;
				cornersConAway+=result.HC;
				cornersCon+=result.HC;
			}
		}
	}
	
	private void createTeamCornerPer() {
		if (matchesHome - matchesNoCornersInfoHome > 0) {
			int sumTemp = matchesHome - matchesNoCornersInfoHome;
			cornersWonHomeAvg = (double) cornersWonHome / sumTemp;
			cornersConHomeAvg = (double) cornersConHome / sumTemp;
		}
		if (matchesAway - matchesNoCornersInfoAway > 0) {
			int sumTemp = matchesAway - matchesNoCornersInfoAway;
			cornersWonAwayAvg = (double) cornersWonAway / sumTemp;
			cornersConAwayAvg = (double) cornersConAway / sumTemp;
		}
		if (matches - matchesNoCornersInfo > 0) {
			int sumTemp = matches - matchesNoCornersInfo;
			cornersWonAvg = (double) cornersWon / sumTemp;
			cornersConAvg = (double) cornersCon / sumTemp;
		}
	}

	private void createFormHome(List<Result> formResultsHome) {
		matchesFormHome=formResultsHome.size();
		for(int i=0;i<formResultsHome.size();i++){
			form3GoalsScoHome+=formResultsHome.get(i).FTHG;
			form3GoalsConHome+=formResultsHome.get(i).FTAG;
			if(formResultsHome.get(i).FTHG>formResultsHome.get(i).FTAG)form3PointsHome+=3;
			if(formResultsHome.get(i).FTHG==formResultsHome.get(i).FTAG)form3PointsHome++;
			if(formResultsHome.get(i).FTHG+formResultsHome.get(i).FTAG>2)form3OverHome++;
			if(formResultsHome.get(i).FTHG+formResultsHome.get(i).FTAG>0)form3BttsHome++;
		}
	}
		
	private void createFormAway(List<Result> formResultsAway) {
		matchesFormAway=formResultsAway.size();
		for(int i=0;i<formResultsAway.size();i++){
			form3GoalsScoAway+=formResultsAway.get(i).FTAG;
			form3GoalsConAway+=formResultsAway.get(i).FTHG;
			if(formResultsAway.get(i).FTHG<formResultsAway.get(i).FTAG)form3PointsAway+=3;
			if(formResultsAway.get(i).FTHG==formResultsAway.get(i).FTAG)form3PointsAway++;
			if(formResultsAway.get(i).FTHG+formResultsAway.get(i).FTAG>2)form3OverAway++;
			if(formResultsAway.get(i).FTHG+formResultsAway.get(i).FTAG>0)form3BttsAway++;
		}
	}

	private void createForm(List<Result> formResults) {
		matchesForm=formResults.size();
		for(int i=0;i<formResults.size();i++){
			if(name.equals(formResults.get(i).homeTeam)) {
				form5GoalsSco+=formResults.get(i).FTHG;
				form5GoalsCon+=formResults.get(i).FTAG;
				if(formResults.get(i).FTHG>formResults.get(i).FTAG)form5Points+=3;
				if(formResults.get(i).FTHG==formResults.get(i).FTAG)form5Points++;
				if(formResults.get(i).FTHG+formResults.get(i).FTAG>2)form5Over++;
				if(formResults.get(i).FTHG+formResults.get(i).FTAG>0)form5Btts++;
			} else if(name.equals(formResults.get(i).awayTeam)) {
				form5GoalsSco+=formResults.get(i).FTAG;
				form5GoalsCon+=formResults.get(i).FTHG;
				if(formResults.get(i).FTHG<formResults.get(i).FTAG)form5Points+=3;
				if(formResults.get(i).FTHG==formResults.get(i).FTAG)form5Points++;
				if(formResults.get(i).FTHG+formResults.get(i).FTAG>2)form5Over++;
				if(formResults.get(i).FTHG+formResults.get(i).FTAG>0)form5Btts++;
				}
			}
	}

	public void createPer() {
		createTeamGoalPer();
		createTeamCornerPer();
	}

	public void createFormStats(List<Result> formResultsHome, List<Result> formResultsAway, List<Result> formResults) {
		createFormHome(formResultsHome);
		createFormAway(formResultsAway);
		createForm(formResults);
		createFormRatings();
	}

	public void createFormRatings(){
		if(matchesFormHome>0) {
			winHomeRating=
					(8*form3PointsHome)/matchesFormHome
					+(5*form5Points)/matchesForm
					+(12*(form3GoalsScoHome-form3GoalsConHome))/matchesFormHome
					+(8*(form5GoalsSco-form5GoalsCon))/matchesForm
					+(int)(wonHomePer*.15)
					+(int)(wonPer*.1)
					+(int)(20*(goalsScoHomeAvg-goalsConHomeAvg))
					+(int)(10*(goalsScoAvg-goalsConAvg));
		
			overHomeRating=
				(18*form3OverHome)/matchesFormHome
				+(12*form5Over)/matchesForm
				+(int)(0.15*overHomePer)
				+(int)(0.1*overPer)
				+(9*form3BttsHome)/matchesFormHome
				+(6*form5Btts)/matchesForm;
		
			bttsHomeRating=
				(18*form3BttsHome)/matchesFormHome
				+(12*form5Btts)/matchesForm
				+(int)(0.15*bttsHomePer)
				+(int)(0.1*bttsPer)
				+(9*form3OverHome)/matchesFormHome
				+(6*form5Over)/matchesForm;
			
			cornersHomeRating=10*(int)((2*cornersWonHomeAvg)+(1*cornersConHomeAvg))/3;
			
		}
		if(matchesFormAway>0) {
			
			winAwayRating=
					(8*form3PointsAway)/matchesFormAway
					+(5*form5Points)/matchesForm
					+(12*(form3GoalsScoAway-form3GoalsConAway))/matchesFormAway
					+(8*(form5GoalsSco-form5GoalsCon))/matchesForm
					+(int)(wonAwayPer*.15)
					+(int)(wonPer*.1)
					+(int)(20*(goalsScoAwayAvg-goalsConAwayAvg))
					+(int)(10*(goalsScoAvg-goalsConAvg));
		
			overAwayRating=
				(18*form3OverAway)/matchesFormAway
				+(12*form5Over)/matchesForm
				+(int)(0.15*overAwayPer)
				+(int)(0.1*overPer)
				+(9*form3BttsAway)/matchesFormAway
				+(6*form5Btts)/matchesForm;
		
			bttsAwayRating=
				(18*form3BttsAway)/matchesFormAway
				+(12*form5Btts)/matchesForm
				+(int)(0.15*bttsAwayPer)
				+(int)(0.1*bttsPer)
				+(9*form3OverAway)/matchesFormAway
				+(6*form5Over)/matchesForm;
			
			cornersAwayRating=10*(int)((2*cornersWonAwayAvg)+(1*cornersConAwayAvg))/3;
			}
	}


	public void addResult(Result result) {
		createTeamGoalStats(result);
		createTeamCornerStats(result);
	}

	Stats(String name){
		this.name=name;
		scoresHome = new int[15][15];
		scoresAway = new int[15][15];
		scores = new int[15][15];
		scoresHomePer = new double[15][15];
		scoresAwayPer = new double[15][15];
		scoresPer = new double[15][15];
		}
}