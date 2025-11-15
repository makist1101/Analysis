
public class Fixture {
	
	
	public int matchesHome=0,
			matchesAway=0,
			matchesA=0,
			matchesB=0;
	
	public double goalsScoHomeAvg=0,
			goalsScoAwayAvg=0,
			goalsScoAvgA=0,
			goalsScoAvgB=0,

			goalsConHomeAvg=0,
			goalsConAwayAvg=0,
			goalsConAvgA=0,
			goalsConAvgB=0,

			wonHomePer=0,
			wonAwayPer=0,
			wonPerA=0,
			wonPerB=0,
			
			bttsHomePer=0,
			bttsAwayPer=0,
			bttsPerA=0,
			bttsPerB=0,

			overHomePer=0,
			overAwayPer=0,
			overPerA=0,
			overPerB=0,

			bOverHomePer=0,
			bOverAwayPer=0,
			bOverPerA=0,
			bOverPerB=0,
			
			cornersWonHomeAvg=0,
			cornersWonAwayAvg=0,
			cornersWonAvgA=0,
			cornersWonAvgB=0,
			
			shotsWonHomeAvg=0,
			shotsWonAwayAvg=0,
			shotsWonAvgA=0,
			shotsWonAvgB=0,
			
			shotsOnTargetWonHomeAvg=0,
			shotsOnTargetWonAwayAvg=0,
			shotsOnTargetWonAvgA=0,
			shotsOnTargetWonAvgB=0,
	
			foulsWonHomeAvg=0,
			foulsWonAwayAvg=0,
			foulsWonAvgA=0,
			foulsWonAvgB=0,
			
			yellowsWonHomeAvg=0,
			yellowsWonAwayAvg=0,
			yellowsWonAvgA=0,
			yellowsWonAvgB=0,

			redsWonHomeAvg=0,
			redsWonAwayAvg=0,
			redsWonAvgA=0,
			redsWonAvgB=0,
			
			cornersConHomeAvg=0,
			cornersConAwayAvg=0,
			cornersConAvgA=0,
			cornersConAvgB=0,
	
			shotsConHomeAvg=0,
			shotsConAwayAvg=0,
			shotsConAvgA=0,
			shotsConAvgB=0,
			
			shotsOnTargetConHomeAvg=0,
			shotsOnTargetConAwayAvg=0,
			shotsOnTargetConAvgA=0,
			shotsOnTargetConAvgB=0,
	
			foulsConHomeAvg=0,
			foulsConAwayAvg=0,
			foulsConAvgA=0,
			foulsConAvgB=0,
			
			yellowsConHomeAvg=0,
			yellowsConAwayAvg=0,
			yellowsConAvgA=0,
			yellowsConAvgB=0,

			redsConHomeAvg=0,
			redsConAwayAvg=0,
			redsConAvgA=0,	
			redsConAvgB=0;

		public int form3PointsHome=0,
			form3PointsAway=0,
			form5PointsA=0,
			form5PointsB=0,
			
			form3GoalsScoHome=0,
			form3GoalsScoAway=0,
			form5GoalsScoA=0,
			form5GoalsScoB=0,
			
			form3GoalsConHome=0,
			form3GoalsConAway=0,
			form5GoalsConA=0,
			form5GoalsConB=0,
			
			form3BttsHome=0,
			form3BttsAway=0,
			form5BttsA=0,
			form5BttsB=0,
			
			form3OverHome=0,
			form3OverAway=0,
			form5OverA=0,
			form5OverB=0,
			
			matchesFormHome=0,
			matchesFormAway=0,
			matchesFormA=0,
			matchesFormB=0;
	
	int ratingWin=0,
		ratingOver=0,
		ratingBtts=0,
		ratingCorners=0;
	boolean hasData=false;

	String codeDiv,
		date,
		homeTeam,
		awayTeam;
	double HODDS, 
		AODDS,
		DODDS,
		OODDS,
		UODDS;

	public String createCsvLine() {
		String temp =  (
			//	matchesHome+","+matchesA+","+matchesAway+","+matchesB+","+
				Common.df12.format(goalsScoHomeAvg)+","+Common.df12.format(goalsScoAvgA)+","+Common.df12.format(goalsScoAwayAvg)+","+Common.df12.format(goalsScoAvgB)
				+","+Common.df12.format(goalsConHomeAvg)+","+Common.df12.format(goalsConAvgA)+","+Common.df12.format(goalsConAwayAvg)+","+Common.df12.format(goalsConAvgB)
				+","+Common.df12.format(wonHomePer)+","+Common.df12.format(wonPerA)+","+Common.df12.format(wonAwayPer)+","+Common.df12.format(wonPerB)
				+","+Common.df12.format(bttsHomePer)+","+Common.df12.format(bttsPerA)+","+Common.df12.format(bttsAwayPer)+","+Common.df12.format(bttsPerB)
				+","+Common.df12.format(overHomePer)+","+Common.df12.format(overPerA)+","+Common.df12.format(overAwayPer)+","+Common.df12.format(overPerB)
				+","+Common.df12.format(bOverHomePer)+","+Common.df12.format(bOverPerA)+","+Common.df12.format(bOverAwayPer)+","+Common.df12.format(bOverPerB));
	return temp;
	}
	
	public void transfer(String[] data) {
		codeDiv=Common.checkString(Common.fixCodeDiv(data[0]));
		date=Common.checkString(data[1]);						
		homeTeam=Common.checkString(data[2]);
		awayTeam=Common.checkString(data[3]);
		HODDS=Common.checkDouble(data[4]);
		AODDS=Common.checkDouble(data[5]);
		DODDS=Common.checkDouble(data[6]);
		OODDS=Common.checkDouble(data[7]);
		UODDS=Common.checkDouble(data[8]);
	}
		
