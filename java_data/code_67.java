package GA;





public class GA {



    public void Analysis_DNA(String DNAs) {



        
        FitnessCalc.setSolntn(DNAs);



        
        Population myPop = new Population(50, true);



        
        int generationCount = 0;

        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {

            if (generationCount == 0) {

                generationCount++;

                System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());

                myPop = Algorithm.evolvePopulation(myPop);

            }

            break;

        }

        System.out.println("Solution found!");

        System.out.println("Generation: " + generationCount);

        System.out.println("Genes:");

        System.out.println(myPop.getFittest());



    }

}