import java.util.*;

public class RR implements Algorithm {
    List<Task> tasks;
    int timeQuantum;
    public RR(List<Task> queue){
        tasks = queue; 
    }
    public void schedule(){
        while (!tasks.isEmpty()){
        pickNextTask();
        tasks.remove(0);
        }
    }
    public Task pickNextTask(){
        CPU.run(tasks.get(0), tasks.get(0).getBurst());
        if (tasks.get(0).getBurst() < 10){
            timeQuantum = tasks.get(0).getBurst();
        }
        else {
            timeQuantum = 10;
        }
        tasks.get(0).setBurst(tasks.get(0).getBurst() - timeQuantum);
        if (tasks.get(0).getBurst() == 0){
            System.out.println("Task " + tasks.get(0).getName() + " finished\n");
            
        }else{
            tasks.add(tasks.get(0));
        }
        
        return tasks.get(0);
    }
}