
public class Result {
	String codeDiv,
		date,
		homeTeam,
		awayTeam;
	
	int FTHG,
		FTAG;
	
	String FTR;
		
	int HTHG,
		HTAG;
		
	String	HTR,
		referee;
	
	int	HS,
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
		codeDiv=Common.fixCodeDiv(data[0]);
		date=data[1];							if(date.contains("-"))System.out.println("Date With -");
		homeTeam=data[2];
		awayTeam=data[3];
		FTHG=Integer.valueOf(data[4]);
		FTAG=Integer.valueOf(data[5]);
		FTR=data[6];
		HTHG=Integer.valueOf(data[7]);
		HTAG=Integer.valueOf(data[8]);
		HTR=data[9];
		referee=data[10];
		HS=Integer.valueOf(data[11]);
		AS=Integer.valueOf(data[12]);
		HST=Integer.valueOf(data[13]);
		AST=Integer.valueOf(data[14]);
		HC=Integer.valueOf(data[15]);
		AC=Integer.valueOf(data[16]);
		HF=Integer.valueOf(data[17]);
		AF=Integer.valueOf(data[18]);
		HY=Integer.valueOf(data[19]);
		AY=Integer.valueOf(data[20]);
		HR=Integer.valueOf(data[21]);
		AR=Integer.valueOf(data[22]);
		HODDS=Float.valueOf(data[23]);
		AODDS=Float.valueOf(data[24]);
		DODDS=Float.valueOf(data[25]);
		OODDS=Float.valueOf(data[26]);
		UODDS=Float.valueOf(data[27]);
	}
	
	
	public Result(String[] data) {
		transfer(data);		
	}
}
