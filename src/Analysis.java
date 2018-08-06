import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

class codeDivYear{
	String codeDiv;
	int yearMax=-1, yearMin=-1;
	int timesUpdated=0;
	codeDivYear(String codeDiv, int year){
		this.codeDiv=codeDiv;
		this.yearMin=year;
		this.yearMax=year;		
	}
	public void checkYears() {
		if((yearMax-yearMin)!=timesUpdated) {
		 System.out.println(codeDiv+"->shit");
		}
	}
	public void updateMinMax(int year){
		if(year>yearMax)yearMax=year;
		if(year<yearMin)yearMin=year;
		timesUpdated++;
	}
}
public class Analysis {

	/*
	 * team history
	 * date 
	 * comp abr 
	 */
	static boolean  downloadStuff=!true, 
					outStuff=!true;
	static int yearMax=20,yearMin=0;
	List<Competition> competitions;
	List<Comparison> fixtureWinRatings,
					fixtureOverRatings, 
					fixtureBttsRatings, 
					fixtureCornerRatings;

	public static void main(String[] args) {
		if(outStuff){
			try {
				PrintStream out = out = new PrintStream(new FileOutputStream(Common.pathToOutput));
				System.setOut(out);
			} catch (FileNotFoundException e1) {e1.printStackTrace();}
		}
		Analysis analysis =new Analysis();
	
	
	
	}
	
