import java.util.ArrayList;
import java.util.Collections;

public class StudentManagerApp {

    static class EmptyListException extends Exception {
        public EmptyListException(String message) {
            super(message);
        }
    }

    static class StudentListManager {

        private ArrayList<String> studentNames;

        public StudentListManager() {
            studentNames = new ArrayList<>();
        }

        public void addName(String name) {
            studentNames.add(name);
            System.out.println("Adding name: " + name);
        }

        public void removeName(String name) {
            System.out.println("\nRemoving " + name + "...");
            boolean isRemoved = studentNames.remove(name);
            if (!isRemoved) {
                System.out.println("Could not find " + name + " in the list.");
            }
        }

        public void displaySortedNames() throws EmptyListException {
            if (studentNames.isEmpty()) {
                throw new EmptyListException("Error: Student list is empty!");
            }

            Collections.sort(studentNames);
            System.out.println("Sorted names: " + studentNames);
        }
    }

    public static void main(String[] args) {
        StudentListManager manager = new StudentListManager();

        manager.addName("Priya");
        manager.addName("Rohan");
        manager.addName("Anjali");
        System.out.println();

        try {
            manager.displaySortedNames();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }

        manager.removeName("Rohan");
        try {
            manager.displaySortedNames();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }

        manager.removeName("Priya");
        manager.removeName("Anjali");

        System.out.println("\nAttempting to display empty list...");
        try {
            manager.displaySortedNames();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
}

