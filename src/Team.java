import java.text.DecimalFormat;
import java.util.*;

public class Team{
	public String name;
	public ArrayList<String[]> results;	
	public ArrayList<int[]> formScoresHome, formScoresAway, formScores; //At all 3 this team is always left
	public int scoresHome[][],	scoresAway[][],		scores[][]; //At scores this team is always left
	public int numberOfMatches,		
				matchesHome=0, 		matchesAway=0,		matches=0,
				goalsHome=0, 		goalsAway=0, 		goals=0,
				goalsConHome=0, 	goalsConAway=0, 	goalsCon=0,
				wonHome=0,			wonAway=0,			won=0,
				drawHome=0,			drawAway=0,			draw=0,
				lostHome=0,			lostAway=0,			lost=0,			
				bttsHome=0,			bttsAway=0,			btts=0,
				overHome=0,			overAway=0,			over=0,
				bOverHome=0,		bOverAway=0,		bOver=0,
				wonHomePer=0,		wonAwayPer=0,		wonPer=0,
				drawHomePer=0,		drawAwayPer=0,		drawPer=0,
				lostHomePer=0,		lostAwayPer=0,		lostPer=0,		
				bttsHomePer=0,		bttsAwayPer=0,		bttsPer=0,
				overHomePer=0,		overAwayPer=0,		overPer=0,
				goals01Per=0,	goals23Per=0,	goals46Per=0, goals7Per=0,
				bOverHomePer=0,		bOverAwayPer=0,		bOverPer=0,
				goals01=0,			goals23=0,			goals46=0,		goals7=0,
				formPointsHome=0,	formPointsAway=0,	formPoints=0,
				formGoalsHome=0,	formGoalsAway=0,	formGoals=0,
				formGoalsConHome=0,	formGoalsConAway=0,	formGoalsCon=0,
				formBttsHome=0,		formBttsAway=0,		formBtts=0,
				formOverHome=0,		formOverAway=0,		formOver=0,
				winHomeRating, 		winAwayRating,
				overHomeRating,		overAwayRating,
				bttsHomeRating, 	bttsAwayRating;
		
	public double	goalsHomeAvg=0, 	goalsAwayAvg=0, 	goalsAvg=0,
					goalsConHomeAvg=0, 	goalsConAwayAvg=0, 	goalsConAvg=0;

	
	public Team(String name, List<String[]> results){
		this.name=name;
		this.results = new ArrayList<String[]>(results);
		formScoresHome = new ArrayList<int[]>();
		formScoresAway = new ArrayList<int[]>();
		formScores = new ArrayList<int[]>();
		scoresHome = new int[10][10];
		scoresAway = new int[10][10];
		scores = new int[10][10];
		numberOfMatches=results.size();
		createStats();
		createFormRatings();
	}
	public void printAll(){
		printTeamScores();
		printTeamStats();
		System.out.println();
		printTeamForm();
	}

	public void printTeamScores(){
		System.out.print(name+":");
		int tempSum=0;
		for(int i=0;i<10;i++){
			tempSum=0;
			for(int j=0;j<10;j++){
				if(scores[i][j]>0){
					if(tempSum==0)System.out.println();
					System.out.print(i+"-"+j+": "+scores[i][j]+"("+(100*scores[i][j])/matches+"%)\t");
					tempSum++;
				}
			}
		}
		System.out.println("\n");
	}
	
