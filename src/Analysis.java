import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
	static boolean  downloadStuff=!true, //Download results, fixtures
					outStuff=!true,//Create output file
					test=!true;
	
	public static String pathToSrc = "/Users/makis/git/Analysis/src/",
						pathToSrcFixtures = pathToSrc+"fixtures.today.csv",
						pathToData = "http://www.football-data.co.uk/mmz4281/",
						pathToFixtures = "http://www.football-data.co.uk/fixtures.csv",
						pathToOutput ="C:/Users/makis/Desktop/output.txt";
	
	List<Competition> competitions;
	List<Comparison> fixtureWinRatings, fixtureOverRatings, fixtureBttsRatings;
	
	public Analysis(){
		long startTimeStamp = System.currentTimeMillis();
		String[] seasonsInput  = {"1617/","1718/"},
				seasonsOutput = {".16",".17"},
				seasons = {"16/17","17/18"},
				/*
				leaguesInput = {"E0","SC0","SP1","D1","I1", "F1","N1","B1","B1","P1","T1","G1",
						"E1","SC1","SP2","D2","I2", "F2","E2","SC2","E3","SC3","EC"},
				leaguesOutput = {"E1","SC1","SP1","D1","I1", "F1","N1","B1","B1","P1","T1","G1", 
						"E2","SC2","SP2","D2","I2","F2","E3","SC3","E4","SC4","E5"};
				 */
		
				leaguesInput = {"E0","SC0","SP1","D1","I1", "F1","N1","B1","B1","P1","T1","G1",
						"E1","SP2","D2","I2", "F2"},
				leaguesOutput = {"E1","SC1","SP1","D1","I1", "F1","N1","B1","B1","P1","T1","G1", 
						"E2","SP2","D2","I2","F2"};
		File folder = new File(pathToSrc);
		File[] listOfFiles = folder.listFiles();
		competitions = new ArrayList<Competition>();
		fixtureWinRatings = new ArrayList<Comparison>();
		fixtureOverRatings= new ArrayList<Comparison>();
		fixtureBttsRatings = new ArrayList<Comparison>();
		if(downloadStuff){
			downloadFiles(pathToFixtures,pathToSrcFixtures);
			for(int i=0;i<seasonsInput.length;i++){
				for(int j=0;j<leaguesInput.length;j++){
					downloadFiles(pathToData+seasonsInput[i]+leaguesInput[j]+".csv",
							pathToSrc+leaguesOutput[j]+seasonsOutput[i]+".csv");
				}
			}
		}
		if(outStuff){
			try {
				PrintStream out = null;
				out = new PrintStream(new FileOutputStream(pathToOutput));
				System.setOut(out);
			} catch (FileNotFoundException e1) {e1.printStackTrace();}
		}
		for(int i=0; i<listOfFiles.length; i++){
			String fileName=listOfFiles[i].getName();
			if (listOfFiles[i].isFile() 
					&& fileName.substring(fileName.lastIndexOf('.') + 1).equals("csv") 
					&& !fileName.equalsIgnoreCase("fixtures.today.csv")){
				String code=fileName.substring(0,fileName.indexOf('.')-1);
				int div = Integer.valueOf(fileName.substring(fileName.indexOf('.')-1,fileName.indexOf('.')));
				int year= Integer.valueOf(fileName.substring(fileName.indexOf('.')+1,fileName.lastIndexOf('.')));
				//System.out.println(fileName+":"+ seasons[year-16]+":"+ code+":"+ div+":"+ year);
				competitions.add(new Competition(pathToSrc+fileName, createName(fileName, seasons[year-16]), code, div, year));
				
			}	
		}
		
		createFixtures();
		System.out.println("RunTime:"+(System.currentTimeMillis()-startTimeStamp)+"ms");
		
		try {
			userInterface();
		} catch (IOException e) {e.printStackTrace();}
	
		for(int i=0;i< competitions.size();i++) {
		//	if(competitions.get(i).year == 17)competitions.get(i).printManager(3);
		}
	}
		

	private void createFixtures(){
		for(int i=0;i<competitions.size();i++){
			if(competitions.get(i).fixturesOutput.size()>0){
				for(int j=0; j<competitions.get(i).fixturesOutput.size();j++){
					String tempCodeDiv=null;
					if(competitions.get(i).code.length()==2){
						tempCodeDiv=competitions.get(i).code+competitions.get(i).div;
					}
					else{
						tempCodeDiv=competitions.get(i).code+competitions.get(i).div+" ";
					}
					fixtureWinRatings.add(new Comparison(
							tempCodeDiv+" "+
							competitions.get(i).fixturesOutput.get(j).nameHome+"-"+
							competitions.get(i).fixturesOutput.get(j).nameAway,
							competitions.get(i).fixturesOutput.get(j).ratingWin));
					fixtureOverRatings.add(new Comparison(
							tempCodeDiv+" "+
							competitions.get(i).fixturesOutput.get(j).nameHome+"-"+
							competitions.get(i).fixturesOutput.get(j).nameAway,
							competitions.get(i).fixturesOutput.get(j).ratingOver));
					fixtureBttsRatings.add(new Comparison(
							tempCodeDiv+" "+
							competitions.get(i).fixturesOutput.get(j).nameHome+"-"+
							competitions.get(i).fixturesOutput.get(j).nameAway,
							competitions.get(i).fixturesOutput.get(j).ratingBtts));
				}
			}		
		}
		sort(fixtureWinRatings);
		sort(fixtureOverRatings);
		sort(fixtureBttsRatings);
	}
	
	private void printFixtures(){
			System.out.println("Fixtures Win Rating:");
			printList(fixtureWinRatings);
			System.out.println();
			System.out.println("Fixtures Over Rating:"+fixtureOverRatings.size());
			printList(fixtureOverRatings);
			System.out.println();
			//System.out.println("Fixtures Btts Rating:");
			//printList(fixtureBttsRatings);
			System.out.println();
	}
	
	private void userInterface() throws IOException {
		int loop =0 ;
		while(loop!=100){
		System.out.println(">>>>Options:");
		System.out.println("1: CompetitionNamesCodeDiv");
		System.out.println("2: Competition All Data ");
		System.out.println("3: Competition Stats");
		System.out.println("4: Competition Scores");
		System.out.println("5: Competition All Team Stats");
		System.out.println("6: Competition All Team Scores");
		System.out.println("7: Competition All Form RatingsList");
		System.out.println("8: Competition All Fixtures Stats");
		System.out.println("9: Competition All Fixtures RatingsList");
		System.out.println("10: Team All Data");
		System.out.println("11: Today Fixtures");
		System.out.println("12: AllCompetitionStats");
		System.out.println("100: Exit");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i=99;
        System.out.println(">>>>>Choose:");
        try{
            i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){System.err.println("Invalid Format!");}
        
       
	    if(i==100){
	    	loop=i;
	    }
	    
	    else if(i==11){
        	printFixtures();
        }
	    else if(i==12){
	    	for(int h=0;h<competitions.size();h++){
	    		competitions.get(h).printManager(3);
	    	}
	    }
        else if(i==1){
        	printCompetitionNames();
        }
        else if(i!=10){
        	 System.out.println("Give Competition CodeDiv:");
             String codeDiv = br.readLine();
        	competitions.get(findCompetition(codeDiv)).printManager(i);
        }
        else{
        	 System.out.println("Give Competition CodeDiv:");
             String codeDiv = br.readLine();
        	competitions.get(findCompetition(codeDiv)).printManager(0);
        	System.out.println("Give Team Name:");
            String teamName = br.readLine();
        	competitions.get(findCompetition(codeDiv)).printManager(teamName);
        }
        
		}
		
	}
	
	private void printCompetitionNames(){
		for(int i=0;i<competitions.size();i++){
			String tempCodeDiv=null;
			if(competitions.get(i).code.length()==2){
				tempCodeDiv=competitions.get(i).code+competitions.get(i).div;
			}
			else{
				tempCodeDiv=competitions.get(i).code+competitions.get(i).div+" ";
			}
			System.out.println(i+": "+tempCodeDiv+" - "+competitions.get(i).name);
		}
	}
	
	private int findCompetition(String name){
		for(int i=0;i<competitions.size();i++){
			if(name.equalsIgnoreCase(competitions.get(i).code+competitions.get(i).div) && competitions.get(i).year==17)return i;
		}
		throw new IllegalArgumentException("Wrong name");
	}
	
	private void printCompetitionAll(String name){
		int i = findCompetition(name);
		competitions.get(i).printAll();
	}
	
	private void printCompetitionAll(int i){
		competitions.get(i).printAll();
	}
	
	private String createName(String fileName, String season){
		String div = ""+fileName.charAt(fileName.indexOf('.')-1);
		String name=null;
		switch(fileName.charAt(0)){
			case 'E':name="England";break;
			case 'S':{
				if(fileName.charAt(1)=='C'){name="Scotland";}
				else if (fileName.charAt(1)=='P'){name="Spain";}
				break;
			}
			case 'D':name="Germany";break;
			case 'I':name="Italy";break;
			case 'F':name="France";break;
			case 'N':name="Netherlands";break;
			case 'B':name="Belgium";break;
			case 'P':name="Portugal";break;
			case 'T':name="Turkey";break;
			case 'G':name="Greece";break;
			default:System.out.println("Unknown League");
			};
		name+=" "+div+" "+season;
		return name;
	}
	
	private void printList(List<Comparison> list){
		for(int i=0; i<list.size();i++){
			list.get(i).print();
		}
	}
	
	private void downloadFiles(String inputPath, String outputPath){
		URL website = null;
		ReadableByteChannel rbc = null;
		FileOutputStream fos = null;
		try {
			website = new URL(inputPath);
		} catch (MalformedURLException e) {e.printStackTrace();}
		try {
			rbc = Channels.newChannel(website.openStream());
		} catch (IOException e) {e.printStackTrace();}
		try {
			fos = new FileOutputStream(outputPath);
		} catch (FileNotFoundException e) {e.printStackTrace();}
		try {
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e) {e.printStackTrace();}
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
    
	public static void main(String[] args) {
		Analysis analysis = new Analysis();		
	}
}