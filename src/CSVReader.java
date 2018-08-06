import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class CSVReader {
	String csvFile;
	String name;
	String code;
	int div;
	int year;
	
	String codeDivTemp;
	boolean extra;
	public List<Fixture> fixtures;
	public List<Result> results;
	public String[] abr = new String[Common.abrOpt.length];
	public int[] abrIndex = new int[Common.abrOpt.length];;
	public String[] abrFix= new String[Common.abrOpt.length];
	public int[] abrIndexFix = new int[Common.abrOpt.length];
	
	
	public void createAbr(String[] abrFile){
		for(int i=0;i<Common.abrOpt.length;i++) {
			abr[i]="X";
			abrIndex[i]=-1;
		}
		for(int i=0;i<Common.abrOpt.length;i++) {
			for(int j=0;j<abrFile.length;j++) {
				if(extra) {
					if(Common.abrOptExtra[i].equalsIgnoreCase(abrFile[j])) {					
						abrIndex[i]=j;
						abr[i]=abrFile[j];
						}
				} else {
					if(Common.abrOpt[i].equalsIgnoreCase(abrFile[j])) {
						abrIndex[i]=j;
						abr[i]=abrFile[j];
						}
					}
				}
			}
		}
	
	public void createAbrFix(String[] abrFile){
		for(int i=0;i<Common.abrOpt.length;i++) {
			abrFix[i]="X";
			abrIndexFix[i]=-1;
		}
		for(int i=0;i<Common.abrOpt.length;i++) {
			for(int j=0;j<abrFile.length;j++) {
				if(extra) {
					if(Common.abrOptFixExtra[i].equalsIgnoreCase(abrFile[j])) {					
						abrIndexFix[i]=j;
						abrFix[i]=abrFile[j];
						}
				} else {
					if(Common.abrOptFix[i].equalsIgnoreCase(abrFile[j])) {
						abrIndexFix[i]=j;
						abrFix[i]=abrFile[j];
						}
					}
				}
			}
		}
	
	public String[] filter(String[] data) {
		String[] output=new String[Common.abrOpt.length];
		for(int i=0;i<Common.abrOpt.length;i++) {
		
			if(abrIndex[i]!=-1 && data.length>=abrIndex[i]) {
				if(data[abrIndex[i]].equalsIgnoreCase("")) {
					if(data[abrIndex[4]].equalsIgnoreCase("") || data[abrIndex[4]].equalsIgnoreCase("")) {
						output[i]="";
					} else {
						output[i]="-1";
						}
					}
				else {output[i]=data[abrIndex[i]];}
			}
			else {output[i]="-1";}
		
		}
		return output;	
	}	

	public String[] filterFix(String[] data) {
		String[] output= new String[Common.abrOpt.length];
		for(int i=0;i<Common.abrOpt.length;i++) {
			
			if(abrIndexFix[i]!=-1 && data.length>=abrIndexFix[i]) {
				if(data[abrIndexFix[i]].equalsIgnoreCase("")) {output[i]="-1";}
				else {output[i]=data[abrIndexFix[i]];}
			}
			else {output[i]="-1";}
			
		}
		return output;
	}
	
	public void createCompetition(List<Competition> competitionsTemp){
		String line = "";
        String cvsSplitBy = ",";
        String[] data= {""};
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	boolean firstTime=true;
        	results = new ArrayList<Result>();
			while ((line = br.readLine()) != null) {
				if(firstTime) {
                	firstTime=false;
                	data = line.split(cvsSplitBy);
                	createAbr(data);
                }
                else {
                	data = line.split(cvsSplitBy);
                	try {}
	            	catch(ArrayIndexOutOfBoundsException e) {System.out.println(code+" "+div+" "+year+" "+results.size());}
                	try {
	               	if(data[4].length()!=0){
	                	codeDivTemp=data[0];
	               		data=filter(data);
	                	results.add(new Result(data));
	            		}
	               	}catch(ArrayIndexOutOfBoundsException e) {}
	               	}
	    		}
    		}catch (IOException e) {e.printStackTrace();}
		
    		if(results.size()>0 && year==19) {
    			boolean firstTime=true;
    			fixtures = new ArrayList<Fixture>();
    			try (BufferedReader br = new BufferedReader(new FileReader(Common.pathToBasicFixtures))) {
	                while ((line = br.readLine()) != null) {
	                	if(firstTime) {
	                    	firstTime=false;
	                    	data = line.split(cvsSplitBy);
	                      	createAbrFix(data);
	                      	}
	                	else{
		                	data = line.split(cvsSplitBy);
		                	data=filterFix(data);
		                	if(data[0].equals(codeDivTemp)){
		                		fixtures.add(new Fixture(data));
		                		}
		                	}
	                	}
	                }catch (IOException e) {e.printStackTrace();}
    			}
    		competitionsTemp.add(new Competition(results, fixtures, name, code, div, year, extra, abr, abrFix));
    	}
	
	public void createCompetitionExtra(List<Competition> competitionsTemp){

		int seasonCur=-1;
		int seasonPre=-1;
		String season="";
		
		String line = "";
		String cvsSplitBy = ",";
		String[] data= {""};
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			boolean firstTime=true;
			results = new ArrayList<Result>();
    		
			while ((line = br.readLine()) != null) {
                if(firstTime) {
                	firstTime=false;
                    data = line.split(cvsSplitBy);
                    createAbr(data);
                }
                else {
	                data = line.split(cvsSplitBy);
	                season = data[2];
	               	codeDivTemp=data[0];
	                data=filter(data);
	                String substring = season.substring(Math.max(season.length() - 2, 0));
	                if(substring.length()!=0)seasonCur = Integer.valueOf(substring);  
	                
	                if(seasonPre==-1)seasonPre=seasonCur;
	                else if(seasonCur>seasonPre) {
	                	seasonPre=seasonCur;
	                	competitionsTemp.add(new Competition(results, fixtures, name, code, div, seasonPre-1, extra, abr, abrFix));
	                	results = new ArrayList<Result>();
	                }
	                if(data[4].length()!=0){
                   		results.add(new Result(data));
                   		}
	                }
                }
    		}catch (IOException e) {e.printStackTrace();}
		
		if(results.size()>0) {
			boolean firstTime=true;
			fixtures = new ArrayList<Fixture>();
			try (BufferedReader br = new BufferedReader(new FileReader(Common.pathToExtraFixtures))) {
                while ((line = br.readLine()) != null) {
                	if(firstTime) {
                    	firstTime=false;
                		data = line.split(cvsSplitBy);
                      	createAbrFix(data);
                      	}
                	else {          			
                		data = line.split(cvsSplitBy);
	                	data=filterFix(data);
	                	if(data[0].equals(codeDivTemp)){
	                		fixtures.add(new Fixture(data));
	                		}
	                	}
                	}
                }catch (IOException e) {e.printStackTrace();}
			}
		competitionsTemp.add(new Competition(results, fixtures, name, code, div, seasonPre, extra, abr, abrFix));
	}
		
	public CSVReader(List<Competition> competitionsTemp, File csvFile) {
		String fileName = csvFile.getName();
		code = fileName.substring(0, fileName.indexOf('.') - 1);
		div = Integer.valueOf(fileName.substring(fileName.indexOf('.') - 1, fileName.indexOf('.')));
		year = Integer.valueOf(fileName.substring(fileName.indexOf('.') + 3, fileName.lastIndexOf('.')));
		name=Common.codeToName(code);
		this.csvFile=""+csvFile;
		
		if(year==0)extra=true;
		else extra=false;
		if(year>=Analysis.yearMin && year<=Analysis.yearMax) {
		if(extra)createCompetitionExtra(competitionsTemp);
		else createCompetition(competitionsTemp);
		}
		}
	}