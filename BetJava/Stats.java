import java.util.ArrayList;
import java.util.List;

public class Stats {
	
	public String name;
/*
	public static double 
			mfpha=3*	1.0,
			mfp=2*	0.5,
			mfgha=3*	1.0,
			mfg=2*	0.5,
			
			mwha=	1.0,
			mw=		0.5,
			mgha=2*	1.0,
			mg=3*		0.5,

			mfoha=7.5*	1.0,
			mfo=5*	0.5,
			moha=	1.0,
			mo=		0.5,

			mfbha=7.5*	1.0,
			mfb=5*	0.5,
			mbha=	1.0,
			mb=		0.5;
*/

	public static double 
	mfpha=5*	1.0,
	mfp=3*	0.5,
	mfgha=3*	1.0,
	mfg=2*	0.5,
	
	mwha=3*	1.0,
	mw=2*		0.5,
	mgha=0*	1.0,
	mg=0*		0.5,

	mfoha=7.5*	1.0,
	mfo=5*	0.5,
	moha=3*	1.0,
	mo=		0.5,

	mfbha=7.5*	1.0,
	mfb=5*	0.5,
	mbha=	1.0,
	mb=		0.5;

	
	public static int teamsCounter=0;
	
	public static int 
	winHomeRatingMin = 100,	winHomeRatingMax = 0,winHomeRatingSum = 0, 
	winAwayRatingMin = 100, winAwayRatingMax = 0,winAwayRatingSum = 0, 
	overHomeRatingMin = 100,overHomeRatingMax = 0,overHomeRatingSum = 0,
	overAwayRatingMin = 100,overAwayRatingMax = 0,overAwayRatingSum = 0,
	bttsHomeRatingMin = 100,bttsHomeRatingMax = 0,bttsHomeRatingSum=0,
	bttsAwayRatingMin = 100,bttsAwayRatingMax = 0,bttsAwayRatingSum=0,
	cornersHomeRatingMin = 100,cornersHomeRatingMax = 0,cornersHomeRatingSum = 0,
	cornersAwayRatingMin = 100,cornersAwayRatingMax = 0,cornersAwayRatingSum = 0;

	public static double 
			fphMin=100, fphMax=0, fphSum=0,
			fghMin=100,fghMax=0,fghSum=0,
			whMin=100,whMax=0,whSum=0,
			ghMin=100,ghMax=0,ghSum=0,
			fohMin=100,fohMax=0,fohSum=0,
			ohMin=100,ohMax=0,ohSum=0,
			fbhMin=100,fbhMax=0,fbhSum=0,
			bhMin=100,bhMax=0,bhSum=0,
			
			fpaMin=100, fpaMax=0, fpaSum=0,
			fgaMin=100,fgaMax=0,fgaSum=0,
			waMin=100,waMax=0,waSum=0,
			gaMin=100,gaMax=0,gaSum=0,
			foaMin=100,foaMax=0,foaSum=0,
			oaMin=100,oaMax=0,oaSum=0,
			fbaMin=100,fbaMax=0,fbaSum=0,
			baMin=100,baMax=0,baSum=0,
						
			fpMin=100, fpMax=0, fpSum=0,
			fgMin=100,fgMax=0,fgSum=0,
			wMin=100,wMax=0,wSum=0,
			gMin=100,gMax=0,gSum=0,
			foMin=100,foMax=0,foSum=0,
			oMin=100,oMax=0,oSum=0,
			fbMin=100,fbMax=0,fbSum=0,
			bMin=100,bMax=0,bSum=0;
		
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
			
			goals12Home=0,
			goals12Away=0,
			goals12=0,
				
			goals13Home=0,
			goals13Away=0,
			goals13=0,
		
			goals24Home=0,
			goals24Away=0,
			goals24=0,

			cornersWonHome=0,
			cornersWonAway=0,
			cornersWon=0,
			
			shotsWonHome=0,
			shotsWonAway=0,
			shotsWon=0,
			
			shotsOnTargetWonHome=0,
			shotsOnTargetWonAway=0,
			shotsOnTargetWon=0,
	
			foulsWonHome=0,
			foulsWonAway=0,
			foulsWon=0,
			
			yellowsWonHome=0,
			yellowsWonAway=0,
			yellowsWon=0,

			redsWonHome=0,
			redsWonAway=0,
			redsWon=0,
			
			cornersConHome=0,
			cornersConAway=0,
			cornersCon=0,
	
			shotsConHome=0,
			shotsConAway=0,
			shotsCon=0,
			
			shotsOnTargetConHome=0,
			shotsOnTargetConAway=0,
			shotsOnTargetCon=0,
	
			foulsConHome=0,
			foulsConAway=0,
			foulsCon=0,
			
			yellowsConHome=0,
			yellowsConAway=0,
			yellowsCon=0,

			redsConHome=0,
			redsConAway=0,
			redsCon=0,

			goalsScoHomeFH=0,
			goalsScoAwayFH=0,
			goalsScoFH=0,
			
			goalsConHomeFH=0,
			goalsConAwayFH=0,
			goalsConFH=0,
			
			wonHomeFH=0,
			wonAwayFH=0,
			wonFH=0,
	
			lostHomeFH=0,
			lostAwayFH=0,
			lostFH=0,
			
			drawHomeFH=0,
			drawAwayFH=0,
			drawFH=0,
				
			bttsHomeFH=0,
			bttsAwayFH=0,
			bttsFH=0,

			overHomeFH=0,
			overAwayFH=0,
			overFH=0,
			
			bOverHomeFH=0,
			bOverAwayFH=0,
			bOverFH=0,
	
			goals0HomeFH=0,
			goals0AwayFH=0,
			goals0FH=0,
					
			goals1HomeFH=0,
			goals1AwayFH=0,
			goals1FH=0,
			
			goals12HomeFH=0,
			goals12AwayFH=0,
			goals12FH=0,

			goalsScoHomeSH=0,
			goalsScoAwaySH=0,
			goalsScoSH=0,
			
			goalsConHomeSH=0,
			goalsConAwaySH=0,
			goalsConSH=0,
			
			wonHomeSH=0,
			wonAwaySH=0,
			wonSH=0,
	
			lostHomeSH=0,
			lostAwaySH=0,
			lostSH=0,
			
			drawHomeSH=0,
			drawAwaySH=0,
			drawSH=0,
				
			bttsHomeSH=0,
			bttsAwaySH=0,
			bttsSH=0,

			overHomeSH=0,
			overAwaySH=0,
			overSH=0,
			
