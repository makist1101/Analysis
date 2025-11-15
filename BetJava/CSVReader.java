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
	public String[] abrFix = new String[Common.abrOptFix.length];
	public int[] abrIndexFix = new int[Common.abrOptFix.length];

	public void createAbr(String[] abrFile) {
		for (int i = 0; i < Common.abrOpt.length; i++) {
			abr[i] = "X";
			abrIndex[i] = -1;
		}
		for (int i = 0; i < Common.abrOpt.length; i++) {
			for (int j = 0; j < abrFile.length; j++) {
				if (extra) {
					if (Common.abrOptExtra[i].equalsIgnoreCase(abrFile[j])) {
						abrIndex[i] = j;
						abr[i] = abrFile[j];
					}
				} else {
					if (Common.abrOpt[i].equalsIgnoreCase(fixAbr(abrFile[j]))) {
						abrIndex[i] = j;
						abr[i] = fixAbr(abrFile[j]);
					}
				}
			}
		}
	}

	public String fixAbr(String input) {
		if (input.equalsIgnoreCase("HT")) {
			return "HomeTeam";
		} else if (input.equalsIgnoreCase("AT")) {
			return "AwayTeam";
		} else
			return input;
	}

	public void createAbrFix(String[] abrFile) {
		for (int i = 0; i < Common.abrOptFix.length; i++) {
			abrFix[i] = "X";
			abrIndexFix[i] = -1;
		}
		for (int i = 0; i < Common.abrOptFix.length; i++) {
			for (int j = 0; j < abrFile.length; j++) {
				if (extra) {
					if (Common.abrOptFixExtra[i].equalsIgnoreCase(abrFile[j])) {
						abrIndexFix[i] = j;
						abrFix[i] = abrFile[j];
					}
				} else {
					if (Common.abrOptFix[i].equalsIgnoreCase(abrFile[j])) {
						abrIndexFix[i] = j;
						abrFix[i] = abrFile[j];
					}
				}
			}
		}
	}

	public String[] filter(String[] data) {
		String[] output = new String[Common.abrOpt.length];
		for (int i = 0; i < Common.abrOpt.length; i++) {

			if (abrIndex[i] != -1 && data.length > abrIndex[i]) {
				if (data[abrIndex[i]].equalsIgnoreCase("")) {
					if (data[abrIndex[4]].equalsIgnoreCase("") || data[abrIndex[4]].equalsIgnoreCase("")) {
						output[i] = "";
					} else {
						output[i] = "-1";
					}
				} else {

					int fixOffset = 0;

					if (data.length > abrIndex[8] + 1 && abrIndex[8] != -1)
						if (!data[abrIndex[8] + 1].equalsIgnoreCase("") && i >= 9) {
							try {
								Integer.valueOf(data[abrIndex[8] + 1]);
							} catch (NumberFormatException nfe) {
								fixOffset = 1;
							}
						}
					output[i] = data[abrIndex[i] + fixOffset];
					fixOffset=0;
				}
			} else {
				output[i] = "-1";
			}

		}
		return output;
	}

	public String[] filterFix(String[] data) {
		String[] output = new String[Common.abrOptFix.length];
		for (int i = 0; i < Common.abrOptFix.length; i++) {

			if (abrIndexFix[i] != -1 && data.length > abrIndexFix[i]) {
				if (data[abrIndexFix[i]].equalsIgnoreCase("")) {
					output[i] = "-1";
				} else {
					output[i] = data[abrIndexFix[i]];
				}
			} else {
				output[i] = "-1";
			}

		}
		return output;
	}

	public void createCompetition(List<Competition> competitionsTemp) {
		String line = "";
		String cvsSplitBy = ",";
		String[] data = { "" };
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			boolean firstTime = true;
			results = new ArrayList<Result>();
			while ((line = br.readLine()) != null) {
				if (firstTime) {
					firstTime = false;
					data = line.split(cvsSplitBy);
					createAbr(data);
				} else {
					data = line.split(cvsSplitBy);
					try {
						if (data.length > 5) {
							if (data[0].length() != 0 && data[1].length() != 0 && data[2].length() != 0
									&& data[3].length() != 0 && data[4].length() != 0 && data[5].length() != 0) {
								codeDivTemp = data[0];
								data[1]=Common.fixYear(data[1]);
								data = filter(data);
								results.add(new Result(data));
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Alert:"+code + div + " Y" + year + " " + results.size());
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (results.size() > 0 && year == Common.getSeason()) {
			boolean firstTime = true;
			fixtures = new ArrayList<Fixture>();
			try (BufferedReader br = new BufferedReader(new FileReader(Common.pathToBasicFixtures))) {
				while ((line = br.readLine()) != null) {
					if (firstTime) {
						firstTime = false;
						data = line.split(cvsSplitBy);
						createAbrFix(data);
					} else {
						data = line.split(cvsSplitBy);
						data[1]=Common.fixYear(data[1]);
						data = filterFix(data);
						if (data[0].equals(codeDivTemp)) {
							fixtures.add(new Fixture(data));
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (useCompetition(code, div, year))
			competitionsTemp.add(new Competition(results, fixtures, name, code, div, year, extra, abr, abrFix));
	}

	public void createCompetitionExtra(List<Competition> competitionsTemp) {
		String seasonTest="";
		boolean firstTime2=true;

		
		int seasonCur = -1;
		int seasonPre = -1;
		String season = "";

		String line = "";
		String cvsSplitBy = ",";
		String[] data = { "" };

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			boolean firstTime = true;
			results = new ArrayList<Result>();

			while ((line = br.readLine()) != null) {
				if (firstTime) {
					data = line.split(cvsSplitBy);
					firstTime = false;
					createAbr(data);
				} else {
					data = line.split(cvsSplitBy);
					
					if(firstTime2) {
						seasonTest=data[2];
						firstTime2 = false;
					}
					
					
					if (data.length > 8) {
						if (data[0].length() != 0 && data[1].length() != 0 && data[2].length() != 0
								&& data[3].length() != 0 && data[4].length() != 0 && data[5].length() != 0
								&& data[6].length() != 0 && data[7].length() != 0 && data[8].length() != 0) {
							
							if(seasonTest.length()!=data[2].length()) {
							//System.out.println("Alert: Season format change "+data[0]+" "+data[2]+" "+data[3]);
							}
							season = data[2];
							seasonTest=data[2];
							
							data[3] = Common.fixDate(data[3], data[4]);
							codeDivTemp = data[0];
							data = filter(data);
							String substring = season.substring(Math.max(season.length() - 2, 0));
							if (substring.length() != 0)
								seasonCur = Integer.valueOf(substring);

							if (seasonPre == -1)
								seasonPre = seasonCur;
							else if (seasonCur > seasonPre) {
								seasonPre = seasonCur;
								if (useCompetition(code, div, seasonPre - 1))
									competitionsTemp.add(new Competition(results, fixtures, name, code, div,
											seasonPre - 1, extra, abr, abrFix));

								results = new ArrayList<Result>();
							}
							results.add(new Result(data));
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (results.size() > 0) {
			boolean firstTime = true;
			fixtures = new ArrayList<Fixture>();
			
			try (BufferedReader br = new BufferedReader(new FileReader(Common.pathToExtraFixtures))) {
				while ((line = br.readLine()) != null) {
					if (firstTime) {
						firstTime = false;
						data = line.split(cvsSplitBy);
						createAbrFix(data);
					} else {
						data = line.split(cvsSplitBy);
						if (data.length > 5) {
							if (data[0].length() != 0 && data[1].length() != 0 && data[2].length() != 0
									&& data[3].length() != 0 && data[4].length() != 0 && data[5].length() != 0
									&& data[6].length() != 0) {

						
						if(Analysis.timeTest)System.out.print(data[4]+"\n"+data[2]+" "+data[3]+"->");
						data[2] = Common.balanceFixtureDate(Common.fixDate(data[2], data[3]), Common.fixTime(data[3]));
						if(Analysis.timeTest)System.out.println(Common.fixTime(data[3])+" "+data[2]);
									
						data = filterFix(data);
						if (data[0].equals(codeDivTemp)) {
									fixtures.add(new Fixture(data));
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (useCompetition(code, div, seasonPre))
			{competitionsTemp.add(new Competition(results, fixtures, name, code, div, seasonPre, extra, abr, abrFix));
			}
	}

	public boolean useCompetition(String code, int div, int year) {
		String codeDiv = code + div;
		if (Analysis.yearMax >= year && Analysis.yearMin <= year) {
			if (Analysis.useFirst)
				for (int i = 0; i < Common.leaguesFirst.length; i++) {
					if (codeDiv.equalsIgnoreCase(Common.fixCodeDiv(Common.leaguesFirst[i])))
						return true;
				}
			if (Analysis.useSecond)
				for (int i = 0; i < Common.leaguesSecond.length; i++) {
					if (codeDiv.equalsIgnoreCase(Common.fixCodeDiv(Common.leaguesSecond[i])))
						return true;
				}
			if (Analysis.useThird)
				for (int i = 0; i < Common.leaguesThird.length; i++) {
					if (codeDiv.equalsIgnoreCase(Common.fixCodeDiv(Common.leaguesThird[i])))
						return true;
				}
			if (Analysis.useExtraStartW)
				for (int i = 0; i < Common.leaguesExtraStartW.length; i++) {
					if (codeDiv.equalsIgnoreCase(Common.fixCodeDiv(Common.leaguesExtraStartW[i])))
						return true;
				}
			if (Analysis.useExtraStartS)
				for (int i = 0; i < Common.leaguesExtraStartS.length; i++) {
					if (codeDiv.equalsIgnoreCase(Common.fixCodeDiv(Common.leaguesExtraStartS[i])))
						return true;
				}
		}
		return false;
	}

	public CSVReader(List<Competition> competitionsTemp, File csvFile) {
		String fileName = csvFile.getName();
		code = fileName.substring(0, fileName.indexOf('.') - 1);
		div = Integer.valueOf(fileName.substring(fileName.indexOf('.') - 1, fileName.indexOf('.')));
		year = Integer.valueOf(fileName.substring(fileName.indexOf('.') + 3, fileName.lastIndexOf('.')));
		name = Common.codeToName(code);
		this.csvFile = "" + csvFile;

		if (year == 0)
			extra = true;
		else
			extra = false;
			if (extra)
				createCompetitionExtra(competitionsTemp);
			else
				createCompetition(competitionsTemp);
		}
	
}