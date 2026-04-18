import java.util.ArrayList;


public class Scheduler{

  private Course[] possibleCourses;     private ArrayList<Schedule> possibleSchedules = new ArrayList<Schedule>();
  public static final int MAX_COURSES = 5; 
  
  public Scheduler(Course[] possibleCourses){
    this.possibleCourses = possibleCourses;
    generateSchedules();
  }

  
  private boolean checkConflicts(Course thisCourse, Course otherCourse){
    int[] thisTimeslots = thisCourse.getTimeslots();
    int[] otherTimeslots = otherCourse.getTimeslots();

        for(int i = 0; i < thisTimeslots.length; i += 2){
      for(int j = 0; j < otherTimeslots.length; j += 2){
        if(thisTimeslots[i] <= otherTimeslots[i + 1] &&
          thisTimeslots[i + 1] > otherTimeslots[j]) return true;
        else if(otherTimeslots[j] <= thisTimeslots[i] &&
          otherTimeslots[j + 1] > thisTimeslots[i]) return true;
      }
    }

    return false;
  }

  
  private void generateSchedules(){
    ArrayList<Course> chosen = new ArrayList<Course>();

    generateScheduleHelper(chosen, 0, false);
  }

  
  private void generateScheduleHelper(ArrayList<Course> chosen, int currIndex,
                                      boolean courseAdded){

                    if(courseAdded) possibleSchedules.add(new Schedule(chosen));

        if(currIndex == possibleCourses.length) return;
    else if(chosen.size() == MAX_COURSES) return;

        generateScheduleHelper(chosen, currIndex + 1, false);

        for(int i = 0; i < chosen.size(); i++){

                if(checkConflicts(chosen.get(i), possibleCourses[currIndex])) break;

                else if(i == chosen.size() - 1) {
          chosen.add(possibleCourses[currIndex]);
          generateScheduleHelper(chosen, currIndex + 1, true);
        }
    }
  }
}