	public Fixture(String[] data) {
		transfer(data);
		if (date.contains("-"))
			System.out.println("Alert:Date with -  "+codeDiv+" "+date);
		
		if (codeDiv.equalsIgnoreCase("-1") || date.equalsIgnoreCase("-1") || homeTeam.equalsIgnoreCase("-1")
				|| awayTeam.equalsIgnoreCase("-1")) {
			System.out.println("Alert:Data input with -1 on basic info "+codeDiv+" "+date);
		}
	}

	public void multi() {
		if(Analysis.multi) {
		if(HODDS!=-1.00 && AODDS!=-1.00) {
			if(ratingWin>0) {
				ratingWin=(int)(ratingWin*Math.sqrt(HODDS));
			}else {
				ratingWin=(int)(ratingWin*Math.sqrt(AODDS));
			}
		}
		}
			
	}
	
	
	
	public void shotRating() {
		double limit=4;
		int tempRating=0;

		if(cornersWonHomeAvg>=limit)tempRating++;
		if(cornersWonAvgA>=limit)tempRating++;
		
		if(cornersWonAwayAvg>=limit)tempRating++;
		if(cornersWonAvgB>=limit)tempRating++;
		
		if(cornersConHomeAvg>=limit)tempRating++;
		if(cornersConAvgA>=limit)tempRating++;
		
		if(cornersConAwayAvg>=limit)tempRating++;
		if(cornersConAvgB>=limit)tempRating++;
		
		if(cornersWonHomeAvg>=limit+1)tempRating++;
		if(cornersWonAvgA>=limit+1)tempRating++;
		
		if(cornersWonAwayAvg>=limit+1)tempRating++;
		if(cornersWonAvgB>=limit+1)tempRating++;
		
		if(cornersConHomeAvg>=limit+1)tempRating++;
		if(cornersConAvgA>=limit+1)tempRating++;
		
		if(cornersConAwayAvg>=limit+1)tempRating++;
		if(cornersConAvgB>=limit+1)tempRating++;
		
		if(cornersWonHomeAvg>=limit+2)tempRating++;
		if(cornersWonAvgA>=limit+2)tempRating++;
		
		if(cornersWonAwayAvg>=limit+2)tempRating++;
		if(cornersWonAvgB>=limit+2)tempRating++;
		
		if(cornersConHomeAvg>=limit+2)tempRating++;
		if(cornersConAvgA>=limit+2)tempRating++;
		
		if(cornersConAwayAvg>=limit+2)tempRating++;
		if(cornersConAvgB>=limit+2)tempRating++;
		
				
		
		
		
		if(cornersWonAvgA==0) {
			ratingWin=-1000;
		} else {
			
			double sumCorners=0;
		if(cornersWonHomeAvg+cornersWonAvgA>cornersConAwayAvg+cornersConAvgB) {
			sumCorners+=cornersConAwayAvg+cornersConAvgB;
		}else {
			sumCorners+=cornersWonHomeAvg+cornersWonAvgA;	
		}
		
		if(cornersWonAwayAvg+cornersWonAvgB>cornersConHomeAvg+cornersConAvgA) {
			sumCorners+=cornersConHomeAvg+cornersConAvgA;	
		}else {
			sumCorners+=cornersWonAwayAvg+cornersWonAvgB;	
		}
		
			ratingWin=(int)(2.5*(cornersWonHomeAvg+
					cornersWonAwayAvg+
					cornersWonAvgA+
					cornersWonAvgB+
					cornersConHomeAvg+
					cornersConAwayAvg
					+cornersConAvgA+
					cornersConAvgB
					));
		
			ratingWin+=(int)(15*sumCorners);
			ratingWin=ratingWin/4;
			
			double tempShotsT = (shotsOnTargetWonHomeAvg+shotsOnTargetWonAwayAvg+shotsOnTargetConHomeAvg+shotsOnTargetConAwayAvg)/2;
			
		//	System.out.println(homeTeam+" "+awayTeam);
			
		//	System.out.println(Common.df11.format((ratingWin/10.0)/tempShotsT)+"->"+ratingWin);
			//System.out.println("----------------------------");
	//	ratingWin=tempRating;;
				//(int)(1000*(wonPerA-wonPerB));
		//	ratingWin=(int)(1000*(((goalsScoAvgA/shotsWonAvgA)+(goalsConAvgB/shotsConAvgB))-((goalsScoAvgB/shotsWonAvgB)+(goalsConAvgA/shotsConAvgA))));
	//	System.out.println(ratingOver);
		}
		/*
		goalsScoHomeAvg=0,
				goalsScoAwayAvg=0,
				goalsScoAvgA=0,
				goalsScoAvgB=0,

				goalsConHomeAvg=0,
				goalsConAwayAvg=0,
				goalsConAvgA=0,
				goalsConAvgB=0,
		
		
		shotsWonHomeAvg=0,
				shotsWonAwayAvg=0,
				shotsWonAvgA=0,
				shotsWonAvgB=0,
				
				shotsOnTargetWonHomeAvg=0,
				shotsOnTargetWonAwayAvg=0,
				shotsOnTargetWonAvgA=0,
				shotsOnTargetWonAvgB=0,
				
				shotsConHomeAvg=0,
				shotsConAwayAvg=0,
				shotsConAvgA=0,
				shotsConAvgB=0,
				
				shotsOnTargetConHomeAvg=0,
				shotsOnTargetConAwayAvg=0,
				shotsOnTargetConAvgA=0,
				shotsOnTargetConAvgB=0,
	*/
	}
	
	
	
}