package optimizationAlgorithms;

import java.util.Arrays;


public class S {
	
	public void runSAlgorithm()
	{	
	
			
	int problemDimension = 10;
	int maxEvaluations = problemDimension*10000;
	double a = 0.4; 	
		
	double problemLowerBound = -5.12;
	double problemUpperBound = 5.12;
	
	double[][] bounds = new double[problemDimension][2];
	
	for (int i = 0; i < problemDimension; i++)
	{
			bounds[i][0] = problemLowerBound;	
			bounds[i][1]= problemUpperBound;	
	}

			
			double[] particle = new double[problemDimension];
			double[] finalBest = new double[problemDimension];
			double fParticle; 			int i = 0;
			
				
			for (int l = 0; l < problemDimension; l++)
			{
				particle[l] = Math.random() * (bounds[l][1] - bounds[l][0]) + bounds[l][0];
			}	
			fParticle = MiscMethods.f(particle);
			i++;		
			
		double[] step = new double[problemDimension]; 		double[] NewStep = new double[problemDimension]; 		double[] xTrial = Arrays.copyOf (particle, particle.length); 		double xTrialOld; 		double fxTrial; 		double oldfxTrial; 		double OldFitness = fParticle; 		
				for (int k = 0; k < problemDimension; k++){	
			NewStep[k] = a * (bounds[k][1]-bounds[k][0]);
			}
		
				while (i < maxEvaluations){
		
						for (int t = 0; t < problemDimension; t++){	
				step[t] = NewStep[t];
				}	
				
						for (int j = 0; j < problemDimension; j++){ 		
				
								oldfxTrial = fParticle;
								xTrialOld = particle[j];
				
								xTrial[j] = particle[j]-step[j]; 		
								xTrial = MiscMethods.saturate(xTrial, bounds); 
				
								fxTrial = MiscMethods.f(xTrial);
				i++; 			
								if (fxTrial <= fParticle){
					particle[j] = xTrial[j];
					fParticle = fxTrial; 				}
				
								else{		

					xTrial[j] = xTrialOld;
					fParticle = oldfxTrial;					
										xTrial[j] = particle[j] + (step[j] * 0.5);
										xTrial = MiscMethods.saturate(xTrial, bounds);
							
										fxTrial = MiscMethods.f(xTrial);
					i++; 					
										if (fxTrial <= fParticle){
						particle[j] = xTrial[j];
						fParticle = fxTrial; 					}
					
										else{
						xTrial[j] = xTrialOld;
												particle[j] = xTrial[j];
						fParticle = oldfxTrial; 					}
				}
			}

						if (fParticle < OldFitness){
				OldFitness = fParticle;
			}
			
						else{
				for (int l = 0; l < problemDimension; l++){
				NewStep[l] = step[l] * 0.5;
				}
			}
		}
	
		finalBest = particle; 		
		System.out.println("S final fitness: " + fParticle);
	}	
}