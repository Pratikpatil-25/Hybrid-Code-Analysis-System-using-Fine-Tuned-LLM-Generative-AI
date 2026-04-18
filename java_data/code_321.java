package ca.pfv.spmf.algorithms.frequentpatterns.fhmds.naive;







import ca.pfv.spmf.algorithms.frequentpatterns.upgrowth_ihup.AlgoUPGrowth;







public class Itemset {



	int[] itemset;

	private Float utility = 0F;

	Float last_batch_utility=0F;

	

	

	public Itemset(int[] setOfItems,Float utility) {

		this.itemset = setOfItems;

		this.utility=utility;

	}

	

	

	public Float getExactUtility() {

		return utility;

	}

	

	public void setExactUtility(Float utility) {

		this.utility=utility;

	}



	

	public void increaseUtility(Float utility) {

		this.utility += utility;

	}

	

	
	public int size(){

		return(this.itemset.length);

	}



	public Integer get(int pos) {

		return itemset[pos];

	}

}