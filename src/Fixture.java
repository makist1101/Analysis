
public class Fixture {
	int ratingWin=0,
		ratingOver=0,
		ratingBtts=0,
		ratingCorners=0;
	boolean hasData=false;

	String codeDiv,
		date,
		homeTeam,
		awayTeam;
	double HODDS, 
		AODDS,
		DODDS,
		OODDS,
		UODDS;

	public void transfer(String[] data) {
		codeDiv=Common.checkString(Common.fixCodeDiv(data[0]));
		date=Common.checkString(data[1]);						
		homeTeam=Common.checkString(data[2]);
		awayTeam=Common.checkString(data[3]);
		HODDS=Common.checkDouble(data[4]);
		AODDS=Common.checkDouble(data[5]);
		DODDS=Common.checkDouble(data[6]);
		OODDS=Common.checkDouble(data[7]);
		UODDS=Common.checkDouble(data[8]);
	}
		
	public Fixture(String[] data) {
		transfer(data);
		
		if (date.contains("-"))
			System.out.println("Alert:Date with -  "+codeDiv+" "+date);
		
		if (codeDiv.equalsIgnoreCase("-1") || date.equalsIgnoreCase("-1") || homeTeam.equalsIgnoreCase("-1")
				|| awayTeam.equalsIgnoreCase("-1")) {
			System.out.println("Alert:Data input with -1 on basic info "+codeDiv+" "+date);
		}
	}

	public void multi() {
		if(true) {
		if(HODDS!=-1.00 && AODDS!=-1.00) {
			if(ratingWin>0) {
				ratingWin=(int)(ratingWin*Math.sqrt(HODDS));
			}else {
				ratingWin=(int)(ratingWin*Math.sqrt(AODDS));
			}
		}
		}
			
	}
}