			bOverHomeSH=0,
			bOverAwaySH=0,
			bOverSH=0,
	
			goals0HomeSH=0,
			goals0AwaySH=0,
			goals0SH=0,
					
			goals1HomeSH=0,
			goals1AwaySH=0,
			goals1SH=0,
			
			goals12HomeSH=0,
			goals12AwaySH=0,
			goals12SH=0,
			
			hfWWHome=0,
			hfWWAway=0,
			hfWW=0,
							
			hfWXHome=0,
			hfWXAway=0,
			hfWX=0,
			
			hfWLHome=0,
			hfWLAway=0,
			hfWL=0,
					
			hfXWHome=0,
			hfXWAway=0,
			hfXW=0,
			
			
			hfXXHome=0,
			hfXXAway=0,
			hfXX=0,
			
			hfXLHome=0,
			hfXLAway=0,
			hfXL=0,
			
			hfLWHome=0,
			hfLWAway=0,
			hfLW=0,
			
			hfLXHome=0,
			hfLXAway=0,
			hfLX=0,
			
			hfLLHome=0,
			hfLLAway=0,
			hfLL=0;
			
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
		
			goals12HomePer=0,
			goals12AwayPer=0,
			goals12Per=0,
				
			goals13HomePer=0,
			goals13AwayPer=0,
			goals13Per=0,
		
			goals24HomePer=0,
			goals24AwayPer=0,
			goals24Per=0,

			cornersWonHomeAvg=0,
			cornersWonAwayAvg=0,
			cornersWonAvg=0,
			
			shotsWonHomeAvg=0,
			shotsWonAwayAvg=0,
			shotsWonAvg=0,
			
			shotsOnTargetWonHomeAvg=0,
			shotsOnTargetWonAwayAvg=0,
			shotsOnTargetWonAvg=0,
	
			foulsWonHomeAvg=0,
			foulsWonAwayAvg=0,
			foulsWonAvg=0,
			
			yellowsWonHomeAvg=0,
			yellowsWonAwayAvg=0,
			yellowsWonAvg=0,

			redsWonHomeAvg=0,
			redsWonAwayAvg=0,
			redsWonAvg=0,
			
			cornersConHomeAvg=0,
			cornersConAwayAvg=0,
			cornersConAvg=0,
	
			shotsConHomeAvg=0,
			shotsConAwayAvg=0,
			shotsConAvg=0,
			
			shotsOnTargetConHomeAvg=0,
			shotsOnTargetConAwayAvg=0,
			shotsOnTargetConAvg=0,
	
			foulsConHomeAvg=0,
			foulsConAwayAvg=0,
			foulsConAvg=0,
			
			yellowsConHomeAvg=0,
			yellowsConAwayAvg=0,
			yellowsConAvg=0,

			redsConHomeAvg=0,
			redsConAwayAvg=0,
			redsConAvg=0,	

			wonHomeFHPer=0,
			wonAwayFHPer=0,
			wonFHPer=0,
		
			lostHomeFHPer=0,
			lostAwayFHPer=0,
			lostFHPer=0,
			
			drawHomeFHPer=0,
			drawAwayFHPer=0,
			drawFHPer=0,
				
			bttsHomeFHPer=0,
			bttsAwayFHPer=0,
			bttsFHPer=0,
		
			overHomeFHPer=0,
			overAwayFHPer=0,
			overFHPer=0,
			
			bOverHomeFHPer=0,
			bOverAwayFHPer=0,
			bOverFHPer=0,
		
			goals0HomeFHPer=0,
			goals0AwayFHPer=0,
			goals0FHPer=0,
					
			goals1HomeFHPer=0,
			goals1AwayFHPer=0,
			goals1FHPer=0,
			
			goals12HomeFHPer=0,
			goals12AwayFHPer=0,
			goals12FHPer=0,

			
			wonHomeSHPer=0,
			wonAwaySHPer=0,
			wonSHPer=0,
		
			lostHomeSHPer=0,
			lostAwaySHPer=0,
			lostSHPer=0,
			
			drawHomeSHPer=0,
			drawAwaySHPer=0,
			drawSHPer=0,
				
			bttsHomeSHPer=0,
			bttsAwaySHPer=0,
			bttsSHPer=0,
		
			overHomeSHPer=0,
			overAwaySHPer=0,
			overSHPer=0,
			
			bOverHomeSHPer=0,
			bOverAwaySHPer=0,
			bOverSHPer=0,
		
			goals0HomeSHPer=0,
			goals0AwaySHPer=0,
			goals0SHPer=0,
					
			goals1HomeSHPer=0,
			goals1AwaySHPer=0,
			goals1SHPer=0,
			
			goals12HomeSHPer=0,
			goals12AwaySHPer=0,
			goals12SHPer=0,
			
			hfWWHomePer=0,
			hfWWAwayPer=0,
			hfWWPer=0,
							
			hfWXHomePer=0,
			hfWXAwayPer=0,
			hfWXPer=0,
			
			hfWLHomePer=0,
			hfWLAwayPer=0,
			hfWLPer=0,
					
			hfXWHomePer=0,
			hfXWAwayPer=0,
			hfXWPer=0,
			
			
			hfXXHomePer=0,
			hfXXAwayPer=0,
			hfXXPer=0,
			
			hfXLHomePer=0,
			hfXLAwayPer=0,
			hfXLPer=0,
			
			hfLWHomePer=0,
			hfLWAwayPer=0,
			hfLWPer=0,
			
			hfLXHomePer=0,
			hfLXAwayPer=0,
			hfLXPer=0,
			
			hfLLHomePer=0,
			hfLLAwayPer=0,
			hfLLPer=0;
			
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
					
			matchesCornersInfoHome=0,
			matchesCornersInfoAway=0,
			matchesCornersInfo=0,

			matchesShotsInfoHome=0,
			matchesShotsInfoAway=0,
			matchesShotsInfo=0,
		
			matchesShotsOnTargetInfoHome=0,
			matchesShotsOnTargetInfoAway=0,
			matchesShotsOnTargetInfo=0,
			
			matchesFoulsInfoHome=0,
			matchesFoulsInfoAway=0,
			matchesFoulsInfo=0,
		
			matchesYellowsInfoHome=0,
			matchesYellowsInfoAway=0,
			matchesYellowsInfo=0,
	
			matchesRedsInfoHome=0,
			matchesRedsInfoAway=0,
			matchesRedsInfo=0,

