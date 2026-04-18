import java.util.*;


public class GA<T extends Gene> {
	
	protected List<T> list;
	protected int generationSize; 	protected int nbrGenerations;
	protected Class<T> clazz; 
	public GA(int generationSize, int nbrGenerations, Class<T> clazz) {
		this.generationSize  = generationSize;
		this.nbrGenerations  = nbrGenerations;
		this.clazz           = clazz;

		
		list = new LinkedList<T>();
		
		run();
	}

	void run(){
		
		
		for (int k = 0; k < generationSize; k++) {
			T gene = newT();
			gene.setRandomValue();
			list.add(gene);
		}

		for (int k = 0; k < nbrGenerations; k++) {

			
			for (int i = 0; i < generationSize; i++) {
				list.get(i).setFitness();
			}

			
			sort();
			
			for(int i = 0; i < generationSize; i+= 2){
						
				T gene1       = list.get(i);
				T gene2       = list.get(i+1);
				
				T offspring = newT(); 
				offspring.setValue(gene1.combineValues(gene2.getValue()));
				
				
				offspring.setFitness();
				place(offspring);
			}

			
			LinkedList<T> tmp = new LinkedList<T>();
			for (int i = 0; i < generationSize; i++) {
				tmp.add(list.get(i));
			}
			list = tmp;

			
			for (int i = generationSize/5; i < generationSize; i++) {
				T gene = list.get(i);
				gene.setValue(gene.mutateValue());
			}	
		}

		
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i).getValue());
		}
	}

	
	private void sort(){
		List<T> tmp = list;
		list = new ArrayList<T>();
		for(T g : tmp){
			place(g);
		}
	}

	
	private void place(T gene){
		for (int k = 0; k < list.size(); k++) {
			if (list.get(k).getFitness() > gene.getFitness()) {
				list.add(k, gene);
				return;
			}
		}
		list.add(list.size(), gene);
	}

	
	private T newT() {
		try{
			return clazz.newInstance();
		}catch(Exception e){
			return null;
		}
	}
}