	public Analysis(){
		Files files = new Files();
		long startTimeStamp = System.currentTimeMillis();
		competitions = new ArrayList<Competition>();
		List<File> listOfFiles = files.getData();
		for (int i = 0; i < listOfFiles.size(); i++) {
			CSVReader reader = new CSVReader(competitions, listOfFiles.get(i));
		}
		
		int matchCounter=0;
		for(int i=0;i<competitions.size();i++)
			matchCounter+=competitions.get(i).results.size();
		System.out.println("Total matches:"+matchCounter);
		
		createFixtures();		
		System.out.println("RunTime:" + (System.currentTimeMillis() - startTimeStamp) + "ms");
		try {
			userInterface();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createFixtures() {
		ArrayList<Comparison> fixtureWinRatingsTemp = new ArrayList<Comparison>(),
				fixtureOverRatingsTemp = new ArrayList<Comparison>(),
				fixtureBttsRatingsTemp = new ArrayList<Comparison>(),
				fixtureCornerRatingsTemp = new ArrayList<Comparison>();

		for (int i = 0; i < competitions.size(); i++) {
			if (competitions.get(i).fixtures != null && (competitions.get(i).year == 18 || competitions.get(i).year == 19))
				if (competitions.get(i).fixtures.size() > 0) {
					fixtureWinRatingsTemp.addAll(competitions.get(i).fixtureWinRatings);
					fixtureOverRatingsTemp.addAll(competitions.get(i).fixtureOverRatings);
					fixtureBttsRatingsTemp.addAll(competitions.get(i).fixtureBttsRatings);
					fixtureCornerRatingsTemp.addAll(competitions.get(i).fixtureCornerRatings);
				}
		}
		fixtureWinRatings = new ArrayList<Comparison>();
		fixtureOverRatings = new ArrayList<Comparison>();
		fixtureBttsRatings = new ArrayList<Comparison>();
		fixtureCornerRatings = new ArrayList<Comparison>();
		for (int i = 0; i < fixtureWinRatingsTemp.size(); i++) {
			fixtureWinRatings.add(new Comparison(fixtureWinRatingsTemp.get(i)));
			fixtureOverRatings.add(new Comparison(fixtureOverRatingsTemp.get(i)));
			fixtureBttsRatings.add(new Comparison(fixtureBttsRatingsTemp.get(i)));
			fixtureCornerRatings.add(new Comparison(fixtureCornerRatingsTemp.get(i)));
		}
		if (fixtureWinRatings.size() != fixtureOverRatings.size()
				|| fixtureOverRatings.size() != fixtureBttsRatings.size()
				|| fixtureBttsRatings.size() != fixtureCornerRatings.size())
			System.out.println("Fuck");
		Common.sort(fixtureWinRatings);
		Common.sort(fixtureOverRatings);
		Common.sort(fixtureBttsRatings);
		Common.sort(fixtureCornerRatings);
	}

	public void printFixtures(){
			System.out.println("Fixtures Win Rating:");
			Common.printList(fixtureWinRatings);
			System.out.println();
			System.out.println("Fixtures Over Rating:"+fixtureOverRatings.size());
			Common.printList(fixtureOverRatings);
			System.out.println();
			System.out.println("Fixtures Btts Rating:");
			Common.printList(fixtureBttsRatings);
			System.out.println();
			System.out.println("Fixtures Corner Rating:");
			Common.printList(fixtureCornerRatings);
			System.out.println();
	}			
	
	
	public int findCompetition(String codeDiv,int year){
		for(int i=0;i<competitions.size();i++){
			if(codeDiv.equalsIgnoreCase(competitions.get(i).code+competitions.get(i).div) && competitions.get(i).year==year)return i;
		}
		return -1;
	}

	public void printCompetitionsInfo() {
		List<codeDivYear> cdyList = new ArrayList<codeDivYear>();
		for (int i = 0; i < competitions.size(); i++) {
			String tempCodeDiv = competitions.get(i).code + competitions.get(i).div;
			int year = competitions.get(i).year;
			for (int j = 0; j <= cdyList.size(); j++) {
				if (j < cdyList.size()) {
					if (tempCodeDiv.equals(cdyList.get(j).codeDiv)) {
						cdyList.get(j).updateMinMax(year);
						break;
					}
				} else if (cdyList.size() == j) {
					cdyList.add(new codeDivYear(tempCodeDiv, year));
					break;
				}
			}
		}
		for (int i = 0; i < cdyList.size(); i++) {
			cdyList.get(i).checkYears();
			System.out.println(cdyList.get(i).codeDiv + "->("+(cdyList.get(i).yearMax-cdyList.get(i).yearMin) +") "+cdyList.get(i).yearMin + " - " + cdyList.get(i).yearMax);
		}
		System.out.println();
	}

	public void userInterface() throws IOException {
		int choice = -1, i = -1, j = -1, year = -1;
		String codeDiv, teamName;
		while (choice != 0) {
			System.out.println("Options:");
			System.out.println("1 ->Competitions Info");
			System.out.println("2 ->Competition All Data ");
			System.out.println("3 ->Competition Bet");
			System.out.println("4 ->Competition Stats");
			System.out.println("5 ->Competition Scores");
			System.out.println("6 ->Competition All Ratings Lists");
			System.out.println("7 ->Competition All Fixtures Stats");
			System.out.println("8 ->Competition All Fixtures Ratings List");
			System.out.println("9 ->Competition Team Names");
			System.out.println("10->Competition All Team Stats");
			System.out.println("11->Competition All Team Scores");
			System.out.println("12->Competition Team All");
			System.out.println("13->Today Fixtures");
			System.out.println("0->Exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Choose:");
				try {
					choice = Integer.parseInt(br.readLine());
					if (choice < -1 && choice > 13)
						System.out.println("Invalid Number!");
					else
						break;
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid Format!");
				}
			}
			
			if (choice > 1 && choice < 13) {
					while (true) {
					System.out.println("Give Competition CodeDiv:");
					codeDiv = br.readLine();
					if (Common.checkCodeDiv(codeDiv)) {
						break;
					} else {
						System.out.println("Invalid CodeDiv!");
						printCompetitionsInfo();
					}
				}
				while (true) {
					System.out.println("Give Year:");
					try {
						year = Integer.parseInt(br.readLine());
						i = findCompetition(codeDiv, year);
						if (i != -1)
							break;
						else {
							System.out.println("No info for this year!");
							printCompetitionsInfo();
						}
						} catch (NumberFormatException nfe) {
						System.out.println("Invalid Format!");
					}
				}

				if (choice == 12) {
					while (true) {
						System.out.println("Give Team Name or ID:");
						teamName = br.readLine();
						try {
							j = Integer.parseInt(teamName);
						} catch (NumberFormatException nfe) {
							if (j != -1)
								j = competitions.get(i).findTeam(teamName);
						}
						if (j != -1 && j<competitions.get(i).teams.size())
							break;
						else {
							System.out.println("Invalid Name!");
							competitions.get(i).printTeamNames();
						}
					}
				}
			}

			switch (choice) {
			case 1:
				printCompetitionsInfo();
				break;
			case 2:
				competitions.get(i).printCompetitionAll();
				break;
			case 3:
				competitions.get(i).printCompetitionBet();
				break;
			case 4:
				competitions.get(i).printCompetitionStats();
				break;
			case 5:
				competitions.get(i).printCompetitionScores();
				break;
			case 6:
				competitions.get(i).printAllRatingsLists();
				break;
			case 7:
				competitions.get(i).printAllFixturesStats();
				break;
			case 8:
				competitions.get(i).printAllFixturesRatingsList();
				break;
			case 9:
				competitions.get(i).printTeamNames();
				break;
			case 10:
				competitions.get(i).printAllTeamStats();
				break;
			case 11:
				competitions.get(i).printAllTeamScores();
				break;
			case 12:
				competitions.get(i).printTeamAll(j);
				break;
			case 13:
				printFixtures();
			default:
				break;
			};
		}
	}
}