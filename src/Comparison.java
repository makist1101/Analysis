import java.text.DecimalFormat;
import java.util.List;

public class Comparison {
	public String name;
	int rating=0;
	double ratingD=0;
	String date="";
	boolean hasData=false;

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

	public void print() {
		System.out.println(rating+"\t"+name);
	}
	
	public void printD() {
		System.out.println(Common.df11.format(ratingD)+"\t"+name);
	}
	
	public static void swap(Comparison first, Comparison second){	
		String tempName;
		int temp; 
		double tempD;
		String tempDate;
		boolean tempHasData;
		temp =  first.rating;
		tempD = first.ratingD;
		tempName = first.name;
		tempDate=first.date;
		tempHasData=first.hasData;
		first.rating =  second.rating;
		first.ratingD = second.ratingD;
		first.name = second.name;
		first.date=second.date;
		first.date=second.date;
		first.hasData=second.hasData;
		second.rating = temp;
		second.ratingD = tempD;
		second.name = tempName;
		second.date=tempDate;
		second.hasData=tempHasData;
	}
}