	public void printTeamStats(){
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormat ndf = new DecimalFormat("00");
		System.out.println(name+":");
		System.out.println("\t\tTotal\t\tHome\t\tAway");
		System.out.println("Matches\t\t"+matches+"\t\t"+matchesHome+"\t\t"+matchesAway);
		System.out.println("Won\t\t"+won+"("+wonPer+"%)\t\t"+wonHome+"("+wonHomePer+"%)\t\t"+wonAway+"("+wonAwayPer+"%)");
		System.out.println("Draw\t\t"+draw+"("+drawPer+"%)\t\t"+drawHome+"("+drawHomePer+"%)\t\t"+drawAway+"("+drawAwayPer+"%)");
		System.out.println("Lost\t\t"+lost+"("+lostPer+"%)\t\t"+lostHome+"("+lostHomePer+"%)\t\t"+lostAway+"("+lostAwayPer+"%)");
		System.out.println("Scored\t\t"+ndf.format(goals)+"("+df.format(goalsAvg)+")\t"+ndf.format(goalsHome)+"("+df.format(goalsHomeAvg)+")\t"+goalsAway+"("+df.format(goalsAwayAvg)+")");
		System.out.println("Conceded\t"+ndf.format(goalsCon)+"("+df.format(goalsConAvg)+")\t"+ndf.format(goalsConHome)+"("+df.format(goalsConHomeAvg)+")\t"+goalsConAway+"("+df.format(goalsConAwayAvg)+")");
		System.out.println("Over\t\t"+over+"("+overPer+"%)\t\t"+overHome+"("+overHomePer+"%)\t\t"+overAway+"("+overAwayPer+"%)");
		System.out.println("Btts\t\t"+btts+"("+bttsPer+"%)\t\t"+bttsHome+"("+bttsHomePer+"%)\t\t"+bttsAway+"("+bttsAwayPer+"%)");
		System.out.println("bOver\t\t"+won+"("+bOverPer+"%)\t\t"+bOverHome+"("+bOverHomePer+"%)\t\t"+bOverAway+"("+bOverAwayPer+"%)");
		System.out.println("0-1:\t"+goals01+"("+goals01Per+"%)");
		System.out.println("2-3:\t"+goals23+"("+goals23Per+"%)");
		System.out.println("4-6:\t"+goals46+"("+goals46Per+"%)");
		System.out.println("7+:\t"+goals7+"("+goals7Per+"%)");
	}
	
	public void printTeamForm(){
		System.out.println(name+" form:");
		System.out.print("Form: ");
		for(int i=0;i<formScores.size();i++){
			System.out.print(formScores.get(i)[0]+"-"+formScores.get(i)[1]+"\t");
		}
		System.out.print("\nHome: ");
		for(int i=0;i<formScoresHome.size();i++){
			System.out.print(formScoresHome.get(i)[0]+"-"+formScoresHome.get(i)[1]+"\t");
		}
		System.out.print("\nAway: ");
		for(int i=0;i<formScoresAway.size();i++){
			System.out.print(formScoresAway.get(i)[0]+"-"+formScoresAway.get(i)[1]+"\t");
		}
		System.out.println();
		System.out.println("\t\tTotal\t\tHome\t\tAway");
		System.out.println("Matches\t\t"+formScores.size()+"\t\t"+formScoresHome.size()+"\t\t"+formScoresAway.size());
		System.out.println("fPoints\t\t"+formPoints+"\t\t"+formPointsHome+"\t\t"+formPointsAway);
		System.out.println("fGoals\t\t"+formGoals+"\t\t"+formGoalsHome+"\t\t"+formGoalsAway);
		System.out.println("fGoalsC\t\t"+formGoalsCon+"\t\t"+formGoalsConHome+"\t\t"+formGoalsConAway);
		System.out.println("fOver\t\t"+formOver+"\t\t"+formOverHome+"\t\t"+formOverAway);
		System.out.println("fBtts\t\t"+formBtts+"\t\t"+formBttsHome+"\t\t"+formBttsAway);
		System.out.println("WinHomeR:  "+winHomeRating+"\t\tWinAwayR:  "+winAwayRating);
		System.out.println("OverHomeR: "+overHomeRating+"\t\tOverAwayR: "+overAwayRating);
		System.out.println("BttsHomeR: "+bttsHomeRating+"\t\tBttsAwayR: "+bttsAwayRating);
		System.out.println("0-1:\t"+goals01+"("+goals01Per+"%)");
		System.out.println("2-3:\t"+goals23+"("+goals23Per+"%)");
		System.out.println("4-6:\t"+goals46+"("+goals46Per+"%)");
		System.out.println("7+:\t"+goals7+"("+goals7Per+"%)");
	}
	
