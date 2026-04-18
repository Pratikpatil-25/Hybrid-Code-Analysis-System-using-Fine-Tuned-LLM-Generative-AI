package moa.classifiers.meta;

import com.yahoo.labs.samoa.instances.Instance;

public class UOB extends OOB {

	@Override
	public String getPurposeString() {
		return "Undersampling on-line bagging of Wang et al IJCAI 2016.";
	}
	
	public UOB() {
		super();
	}
	
			@Override
	public double calculatePoissonLambda(Instance inst) {
		double lambda = 1d;
		int minClass = getMinorityClass();
		
		lambda = classSize[minClass] / classSize[(int) inst.classValue()];
		
		return lambda;
	}
	
	

}