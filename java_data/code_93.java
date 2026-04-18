import java.util.*;

public class SJF {
        private static ArrayList<Process> processes;
    private static ArrayList<Process> executedProcesses;
    private static ArrayList<Integer> times;    private static int currentTime = 0;

        private static int waitingTimes = 0;
    private static int turnAroundTimes = 0;
    private static int time = 0;

    public SJF(ArrayList<Process> processes) {         SJF.processes = new ArrayList<Process>(processes);
        executedProcesses = new ArrayList<>();
        times = new ArrayList<>();
    }

    void runSJF() {
                processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        while (!processes.isEmpty()) {
            Process shortestJob = findShortestJob(currentTime);

            if (shortestJob == null) {
                currentTime++;
                continue;
            }

                        turnAroundTimes += currentTime - shortestJob.arrivalTime + shortestJob.burstTime;
            waitingTimes += currentTime - shortestJob.arrivalTime;

                        executedProcesses.add(shortestJob);
            processes.remove(shortestJob);
            times.add(currentTime);

            currentTime += shortestJob.burstTime;
            currentTime++; 
                        while (time <= currentTime - 1) {
                if (time == currentTime - 1 && currentTime - 1 > 0) {
                    System.out.println("At t = " + time + " - Context Switching");
                } else {
                    System.out.println("At t = " + time + " - Process ID: " + shortestJob.pid);
                }

                time++;
            }
        }
        System.out.println("-------");

        for (int i = 0; i < executedProcesses.size(); ++i) {
            Process currentProcess = executedProcesses.get(i);
            System.out.println("Executing process: " + currentProcess.pid +
                    " | Arrival Time: " + currentProcess.arrivalTime +
                    " | Burst Time: " + currentProcess.burstTime +
                    " | Waiting Time: " + (times.get(i) - currentProcess.arrivalTime));
        }

        System.out.println("-------");

                System.out.println("Average waiting time: " + (double) waitingTimes / executedProcesses.size());
        System.out.println("Average turnaround time: " + (double) turnAroundTimes / executedProcesses.size());
    }

        private Process findShortestJob(int currentTime) {
        Process shortestJob = null;
        for (Process process : processes) {
            if (process.arrivalTime <= currentTime) {
                if (shortestJob == null || process.burstTime < shortestJob.burstTime) {
                    shortestJob = process;
                }
            }
        }
        return shortestJob;
    }
}