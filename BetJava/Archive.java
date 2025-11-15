
public class Archive {
	String date, homeTeam, awayTeam, csvLine, bet; 
	int ratingWin, ratingOver, ratingBtts, ratingCorners;
	public Archive(String date, String homeTeam, String awayTeam, int ratingWin, int ratingOver, int ratingBtts, int ratingCorners, String bet, String csvLine) {
		this.date=date;
		this.homeTeam=homeTeam;
		this.awayTeam=awayTeam;
		this.ratingWin=ratingWin;
		this.ratingOver=ratingOver;
		this.ratingBtts=ratingBtts;
		this.ratingCorners=ratingCorners;
		this.csvLine=csvLine;
		this.bet=bet;
	}
	
	
	
	public String[] createCsvLine2() {
		String[] temp =  {date, homeTeam, awayTeam, ""+ratingWin, ""+ratingOver, ""+ratingBtts, ""+ratingCorners};
	return temp;
	}
	public String createCsvLine() {
		String temp =  (date+","+homeTeam+","+awayTeam+","+ratingWin+","+ratingOver
				//+","+ratingBtts+","+ratingCorners
				+","+csvLine);
	return temp;
	}
	
}