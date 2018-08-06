import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

public class Common {
	
	public static DecimalFormat df22 = new DecimalFormat("00.00"), 
			df21 = new DecimalFormat("00.0"),
			df12 = new DecimalFormat("0.00"), 
			df11 = new DecimalFormat("0.0"), 
			df20 = new DecimalFormat("00");

	public static String pathToSrc = "/Users/makis/git/Analysis/src/",
			pathToNewData = "/Users/makis/git/Analysis/src/NewData/",
			pathToOldData = "/Users/makis/git/Analysis/src/OldData/",
			basicFixtures = "fixtures.basic.csv", 
			extraFixtures = "fixtures.extra.csv",
			pathToBasicFixtures = pathToSrc + basicFixtures, 
			pathToExtraFixtures = pathToSrc + extraFixtures,

			linkToSite = "http://www.football-data.co.uk/", 
			linkToBasicData = linkToSite + "mmz4281/",
			linkToExtraData = linkToSite + "new/", 
			linkToBasicFixtures = linkToSite + "fixtures.csv",
			linkToExtraFixtures = linkToSite + "new_league_fixtures.csv",

			pathToOutput = "C:/Users/makis/Desktop/output.txt";

	
	public static String[] abrOptExtra= 
									{/*0*/"Country",
									/*1*/"Date",
									/*2*/ "Home",
									/*3*/ "Away",
									/*4*/ "HG",
									/*5*/ "AG",
									/*6*/ "Res",
									/*7*/ "HTHG", //Half Time Home Team Goals
									/*8*/ "HTAG", //Half Time Away Team Goals
									/*9*/ "HTR", //Half Time Result (H Home Win, D Draw, A Away Win)
									/*10*/ "Referee", //Match Referee
									/*11*/ "HS", //Home Team Shots
									/*12*/ "AS", //Away Team Shots
									/*13*/ "HST", //Home Team Shots on Target
									/*14*/ "AST", //Away Team Shots on Target
									/*15*/ "HC", //Home Team Corners
									/*16*/ "AC", //Away Team Corners
									/*17*/ "HF", //Home Team Fouls Committed
									/*18*/ "AF", //Away Team Fouls Committed
									/*19*/ "HY", //Home Team Yellow Cards
									/*20*/ "AY", //Away Team Yellow Cards
									/*21*/ "HR", //Home Team Red Cards
									/*22*/ "AR", //Away Team Red Cards
									
								//	/*23*/"B365H", //Bet365 home win odds
								//	/*24*/"B365D", //Bet365 draw odds
								//	/*25*/"B365A", //Bet365 away win odds
									
									/*23*/"PH",
									/*24*/"PD",
									/*25*/"PA",
									//PH,PD,PA,MaxH,MaxD,MaxA,AvgH,AvgD,AvgA
									/*26*/"BbAv>2.5", //Betbrain average over 2.5 goals
									/*27*/"BbAv<2.5"}, //Betbrain average under 2.5 goals
	
								abrOpt=
								{/*0*/"Div", //League Division
								/*1*/"Date", //Match Date (dd/mm/yy)
								/*2*/"HomeTeam", //Home Team
								/*3*/"AwayTeam", //Away Team
								/*4*/"FTHG", //Full Time Home Team Goals
								/*5*/"FTAG", //Full Time Away Team Goals
								/*6*/"FTR", //Full Time Result (H=Home Win, D=Draw, A=Away Win)
								/*7*/"HTHG", //Half Time Home Team Goals
								/*8*/"HTAG", //Half Time Away Team Goals
								/*9*/"HTR", //Half Time Result (H=Home Win, D=Draw, A=Away Win)
								/*10*/"Referee", //Match Referee
								/*11*/"HS", //Home Team Shots
								/*12*/"AS", //Away Team Shots
								/*13*/"HST", //Home Team Shots on Target
								/*14*/"AST", //Away Team Shots on Target
								/*15*/"HC", //Home Team Corners
								/*16*/"AC", //Away Team Corners
								/*17*/"HF", //Home Team Fouls Committed
								/*18*/"AF", //Away Team Fouls Committed
								/*19*/"HY", //Home Team Yellow Cards
								/*20*/"AY", //Away Team Yellow Cards
								/*21*/"HR", //Home Team Red Cards
								/*22*/"AR", //Away Team Red Cards
								/*23*/"B365H", //Bet365 home win odds
								/*25*/"B365A", //Bet365 away win odds
								/*24*/"B365D", //Bet365 draw odds
								/*26*/"BbAv>2.5", //Betbrain average over 2.5 goals
								/*27*/"BbAv<2.5"}, //Betbrain average under 2.5 goals
	