			matchesHalfInfoHome=0,
			matchesHalfInfoAway=0,
			matchesHalfInfo=0;

	
	
	public int scoresHome[][],
			scoresAway[][],
			scores[][]; //this team is always left
	
	public double scoresHomePer[][],
	scoresAwayPer[][],
	scoresPer[][]; //this team is always left

	private void createTeamGoalStats(Result result) {
		if(result.FTHG!=-1 && result.FTAG!=-1){
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
				if(sumTemp>0 && sumTemp<3) {goals12Home++; goals12++;}
				if(sumTemp>0 && sumTemp<4) {goals13Home++; goals13++;}
				if(sumTemp>1 && sumTemp<5) {goals24Home++; goals24++;}
				
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
				if(sumTemp>0 && sumTemp<3) {goals12Away++; goals12++;}
				if(sumTemp>0 && sumTemp<4) {goals13Away++; goals13++;}
				if(sumTemp>1 && sumTemp<5) {goals24Away++; goals24++;}
				
				if(result.FTHG<result.FTAG) {wonAway++; won++;}
				if(result.FTHG>result.FTAG) {lostAway++; lost++;}
				if(result.FTHG==result.FTAG) {drawAway++; draw++;}
				scoresAway[result.FTAG][result.FTHG]++;
				scores[result.FTAG][result.FTHG]++;
				}
		} else {
		System.out.println("Alert:No goals info");	
		}
	}
	private void createTeamHalfStats(Result result) {
		if(result.HTHG !=-1 && result.HTAG !=-1){
			if(name.equals(result.homeTeam)) {
				matchesHalfInfoHome++;
				matchesHalfInfo++;
				
				goalsScoHomeFH+=result.HTHG;
				goalsScoFH+=result.HTHG;
				goalsConHomeFH+=result.HTAG;
				goalsConFH+=result.HTAG;
				
				int sumTemp1=result.HTHG+result.HTAG;
				if(result.HTHG>0 && result.HTAG>0) {bttsHomeFH++; bttsFH++;}
				if(sumTemp1>2) {overHomeFH++; overFH++;}
				if(result.HTHG>0 && result.HTAG>0 && sumTemp1>2) {bOverHomeFH++; bOverFH++;}
				if(sumTemp1==0) {goals0HomeFH++; goals0FH++;}
				if(sumTemp1==1) {goals1HomeFH++; goals1FH++;}
				if(sumTemp1>0 && sumTemp1<3) {goals12HomeFH++; goals12FH++;}
				
				goalsScoHomeSH+=result.FTHG-result.HTHG;
				goalsScoSH+=result.FTHG-result.HTHG;
				goalsConHomeSH+=result.FTAG-result.HTAG;
				goalsConSH+=result.FTAG-result.HTAG;
				
				int sumTemp2=(result.FTHG+result.FTHG)-(result.HTHG+result.HTAG);
				if(result.FTHG-result.HTHG>0 && result.FTAG-result.HTAG>0) {bttsHomeSH++; bttsSH++;}
				if(sumTemp2>2) {overHomeSH++; overSH++;}
				if(result.FTHG-result.HTHG>0 && result.FTAG-result.HTAG>0 && sumTemp2>2) {bOverHomeSH++; bOverSH++;}
				if(sumTemp2==0) {goals0HomeSH++; goals0SH++;}
				if(sumTemp2==1) {goals1HomeSH++; goals1SH++;}
				if(sumTemp2>0 && sumTemp2<3) {goals12HomeSH++; goals12SH++;}
			
				
				
				if(result.HTHG>result.HTAG) {wonHomeFH++; wonFH++;}
				if(result.HTHG<result.HTAG) {lostHomeFH++; lostFH++;}
				if(result.HTHG==result.HTAG) {drawHomeFH++; drawFH++;}

				
				if(result.FTHG-result.HTHG>result.FTAG-result.HTAG) {wonHomeSH++; wonSH++;}
				if(result.FTHG-result.HTHG<result.FTAG-result.HTAG)	{lostHomeSH++; lostSH++;}
				if(result.FTHG-result.HTHG==result.FTAG-result.HTAG) {drawHomeSH++; drawSH++;}
			

				if(result.HTHG>result.HTAG) {
					if(result.FTHG>result.FTAG) {hfWWHome++; hfWW++;}
					if(result.FTHG<result.FTAG)	{hfWLHome++; hfWL++;}
					if(result.FTHG==result.FTAG) {hfWXHome++; hfWX++;}
				}
				if(result.HTHG<result.HTAG) {
					if(result.FTHG>result.FTAG) {hfLWHome++; hfLW++;}
					if(result.FTHG<result.FTAG)	{hfLLHome++; hfLL++;}
					if(result.FTHG==result.FTAG) {hfLXHome++; hfLX++;}
				}
				if(result.HTHG==result.HTAG) {
					if(result.FTHG>result.FTAG) {hfXWHome++; hfXW++;}
					if(result.FTHG<result.FTAG)	{hfXLHome++; hfXL++;}
					if(result.FTHG==result.FTAG) {hfXXHome++; hfXX++;}
				}

			
				
				
			} else if(name.equals(result.awayTeam)) {
					matchesHalfInfoAway++;
					matchesHalfInfo++;
					
					goalsScoAwayFH+=result.HTAG;
					goalsScoFH+=result.HTAG;
					goalsConAwayFH+=result.HTHG;
					goalsConFH+=result.HTHG;
					
					int sumTemp1=result.HTAG+result.HTHG;
					if(result.HTAG>0 && result.HTHG>0) {bttsAwayFH++; bttsFH++;}
					if(sumTemp1>2) {overAwayFH++; overFH++;}
					if(result.HTAG>0 && result.HTHG>0 && sumTemp1>2) {bOverAwayFH++; bOverFH++;}
					if(sumTemp1==0) {goals0AwayFH++; goals0FH++;}
					if(sumTemp1==1) {goals1AwayFH++; goals1FH++;}
					if(sumTemp1>0 && sumTemp1<3) {goals12AwayFH++; goals12FH++;}
					
					goalsScoAwaySH+=result.FTAG-result.HTAG;
					goalsScoSH+=result.FTAG-result.HTAG;
					goalsConAwaySH+=result.FTHG-result.HTHG;
					goalsConSH+=result.FTHG-result.HTHG;
					
					int sumTemp2=(result.FTAG+result.FTAG)-(result.HTAG+result.HTHG);
					if(result.FTAG-result.HTAG>0 && result.FTHG-result.HTHG>0) {bttsAwaySH++; bttsSH++;}
					if(sumTemp2>2) {overAwaySH++; overSH++;}
					if(result.FTAG-result.HTAG>0 && result.FTHG-result.HTHG>0 && sumTemp2>2) {bOverAwaySH++; bOverSH++;}
					if(sumTemp2==0) {goals0AwaySH++; goals0SH++;}
					if(sumTemp2==1) {goals1AwaySH++; goals1SH++;}
					if(sumTemp2>0 && sumTemp2<3) {goals12AwaySH++; goals12SH++;}
				
					
					
					if(result.HTAG>result.HTHG) {wonAwayFH++; wonFH++;}
					if(result.HTAG<result.HTHG) {lostAwayFH++; lostFH++;}
					if(result.HTAG==result.HTHG) {drawAwayFH++; drawFH++;}

					
					if(result.FTAG-result.HTAG>result.FTHG-result.HTHG) {wonAwaySH++; wonSH++;}
					if(result.FTAG-result.HTAG<result.FTHG-result.HTHG)	{lostAwaySH++; lostSH++;}
					if(result.FTAG-result.HTAG==result.FTHG-result.HTHG) {drawAwaySH++; drawSH++;}
				

					if(result.HTAG>result.HTHG) {
						if(result.FTAG>result.FTHG) {hfWWAway++; hfWW++;}
						if(result.FTAG<result.FTHG)	{hfWLAway++; hfWL++;}
						if(result.FTAG==result.FTHG) {hfWXAway++; hfWX++;}
					}
					if(result.HTAG<result.HTHG) {
						if(result.FTAG>result.FTHG) {hfLWAway++; hfLW++;}
						if(result.FTAG<result.FTHG)	{hfLLAway++; hfLL++;}
						if(result.FTAG==result.FTHG) {hfLXAway++; hfLX++;}
					}
					if(result.HTAG==result.HTHG) {
						if(result.FTAG>result.FTHG) {hfXWAway++; hfXW++;}
						if(result.FTAG<result.FTHG)	{hfXLAway++; hfXL++;}
						if(result.FTAG==result.FTHG) {hfXXAway++; hfXX++;}
					}

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
			goals12HomePer=(100.0*goals12)/matches;
			goals13HomePer=(100.0*goals13)/matches;
			goals24HomePer=(100.0*goals24)/matches;
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
			goals12AwayPer=(100.0*goals12)/matches;
			goals13AwayPer=(100.0*goals13)/matches;
			goals24AwayPer=(100.0*goals24)/matches;
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
					scoresPer[i][j] = (100.0 * scores[i][j]) / matches;
			}
		}
	}

	private void createTeamHalfStats() {
		if (matchesHalfInfoHome > 0 && matchesHalfInfoAway > 0) {
			wonHomeFHPer = (100.0 * wonHomeFH) / matchesHalfInfoHome;
			wonAwayFHPer = (100.0 * wonAwayFH) / matchesHalfInfoAway;
			wonFHPer = (100.0 * wonFH) / matchesHalfInfo;

			lostHomeFHPer = (100.0 * lostHomeFH) / matchesHalfInfoHome;
			lostAwayFHPer = (100.0 * lostAwayFH) / matchesHalfInfoAway;
			lostFHPer = (100.0 * lostFH) / matchesHalfInfo;

			drawHomeFHPer = (100.0 * drawHomeFH) / matchesHalfInfoHome;
			drawAwayFHPer = (100.0 * drawAwayFH) / matchesHalfInfoAway;
			drawFHPer = (100.0 * drawFH) / matchesHalfInfo;

			bttsHomeFHPer = (100.0 * bttsHomeFH) / matchesHalfInfoHome;
			bttsAwayFHPer = (100.0 * bttsAwayFH) / matchesHalfInfoAway;
			bttsFHPer = (100.0 * bttsFH) / matchesHalfInfo;

			overHomeFHPer = (100.0 * overHomeFH) / matchesHalfInfoHome;
			overAwayFHPer = (100.0 * overAwayFH) / matchesHalfInfoAway;
			overFHPer = (100.0 * overFH) / matchesHalfInfo;

			bOverHomeFHPer = (100.0 * bOverHomeFH) / matchesHalfInfoHome;
			bOverAwayFHPer = (100.0 * bOverAwayFH) / matchesHalfInfoAway;
			bOverFHPer = (100.0 * bOverFH) / matchesHalfInfo;

			goals0HomeFHPer = (100.0 * goals0HomeFH) / matchesHalfInfoHome;
			goals0AwayFHPer = (100.0 * goals0AwayFH) / matchesHalfInfoAway;
			goals0FHPer = (100.0 * goals0FH) / matchesHalfInfo;

			goals1HomeFHPer = (100.0 * goals1HomeFH) / matchesHalfInfoHome;
			goals1AwayFHPer = (100.0 * goals1AwayFH) / matchesHalfInfoAway;
			goals1FHPer = (100.0 * goals1FH) / matchesHalfInfo;

			goals12HomeFHPer = (100.0 * goals12HomeFH) / matchesHalfInfoHome;
			goals12AwayFHPer = (100.0 * goals12AwayFH) / matchesHalfInfoAway;
			goals12FHPer = (100.0 * goals12FH) / matchesHalfInfo;

			wonHomeSHPer = (100.0 * wonHomeSH) / matchesHalfInfoHome;
			wonAwaySHPer = (100.0 * wonAwaySH) / matchesHalfInfoAway;
			wonSHPer = (100.0 * wonSH) / matchesHalfInfo;

			lostHomeSHPer = (100.0 * lostHomeSH) / matchesHalfInfoHome;
			lostAwaySHPer = (100.0 * lostAwaySH) / matchesHalfInfoAway;
			lostSHPer = (100.0 * lostSH) / matchesHalfInfo;

			drawHomeSHPer = (100.0 * drawHomeSH) / matchesHalfInfoHome;
			drawAwaySHPer = (100.0 * drawAwaySH) / matchesHalfInfoAway;
			drawSHPer = (100.0 * drawSH) / matchesHalfInfo;

			bttsHomeSHPer = (100.0 * bttsHomeSH) / matchesHalfInfoHome;
			bttsAwaySHPer = (100.0 * bttsAwaySH) / matchesHalfInfoAway;
			bttsSHPer = (100.0 * bttsSH) / matchesHalfInfo;

			overHomeSHPer = (100.0 * overHomeSH) / matchesHalfInfoHome;
			overAwaySHPer = (100.0 * overAwaySH) / matchesHalfInfoAway;
			overSHPer = (100.0 * overSH) / matchesHalfInfo;

			bOverHomeSHPer = (100.0 * bOverHomeSH) / matchesHalfInfoHome;
			bOverAwaySHPer = (100.0 * bOverAwaySH) / matchesHalfInfoAway;
			bOverSHPer = (100.0 * bOverSH) / matchesHalfInfo;

			goals0HomeSHPer = (100.0 * goals0HomeSH) / matchesHalfInfoHome;
			goals0AwaySHPer = (100.0 * goals0AwaySH) / matchesHalfInfoAway;
			goals0SHPer = (100.0 * goals0SH) / matchesHalfInfo;

			goals1HomeSHPer = (100.0 * goals1HomeSH) / matchesHalfInfoHome;
			goals1AwaySHPer = (100.0 * goals1AwaySH) / matchesHalfInfoAway;
			goals1SHPer = (100.0 * goals1SH) / matchesHalfInfo;

			goals12HomeSHPer = (100.0 * goals12HomeSH) / matchesHalfInfoHome;
			goals12AwaySHPer = (100.0 * goals12AwaySH) / matchesHalfInfoAway;
			goals12SHPer = (100.0 * goals12SH) / matchesHalfInfo;

			hfWWHomePer = (100.0 * hfWWHome) / matchesHalfInfoHome;
			hfWWAwayPer = (100.0 * hfWWAway) / matchesHalfInfoAway;
			hfWWPer = (100.0 * hfWW) / matchesHalfInfo;

			hfWXHomePer = (100.0 * hfWXHome) / matchesHalfInfoHome;
			hfWXAwayPer = (100.0 * hfWXAway) / matchesHalfInfoAway;
			hfWXPer = (100.0 * hfWX) / matchesHalfInfo;

			hfWLHomePer = (100.0 * hfWLHome) / matchesHalfInfoHome;
			hfWLAwayPer = (100.0 * hfWLAway) / matchesHalfInfoAway;
			hfWLPer = (100.0 * hfWL) / matchesHalfInfo;

			hfXWHomePer = (100.0 * hfXWHome) / matchesHalfInfoHome;
			hfXWAwayPer = (100.0 * hfXWAway) / matchesHalfInfoAway;
			hfXWPer = (100.0 * hfXW) / matchesHalfInfo;

			hfXXHomePer = (100.0 * hfXXHome) / matchesHalfInfoHome;
			hfXXAwayPer = (100.0 * hfXXAway) / matchesHalfInfoAway;
			hfXXPer = (100.0 * hfXX) / matchesHalfInfo;

			hfXLHomePer = (100.0 * hfXLHome) / matchesHalfInfoHome;
			hfXLAwayPer = (100.0 * hfXLAway) / matchesHalfInfoAway;
			hfXLPer = (100.0 * hfXL) / matchesHalfInfo;

			hfLWHomePer = (100.0 * hfLWHome) / matchesHalfInfoHome;
			hfLWAwayPer = (100.0 * hfLWAway) / matchesHalfInfoAway;
			hfLWPer = (100.0 * hfLW) / matchesHalfInfo;

			hfLXHomePer = (100.0 * hfLXHome) / matchesHalfInfoHome;
			hfLXAwayPer = (100.0 * hfLXAway) / matchesHalfInfoAway;
			hfLXPer = (100.0 * hfLX) / matchesHalfInfo;

			hfLLHomePer = (100.0 * hfLLHome) / matchesHalfInfoHome;
			hfLLAwayPer = (100.0 * hfLLAway) / matchesHalfInfoAway;
			hfLLPer = (100.0 * hfLL) / matchesHalfInfo;
		}
	}

	private void createTeamCornersStats(Result result) {
		if (result.HC != -1 && result.AC != -1) {

		if (name.equals(result.homeTeam)) {
				matchesCornersInfoHome++;
				matchesCornersInfo++;
		
				cornersWonHome += result.HC;
				cornersWon += result.HC;
				cornersConHome += result.AC;
				cornersCon += result.AC;
		} else if (name.equals(result.awayTeam)) {
				matchesCornersInfoAway++;
				matchesCornersInfo++;
				
				cornersWonAway += result.AC;
				cornersWon += result.AC;
				cornersConAway += result.HC;
				cornersCon += result.HC;
			}
		}
	}
	
	private void createTeamShotsStats(Result result) {
		if (result.HS != -1 && result.AS != -1) {
			
		if (name.equals(result.homeTeam)) {
				matchesShotsInfoHome++;
				matchesShotsInfo++;

				shotsWonHome += result.HS;
				shotsWon += result.HS;
				shotsConHome += result.AS;
				shotsCon += result.AS;
		} else if (name.equals(result.awayTeam)) {
				matchesShotsInfoAway++;
				matchesShotsInfo++;
				shotsWonAway += result.AS;
				shotsWon += result.AS;
				shotsConAway += result.HS;
				shotsCon += result.HS;
			}
		}
	}
	

	private void createTeamShotsOnTargetStats(Result result) {
		if (result.HST != -1 && result.AST != -1) {
			
		if (name.equals(result.homeTeam)) {
				matchesShotsOnTargetInfoHome++;
				matchesShotsOnTargetInfo++;
				shotsOnTargetWonHome += result.HST;
				shotsOnTargetWon += result.HST;
				shotsOnTargetConHome += result.AST;
				shotsOnTargetCon += result.AST;
		} else if (name.equals(result.awayTeam)) {
				matchesShotsOnTargetInfoAway++;
				matchesShotsOnTargetInfo++;
				shotsOnTargetWonAway += result.AST;
				shotsOnTargetWon += result.AST;
				shotsOnTargetConAway += result.HST;
				shotsOnTargetCon += result.HST;
			}
		}
	}
	
	private void createTeamYellowsStats(Result result) {
		if (result.HY != -1 && result.AY != -1) {
		if (name.equals(result.homeTeam)) {
				matchesYellowsInfoHome++;
				matchesYellowsInfo++;
				yellowsWonHome += result.AY;
				yellowsWon += result.AY;
				yellowsConHome += result.HY;
				yellowsCon += result.HY;
		} else if (name.equals(result.awayTeam)) {
				yellowsWonAway += result.HY;
				yellowsWon += result.HY;
				yellowsConAway += result.AY;
				yellowsCon += result.AY;
			}
		}
	}
	
	private void createTeamRedsStats(Result result) {
		if (result.HR != -1 && result.AR != -1) {
			if (name.equals(result.homeTeam)) {
				matchesRedsInfoHome++;
				matchesRedsInfo++;
				redsWonHome += result.AR;
				redsWon += result.AR;
				redsConHome += result.HR;
				redsCon += result.HR;
		} else if (name.equals(result.awayTeam)) {
				matchesRedsInfoAway++;
				matchesRedsInfo++;
				redsWonAway += result.HR;
				redsWon += result.HR;
				redsConAway += result.AR;
				redsCon += result.AR;
			}
		}
	}
	
	private void createTeamFoulsStats(Result result) {
		if (result.HF != -1 && result.AF != -1) {
		if (name.equals(result.homeTeam)) {
				matchesFoulsInfoHome++;
				matchesFoulsInfo++;
				foulsWonHome += result.AF;
				foulsWon += result.AF;
				foulsConHome += result.HF;
				foulsCon += result.HF;
		} else if (name.equals(result.awayTeam)) {
				matchesFoulsInfoAway++;
				matchesFoulsInfo++;
				foulsWonAway += result.HF;
				foulsWon += result.HF;
				foulsConAway += result.AF;
				foulsCon += result.AF;
			}
		}
	}
	
	
	private void createTeamCornerPer() {
		if (matchesCornersInfoHome > 0) {
			cornersWonHomeAvg = (double) cornersWonHome / matchesCornersInfoHome;
			cornersConHomeAvg = (double) cornersConHome / matchesCornersInfoHome;
		}
		if (matchesCornersInfoAway > 0) {
			cornersWonAwayAvg = (double) cornersWonAway / matchesCornersInfoAway;
			cornersConAwayAvg = (double) cornersConAway / matchesCornersInfoAway;
		}
		if (matchesCornersInfo > 0) {
			cornersWonAvg = (double) cornersWon / matchesCornersInfo;
			cornersConAvg = (double) cornersCon / matchesCornersInfo;
		}
	}
	private void createTeamShotsPer() {
		if (matchesShotsInfoHome > 0) {
			shotsWonHomeAvg = (double) shotsWonHome / matchesShotsInfoHome;
			shotsConHomeAvg = (double) shotsConHome / matchesShotsInfoHome;
		}
		if (matchesShotsInfoAway > 0) {
			shotsWonAwayAvg = (double) shotsWonAway / matchesShotsInfoAway;
			shotsConAwayAvg = (double) shotsConAway / matchesShotsInfoAway;
		}
		if (matchesShotsInfo > 0) {
			shotsWonAvg = (double) shotsWon / matchesShotsInfo;
			shotsConAvg = (double) shotsCon / matchesShotsInfo;
		}
	}
	private void createTeamShotsOnTargetPer() {
		if (matchesShotsOnTargetInfoHome > 0) {
			shotsOnTargetWonHomeAvg = (double) shotsOnTargetWonHome / matchesShotsOnTargetInfoHome;
			shotsOnTargetConHomeAvg = (double) shotsOnTargetConHome / matchesShotsOnTargetInfoHome;
		}
		if (matchesShotsOnTargetInfoAway > 0) {
			shotsOnTargetWonAwayAvg = (double) shotsOnTargetWonAway / matchesShotsOnTargetInfoAway;
			shotsOnTargetConAwayAvg = (double) shotsOnTargetConAway / matchesShotsOnTargetInfoAway;
		}
		if (matchesShotsOnTargetInfo > 0) {
			shotsOnTargetWonAvg = (double) shotsOnTargetWon / matchesShotsOnTargetInfo;
			shotsOnTargetConAvg = (double) shotsOnTargetCon / matchesShotsOnTargetInfo;
		}
	}
	private void createTeamYellowsPer() {
		if (matchesYellowsInfoHome > 0) {
			yellowsWonHomeAvg = (double) yellowsWonHome / matchesYellowsInfoHome;
			yellowsConHomeAvg = (double) yellowsConHome / matchesYellowsInfoHome;
		}
		if (matchesYellowsInfoAway > 0) {
			yellowsWonAwayAvg = (double) yellowsWonAway / matchesYellowsInfoAway;
			yellowsConAwayAvg = (double) yellowsConAway / matchesYellowsInfoAway;
		}
		if (matchesYellowsInfo > 0) {
			yellowsWonAvg = (double) yellowsWon / matchesYellowsInfo;
			yellowsConAvg = (double) yellowsCon / matchesYellowsInfo;
		}
	}
	private void createTeamRedsPer() {
		if (matchesRedsInfoHome > 0) {
			redsWonHomeAvg = (double) redsWonHome / matchesRedsInfoHome;
			redsConHomeAvg = (double) redsConHome / matchesRedsInfoHome;
		}
		if (matchesRedsInfoAway > 0) {
			redsWonAwayAvg = (double) redsWonAway / matchesRedsInfoAway;
			redsConAwayAvg = (double) redsConAway / matchesRedsInfoAway;
		}
		if (matchesRedsInfo > 0) {
			redsWonAvg = (double) redsWon / matchesRedsInfo;
			redsConAvg = (double) redsCon / matchesRedsInfo;
		}
	}
	private void createTeamFoulsPer() {
		if (matchesFoulsInfoHome > 0) {
			foulsWonHomeAvg = (double) foulsWonHome / matchesFoulsInfoHome;
			foulsConHomeAvg = (double) foulsConHome / matchesFoulsInfoHome;
		}
		if (matchesFoulsInfoAway > 0) {
			foulsWonAwayAvg = (double) foulsWonAway / matchesFoulsInfoAway;
			foulsConAwayAvg = (double) foulsConAway / matchesFoulsInfoAway;
		}
		if (matchesFoulsInfo > 0) {
			foulsWonAvg = (double) foulsWon / matchesFoulsInfo;
			foulsConAvg = (double) foulsCon / matchesFoulsInfo;
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
			if(formResultsHome.get(i).FTHG>0&&formResultsHome.get(i).FTAG>0)form3BttsHome++;
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
			if(formResultsAway.get(i).FTHG>0&&formResultsAway.get(i).FTAG>0)form3BttsAway++;
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
				if(formResults.get(i).FTHG>0&&formResults.get(i).FTAG>0)form5Btts++;
			} else if(name.equals(formResults.get(i).awayTeam)) {
				form5GoalsSco+=formResults.get(i).FTAG;
				form5GoalsCon+=formResults.get(i).FTHG;
				if(formResults.get(i).FTHG<formResults.get(i).FTAG)form5Points+=3;
				if(formResults.get(i).FTHG==formResults.get(i).FTAG)form5Points++;
				if(formResults.get(i).FTHG+formResults.get(i).FTAG>2)form5Over++;
				if(formResults.get(i).FTHG>0&&formResults.get(i).FTAG>0)form5Btts++;
				}
			}
	}

	public void createFormStats(List<Result> formResultsHome, List<Result> formResultsAway, List<Result> formResults) {
		createFormHome(formResultsHome);
		createFormAway(formResultsAway);
		createForm(formResults);
		createFormRatings();
	}

	public void createFormRatings(){
		if(matchesFormHome>0) {
			double fph=mfpha* 	(((double)form3PointsHome)/matchesFormHome),
					fp=mfp*		(((double)form5Points)/matchesForm),
					fgh=mfgha* 	(((double)(form3GoalsScoHome-form3GoalsConHome))/matchesFormHome),
					fg=mfg*		(((double)(form5GoalsSco-form5GoalsCon))/matchesForm),
					wh=mwha*0.1*	wonHomePer,
					w=mw*0.1*	wonPer,
					gh=mgha*		(goalsScoHomeAvg-goalsConHomeAvg),
					g=mg*		(goalsScoAvg-goalsConAvg),
		
					foh=mfoha*	(((double)form3OverHome)/matchesFormHome),
					fo=mfo*		(((double)form5Over)/matchesForm),
					oh=moha*0.1*		overHomePer,
					o=mo*0.1*		overPer,
		
					fbh=mfbha*	(((double)form3BttsHome)/matchesFormHome),
					fb=mfb*		(((double)form5Btts)/matchesForm),
					bh=mbha*0.1*		bttsHomePer,
					b=mb*0.1*		bttsPer;
	
			winHomeRating=(int)(fph+fp+fgh+fg+wh+w+gh+g);
			overHomeRating=(int)(foh+fo+oh+o);
			bttsHomeRating=(int)(fbh+fb+bh+b);
			cornersHomeRating=(int)(10*((2*cornersWonHomeAvg)+(1*cornersConHomeAvg))/3);

			if(fphMin>fph)fphMin=fph; 
			if(fphMax<fph)fphMax=fph;
			fphSum+=fph;
			
			if(fghMin>fgh)fghMin=fgh; 
			if(fghMax<fgh)fghMax=fgh;
			fghSum+=fgh;
		
			if(whMin>wh)whMin=wh; 
			if(whMax<wh)whMax=wh;
			whSum+=wh;
		
			if(ghMin>gh)ghMin=gh; 
			if(ghMax<gh)ghMax=gh;
			ghSum+=gh;
			
			if(fohMin>foh)fohMin=foh; 
			if(fohMax<foh)fohMax=foh;
			fohSum+=foh;
			
			if(ohMin>oh)ohMin=oh; 
			if(ohMax<oh)ohMax=oh;
			ohSum+=oh;
		
			if(fbhMin>fbh)fbhMin=fbh; 
			if(fbhMax<fbh)fbhMax=fbh;
			fbhSum+=fbh;
		
			if(bhMin>bh)bhMin=bh; 
			if(bhMax<bh)bhMax=bh;
			bhSum+=bh;
		
		
			
			if(fpMin>fp)fpMin=fp; 
			if(fpMax<fp)fpMax=fp;
			fpSum+=fp;
			
			if(fgMin>fg)fgMin=fg; 
			if(fgMax<fg)fgMax=fg;
			fgSum+=fg;
		
			if(wMin>w)wMin=w; 
			if(wMax<w)wMax=w;
			wSum+=w;
		
			if(gMin>g)gMin=g; 
			if(gMax<g) gMax=g;
			gSum+=g;
			
			if(foMin>fo)foMin=fo; 
			if(foMax<fo)foMax=fo;
			foSum+=fo;
			
			if(oMin>o)oMin=o; 
			if(oMax<o)oMax=o;
			oSum+=o;
		
			if(fbMin>fb)fbMin=fb; 
			if(fbMax<fb)fbMax=fb;
			fbSum+=fb;
		
			if(bMin>b)bMin=b; 
			if(bMax<b)bMax=b;
			bSum+=b;
			
			
			if(winHomeRatingMax<winHomeRating)winHomeRatingMax=winHomeRating;
			if(winHomeRatingMin>winHomeRating)winHomeRatingMin=winHomeRating;
			winHomeRatingSum+=winHomeRating;
			
			if(overHomeRatingMin>overHomeRating)overHomeRatingMin=overHomeRating;
			if(overHomeRatingMax<overHomeRating)overHomeRatingMax=overHomeRating;
			overHomeRatingSum+=overHomeRating;
			
			if(bttsHomeRatingMax<bttsHomeRating)bttsHomeRatingMax=bttsHomeRating;
			if(bttsHomeRatingMin>bttsHomeRating)bttsHomeRatingMin=bttsHomeRating;
			bttsHomeRatingSum+=bttsHomeRating;
			
			if(cornersHomeRatingMax<cornersHomeRating)cornersHomeRatingMax=cornersHomeRating;
			if(cornersHomeRatingMin>cornersHomeRating)cornersHomeRatingMin=cornersHomeRating;
			cornersHomeRatingSum+=cornersHomeRatingSum;
		}
		if(matchesFormAway>0) {
			double fpa=mfpha*		 (((double)form3PointsAway)/matchesFormAway),
					fp=mfp*		(((double)form5Points)/matchesForm),
					fga=mfgha* 	(((double)(form3GoalsScoAway-form3GoalsConAway))/matchesFormAway),
					fg=mfg*		(((double)(form5GoalsSco-form5GoalsCon))/matchesForm),
					wa=mwha*0.1*	wonAwayPer,
					w=mw*0.1*	wonPer,
					ga=mgha*		(goalsScoAwayAvg-goalsConAwayAvg),
					g=mg*		(goalsScoAvg-goalsConAvg),
		
					foa=mfoha*	(((double)form3OverAway)/matchesFormAway),
					fo=mfo*		(((double)form5Over)/matchesForm),
					oa=moha*0.1*	overAwayPer,
					o=mo*0.1*	overPer,
		
					fba=mfbha*	(((double)form3BttsAway)/matchesFormAway),
					fb=mfb*		(((double)form5Btts)/matchesForm),
					ba=mbha*0.1*	bttsAwayPer,
					b=mb*0.1*	bttsPer;

			winAwayRating=(int)(fpa+fp+fga+fg+wa+w+ga+g);
			overAwayRating=(int)(foa+fo+oa+o+ba+b);
			bttsAwayRating=(int)(fba+fb+ba+b+foa+fo);
			cornersAwayRating=(int)(10*((2*cornersWonAwayAvg)+(1*cornersConAwayAvg))/3);
			
			if(fpaMin>fpa)fpaMin=fpa; 
			if(fpaMax<fpa)fpaMax=fpa;
			fpaSum+=fpa;
			
			if(fgaMin>fga)fgaMin=fga; 
			if(fgaMax<fga)fgaMax=fga;
			fgaSum+=fga;
		
			if(waMin>wa)waMin=wa; 
			if(waMax<wa)waMax=wa;
			waSum+=wa;
		
			if(gaMin>ga)gaMin=ga; 
			if(gaMax<ga)gaMax=ga;
			gaSum+=ga;
			
			if(foaMin>foa)foaMin=foa; 
			if(foaMax<foa)foaMax=foa;
			foaSum+=foa;
			
			if(oaMin>oa)oaMin=oa; 
			if(oaMax<oa)oaMax=oa;
			oaSum+=oa;
		
			if(fbaMin>fba)fbaMin=fba; 
			if(fbaMax<fba)fbaMax=fba;
			fbaSum+=fba;
		
			if(baMin>ba)baMin=ba; 
			if(baMax<ba)baMax=ba;
			baSum+=ba;
	
			
			if(fpMin>fp)fpMin=fp; 
			if(fpMax<fp)fpMax=fp;
			fpSum+=fp;
			
			if(fgMin>fg)fgMin=fg; 
			if(fgMax<fg)fgMax=fg;
			fgSum+=fg;
		
			if(wMin>w)wMin=w; 
			if(wMax<w)wMax=w;
			wSum+=w;
		
			if(gMin>g)gMin=g; 
			if(gMax<g)gMax=g;
			gSum+=g;
			
			if(foMin>fo)foMin=fo; 
			if(foMax<fo)foMax=fo;
			foSum+=fo;
			
			if(oMin>o)oMin=o; 
			if(oMax<o)oMax=o;
			oSum+=o;
		
			if(fbMin>fb)fbMin=fb; 
			if(fbMax<fb)fbMax=fb;
			fbSum+=fb;
		
			if(bMin>b)bMin=b; 
			if(bMax<b)bMax=b;
			bSum+=b;

			if(winAwayRatingMin>winAwayRating)winAwayRatingMin=winAwayRating;
			if(winAwayRatingMax<winAwayRating)winAwayRatingMax=winAwayRating;
			winAwayRatingSum+=winAwayRating;
			
			if(overAwayRatingMin>overAwayRating)overAwayRatingMin=overAwayRating;
			if(overAwayRatingMax<overAwayRating)overAwayRatingMax=overAwayRating;
			overAwayRatingSum+=overAwayRating;
				
			if(bttsAwayRatingMin>bttsAwayRating)bttsAwayRatingMin=bttsAwayRating;
			if(bttsAwayRatingMax<bttsAwayRating)bttsAwayRatingMax=bttsAwayRating;
			bttsAwayRatingSum+=bttsAwayRating;

			if(cornersAwayRatingMin>cornersAwayRating)cornersAwayRatingMin=cornersAwayRating;
			if(cornersAwayRatingMax<cornersAwayRating)cornersAwayRatingMax=cornersAwayRating;
			cornersAwayRatingSum+=cornersAwayRatingSum;
			
		}
		if(matchesFormAway>0 || matchesFormHome>0) 
		{teamsCounter++;}
	}

	public void createPer() {
		createTeamGoalPer();
		createTeamCornerPer();
		createTeamShotsPer();
		createTeamShotsOnTargetPer();
		createTeamYellowsPer();
		createTeamRedsPer();
		createTeamFoulsPer();
		createTeamHalfStats();
	}

	public void addResult(Result result) {
		createTeamGoalStats(result);
		createTeamCornersStats(result);
		createTeamShotsStats(result);
		createTeamShotsOnTargetStats(result);
		createTeamYellowsStats(result);
		createTeamRedsStats(result);
		createTeamFoulsStats(result);
		createTeamHalfStats(result);
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
	public void testoutput() {
	//	if(teamsCounter>6)
		System.out.println(teamsCounter);
	}
	
}

