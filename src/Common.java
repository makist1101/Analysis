import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Common {

	public static DecimalFormat df22 = new DecimalFormat("00.00"), 
			df21 = new DecimalFormat("00.0"),
			df13 = new DecimalFormat("0.000"), 
			df12 = new DecimalFormat("0.00"), 
			df11 = new DecimalFormat("0.0"),
			df20 = new DecimalFormat("00"),
			df10 = new DecimalFormat("0");
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

//pathToOutput = "C:/Users/makis/Desktop/output.txt";
pathToOutput = "C:/Users/makis/Google Drive/Analysis/output."+Common.getDate().replace("/","")+".txt";
	
	public static String[] abrOptExtra= 
									{/*0*/"Country",
											/*1*/"Date",
											/*2*/ "Home",
											/*3*/ "Away",
											/*4*/ "HG",
											/*5*/ "AG",
											/*6*/"HTHG", //Half Time Home Team Goals
											/*7*/"HTAG", //Half Time Away Team Goals
											/*8*/"Referee", //Match Referee
											/*9*/"HS", //Home Team Shots
											/*10*/"AS", //Away Team Shots
											/*11*/"HST", //Home Team Shots on Target
											/*12*/"AST", //Away Team Shots on Target
											/*13*/"HC", //Home Team Corners
											/*14*/"AC", //Away Team Corners
											/*15*/"HF", //Home Team Fouls Committed
											/*16*/"AF", //Away Team Fouls Committed
											/*17*/"HY", //Home Team Yellow Cards
											/*18*/"AY", //Away Team Yellow Cards
											/*19*/"HR", //Home Team Red Cards
											/*20*/"AR", //Away Team Red Cards
									/*21*/"AvgH",
									/*22*/"AvgD",
									/*23*/"AvgHA",
									//PH,PD,PA,MaxH,MaxD,MaxA,AvgH,AvgD,AvgA
									/*24*/"BbAv>2.5", //Betbrain average over 2.5 goals
									/*25*/"BbAv<2.5"}, //Betbrain average under 2.5 goals
	
								abrOpt=
								{/*0*/"Div", //League Division
								/*1*/"Date", //Match Date (dd/mm/yy)
								/*2*/"HomeTeam", //Home Team
								/*3*/"AwayTeam", //Away Team
								/*4*/"FTHG", //Full Time Home Team Goals
								/*5*/"FTAG", //Full Time Away Team Goals
								/*6*/"HTHG", //Half Time Home Team Goals
								/*7*/"HTAG", //Half Time Away Team Goals
								/*8*/"Referee", //Match Referee
								/*9*/"HS", //Home Team Shots
								/*10*/"AS", //Away Team Shots
								/*11*/"HST", //Home Team Shots on Target
								/*12*/"AST", //Away Team Shots on Target
								/*13*/"HC", //Home Team Corners
								/*14*/"AC", //Away Team Corners
								/*15*/"HF", //Home Team Fouls Committed
								/*16*/"AF", //Away Team Fouls Committed
								/*17*/"HY", //Home Team Yellow Cards
								/*18*/"AY", //Away Team Yellow Cards
								/*19*/"HR", //Home Team Red Cards
								/*20*/"AR", //Away Team Red Cards
								/*21*/"B365H", //Bet365 home win odds
								/*22*/"B365A", //Bet365 away win odds
								/*23*/"B365D", //Bet365 draw odds
								/*24*/"BbAv>2.5", //Betbrain average over 2.5 goals
								/*25*/"BbAv<2.5"}, //Betbrain average under 2.5 goals
	
									abrOptFixExtra=
									{/*0*/"Country",
										/*1*/"Date",
										/*2*/ "Home",
										/*3*/ "Away",
										/*4*/"AvgH",
										/*5*/"AvgA",
										/*6*/"AvgD",
										/*7*/"BbAv>2.5", //Betbrain average over 2.5 goals
										/*8*/"BbAv<2.5"}, //Betbrain average under 2.5 goals
										
								abrOptFix=							
										{/*0*/"Div", //League Division
										/*1*/"Date", //Match Date (dd/mm/yy)
										/*2*/"HomeTeam", //Home Team
										/*3*/"AwayTeam", //Away Team
										/*4*/"B365H", //Bet365 home win odds
										/*5*/"B365A", //Bet365 away win odds
										/*6*/"B365D", //Bet365 draw odds
										/*7*/"BbAv>2.5", //Betbrain average over 2.5 goals
										/*8*/"BbAv<2.5"}; //Betbrain average under 2.5 goals
	
	public static String[] 
seasonsNewInput  = {"1819/"},
seasonsNewOutput = {".1819"},
				
seasonsOldInput  = {"0001/","0102/","0203/","0304/","0405/","0506/","0607/","0708/","0809/","0910/","1011/","1112/","1213/","1314/","1415/","1516/","1617/","1718/"},
seasonsOldOutput = {".0001",".0102",".0203",".0304",".0405",".0506",".0607",".0708",".0809",".0910",".1011",".1112",".1213",".1314",".1415",".1516",".1617",".1718"},

			leaguesFirst = {"E0","SP1","D1","I1","F1","G1"},
			leaguesSecond = {"SC0","N1","B1","P1","T1","E1","SP2","D2","F2"},
			leaguesThird = {"SC1","I2","E2","SC2","E3","SC3","EC"},
			leaguesExtraStartS = {"ARG", "AUT", "DNK","MEX","POL","ROU","RUS","SWZ"},
		leaguesExtraStartW = {"BRA","CHN","FIN","IRL","JPN","NOR","SWE","USA"};
		//	leaguesExtraStartW = {"BRA","MEX","USA"};
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

	public static void printList(List<Comparison> list,String date){
		for(int i=0; i<list.size();i++){
			list.get(i).printWithDate(date);
		}
	}

	public static String checkString(String input) {
		String output;
		if(input.length()==0 || input.equalsIgnoreCase("-1")) {
		output ="-1";
		}else {
		output = input;
		}
		return output;
	}

	
	public static int checkInt(String input) {
		int output;
		if(input.length()==0 || input.equalsIgnoreCase("-1")) {
		output =-1;
		}else {
		output =Integer.valueOf(input);
		}
		return output;
	}


	public static double checkDouble(String input) {
		double output;
		if(input.length()==0 || input.equalsIgnoreCase("-1")) {
		output =-1.00;
		}else {
		output =Double.valueOf(input);
		}
		return output;
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
		else {name=""; System.out.println("Alert:Code error");}
		return name;
	}

	
	public static String fixCodeDiv(String oldCodeDiv) {
		String newCodeDiv="";
		oldCodeDiv=oldCodeDiv.replaceAll("\\s+","");
		for(int i=0;i<output.length;i++)
			if(oldCodeDiv.equalsIgnoreCase(input1[i]) || oldCodeDiv.equalsIgnoreCase(input2[i]))
				newCodeDiv=output[i];
		
		if(newCodeDiv.equals(""))System.out.println("Alert:Wrong CodeDiv >"+oldCodeDiv+"<");
		return newCodeDiv;
	}
	
	public static String balanceFixtureDate(String inputDate, String inputTime) {
		String input=inputDate+" "+inputTime+" +"+Common.df20.format(Analysis.balanceTime+2)+"00";
		String output="";
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm Z");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");
		Date date = null;
		try {
			date = inputFormat.parse(input);
			output = outputFormat.format(date);
			} catch (ParseException e) {
			output=inputDate;
			System.out.println("Alert:Error Date "+input);
			} 
		return output;
	}

	
	public static String fixTime(String inputTime) {
		String input="10/08/18"+" "+inputTime+" +0000";
		String output="";
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm Z");
		SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = inputFormat.parse(input);
			output = outputFormat.format(date);
			} catch (ParseException e) {
			output=inputTime;
			System.out.println("Alert:Error Date "+input);
			} 
		return output;
	}

	
	public static String fixDate(String inputDate, String inputTime) {
		String input=inputDate+" "+inputTime+" +0100";
		String output="";
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm Z");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");
		Date date = null;
		try {
			date = inputFormat.parse(input);
			output = outputFormat.format(date);
			} catch (ParseException e) {
			output=inputDate;
			System.out.println("Alert:Error Date "+input);
			} 
		return output;
	}

	public static String getDate() {
		return getDate(0);
	}
	
	public static String getDate(int dif) {
		Date output;
		if(dif>=0) {
		output = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(dif));
		} else {
			output = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(-dif));
		}
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");
		return outputFormat.format(output);
	}
	
	public static int getSeason() {
		int month,year;
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
		month = Integer.parseInt(monthFormat.format(date));
		year = Integer.parseInt(yearFormat.format(date));
		if(month>6)year++;
		return year;
	}
	
	public static int getYear() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
		return Integer.parseInt(yearFormat.format(date));
	}
}
