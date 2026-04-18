import java.util.List;

public class RR implements Algorithm {
    private List<Task> queue;
    private Task currentTask;

    private int tasksRun;
    private int nextTaskIndex;

    private final int quantum = 10; 
    public RR(List<Task> queue) {
        this.queue = queue;
        this.tasksRun = queue.size();
    }

    public void schedule() {
        System.out.println("RR Scheduling \n");

        nextTaskIndex = 0;

                while (!queue.isEmpty()) {
                        currentTask = pickNextTask();

                        CPU.run(currentTask, Math.min(quantum, currentTask.getBurst()));

                        currentTask.setBurst(currentTask.getBurst() - Math.min(quantum, currentTask.getBurst()));

                        if (currentTask.getBurst() <= 0) {
                System.out.println("Task " + currentTask.getName() + " finished.\n");
                queue.remove(currentTask);
                nextTaskIndex--;
            }

                        nextTaskIndex++;
            if (!queue.isEmpty()) {
                nextTaskIndex = nextTaskIndex % queue.size();
            }
        }
    }

    public Task pickNextTask() {
                return queue.get(nextTaskIndex);
    }
}