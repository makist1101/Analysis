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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Analysis {

/*
memory
team history
add alternatives
print team data for 2 fixture
automatic download
*/
	
	static boolean  downloadFiles=!true, 
					downloadOnlyNewFiles=true,
					outputToText=true,
					useAll=!true,
					useFirst=(true||useAll),
					useSecond=(true||useAll),
					useThird=(!true||useAll),
					useExtraStartS=(true||useAll),
					useExtraStartW=(true||useAll),
					useEmptyFixtures=!true,
					useFullFixtures=true;
	
	static int yearMin=0,yearMax=19;
	static int balanceTime=10;
	static int fixtureOffsetMin=5,fixtureOffsetMax=-5;
	
	//static int matchCounter=0;
	public int getNthDigit(int number, int base, int n) {    
		  return (int) ((number / Math.pow(base, n - 1)) % base);
		}

	void test() {
		if (!true) {
			// 1.00-1.39 1.40-1.99 2.00-2.69 2.70-3.49 3.5-4.99 5+

			String[] values = { "1.00", "1.40", "2.00", "2.70", "3.50", "5+++" };

			int[] count1 = new int[6];
			int[] count2 = new int[6];
			double[] count3 = new double[6];
			double[] sum = new double[6];
			int[] countTot = new int[6];
			int index = 0;
			for (int i = 0; i < competitions.size(); i++)
				for (int j = 0; j < competitions.get(i).results.size(); j++) {
					if (competitions.get(i).results.get(j).HODDS != -1.00) {

						double d = competitions.get(i).results.get(j).HODDS;
						if (Double.compare(1.00, d) <= 0 && Double.compare(d, 1.39) <= 0) {
							index = 0;
						}
						if (Double.compare(1.40, d) <= 0 && Double.compare(d, 1.99) <= 0) {
							index = 1;
						}
						if (Double.compare(2.00, d) <= 0 && Double.compare(d, 2.69) <= 0) {
							index = 2;
						}
						if (Double.compare(2.70, d) <= 0 && Double.compare(d, 3.49) <= 0) {
							index = 3;
						}
						if (Double.compare(3.50, d) <= 0 && Double.compare(d, 4.99) <= 0) {
							index = 4;
						}
						if (Double.compare(5, d) <= 0) {
							index = 5;
						}
						if ((competitions.get(i).results.get(j).HTHG+competitions.get(i).results.get(j).HTAG==1)) {
							sum[index] += d;
							
							countTot[index]++;	
							if (competitions.get(i).results.get(j).FTHG + competitions.get(i).results.get(j).FTAG >=2)
								count1[index]++;
							
							if (competitions.get(i).results.get(j).FTHG + competitions.get(i).results.get(j).FTAG == 2)
								count2[index]++;
							
							if (competitions.get(i).results.get(j).FTHG>0  && competitions.get(i).results.get(j).FTAG>0)
								count3[index]++;;
						
						}
					}
				}

			for (int i = 0; i < 6; i++) {
				double temp1 = 0, temp2 = 0, temp3 = 0, tempT = 0;
				temp1 = ((100.0 * count1[i]) / countTot[i]);
				temp2 = ((100.0 * count2[i]) / countTot[i]);
				temp3 = ((100.0 * count3[i]) / countTot[i]);
				tempT = ((sum[i]) / countTot[i]);
				System.out.println(values[i] + " " + Common.df12.format(tempT) + ": "
						 + Common.df11.format(temp1)+" / " + Common.df11.format(temp2)+" / " + Common.df11.format(temp3)
						+ " - " + Common.df10.format(countTot[i] / 1000) + "K");
			}
		}
	}

	void test2() {
		if (true) {
			int[][] count1 = new int[100][10];
			int[][] count2 = new int[100][10];
			int[][] count3 = new int[100][10];
			int[][] countTot = new int[100][10];

			for (int i = 0; i < competitions.size(); i++)
				for (int j = 0; j < competitions.get(i).results.size(); j++) {
					if (competitions.get(i).results.get(j).HODDS != -1.00) {
						int temp = (int) (100 * competitions.get(i).results.get(j).HODDS);
						int dekadiko = getNthDigit(temp, 10, 2),

								low = getNthDigit(temp, 10, 3), big = 0;
						if (temp > 999)
							big = getNthDigit(temp, 10, 4);

						if (temp == 0) {
							low = 0;
							big = 0;
							dekadiko = 0;
						}
						countTot[big * 10 + low][dekadiko]++;
						
						if ((competitions.get(i).results.get(j).FTHG > competitions.get(i).results.get(j).FTAG))
							count1[big * 10 + low][dekadiko]++;
						
						if ((competitions.get(i).results.get(j).FTHG
										+ competitions.get(i).results.get(j).FTAG <4)&& competitions.get(i).results.get(j).FTHG>=competitions.get(i).results.get(j).FTAG)
							count2[big * 10 + low][dekadiko]++;
						if (competitions.get(i).results.get(j).FTHG<competitions.get(i).results.get(j).FTAG)
							count3[big * 10 + low][dekadiko]++;
						

					}
				}
			int tot = 0;
			for (int i = 0; i < 50; i++) {
				int c = 0;
				for (int j = 0; j < 10; j++) {
					double temp3 = 0, temp4 = 0, temp5 = 0;
					temp3 = ((100.0 * count1[i][j]) / countTot[i][j]);
					temp4 = ((100.0 * count2[i][j]) / countTot[i][j]);
					temp5 = ((100.0 * count3[i][j]) / countTot[i][j]);

					tot += countTot[i][j];
					if (temp3 == 0) {
						c++;
						System.out.print(i + "," + j + ": 0  \t");
					} else if (countTot[i][j] != 0) {
						c++;
						System.out.print(i + "," + j + ": " + Common.df10.format(temp3) + "/"
								+ Common.df10.format(temp4) + "/" + Common.df10.format(temp5) + "\t");
					}
				}
				if (c > 0)
					System.out.println();
			}
			System.out.println(tot);

			System.out.println();
			// printCompetitionStats(true);
			// printTeamStats(!true);
		}
	}

	void printTeamStats(boolean combine) {
		List<Comparison> testL = new ArrayList<Comparison>();
		for (int i = 0; i < competitions.size(); i++) {
			for (int h = 0; h < competitions.get(i).teams.size(); h++) {
			String tempName;
			if (combine) tempName = competitions.get(i).teams.get(h).name + "-" + competitions.get(i).div;
			else tempName = competitions.get(i).teams.get(h).name + "-" + competitions.get(i).div+ " " +competitions.get(i).year;
			double[] tempRatingParts = {0.0,0.0};
			tempRatingParts[0] = competitions.get(i).teams.get(h).stats.shotsOnTargetWon*100;
//+competitions.get(i).teams.get(h).stats.yellowsCon;
			tempRatingParts[1] = competitions.get(i).teams.get(h).stats.shotsWon;	
			createCompareCompetitionsList(testL,tempName,tempRatingParts);
		}}
		Common.sortD(testL);
		Common.printList(testL);
	}

	
	void printCompetitionStats(boolean combine) {
		List<Comparison> testL = new ArrayList<Comparison>();
		for (int i = 0; i < competitions.size(); i++) {
			String tempName;
			if (combine) tempName = competitions.get(i).name + "-" + competitions.get(i).div;
			else tempName = competitions.get(i).nameComplete;
			double[] tempRatingParts = {0.0,0.0};
			tempRatingParts[0] = competitions.get(i).yellows*1;
			tempRatingParts[1] = competitions.get(i).matchesYellowsInfo;	
			createCompareCompetitionsList(testL,tempName,tempRatingParts);
		}
		Common.sortD(testL);
		Common.printList(testL);
	}

	public void createCompareCompetitionsList(List<Comparison> testL, String tempName, double[] tempRatingParts) {
		if (tempRatingParts[1] != 0) {
			for (int h = 0; h <= testL.size(); h++) {
				if ((h < testL.size())) {
					if (testL.get(h).name.equalsIgnoreCase(tempName)) {
						testL.get(h).ratingParts[0] += tempRatingParts[0];
						testL.get(h).ratingParts[1] += tempRatingParts[1];
						break;
					}
				} else if (h == testL.size()) {
					testL.add(new Comparison(tempName, tempRatingParts));
					break;
				}
			}
			for (int h = 0; h < testL.size(); h++) {
				testL.get(h).ratingD = (1.0 * testL.get(h).ratingParts[0]) / testL.get(h).ratingParts[1];
			}
		}
	}

	List<Competition> competitions;
	List<Comparison> fixtureWinRatings,
					fixtureOverRatings, 
					fixtureBttsRatings, 
					fixtureCornerRatings;
	
	List<codeDivYear> cdyList = new ArrayList<codeDivYear>();
	
	List<List<codeDivYear>> cdyListAllData= new ArrayList<List<codeDivYear>>(Common.abrOpt.length);
	List<List<codeDivYear>> cdyListSomeData= new ArrayList<List<codeDivYear>>(Common.abrOpt.length);
	List<List<codeDivYear>> cdyListNoData= new ArrayList<List<codeDivYear>>(Common.abrOpt.length);
	
	List<String> otherFixtures = new ArrayList<String>();

	public Analysis(){
		Files files = new Files();
		long startTimeStamp = System.currentTimeMillis();
		competitions = new ArrayList<Competition>();
		List<File> listOfFiles = files.getData();
		for (int i = 0; i < listOfFiles.size(); i++) {
			CSVReader reader = new CSVReader(competitions, listOfFiles.get(i));
		}
		createFixtures();		
		createCompetitionsInfo();
		//createNocompFixtures();
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Total matches: "+Competition.matchesCounter);
		System.out.println("Total fixtures: "+fixtureWinRatings.size()+" / "+otherFixtures.size());
		if(fixtureOffsetMax>-10)
			System.out.println("Fixtures Until: " + Common.getDate(Analysis.fixtureOffsetMax));
		else
			System.out.println("Fixtures Until: -");
		System.out.println("RunTime:" + Common.df11.format(((System.currentTimeMillis() - startTimeStamp) / 1000.0)) + " s");
		System.out.println("---------------------------------------------------------");
		test();
		System.out.println("---------------------------------------------------------");
//printRatingsReport();
printFixtures(1,Common.getDate()); printFixtures(2,Common.getDate());
//try {userInterface();} catch (IOException e) {e.printStackTrace();}
	}

	public void createFixtures() {
		ArrayList<Comparison> fixtureWinRatingsTemp = new ArrayList<Comparison>(),
				fixtureOverRatingsTemp = new ArrayList<Comparison>(),
				fixtureBttsRatingsTemp = new ArrayList<Comparison>(),
				fixtureCornerRatingsTemp = new ArrayList<Comparison>();

		for (int i = 0; i < competitions.size(); i++) {
			if (competitions.get(i).fixtures != null && (competitions.get(i).year == Common.getSeason()-1 || competitions.get(i).year == Common.getSeason()))
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
			System.out.println("Alert:Ratings have different size");
		Common.sort(fixtureWinRatings);
		Common.sort(fixtureOverRatings);
		Common.sort(fixtureBttsRatings);
		Common.sort(fixtureCornerRatings);
		String dateTemp;
		for(int i=0;i<fixtureWinRatings.size();i++) {
			dateTemp=fixtureWinRatings.get(i).date;
			for(int j=-100;j<101;j++) {
				if(dateTemp.equalsIgnoreCase(Common.getDate(j))){
					if(j<fixtureOffsetMin)fixtureOffsetMin=j;
					if(j>fixtureOffsetMax)fixtureOffsetMax=j;
				}
			}
		}
	}


	public void createCompetitionsInfo() {
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
		for (int j = 0; j < competitions.size(); j++) {
			for (int h = 0; h < cdyList.size(); h++) {
				for (int i = 0; i < Common.abrOpt.length; i++) {

					if ((competitions.get(j).code + competitions.get(j).div).equalsIgnoreCase(cdyList.get(h).codeDiv)) {
						if (!competitions.get(j).abr[i].equalsIgnoreCase("X"))
							cdyList.get(h).counterAbr[i]++;
					}
				}
			}
		}

		
		for(int i=0;i<Common.abrOpt.length;i++) {
			cdyListAllData.add(new ArrayList<codeDivYear>());
		cdyListSomeData.add(new ArrayList<codeDivYear>());
		cdyListNoData.add(new ArrayList<codeDivYear>());}		
		for(int i=0;i<Common.abrOpt.length;i++)
			for(int j=0;j<cdyList.size();j++) {
				if(cdyList.get(j).counterAbr[i] == cdyList.get(j).yearDif) {
					cdyListAllData.get(i).add(cdyList.get(j));
				}
				if(cdyList.get(j).counterAbr[i]>0 && cdyList.get(j).counterAbr[i]<(cdyList.get(j).yearDif)) {
					cdyListSomeData.get(i).add(cdyList.get(j));
				}
				if(cdyList.get(j).counterAbr[i]==0) {
					cdyListNoData.get(i).add(cdyList.get(j));
				}
			}

	
	}


	public void printCompetitionsInfo() {
		
		System.out.println("Competitions:" + cdyList.size() + "(" + competitions.size() + ")");
		for (int i = 0; i < cdyList.size(); i++) {
			cdyList.get(i).checkYears();
			System.out.println(cdyList.get(i).codeDiv + "->(" + (cdyList.get(i).yearDif) + ") "
					+ cdyList.get(i).yearMin + " - " + cdyList.get(i).yearMax);
		}
		System.out.println("\n___________________________________________________________________________________");
		System.out.println("By Competition");

		for (int i = 0; i < cdyList.size(); i++) {
			System.out.print(cdyList.get(i).codeDiv + "->(" + (cdyList.get(i).yearDif)
					+ ") " + cdyList.get(i).yearMin + "-" + cdyList.get(i).yearMax + "\nAll:");
			for (int h = 7; h < Common.abrOpt.length; h++) {
				if (cdyList.get(i).counterAbr[h] == (cdyList.get(i).yearDif))
					System.out.print(Common.abrOpt[h]+" ");
			}
			System.out.println();
			System.out.print("Some:");
			for (int h = 7; h < Common.abrOpt.length; h++) {
				if (cdyList.get(i).counterAbr[h] < (cdyList.get(i).yearDif) && cdyList.get(i).counterAbr[h]>0) {
					System.out.print(Common.abrOpt[h] + ":" + cdyList.get(i).counterAbr[h] + " ");
				}
			}
			System.out.println();
			System.out.print("None:");
			for (int h = 7; h < Common.abrOpt.length; h++) {
				if (cdyList.get(i).counterAbr[h]==0) {
					System.out.print(Common.abrOpt[h]+ " ");
				}
			}
			System.out.println("\n");
		}
		System.out.println("___________________________________________________________________________________");
		System.out.println("By Abr");
		for (int i = 6; i < Common.abrOpt.length; i++) {
			System.out.print(Common.abrOpt[i] + "\tAll(" + cdyListAllData.get(i).size() + "):");
			for (int j = 0; j < cdyListAllData.get(i).size(); j++) {
				System.out.print(cdyListAllData.get(i).get(j).codeDiv + " ");
			}
			System.out.print("\n\tSome(" + cdyListSomeData.get(i).size() + "):");

			for (int j = 0; j < cdyListSomeData.get(i).size(); j++) {
				System.out.print(cdyListSomeData.get(i).get(j).codeDiv + "(" + cdyListSomeData.get(i).get(j).counterAbr[i]
						+ ")" + " ");
			}
			System.out.print("\n\tNone(" + cdyListNoData.get(i).size() + "):");
			for (int j = 0; j < cdyListNoData.get(i).size(); j++) {
				System.out.print(cdyListNoData.get(i).get(j).codeDiv + " ");
			}
			System.out.println();
			System.out.println();
		}

		
	}


	public void printFixtures(int option) {
		printFixtures(option,null);
	}

	public void printFixtures(int option, String targetDate) {
		switch (option) {
		case 0:
		case 1:
			System.out.println("Fixtures Win Rating ("+ fixtureOverRatings.size()+"):");
			Common.printList(fixtureWinRatings, targetDate);
			System.out.println();
			if (option != 0)
				break;
		case 2:
			System.out.println("Fixtures Over Rating ("+ fixtureOverRatings.size()+"):");
			Common.printList(fixtureOverRatings, targetDate);
			System.out.println();
			if (option != 0)
				break;
		case 3:
			System.out.println("Fixtures Btts Rating ("+ fixtureOverRatings.size()+"):");
			Common.printList(fixtureBttsRatings, targetDate);
			System.out.println();
			if (option != 0)
				break;
		case 4:
			System.out.println("Fixtures Corner Rating ("+ fixtureOverRatings.size()+"):");
			Common.printList(fixtureCornerRatings, targetDate);
			System.out.println();
			if (option != 0)
				break;
		default:
			break;
		};
	}
	
	public void createNocompFixtures() {
		String line = "";
		String cvsSplitBy = ",";
		String[] data = { "" };
	
		try (BufferedReader br = new BufferedReader(new FileReader(Common.pathToExtraFixtures))) {
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				data = line.split(cvsSplitBy);
				if (data.length > 5) {
					if (data[0].length() != 0 && data[1].length() != 0 && data[2].length() != 0 && data[3].length() != 0
							&& data[4].length() != 0 && data[5].length() != 0 && data[6].length() != 0) {

						for (int i = 0; i < cdyList.size(); i++) {
							if ((cdyList.get(i).yearMax == Common.getSeason()
									|| cdyList.get(i).yearMax == Common.getSeason() - 1)
									&& Common.fixCodeDiv(data[0]).equalsIgnoreCase(cdyList.get(i).codeDiv)) {
								break;
							}
							if (cdyList.size() - 1 == i)
								otherFixtures.add(Common.fixCodeDiv(data[0]) + " "
										+ Common.balanceFixtureDate(Common.fixDate(data[2], data[3]), data[3]) + " "
										+ data[4] + "-" + data[5]);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(Common.pathToBasicFixtures))) {
			line = br.readLine();
			while ((line = br.readLine()) != null) {

				data = line.split(cvsSplitBy);
				for (int i = 0; i < cdyList.size(); i++) {
					if (cdyList.get(i).yearMax == Common.getSeason()
							&& Common.fixCodeDiv(data[0]).equalsIgnoreCase(cdyList.get(i).codeDiv)) {
						break;
					}
					if (cdyList.size() - 1 == i)
						otherFixtures.add(Common.fixCodeDiv(data[0]) + " " + data[1] + " " + data[2] + "-" + data[3]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printNoCompFixtures() {
		for (int i = 0; i < otherFixtures.size(); i++) {
			System.out.println(otherFixtures.get(i));
		}
	}

	public int findCompetition(String codeDiv,int year){
		for(int i=0;i<competitions.size();i++){
			if(codeDiv.equalsIgnoreCase(competitions.get(i).code+competitions.get(i).div) && competitions.get(i).year==year)return i;
		}
		return -1;
	}

	public void userInterface() throws IOException {
		int choice = -1, competitionId = -1, teamId = -1, year = -1, offset=0, option=-1;
		String codeDiv, teamName,date=null;
		while (choice != 0) {
			System.out.println("Options:");
			System.out.println("1 ->Competition All Data ");
			System.out.println("2 ->Competition Bet Data");
			System.out.println("3 ->Competition Stats");
			System.out.println("4 ->Competition Scores");
			System.out.println("5 ->Competition All Ratings Lists");
			System.out.println("6 ->Competition All Fixtures Stats");
			System.out.println("7 ->Competition All Fixtures Ratings List");
			System.out.println("8 ->Competition Team Names");
			System.out.println("9 ->Competition All Team Stats");
			System.out.println("10->Competition All Team Scores");
			System.out.println("11->Competition Team All");
			System.out.println("12->Competitions Info");
			System.out.println("13->All Fixtures");
			System.out.println("14->Selected Day's Fixtures");
			System.out.println("15->Other Fixtures");
			System.out.println("0->Exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Choose:");
				try {
					choice = Integer.parseInt(br.readLine());
					if (choice < -1 && choice > 15)
						System.out.println("Invalid Number!");
					else
						break;
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid Format!");
				}
			}
			
			if (choice > 0 && choice < 12) {
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
						competitionId = findCompetition(codeDiv, year);
						if (competitionId != -1)
							break;
						else {
							System.out.println("No info for this year!");
							printCompetitionsInfo();
						}
						} catch (NumberFormatException nfe) {
						System.out.println("Invalid Format!");
					}
				}

				if (choice == 11) {
					while (true) {
						System.out.println("Give Team Name or ID:");
						teamName = br.readLine();
						try {
							teamId = Integer.parseInt(teamName);
						} catch (NumberFormatException nfe) {
							if (teamId != -1)
								teamId = competitions.get(competitionId).findTeam(teamName);
						}
						if (teamId != -1 && teamId<competitions.get(competitionId).teams.size())
							break;
						else {
							System.out.println("Invalid Name!");
							competitions.get(competitionId).printTeamNames();
						}
					}
				}
			}

			if (choice == 14) {
				while (true) {
					System.out.println("Give day offset (" + fixtureOffsetMin + ") - (" + fixtureOffsetMax + "):");
					try {
						offset = Integer.parseInt(br.readLine());
					} catch (NumberFormatException nfe) {
						System.out.println("Invalid Format!");
					}
					if (offset >= fixtureOffsetMin && offset <= fixtureOffsetMax) {
						date = Common.getDate(offset);
						break;
					}
				}
			}
			if (choice == 14 || choice==13) {
				
				while (true) {
					System.out.println("Use Fixtures only with or without data:");
					System.out.println("0:Both 1:With 2:Without");
					try {
						option = Integer.parseInt(br.readLine());
						if (option>-1 && option<3)
							break;
						else {
							System.out.println("Invalid Number");
						}
						} catch (NumberFormatException nfe) {
						System.out.println("Invalid Format!");
					}
				}
				if(option==0) {
					Analysis.useFullFixtures=true;
					Analysis.useEmptyFixtures=true;
				}
				if(option==1) {
					Analysis.useFullFixtures=true;
					Analysis.useEmptyFixtures=false;
				}
				if(option==2) {
					Analysis.useFullFixtures=false;
					Analysis.useEmptyFixtures=true;
				}
				while (true) {
					System.out.println("Choose Ratings List:");
					System.out.println("0:W+O 1:Win 2:Over 3:Btts 4:Corners");
					try {
						option = Integer.parseInt(br.readLine());
						if (option>-1 && option<5)
							break;
						else {
							System.out.println("Invalid Number");
						}
						} catch (NumberFormatException nfe) {
						System.out.println("Invalid Format!");
					}
				}
				}
			switch (choice) {
			case 1:
				competitions.get(competitionId).printCompetitionAll();
				break;
			case 2:
				competitions.get(competitionId).printCompetitionBet();
				break;
			case 3:
				competitions.get(competitionId).printCompetitionStats();
				break;
			case 4:
				competitions.get(competitionId).printCompetitionScores();
				break;
			case 5:
				competitions.get(competitionId).printAllRatingsLists();
				break;
			case 6:
				competitions.get(competitionId).printAllFixturesStats();
				break;
			case 7:
				competitions.get(competitionId).printAllFixturesRatingsList();
				break;
			case 8:
				competitions.get(competitionId).printTeamNames();
				break;
			case 9:
				competitions.get(competitionId).printAllTeamStats();
				break;
			case 10:
				competitions.get(competitionId).printAllTeamScores();
				break;
			case 11:
				competitions.get(competitionId).printTeamAll(teamId);
				break;
			case 12:
				printCompetitionsInfo();
				break;
			case 13:
				if(option==0) {printFixtures(1);
				printFixtures(2);
				}else printFixtures(option);
				break;
			case 14:
				if(option==0) {printFixtures(1, date);
				printFixtures(2, date);
				}else printFixtures(option, date);
				break;
			case 15:
				printNoCompFixtures();
				break;
			default:
				break;
			}
			;
		}
	}

	public static void main(String[] args) {
		if(outputToText){
			try {
				PrintStream out = out = new PrintStream(new FileOutputStream(Common.pathToOutput));
				System.setOut(out);
			} catch (FileNotFoundException e1) {e1.printStackTrace();}
		}
		
/*
		File folderNewData = new File("C:/Users/makis/Desktop/Main/");
		String fileName;
		System.out.println("<!DOCTYPE html>");
		System.out.println("<html>");
		System.out.println("<head>");
		System.out.println("<title>Page Title</title>");
		System.out.println("</head>");
		System.out.println("<body>");
		for (int i = 0; i < folderNewData.listFiles().length; i++) {
			fileName = folderNewData.listFiles()[i].getName();
			String substring = fileName.substring(0,fileName.length() - 4);
				System.out.println("<a href=\"https://www.youtube.com/results?search_query="
		+substring.replace("&","+").replace(" ","+").replace("(","+").replace(")","+")+ "\">"+fileName+"</a><br />");
		}
		System.out.println("</body>");
		System.out.println("</html>");
*/
		Analysis analysis =new Analysis();
	}


	public void printRatingsReport(){
		System.out.println("Total Teams: "+Stats.teamsCounter);
		
		System.out.println(
				"win: \t"+
				Stats.winHomeRatingMin+":"+Stats.winHomeRatingMax+" ("+Common.df12.format(Stats.winHomeRatingSum/((double)Stats.teamsCounter))+") / "+
				Stats.winAwayRatingMin+" : "+Stats.winAwayRatingMax+" ("+Common.df12.format(Stats.winAwayRatingSum/((double)Stats.teamsCounter))+")");
	
		System.out.println(
				"over: \t"+
				Stats.overHomeRatingMin+":"+Stats.overHomeRatingMax+" ("+Common.df12.format(Stats.overHomeRatingSum/((double)Stats.teamsCounter))+") / "+
				Stats.overAwayRatingMin+" : "+Stats.overAwayRatingMax+" ("+Common.df12.format(Stats.overAwayRatingSum/((double)Stats.teamsCounter))+")");
	
		System.out.println(
				"btts: \t"+
				Stats.bttsHomeRatingMin+":"+Stats.bttsHomeRatingMax+" ("+Common.df12.format(Stats.bttsHomeRatingSum/((double)Stats.teamsCounter))+") / "+
				Stats.bttsAwayRatingMin+" : "+Stats.bttsAwayRatingMax+" ("+Common.df12.format(Stats.bttsAwayRatingSum/((double)Stats.teamsCounter))+")");
		System.out.println(
				"corn: \t"+
				Stats.cornersHomeRatingMin+":"+Stats.cornersHomeRatingMax+" ("+Common.df12.format(Stats.cornersHomeRatingSum/((double)Stats.teamsCounter))+") / "+
				Stats.cornersAwayRatingMin+" : "+Stats.cornersAwayRatingMax+" ("+Common.df12.format(Stats.cornersAwayRatingSum/((double)Stats.teamsCounter))+")");
		
		
		System.out.println();
		
		
		System.out.println("fp:\t" + Common.df12.format(Stats.fphMin) + " : " + Common.df12.format(Stats.fphMax) + " ("
				+ Common.df12.format(Stats.fphSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.fpaMin) + " : "
				+ Common.df12.format(Stats.fpaMax) + " (" + Common.df12.format(Stats.fpaSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.fpMin) + " : " + Common.df12.format(Stats.fpMax) + " ("
				+ Common.df12.format(Stats.fpSum/Stats.teamsCounter) + ") ");
	
		System.out.println("fg:\t" + Common.df12.format(Stats.fghMin) + " : " + Common.df12.format(Stats.fghMax) + " ("
				+ Common.df12.format(Stats.fghSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.fgaMin) + " : "
				+ Common.df12.format(Stats.fgaMax) + " (" + Common.df12.format(Stats.fgaSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.fgMin) + " : " + Common.df12.format(Stats.fgMax) + " ("
				+ Common.df12.format(Stats.fgSum/Stats.teamsCounter) + ") ");
	
		System.out.println("w:\t" + Common.df12.format(Stats.whMin) + " : " + Common.df12.format(Stats.whMax) + " ("
				+ Common.df12.format(Stats.whSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.waMin) + " : "
				+ Common.df12.format(Stats.waMax) + " (" + Common.df12.format(Stats.waSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.wMin) + " : " + Common.df12.format(Stats.wMax) + " ("
				+ Common.df12.format(Stats.wSum/Stats.teamsCounter) + ") ");
	
		System.out.println("g:\t" + Common.df12.format(Stats.ghMin) + " : " + Common.df12.format(Stats.ghMax) + " ("
				+ Common.df12.format(Stats.ghSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.gaMin) + " : "
				+ Common.df12.format(Stats.gaMax) + " (" + Common.df12.format(Stats.gaSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.gMin) + " : " + Common.df12.format(Stats.gMax) + " ("
				+ Common.df12.format(Stats.gSum/Stats.teamsCounter) + ") ");
	
		System.out.println("fo:\t" + Common.df12.format(Stats.fohMin) + " : " + Common.df12.format(Stats.fohMax) + " ("
				+ Common.df12.format(Stats.fohSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.foaMin) + " : "
				+ Common.df12.format(Stats.foaMax) + " (" + Common.df12.format(Stats.foaSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.foMin) + " : " + Common.df12.format(Stats.foMax) + " ("
				+ Common.df12.format(Stats.foSum/Stats.teamsCounter) + ") ");
	
		System.out.println("o:\t" + Common.df12.format(Stats.ohMin) + " : " + Common.df12.format(Stats.ohMax) + " ("
				+ Common.df12.format(Stats.ohSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.oaMin) + " : "
				+ Common.df12.format(Stats.oaMax) + " (" + Common.df12.format(Stats.oaSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.oMin) + " : " + Common.df12.format(Stats.oMax) + " ("
				+ Common.df12.format(Stats.oSum/Stats.teamsCounter) + ") ");
	
		System.out.println("fb:\t" + Common.df12.format(Stats.fbhMin) + " : " + Common.df12.format(Stats.fbhMax) + " ("
				+ Common.df12.format(Stats.fbhSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.fbaMin) + " : "
				+ Common.df12.format(Stats.fbaMax) + " (" + Common.df12.format(Stats.fbaSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.fbMin) + " : " + Common.df12.format(Stats.fbMax) + " ("
				+ Common.df12.format(Stats.fbSum/Stats.teamsCounter) + ") ");
		
		System.out.println("b:\t" + Common.df12.format(Stats.bhMin) + " : " + Common.df12.format(Stats.bhMax) + " ("
				+ Common.df12.format(Stats.bhSum/Stats.teamsCounter) + ")\t/" + Common.df12.format(Stats.baMin) + " : "
				+ Common.df12.format(Stats.baMax) + " (" + Common.df12.format(Stats.baSum/Stats.teamsCounter) + ") \t//"
				+ Common.df12.format(Stats.bMin) + " : " + Common.df12.format(Stats.bMax) + " ("
				+ Common.df12.format(Stats.bSum/Stats.teamsCounter) + ") ");
		System.out.println();
		
	}

	class codeDivYear{
		String codeDiv;
		int yearMax=-1, yearMin=-1,yearDif=0;
		int timesUpdated=0;
		int[] counterAbr = new int[Common.abrOpt.length];
		codeDivYear(String codeDiv, int year){
			this.codeDiv=codeDiv;
			this.yearMin=year;
			this.yearMax=year;		
		}
		public void checkYears() {
			if((yearMax-yearMin)!=timesUpdated) {
			 System.out.println("Alert:Year missing"+codeDiv);
			}
		}
		public void updateMinMax(int year){
			if(year>yearMax)yearMax=year;
			if(year<yearMin)yearMin=year;
			yearDif=yearMax+1-yearMin;
			timesUpdated++;
		}
	}
}