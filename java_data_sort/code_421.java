package practice.prac6.task2;

import java.util.Comparator;
import java.util.List;

public class SortingStudentsByGPA implements Comparator<Student> {

    public List<Student> sort(List<Student> std, int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;

        int pivot = std.get((leftMarker + rightMarker) / 2).getMark();
        do {
            while (compare(std.get((leftMarker + rightMarker) / 2), std.get(leftMarker)) == 1) {
                leftMarker++;
            }
            while (compare(std.get((leftMarker + rightMarker) / 2), std.get(rightMarker)) == -1) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    Student tmp = std.get(leftMarker);
                    std.set(leftMarker, std.get(rightMarker));
                    std.set(rightMarker, tmp);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            sort(std, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            sort(std, leftBorder, rightMarker);
        }

        return std;
    }


    @Override
    public int compare(Student o1, Student o2) {
        int mark1 = o1.getMark();
        int mark2 = o2.getMark();

        if(mark1 > mark2) return 1;
        if(mark1 < mark2) return -1;
        return 0;

    }
}