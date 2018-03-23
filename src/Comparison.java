import java.util.List;

public class Comparison {
	public String name;
	int rating;
	public Comparison(String name, int rating){
		this.name=name;
		this.rating=rating;
	}
	public void print() {
		System.out.println(rating+"\t"+name);
	}
	
	public static void swap(Comparison first, Comparison second){	
		String tempName;
		int temp;   													
		temp =  first.rating;             			
		tempName = first.name;
		first.rating =  second.rating;
		first.name = second.name;
		second.rating = temp;
		second.name = tempName;								
	}
}