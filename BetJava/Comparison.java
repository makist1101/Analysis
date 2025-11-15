import java.text.DecimalFormat;
import java.util.List;

public class Comparison {
	public String name;
	int rating=0;
	double ratingD=0;
	String date="";
	boolean hasData=false;
	double[] ratingParts= {0.0,0.0};
	//sum,count
	public Comparison(Comparison copy) {
		this.name = copy.name;
		this.rating = copy.rating;
		this.ratingD = copy.ratingD;
		this.date = copy.date;
		this.hasData = copy.hasData;		
	}
	
	public Comparison(String name, int rating,String date, boolean hasData){
		this(name, rating);
		this.date=date;
		this.hasData=hasData;
		
	}
	public Comparison(String name, double ratingD,String date, boolean hasData){
		this(name, ratingD);
		this.date=date;
		this.hasData=hasData;
		
	}

	public Comparison(String name, int rating){
		this.name=name;
		this.rating=rating;
	}
	public Comparison(String name, double ratingD){
		this.name=name;
		this.ratingD=ratingD;
	}

	public Comparison(String name, double[] ratingParts){
		this.name=name;
		this.ratingParts[0]=ratingParts[0];
		this.ratingParts[1]=ratingParts[1];
	}
	public void printWithDate(String targetDate) {
		if((hasData && Analysis.useFullFixtures) || (!hasData && Analysis.useEmptyFixtures)) {
		String substring = date.substring(0, date.length() - 3);
		if (targetDate != null) {
		//	System.out.println(targetDate+"->"+date);
			if (targetDate.equalsIgnoreCase(date) && substring.length() != 0)
				System.out.println(rating + "\t" + substring + "\t" + name);
		} else {
			if (substring.length() != 0)
				System.out.println(rating + "\t" + substring + "\t" + name);

		}
		}
	}

	public void print() {
		if(ratingD==0)
		System.out.println(rating+"\t"+name);
		else printD();
	}
	
	public void printD() {
		System.out.println(Common.df12.format(ratingD)+"\t"+name);
	}
	
	public static void swap(Comparison first, Comparison second){	
		String tempName;
		int temp; 
		double tempD;
		String tempDate;
		boolean tempHasData;
		
		temp =  first.rating;
		first.rating =  second.rating;
		second.rating = temp;
		
		tempD = first.ratingD;
		first.ratingD = second.ratingD;
		second.ratingD = tempD;
		
		tempName = first.name;
		first.name = second.name;
		second.name = tempName;
		
		tempDate=first.date;
		first.date=second.date;
		second.date=tempDate;
		
		tempHasData=first.hasData;
		first.hasData=second.hasData;
		second.hasData=tempHasData;
	}
}