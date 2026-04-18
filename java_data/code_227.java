import java.util.Comparator;

public class Term implements Comparable<Term> {

	private final String myWord;
	private final double myWeight;

	
	public Term(String word, double weight) {
				if(word == null){
			throw new NullPointerException("Word is empty!");
		}
		if(weight<0){
			throw new IllegalArgumentException("Weight is negative!");
		}
		myWord = word;
		myWeight = weight;
	}

	
	public static class PrefixOrder implements Comparator<Term> {
		private final int r;

		public PrefixOrder(int r) {
			this.r = r;
		}

		
		public int compare(Term v, Term w) {
			int length = Math.min(Math.min(v.myWord.length(), w.myWord.length()), r);
			for(int i = 0; i<length; i++){
				if(Character.toString(v.myWord.charAt(i)).compareTo(Character.toString(w.myWord.charAt(i)))  != 0 )
					return Character.toString(v.myWord.charAt(i)).compareTo(Character.toString(w.myWord.charAt(i))); 
			}
			if(r-length>0)
				return v.myWord.length()-w.myWord.length();
			return 0;
		}
	}

	
	public static class ReverseWeightOrder implements Comparator<Term> {
		public int compare(Term v, Term w) {
			if(v.myWeight-w.myWeight > 0){
				return -1;
			} else if(v.myWeight-w.myWeight < 0){
				return 1;
			}
			return 0;
		}
	}

	
	public static class WeightOrder implements Comparator<Term> {
		public int compare(Term v, Term w) {
			if(v.myWeight-w.myWeight > 0){
				return 1;
			} else if(v.myWeight-w.myWeight < 0){
				return -1;
			}
			return 0;
		}
	}

	
	public int compareTo(Term that) {
		return myWord.compareTo(that.myWord);
	}

	
	public String getWord() {
		return myWord;
	}

	public double getWeight() {
		return myWeight;
	}

	public String toString() {
		return String.format("%14.1f\t%s", myWeight, myWord);
	}
	
	public static void main(String[] args){
		PrefixOrder test = new Term.PrefixOrder(4);
		System.out.println(test.compare(new Term("bug", 0), new Term("bees", 0)));
	}
}