	public void printTeamHistory(){
		
	}
	private void createFormRatings(){
		for(int i=0;i<formScoresHome.size();i++){
			formGoalsHome+=formScoresHome.get(i)[0];
			formGoalsConHome+=formScoresHome.get(i)[1];
			if(formScoresHome.get(i)[0]>formScoresHome.get(i)[1])formPointsHome+=3;
			if(formScoresHome.get(i)[0]==formScoresHome.get(i)[1])formPointsHome++;
			if(formScoresHome.get(i)[0]+formScoresHome.get(i)[1]>2)formOverHome++;
			if(formScoresHome.get(i)[0]>0 && formScoresHome.get(i)[1]>0)formBttsHome++;
		}
		for(int i=0;i<formScoresAway.size();i++){
			formGoalsAway+=formScoresAway.get(i)[0];
			formGoalsConAway+=formScoresAway.get(i)[1];
			if(formScoresAway.get(i)[0]>formScoresAway.get(i)[1])formPointsAway+=3;
			if(formScoresAway.get(i)[0]==formScoresAway.get(i)[1])formPointsAway++;
			if(formScoresAway.get(i)[0]+formScoresAway.get(i)[1]>2)formOverAway++;
			if(formScoresAway.get(i)[0]>0 && formScoresAway.get(i)[1]>0)formBttsAway++;
		}
		for(int i=0;i<formScores.size();i++){
			formGoals+=formScores.get(i)[0];
			formGoalsCon+=formScores.get(i)[1];
			if(formScores.get(i)[0]>formScores.get(i)[1])formPoints+=3;
			if(formScores.get(i)[0]==formScores.get(i)[1])formPoints++;
			if(formScores.get(i)[0]+formScores.get(i)[1]>2)formOver++;
			if(formScores.get(i)[0]>0 && formScores.get(i)[1]>0)formBtts++;
		}
	
		winHomeRating=formPointsHome*(15/(3*formScoresHome.size()))
					+formPoints*(15/(3*formScores.size()))
					+(formGoalsHome-formGoalsConHome)*(8/formScoresHome.size())
					+(formGoals-formGoalsCon)*(8/formScores.size())
					+(int)(wonHomePer*.1)
					+(int)(wonPer*.1)
					+(int)(20*(goalsHomeAvg-goalsConHomeAvg))
					+(int)(10*(goalsAvg-goalsConAvg));
		
		winAwayRating=formPointsAway*(15/(3*formScoresAway.size()))
				+formPoints*(15/(3*formScores.size()))
				+(formGoalsAway-formGoalsConAway)*(8/formScoresAway.size())
				+(formGoals-formGoalsCon)*(8/formScores.size())
				+(int)(wonAwayPer*.1)
				+(int)(wonPer*.1)
				+(int)(20*(goalsAwayAvg-goalsConAwayAvg))
				+(int)(10*(goalsAvg-goalsConAvg));
		if(Analysis.test){
		if(name.equalsIgnoreCase("Holstein Kiel")){
			System.out.println(results.get(1)[1]);
			System.out.println((formOverHome)*(18/formScoresHome.size()));
			System.out.println((formOver)*(15/formScores.size()));
			System.out.println((int)(0.15*overHomePer));
			System.out.println((int)(0.1*overPer));
		}
		}
		overHomeRating=
				(formOverHome)*(18/formScoresHome.size())
				+(formOver)*(15/formScores.size())
				+(int)(0.15*overHomePer)
				+(int)(0.1*overPer)
				+(formBttsHome)*(9/formScoresHome.size());
		
		overAwayRating=
				(formOverAway)*(18/formScoresAway.size())
				+(formOver)*(15/formScores.size())
				+(int)(0.15*overAwayPer)
				+(int)(0.1*overPer)
				+(formBttsAway)*(9/formScoresAway.size());
		
		bttsHomeRating=
				(formBttsHome)*(18/formScoresHome.size())
				+(formBtts)*(15/formScores.size())
				+(int)(0.15*bttsHomePer)
				+(int)(0.1*bttsPer);
		
		bttsAwayRating=
				(formBttsAway)*(18/formScoresAway.size())
				+(formBtts)*(15/formScores.size())
				+(int)(0.15*bttsAwayPer)
				+(int)(0.1*bttsPer);
		/*
		ratingHomeOver=(formGoalsHome)*(9/formHome.size())
				+(formGoals)*(15/form.size())
				+(formGoalsConHome)*(9/formHome.size())
				+(formGoalsCon)*(15/form.size())
				+(formOverHome)*(9/formHome.size())
				+(formOver)*(15/form.size())
				+(int)(20*goalsHomeAvg)
				+(int)(10*goalsAvg)
				+(int)(20*goalsConHomeAvg)
				+(int)(10*goalsConAvg)
				+(int)(0.2*overHomePer)
				+(int)(0.1*overPer);
		
		ratingAwayOver=(formGoalsAway)*(9/formAway.size())
				+(formGoals)*(15/form.size())
				+(formGoalsConAway)*(9/formAway.size())
				+(formGoalsCon)*(15/form.size())
				+(formOverAway)*(9/formAway.size())
				+(formOver)*(15/form.size())
				+(int)(20*goalsAwayAvg)
				+(int)(10*goalsAvg)
				+(int)(20*goalsConAwayAvg)
				+(int)(10*goalsConAvg)
				+(int)(0.2*overAwayPer)
				+(int)(0.1*overPer);
				
		ratingHomeBtts=(formGoalsHome)*(9/formHome.size())
				+(formGoals)*(15/form.size())
				+(formGoalsConHome)*(9/formHome.size())
				+(formGoalsCon)*(15/form.size())
				+(formBttsHome)*(9/formHome.size())
				+(formBtts)*(15/form.size())
				+(int)(20*goalsHomeAvg)
				+(int)(10*goalsAvg)
				+(int)(20*goalsConHomeAvg)
				+(int)(10*goalsConAvg)
				+(int)(0.2*bttsHomePer)
				+(int)(0.1*bttsPer);
		
		ratingAwayBtts=(formGoalsAway)*(9/formAway.size())
				+(formGoals)*(15/form.size())
				+(formGoalsConAway)*(9/formAway.size())
				+(formGoalsCon)*(15/form.size())
				+(formBttsAway)*(9/formAway.size())
				+(formBtts)*(15/form.size())
				+(int)(20*goalsAwayAvg)
				+(int)(10*goalsAvg)
				+(int)(20*goalsConAwayAvg)
				+(int)(10*goalsConAvg)
				+(int)(0.2*bttsAwayPer)
				+(int)(0.1*bttsPer);
		System.out.println("ratingHomeWin:"+ratingHomeWin);
		System.out.println("formPointsHome:"+formPointsHome+">>>"+formPointsHome*(27/(3*formHome.size())));
		System.out.println("formPoints:"+formPoints+">>>"+formPoints*(30/(3*form.size())));
		System.out.println("formGoalsHome:"+(formGoalsHome-formGoalsConHome)+">>>"+(formGoalsHome-formGoalsConHome)*(6/formHome.size()));
		System.out.println("formGoals:"+(formGoals-formGoalsCon)+">>>"+(formGoals-formGoalsCon)*(10/form.size()));
		System.out.println("wonHomePer:"+wonHomePer+">>>"+(int)(wonHomePer*.4));
		System.out.println("wonPer:"+wonPer+">>>"+(int)(wonPer*.3));
		System.out.println("goalsHomeAvg:"+((goalsHomeAvg-goalsConHomeAvg))+">>>"+(int)(50*(goalsHomeAvg-goalsConHomeAvg)));
		System.out.println("goalsAvg:"+((goalsAvg-goalsConAvg))+">>>"+(int)(30*(goalsAvg-goalsConAvg)));
		
		System.out.println("ratingAwayWin:"+ratingAwayWin);
		System.out.println("formPointsAway:"+formPointsAway+">>>"+formPointsAway*(27/(3*formAway.size())));
		System.out.println("formPoints:"+formPoints+">>>"+formPoints*(30/(3*form.size())));
		System.out.println("formGoalsAway:"+(formGoalsAway-formGoalsConAway)+">>>"+(formGoalsAway-formGoalsConAway)*(6/formAway.size()));
		System.out.println("formGoals:"+(formGoals-formGoalsCon)+">>>"+(formGoals-formGoalsCon)*(10/form.size()));
		System.out.println("wonAwayPer:"+wonAwayPer+">>>"+(int)(wonAwayPer*.4));
		System.out.println("wonPer:"+wonPer+">>>"+(int)(wonPer*.3));
		System.out.println("goalsAwayAvg:"+((goalsAwayAvg-goalsConAwayAvg))+">>>"+(int)(40*(goalsAwayAvg-goalsConAwayAvg)));
		System.out.println("goalsAvg:"+((goalsAvg-goalsConAvg))+">>>"+(int)(25*(goalsAvg-goalsConAvg)));
		
		System.out.println("________________________________________________________________");
	*/
	}

