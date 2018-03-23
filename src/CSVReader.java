import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	public List<String[]> results, fixtures;
	public String[] abr, abrOpt;
	public int[] abrIndex;
	private String getDate(){
		String dateIn = LocalDateTime.now()+"";
		String dateOut = dateIn.substring(dateIn.lastIndexOf('-') + 1, (dateIn.lastIndexOf('-') + 3))+"/"+
				dateIn.substring(dateIn.indexOf('-') + 1, (dateIn.indexOf('-') + 3))+"/18";
		return dateOut;
	}
	
	public void createAbr(String[] abrTemp) {
		for(int i=0;i<28;i++) {
			abr[i]="X";
			abrIndex[i]=100;
		}
		
		for(int i=0;i<28;i++) {
			for(int j=0;j<abrTemp.length;j++) {
				if(abrOpt[i].equalsIgnoreCase(abrTemp[j])) {					
					abrIndex[i]=j;
					abr[i]=abrTemp[j];
				}
			}
		}
	}
	public String[] filter(String[] abrTemp) {
		String[] output= new String[28];
		for(int i=0;i<28;i++) {
			if(abrIndex[i]!=100)output[i]=abrTemp[abrIndex[i]];
			else {
				output[i]="1000";
			}
		}
		return output;
	}
	
	public CSVReader(String csvFile, int year){
		results = new ArrayList<String[]>();
		fixtures = new ArrayList<String[]>();
		abrOpt = new String[28];
		abr = new String[28];
		abrIndex = new int[28];
		
		abrOpt[0]="Div"; //League Division
		abrOpt[1]="Date"; //Match Date (dd/mm/yy)
		abrOpt[2]="HomeTeam"; //Home Team
		abrOpt[3]="AwayTeam"; //Away Team
		abrOpt[4]="FTHG"; //Full Time Home Team Goals
		abrOpt[5]="FTAG"; //Full Time Away Team Goals
		abrOpt[6]="FTR"; //Full Time Result (H=Home Win, D=Draw, A=Away Win)
		abrOpt[7]="HTHG"; //Half Time Home Team Goals
		abrOpt[8]="HTAG"; //Half Time Away Team Goals
		abrOpt[9]="HTR"; //Half Time Result (H=Home Win, D=Draw, A=Away Win)
		abrOpt[10]="Referee"; //Match Referee
		abrOpt[11]="HS"; //Home Team Shots
		abrOpt[12]="AS"; //Away Team Shots
		abrOpt[13]="HST"; //Home Team Shots on Target
		abrOpt[14]="AST"; //Away Team Shots on Target
		abrOpt[15]="HC"; //Home Team Corners
		abrOpt[16]="AC"; //Away Team Corners
		abrOpt[17]="HF"; //Home Team Fouls Committed
		abrOpt[18]="AF"; //Away Team Fouls Committed
		abrOpt[19]="HY"; //Home Team Yellow Cards
		abrOpt[20]="AY"; //Away Team Yellow Cards
		abrOpt[21]="HR"; //Home Team Red Cards
		abrOpt[22]="AR"; //Away Team Red Cards
		abrOpt[23]="B365H"; //Bet365 home win odds
		abrOpt[24]="B365D"; //Bet365 draw odds
		abrOpt[25]="B365A"; //Bet365 away win odds
		abrOpt[26]="BbAv>2.5"; //Betbrain average over 2.5 goals
		abrOpt[27]="BbAv<2.5"; //Betbrain average under 2.5 goals
		String tempCodeDiv="";
		String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy); // use comma as separator
                if(results.size()==0) {
                	createAbr(data);
                	data=abr;
                } else {
                	data=filter(data);
                }
              
				if(data[4].length()!=0){
					results.add(data);
				}
				tempCodeDiv=data[0];
			}
        } catch (IOException e) {e.printStackTrace();}
        
        try (BufferedReader br = new BufferedReader(new FileReader(Analysis.pathToSrcFixtures))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
				if(data[4].length()==0 && data[0].equals(tempCodeDiv) && year==17 && data[1].equals(getDate())){
					fixtures.add(data);				
				}
			}
        } catch (IOException e) {e.printStackTrace();}
	} 
}