package cnuphys.advisors.checklist.steps;

import java.util.List;

import cnuphys.advisors.Advisor;
import cnuphys.advisors.Person;
import cnuphys.advisors.Student;
import cnuphys.advisors.checklist.CheckListLaunchable;
import cnuphys.advisors.frame.AdvisorAssign;
import cnuphys.advisors.model.AdvisorData;
import cnuphys.advisors.model.DataManager;
import cnuphys.advisors.simulation.AdvisorSimulation;

public class HonorsAlgorithmStep extends CheckListLaunchable {

	public HonorsAlgorithmStep(String info, boolean enabled) {
		super("Honors Algorithm", info, enabled);
	}

	@Override
	public void launch() {
				
						AdvisorData advisorData = DataManager.getFilteredAdvisorData(Person.HONOR);
		List<Advisor> advisors = advisorData.getAdvisors();
		advisors.removeIf(x -> x.locked());

		List<Student> students = DataManager.getUnassignedHonorsStudents();

		Algorithm.runAlgorithm(students, advisors);

		try {
			AdvisorSimulation.getInstance().getSimThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		System.out.println("Honors algorithm complete");

				for (Student student : students) {
			student.setLocked();
		}

				int target = AdvisorAssign.targetAverage();
		for (Advisor advisor : advisors) {
			if ((advisor.adviseeCount() >= target) || (advisor == DataManager.honorsDirector)) {
				advisor.setLocked();
			}
		}
	}

}