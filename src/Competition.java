import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Competition{
	public List<String[]> fixturesInput, results;
	public List<Team> teams;
	public List<Fixture> fixturesOutput;
	public List<Comparison> winHomeRatings, winAwayRatings,
							overHomeRatings, overAwayRatings,
							bttsHomeRatings, bttsAwayRatings,
							fixtureWinRatings,
							fixtureOverRatings,
							fixtureBttsRatings;
	public String name,code;
	int div, year;
	public int[][] scores;	
	public int matches=0,
				goalsHome=0,	goalsAway=0,	goals=0,
				winHome=0,		winAway=0, 		draw=0,
				btts=0, 		over=0, 		bOver=0,
				goals01=0,		goals23=0,		goals46=0, goals7=0,
				homeWinPer=0, 	awayWinPer=0, 	drawPer=0,
				bttsPer=0, 		overPer=0, 		bOverPer=0,
				goals01Per=0,	goals23Per=0,	goals46Per=0, goals7Per=0;
	public double	goalsHomeAvg=0, goalsAwayAvg=0, goalsAvg=0,
					betHome=0, betAway=0, betDraw=0;
	
	public Competition(String csvFile, String name, String code, int div, int year){
		this.name=name;
		this.code=code;
		this.div=div;
		this.year=year;
		CSVReader reader = new CSVReader(csvFile, year);
		results = new ArrayList<String[]>(reader.results);
		fixturesInput = new ArrayList<String[]>(reader.fixtures);
		teams = new ArrayList<Team>();
		fixturesOutput = new ArrayList<Fixture>();
		scores = new int[10][10];
		matches=results.size()-1;
		createTeams();
		createStats();
		createRatingLists();
		createFixtures();
	}
	public void printManager(int choice){
		switch(choice){
		case 0: printTeamNames(); break;
		case 2: printAll(); break;
		case 3: printCompetitionStats(); break;
		case 4: printCompetitionScores(); break;
		case 5: printAllTeamStats(); break;
		case 6: printAllTeamScores(); break;
		case 7: printAllFormRatingsList(); break;
		case 8: printAllFixturesStats(); break;
		case 9: printAllFixturesRatingsList(); break;
		default: break;
		};
	}
	
	public void printManager(String teamName){
		 printTeamAll(teamName);
	}
	
	private void printTeamNames(){
		for(int i=0;i<teams.size();i++){
			System.out.println(i+": "+teams.get(i).name);
		}
	}
	
	private int findTeam(String name){
		for(int i=0;i<teams.size();i++){
			if(name.equalsIgnoreCase(teams.get(i).name))return i;
		}
		throw new IllegalArgumentException("Wrong name");
	}
	
	private void printTeamAll(String name){
		int i =findTeam(name);
		teams.get(i).printAll();
	}
	
	private void printTeamAll(int i){
		teams.get(i).printAll();
	}
	
	public void printAll(){
		printCompetitionStats();
		printCompetitionScores();
		printAllTeamStats();
		printAllTeamScores();
		printAllFormRatingsList();
		printAllFixturesStats();
		printAllFixturesRatingsList();
	}
	
	private void printCompetitionStats(){
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(name+":");
		System.out.println("Played:\t"+matches);
		
		System.out.println("1:\t"+winHome+"("+homeWinPer+"%)");
		System.out.println("X:\t"+draw+"("+drawPer+"%)");
		System.out.println("2:\t"+winAway+"("+awayWinPer+"%)");
		
		System.out.println("HomeG:\t"+goalsHome+"("+df.format(goalsHomeAvg)+")");
		System.out.println("AwayG:\t"+goalsAway+"("+df.format(goalsAwayAvg)+")");
		System.out.println("TotalG:\t"+goals+"("+df.format(goalsAvg)+")");
		
		System.out.println("Over:\t"+over+"("+overPer+"%)");
		System.out.println("Btts:\t"+btts+"("+bttsPer+"%)");
		System.out.println("bOver:\t"+bOver+"("+bOverPer+"%)");
		
		System.out.println("0-1:\t"+goals01+"("+goals01Per+"%)");
		System.out.println("2-3:\t"+goals23+"("+goals23Per+"%)");
		System.out.println("4-6:\t"+goals46+"("+goals46Per+"%)");
		System.out.println("7+:\t"+goals7+"("+goals7Per+"%)");
		
		System.out.println("BetHome:\t"+betHome);
		System.out.println("BetDraw:\t"+betDraw);
		System.out.println("BetAway:\t"+betAway);
		
		System.out.println();
	}
	private void printCompetitionScores(){
		System.out.print(name+" scores:");
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
	
	private void printAllTeamStats(){
		System.out.print(name+" teams stats:\n");
		System.out.println("________________________________________________________");
		for(int i=0;i<teams.size();i++){
			teams.get(i).printTeamStats();
			System.out.println("________________________________________________________\n");
		}
	}
	private void printAllTeamScores(){
		System.out.print(name+" teams scores:\n");
		for(int i=0;i<teams.size();i++){
			teams.get(i).printTeamScores();
		}
	}
	private void printAllFormRatingsList(){
		System.out.print(name+" form ratings:\n");
		System.out.println("WinHomeRatings:");
		printList(winHomeRatings);
		System.out.println();
		System.out.println("WinAwayRatings:");
		printList(winAwayRatings);
		System.out.println();
		System.out.println("OverHomeRatings:");
		printList(overHomeRatings);
		System.out.println();
		System.out.println("OverAwayRatings:");
		printList(overAwayRatings);
		System.out.println();
		System.out.println("BttsHomeRatings:");
		printList(bttsHomeRatings);
		System.out.println();
		System.out.println("BttsAwayRatings:");
		printList(bttsAwayRatings);
		System.out.println();
	}

	private void printAllFixturesStats(){
		System.out.print(name+" fixtures stats:\n");
		for(int i=0;i<fixturesOutput.size();i++){
			System.out.println(fixturesOutput.get(i).nameHome+"-"+fixturesOutput.get(i).nameAway+":");
			System.out.print("Win:"+fixturesOutput.get(i).ratingWin);
			System.out.print("\tOver:"+fixturesOutput.get(i).ratingOver);
			System.out.println("\tBtts:"+fixturesOutput.get(i).ratingBtts);
			System.out.println();
		}
	}

	private void printAllFixturesRatingsList(){
		System.out.print(name+" fixtures ratings:\n");
		if(fixturesOutput.size()>0){
			System.out.println("Fixture Win Ratings:");
			printList(fixtureWinRatings);
			System.out.println();
			System.out.println("Fixture Over Ratings:");
			printList(fixtureOverRatings);
			System.out.println();
			System.out.println("Fixture Btts Ratings:");
			printList(fixtureBttsRatings);
			System.out.println("");
			}
	}
	private void createTeams(){
		for(int i=1;i<results.size();i++){
			String teamName=results.get(i)[2];
			for(int j=0;j<=teams.size();j++){
				if(j<teams.size()){
					if(teamName.equals(teams.get(j).name)){
						break;
					}
				}
				else if(teams.size()==j){
					teams.add(new Team(teamName, results));
					break;
				}
			}
		}
	}
	private void createStats(){
		DecimalFormat df = new DecimalFormat("0.00");
		for(int i=1;i<results.size();i++){
			goalsHome+=Integer.valueOf(results.get(i)[4]);
			goalsAway+=Integer.valueOf(results.get(i)[5]);
			if(Integer.valueOf(results.get(i)[4])>0 && Integer.valueOf(results.get(i)[5])>0)btts++;
			if(Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5])>2)over++;
			if((Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5])>2)
				&&(Integer.valueOf(results.get(i)[4])>0 && Integer.valueOf(results.get(i)[5])>0))bOver++;
			int tempSum = Integer.valueOf(results.get(i)[4])+Integer.valueOf(results.get(i)[5]);
			if(tempSum<2)goals01++;
			if(tempSum>1 && tempSum<4)goals23++;
			if(tempSum>3 && tempSum<7)goals46++;
			if(tempSum>6)goals7++;
			if(Integer.valueOf(results.get(i)[4])>Integer.valueOf(results.get(i)[5]))winHome++;
			if(Integer.valueOf(results.get(i)[4])<Integer.valueOf(results.get(i)[5]))winAway++;
			if(Integer.valueOf(results.get(i)[4])==Integer.valueOf(results.get(i)[5]))draw++;
			scores[Integer.valueOf(results.get(i)[4])][Integer.valueOf(results.get(i)[5])]++;
			if(!(results.get(i)[23].equalsIgnoreCase("1000")
					 || results.get(i)[23].length() ==0 )) {
				//System.out.println("------:"+results.get(i)[6]);
			////	System.out.println("Pre:"+df.format(betHome)+"/"+df.format(betDraw)+"/"+df.format(betAway));
			//System.out.println("Odd:"+results.get(i)[23]+"/"+results.get(i)[24]+"/"+results.get(i)[25]);
			//double temp = (1/Double.parseDouble(results.get(i)[23]))+(1/Double.parseDouble(results.get(i)[24]))+(1/Double.parseDouble(results.get(i)[25]));
	
			//System.out.println(temp);	
			if(Integer.valueOf(results.get(i)[4])>Integer.valueOf(results.get(i)[5])) {
					betHome+=(Double.parseDouble(results.get(i)[23])-1.00);
					betAway--;
					betDraw--;
				}
				if(Integer.valueOf(results.get(i)[4])<Integer.valueOf(results.get(i)[5])) {
					betHome--;
					betAway+=(Double.parseDouble(results.get(i)[25])-1.00);
					betDraw--;
				}
				if(Integer.valueOf(results.get(i)[4])==Integer.valueOf(results.get(i)[5])) {
					betHome--;
					betAway--;
					betDraw+=(Double.parseDouble(results.get(i)[24])-1.00);
				}
			//	System.out.println("Aft:"+df.format(betHome)+"/"+df.format(betDraw)+"/"+df.format(betAway));
			}
		}
		goals=goalsHome+goalsAway;
		goalsHomeAvg=(double)(goalsHome)/matches;
		goalsAwayAvg=(double)(goalsAway)/matches;
		goalsAvg=(double)(goals)/matches;
		homeWinPer=(100*winHome)/matches;
		awayWinPer=(100*winAway)/matches;
		drawPer=(100*draw)/matches;
		bttsPer=(100*btts)/matches;
		overPer=(100*over)/matches;
		bOverPer=(100*bOver)/matches;
		goals01Per=(100*goals01)/matches;
		goals23Per=(100*goals23)/matches;
		goals46Per=(100*goals46)/matches;
		goals7Per=(100*goals7)/matches;
	}
	
	private void createRatingLists(){
		winHomeRatings = new ArrayList<Comparison>();
		winAwayRatings = new ArrayList<Comparison>();
		overHomeRatings = new ArrayList<Comparison>();
		overAwayRatings = new ArrayList<Comparison>();
		bttsHomeRatings = new ArrayList<Comparison>();
		bttsAwayRatings = new ArrayList<Comparison>();		
		for(int i=0; i<teams.size();i++){
			winHomeRatings.add(new Comparison(teams.get(i).name, teams.get(i).winHomeRating));
			winAwayRatings.add(new Comparison(teams.get(i).name, teams.get(i).winAwayRating));
			overHomeRatings.add(new Comparison(teams.get(i).name, teams.get(i).overHomeRating));
			overAwayRatings.add(new Comparison(teams.get(i).name, teams.get(i).overAwayRating));
			bttsHomeRatings.add(new Comparison(teams.get(i).name, teams.get(i).bttsHomeRating));
			bttsAwayRatings.add(new Comparison(teams.get(i).name, teams.get(i).bttsAwayRating));
		}
		sort(winHomeRatings);
		sort(winAwayRatings);
		sort(overHomeRatings);
		sort(overAwayRatings);
		sort(bttsHomeRatings);
		sort(bttsAwayRatings);
	}

	private void createFixtures(){
		if(fixturesInput.size()>0){
			for(int i=0;i<fixturesInput.size();i++){
				fixturesOutput.add(new Fixture(fixturesInput.get(i)[2], fixturesInput.get(i)[3]));
				for(int j=0;j<teams.size();j++){
					if(fixturesOutput.get(i).nameHome.equals(teams.get(j).name)){
						fixturesOutput.get(i).ratingWin+=teams.get(j).winHomeRating;
						fixturesOutput.get(i).ratingOver+=teams.get(j).overHomeRating;
						fixturesOutput.get(i).ratingBtts+=teams.get(j).bttsHomeRating;
					}
					if(fixturesOutput.get(i).nameAway.equals(teams.get(j).name)){
						fixturesOutput.get(i).ratingWin-=teams.get(j).winAwayRating;
						fixturesOutput.get(i).ratingOver+=teams.get(j).overAwayRating;
						fixturesOutput.get(i).ratingBtts+=teams.get(j).bttsAwayRating;
					}
				}
			}
		}
		fixtureWinRatings = new ArrayList<Comparison>();
		fixtureOverRatings = new ArrayList<Comparison>();
		fixtureBttsRatings = new ArrayList<Comparison>();
		for(int i=0; i<fixturesOutput.size();i++){
			fixtureWinRatings.add(new Comparison(fixturesOutput.get(i).nameHome+"-"+fixturesOutput.get(i).nameAway, fixturesOutput.get(i).ratingWin));
			fixtureOverRatings.add(new Comparison(fixturesOutput.get(i).nameHome+"-"+fixturesOutput.get(i).nameAway, fixturesOutput.get(i).ratingOver));
			fixtureBttsRatings.add(new Comparison(fixturesOutput.get(i).nameHome+"-"+fixturesOutput.get(i).nameAway, fixturesOutput.get(i).ratingBtts));
		}
		sort(fixtureWinRatings);
		sort(fixtureOverRatings);
		sort(fixtureBttsRatings);
	}
	private void printList(List<Comparison> list){
		for(int i=0; i<list.size();i++){
			list.get(i).print();
		}
	}

	private void sort(List<Comparison> list){
		boolean flag = true;
		while ( flag )
			{
			flag= false;
			for(int i=0;i<list.size()-1;i++){
				if (list.get(i).rating<list.get(i+1).rating){
					Comparison.swap(list.get(i), list.get(i+1));
					flag = true; 									
				} 
			} 
		}
	}
}