	private void createStats(){
		for(int i=1; i<numberOfMatches;i++){
			if(results.get(i)[2].equals(name)){
				goalsHome+=Integer.valueOf(results.get(i)[4]);
				goalsConHome+=Integer.valueOf(results.get(i)[5]);
				matchesHome++;
				if(Integer.valueOf(results.get(i)[4])>0 && Integer.valueOf(results.get(i)[5])>0)bttsHome++;
				if(Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5])>2)overHome++;
				if((Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5])>2)
					&&(Integer.valueOf(results.get(i)[4])>0 && Integer.valueOf(results.get(i)[5])>0))bOverHome++;
				int tempSum = Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5]);
				if(tempSum<2)goals01++;
				if(tempSum>1 && tempSum<4)goals23++;
				if(tempSum>3 && tempSum<7)goals46++;
				if(tempSum>6)goals7++;
				if(Integer.valueOf(results.get(i)[4])>Integer.valueOf(results.get(i)[5]))wonHome++;
				if(Integer.valueOf(results.get(i)[4])<Integer.valueOf(results.get(i)[5]))lostHome++;
				if(Integer.valueOf(results.get(i)[4])==Integer.valueOf(results.get(i)[5]))drawHome++;
				scoresHome[Integer.valueOf(results.get(i)[4])][Integer.valueOf(results.get(i)[5])]++;
				scores[Integer.valueOf(results.get(i)[4])][Integer.valueOf(results.get(i)[5])]++;
				createHomeForm(Integer.valueOf(results.get(i)[4]), Integer.valueOf(results.get(i)[5]));
			}
			else if(results.get(i)[3].equals(name)){
				goalsAway+=Integer.valueOf(results.get(i)[5]);
				goalsConAway+=Integer.valueOf(results.get(i)[4]);
				matchesAway++;
				if(Integer.valueOf(results.get(i)[4])>0 && Integer.valueOf(results.get(i)[5])>0)bttsAway++;
				if(Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5])>2)overAway++;
				if((Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5])>2)
					&&(Integer.valueOf(results.get(i)[4])>0 && Integer.valueOf(results.get(i)[5])>0))bOverAway++;
				int tempSum = Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5]);
				if(tempSum<2)goals01++;
				if(tempSum>1 && tempSum<4)goals23++;
				if(tempSum>3 && tempSum<7)goals46++;
				if(tempSum>6)goals7++;
				if(Integer.valueOf(results.get(i)[4])<Integer.valueOf(results.get(i)[5]))wonAway++;
				if(Integer.valueOf(results.get(i)[4])>Integer.valueOf(results.get(i)[5]))lostAway++;
				if(Integer.valueOf(results.get(i)[4])==Integer.valueOf(results.get(i)[5]))drawAway++;
				scoresAway[Integer.valueOf(results.get(i)[4])][Integer.valueOf(results.get(i)[5])]++;
				scores[Integer.valueOf(results.get(i)[5])][Integer.valueOf(results.get(i)[4])]++;
				createAwayForm(Integer.valueOf(results.get(i)[5]), Integer.valueOf(results.get(i)[4]));
			}
		}
		matches=matchesHome+matchesAway;
		goals=goalsHome+goalsAway;
		goalsCon=goalsConHome+goalsConAway;
		btts=bttsHome+bttsAway;
		over=overHome+overAway;
		bOver=bOverHome+bOverAway;
		won=wonHome+wonAway;
		draw=drawHome+drawAway;
		lost=lostHome+lostAway;
		
		goalsHomeAvg=(double)goalsHome/matchesHome;
		goalsAwayAvg=(double)goalsAway/matchesAway;
		goalsAvg=(double)goals/matches;
		
		goalsConHomeAvg=(double)goalsConHome/matchesHome;
		goalsConAwayAvg=(double)goalsConAway/matchesAway;
		goalsConAvg=(double)goalsCon/matches;
					
		wonHomePer=(100*wonHome)/matchesHome;
		wonAwayPer=(100*wonAway)/matchesAway;
		wonPer=(100*won)/matches;

		lostHomePer=(100*lostHome)/matchesHome;
		lostAwayPer=(100*lostAway)/matchesAway;
		lostPer=(100*lost)/matches;
		
		drawHomePer=(100*drawHome)/matchesHome;
		drawAwayPer=(100*drawAway)/matchesAway;
		drawPer=(100*draw)/matches;
		
		bttsHomePer=(100*bttsHome)/matchesHome;
		bttsAwayPer=(100*bttsAway)/matchesAway;
		bttsPer=(100*btts)/matches;
		
		overHomePer=(100*overHome)/matchesHome;
		overAwayPer=(100*overAway)/matchesAway;
		overPer=(100*over)/matches;
		
		bOverHomePer=(100*bOverHome)/matchesHome;
		bOverAwayPer=(100*bOverAway)/matchesAway;
		bOverPer=(100*bOver)/matches;
		goals01Per=(100*goals01)/matches;
		goals23Per=(100*goals23)/matches;
		goals46Per=(100*goals46)/matches;
		goals7Per=(100*goals7)/matches;
	}

	private void createHomeForm(int team, int opponent){
		if(formScoresHome.size()<3){
			formScoresHome.add(new int[]{team,opponent});
		}
		else{
			formScoresHome.get(0)[0]=formScoresHome.get(1)[0];
			formScoresHome.get(0)[1]=formScoresHome.get(1)[1];
			formScoresHome.get(1)[0]=formScoresHome.get(2)[0];
			formScoresHome.get(1)[1]=formScoresHome.get(2)[1];
			formScoresHome.get(2)[0]=team;
			formScoresHome.get(2)[1]=opponent;
		}
		
		if(formScores.size()<5){
			formScores.add(new int[]{team,opponent});
		}
		else{
			formScores.get(0)[0]=formScores.get(1)[0];
			formScores.get(0)[1]=formScores.get(1)[1];
			formScores.get(1)[0]=formScores.get(2)[0];
			formScores.get(1)[1]=formScores.get(2)[1];
			formScores.get(2)[0]=formScores.get(3)[0];
			formScores.get(2)[1]=formScores.get(3)[1];
			formScores.get(3)[0]=formScores.get(4)[0];
			formScores.get(3)[1]=formScores.get(4)[1];
			formScores.get(4)[0]=team;
			formScores.get(4)[1]=opponent;
		}
	}
	
	private void createAwayForm(int team, int opponent){
		if(formScoresAway.size()<3){
			formScoresAway.add(new int[]{team,opponent});
		}
		else{
			formScoresAway.get(0)[0]=formScoresAway.get(1)[0];
			formScoresAway.get(0)[1]=formScoresAway.get(1)[1];
			formScoresAway.get(1)[0]=formScoresAway.get(2)[0];
			formScoresAway.get(1)[1]=formScoresAway.get(2)[1];
			formScoresAway.get(2)[0]=team;
			formScoresAway.get(2)[1]=opponent;
		}
		if(formScores.size()<5){
			formScores.add(new int[]{team,opponent});
		}
		else{
			formScores.get(0)[0]=formScores.get(1)[0];
			formScores.get(0)[1]=formScores.get(1)[1];
			formScores.get(1)[0]=formScores.get(2)[0];
			formScores.get(1)[1]=formScores.get(2)[1];
			formScores.get(2)[0]=formScores.get(3)[0];
			formScores.get(2)[1]=formScores.get(3)[1];
			formScores.get(3)[0]=formScores.get(4)[0];
			formScores.get(3)[1]=formScores.get(4)[1];
			formScores.get(4)[0]=team;
			formScores.get(4)[1]=opponent;
		}
	}			
}