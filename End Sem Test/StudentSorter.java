import java.util.ArrayList;
import java.util.Collections;

public class StudentSorter {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList to store student names
        ArrayList<String> studentNames = new ArrayList<>();

        // Step 2: Add student names to the list
        studentNames.add("Ravi");
        studentNames.add("Anjali");
        studentNames.add("Zoya");
        studentNames.add("Manish");
        studentNames.add("Bhavna");

        // Step 3: Sort the list alphabetically
        Collections.sort(studentNames);

        // Step 4: Print the sorted list
        System.out.println("Sorted Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
