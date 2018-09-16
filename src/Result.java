public class Result {
	String codeDiv,
		date,
		homeTeam,
		awayTeam,
		referee;
	
	int FTHG,
		FTAG,
		HTHG,
		HTAG,
		HS,
		AS,
		HST,
		AST,
		HC,
		AC,
		HF,
		AF,
		HY,
		AY,
		HR,
		AR;
		
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
		FTHG=Common.checkInt(data[4]);
		FTAG=Common.checkInt(data[5]);
		HTHG=Common.checkInt(data[6]);
		HTAG=Common.checkInt(data[7]);
		referee=Common.checkString(data[8]);
		HS=Common.checkInt(data[9]);
		AS=Common.checkInt(data[10]);
		HST=Common.checkInt(data[11]);
		AST=Common.checkInt(data[12]);
		HC=Common.checkInt(data[13]);
		AC=Common.checkInt(data[14]);
		HF=Common.checkInt(data[15]);
		AF=Common.checkInt(data[16]);
		HY=Common.checkInt(data[17]);
		AY=Common.checkInt(data[18]);
		HR=Common.checkInt(data[19]);
		AR=Common.checkInt(data[20]);
		HODDS=Common.checkDouble(data[21]);
		AODDS=Common.checkDouble(data[22]);
		DODDS=Common.checkDouble(data[23]);
		OODDS=Common.checkDouble(data[24]);
		UODDS=Common.checkDouble(data[25]);
	}
	
	
	public Result(String[] data) {
	try 
		{
		transfer(data);		
		}
		catch (NumberFormatException nfe) {System.out.println("Alert:Data input invalid format "+codeDiv+" "+date);}
		
		if (date.contains("-"))
			System.out.println("Alert:Date with -  "+codeDiv+" "+date);
		
		if (codeDiv.equalsIgnoreCase("-1") || date.equalsIgnoreCase("-1") || homeTeam.equalsIgnoreCase("-1")
				|| awayTeam.equalsIgnoreCase("-1")) {
			System.out.println("Alert:Data input with -1 on basic info "+codeDiv+" "+date);
		}
	}
}