									abrOptFixExtra=
									{/*0*/"Country",
										/*1*/"Date",
										/*2*/ "Home",
										/*3*/ "Away",
										/*4*/ "HG",
										/*5*/ "AG",
										/*6*/ "Res",
										/*7*/"HTHG", //Half Time Home Team Goals
									/*8*/"HTAG", //Half Time Away Team Goals
										/*9*/"HTR", //Half Time Result (H=Home Win, D=Draw, A=Away Win)
										/*10*/"Referee", //Match Referee
										/*11*/"HS", //Home Team Shots
										/*12*/"AS", //Away Team Shots
										/*13*/"HST", //Home Team Shots on Target
										/*14*/"AST", //Away Team Shots on Target
										/*15*/"HC", //Home Team Corners
										/*16*/"AC", //Away Team Corners
										/*17*/"HF", //Home Team Fouls Committed
										/*18*/"AF", //Away Team Fouls Committed
										/*19*/"HY", //Home Team Yellow Cards
										/*20*/"AY", //Away Team Yellow Cards
										/*21*/"HR", //Home Team Red Cards
										/*22*/"AR", //Away Team Red Cards
										/*23*/"PH",
										/*24*/"PD",
										/*25*/"PA",
										/*26*/"BbAv>2.5", //Betbrain average over 2.5 goals
										/*27*/"BbAv<2.5"}, //Betbrain average under 2.5 goals
										
								abrOptFix=							
										{/*0*/"Div", //League Division
										/*1*/"Date", //Match Date (dd/mm/yy)
										/*2*/"HomeTeam", //Home Team
										/*3*/"AwayTeam", //Away Team
										/*4*/"FTHG", //Full Time Home Team Goals
										/*5*/"FTAG", //Full Time Away Team Goals
										/*6*/"FTR", //Full Time Result (H=Home Win, D=Draw, A=Away Win)
										/*7*/"HTHG", //Half Time Home Team Goals
										/*8*/"HTAG", //Half Time Away Team Goals
										/*9*/"HTR", //Half Time Result (H=Home Win, D=Draw, A=Away Win)
										/*10*/"Referee", //Match Referee
										/*11*/"HS", //Home Team Shots
										/*12*/"AS", //Away Team Shots
										/*13*/"HST", //Home Team Shots on Target
										/*14*/"AST", //Away Team Shots on Target
										/*15*/"HC", //Home Team Corners
										/*16*/"AC", //Away Team Corners
										/*17*/"HF", //Home Team Fouls Committed
										/*18*/"AF", //Away Team Fouls Committed
										/*19*/"HY", //Home Team Yellow Cards
										/*20*/"AY", //Away Team Yellow Cards
										/*21*/"HR", //Home Team Red Cards
										/*22*/"AR", //Away Team Red Cards
										/*23*/"B365H", //Bet365 home win odds
										/*25*/"B365A", //Bet365 away win odds
										/*24*/"B365D", //Bet365 draw odds
										/*26*/"BbAv>2.5", //Betbrain average over 2.5 goals
										/*27*/"BbAv<2.5"}; //Betbrain average under 2.5 goals
	
	public static String[] 
seasonsNewInput  = {"1819/"},
seasonsNewOutput = {".1819"},
				
seasonsOldInput  = {"0809/","0910/","1011/","1112/","1213/","1314/","1415/","1516/","1617/","1718/"},
seasonsOldOutput = {".0809",".0910",".1011",".1112",".1213",".1314",".1415",".1516",".1617",".1718"},

			leaguesInputFirst = {"E0","SP1","D1","I1","F1","G1"},
			leaguesOutputFirst = {"EN1","SP1","DE1","IT1","FR1","GR1"},
			
			leaguesInputSecond = {"SC0","N1","B1","P1","T1","E1"},
			leaguesOutputSecond = {"SC1","NE1","BE1","PO1","TU1","EN2"},
					
			leaguesInputThird = {"SC1","SP2","D2","I2","F2","E2","SC2","E3","SC3","EC"},
			leaguesOutputThird = {"SC2","SP2","DE2","IT2","FR2","EN3","SC3","EN4","SC4","EN5"},
	
			leaguesInputRestW = {"ARG","AUT","DNK","MEX","POL","ROU","RUS","SWZ"},
			leaguesOutputRestW = {"AR1","AU1","DN1","ME1","PL1","RO1","RU1","SU1"},
					
			leaguesInputRestS = {"BRA","CHN","FIN","IRL","JPN","NOR","SWE","USA"},
			leaguesOutputRestS = {"BR1","CH1","FI1","IR1","JP1","NO1","SW1","US1"};

	public static String[] input1 = {"E0","SP1","D1","I1","F1","G1",
			"SC0","N1","B1","P1","T1","E1",
			"SC1","SP2","D2","I2","F2","E2","SC2","E3","SC3","EC",
			"ARG","AUT","DNK","MEX","POL","ROU","RUS","SWZ",
			"BRA","CHN","FIN","IRL","JPN","NOR","SWE","USA"},
			
