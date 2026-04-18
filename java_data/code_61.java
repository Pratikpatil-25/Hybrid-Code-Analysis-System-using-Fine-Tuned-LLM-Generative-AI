import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RR implements Algorithm {
    private Queue<Task> taskQueue;
    private int timeQuantum;

        public RR(List<Task> queue, int timeQuantum) {
        this.taskQueue = new LinkedList<>(queue);
        this.timeQuantum = timeQuantum;
    }

    @Override
    public void schedule() {
        while (!taskQueue.isEmpty()) {
            Task task = pickNextTask();
            if (task != null) {
                runTask(task);
            }
        }
    }

    private void runTask(Task task) {
        int burstTime = task.getBurst();
        if (burstTime > timeQuantum) {
                        CPU.run(task, timeQuantum);
            task.setBurst(burstTime - timeQuantum);
            taskQueue.add(task);
        } else {
                        CPU.run(task, burstTime);
            System.out.println("Task finished: " + task.getName() + "\n");
        }
    }

    @Override
    public Task pickNextTask() {
        return taskQueue.poll();
    }
}