/*
public int matchesHome=0,
matchesAway=0,
matches=0,



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

cornersWonHomeAvg=0,
cornersWonAwayAvg=0,
cornersWonAvg=0,

shotsWonHomeAvg=0,
shotsWonAwayAvg=0,
shotsWonAvg=0,

shotsOnTargetWonHomeAvg=0,
shotsOnTargetWonAwayAvg=0,
shotsOnTargetWonAvg=0,

foulsWonHomeAvg=0,
foulsWonAwayAvg=0,
foulsWonAvg=0,

yellowsWonHomeAvg=0,
yellowsWonAwayAvg=0,
yellowsWonAvg=0,

redsWonHomeAvg=0,
redsWonAwayAvg=0,
redsWonAvg=0,

cornersConHomeAvg=0,
cornersConAwayAvg=0,
cornersConAvg=0,

shotsConHomeAvg=0,
shotsConAwayAvg=0,
shotsConAvg=0,

shotsOnTargetConHomeAvg=0,
shotsOnTargetConAwayAvg=0,
shotsOnTargetConAvg=0,

foulsConHomeAvg=0,
foulsConAwayAvg=0,
foulsConAvg=0,

yellowsConHomeAvg=0,
yellowsConAwayAvg=0,
yellowsConAvg=0,

redsConHomeAvg=0,
redsConAwayAvg=0,
redsConAvg=0,	



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
			

		
matchesCornersInfoHome=0,
matchesCornersInfoAway=0,
matchesCornersInfo=0,

matchesShotsInfoHome=0,
matchesShotsInfoAway=0,
matchesShotsInfo=0,

matchesShotsOnTargetInfoHome=0,
matchesShotsOnTargetInfoAway=0,
matchesShotsOnTargetInfo=0,

matchesFoulsInfoHome=0,
matchesFoulsInfoAway=0,
matchesFoulsInfo=0,

matchesYellowsInfoHome=0,
matchesYellowsInfoAway=0,
matchesYellowsInfo=0,

matchesRedsInfoHome=0,
matchesRedsInfoAway=0,
matchesRedsInfo=0,

matchesHalfInfoHome=0,
matchesHalfInfoAway=0,
matchesHalfInfo=0;
*/