			input2 = {"E0","SP1","D1","I1","F1","G1",
					"SC0","N1","B1","P1","T1","E1",
					"SC1","SP2","D2","I2","F2","E2","SC2","E3","SC3","EC",
					"Argentina","Austria","Denmark","Mexico","Poland","Romania","Russia","Switzerland",
					"Brazil","China","Finland","Ireland","Japan","Norway","Sweden","USA"},
			
			output = {"EN1","SP1","DE1","IT1","FR1","GR1",
					"SC1","NE1","BE1","PO1","TU1","EN2",
					"SC2","SP2","DE2","IT2","FR2","EN3","SC3","EN4","SC4","EN5",
					"AR1","AU1","DN1","ME1","PL1","RO1","RU1","SU1",
					"BR1","CH1","FI1","IR1","JP1","NO1","SW1","US1"};
	
	
	public static boolean checkCodeDiv(String codeDiv) {
		for(int i=0;i<output.length;i++) {
			if(codeDiv.equalsIgnoreCase(output[i]))return true;
		}
	return false;
	}
	
	public static void sort(List<Comparison> list){
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
	
	public static void sortD(List<Comparison> list){
		boolean flag = true;
		while ( flag )
			{
			flag= false;
			for(int i=0;i<list.size()-1;i++){
				if ((Double.compare(list.get(i).ratingD,list.get(i+1).ratingD))<0){
					Comparison.swap(list.get(i), list.get(i+1));
					flag = true; 									
				} 
			} 
		}
	}
	
	public static void printList(List<Comparison> list){
		for(int i=0; i<list.size();i++){
			list.get(i).print();
		}
	}


	public static String codeToName(String code){
		String name;
		if(code.equalsIgnoreCase("EN")) name="England";
		else if(code.equalsIgnoreCase("SP")) name="Spain";
		else if(code.equalsIgnoreCase("DE")) name="Germany";
		else if(code.equalsIgnoreCase("IT")) name="Italy";
		else if(code.equalsIgnoreCase("FR")) name="France";
		else if(code.equalsIgnoreCase("GR")) name="Greece";
		else if(code.equalsIgnoreCase("SC")) name="Scotland";
		else if(code.equalsIgnoreCase("NE")) name="Netherlands";
		else if(code.equalsIgnoreCase("BE")) name="Belgium";
		else if(code.equalsIgnoreCase("PO")) name="Portugal";
		else if(code.equalsIgnoreCase("TU")) name="Turkey";
		else if(code.equalsIgnoreCase("AR")) name="Argentina";
		else if(code.equalsIgnoreCase("AU")) name="Austria";
		else if(code.equalsIgnoreCase("DN")) name="Denmark";
		else if(code.equalsIgnoreCase("ME")) name="Mexico";
		else if(code.equalsIgnoreCase("PL")) name="Poland";
		else if(code.equalsIgnoreCase("RO")) name="Romania";
		else if(code.equalsIgnoreCase("RU")) name="Russia";
		else if(code.equalsIgnoreCase("SU")) name="Switzerland";
		else if(code.equalsIgnoreCase("BR")) name="Brazil";
		else if(code.equalsIgnoreCase("CH")) name="China";
		else if(code.equalsIgnoreCase("FI")) name="Finland";
		else if(code.equalsIgnoreCase("IR")) name="Ireland";
		else if(code.equalsIgnoreCase("JP")) name="Japan";
		else if(code.equalsIgnoreCase("NO")) name="Norway";
		else if(code.equalsIgnoreCase("SW")) name="Sweden";
		else if(code.equalsIgnoreCase("US")) name="USA";
		else {name=""; System.out.println("code error");}
		return name;
	}

	
	public static String fixCodeDiv(String oldCodeDiv) {
		String newCodeDiv="";
		oldCodeDiv=oldCodeDiv.replaceAll("\\s+","");
		for(int i=0;i<output.length;i++)
			if(oldCodeDiv.equalsIgnoreCase(input1[i]) || oldCodeDiv.equalsIgnoreCase(input2[i]))
				newCodeDiv=output[i];
		
		if(newCodeDiv.equals(""))System.out.println("Wrong CodeDiv: >"+oldCodeDiv+"<");
		return newCodeDiv;
	}
	
	public static String getDate() {
		return getDate("/");
	}
	public static String getDate(String seperator){
		String dateIn = LocalDateTime.now()+"",
				day = dateIn.substring(dateIn.lastIndexOf('-') + 1, (dateIn.lastIndexOf('-') + 3)),
				month = dateIn.substring(dateIn.indexOf('-') + 1, (dateIn.indexOf('-') + 3)),
				year = dateIn.substring(dateIn.indexOf('-') - 2, (dateIn.indexOf('-'))),
				dateOut = day+seperator+month+seperator+year;
		return dateOut;
	}
}
