import java.util.ArrayList;

public class PC {

    public static void main(String[] args) {
        
        final Process[] processes = {
                                new Process(0, 10, 23),
                new Process(0, 5, 30),
                new Process(0, 2, 9),
                new Process(1, 3, 11),

        };

        final int[] availableBlockSizes = {9, 40, 23};         MemoryAllocationAlgorithm algorithm = new NextFit(availableBlockSizes);
        MMU mmu = new MMU(availableBlockSizes, algorithm);
        Scheduler scheduler = new RoundRobin(1);
        CPU cpu = new CPU(scheduler, mmu, processes);
        cpu.run();

        for (Process p : processes) {
            if(!p.isDisable()) {
                System.out.println("ID-> " + p.getPCB().getPid());
                System.out.println("TurnAround Time = " + p.getTurnAroundTime());
                System.out.println("Response Time = " + p.getResponseTime());
                System.out.println("Waiting Time = " + p.getWaitingTime());
                System.out.println();
            }
        }


    }

}