
import java.util.ArrayList;

public class GradeBookTester {
    
    public static void main(String[] args) {
        // Create an ArrayList to store students (allow for at least 12 students)
        ArrayList<Student> gradeBook = new ArrayList<Student>();
        
        // Add 5 initial students
        gradeBook.add(new Student("Joe", new double[]{70, 80, 90, 80, 90}));
        gradeBook.add(new Student("Sally", new double[]{80, 85, 90, 85, 80}));
        gradeBook.add(new Student("Billy", new double[]{50, 79, 80, 85, 99}));
        gradeBook.add(new Student("Ada", new double[]{85, 80, 85, 88, 89}));
        gradeBook.add(new Student("Jimmy", new double[]{70, 70, 90, 70, 80}));
        
        // Display initial grade book
        System.out.println("Starting Gradebook:");
        displayGradeBook(gradeBook);
        
        // Test replaceName method
        System.out.println("\nReplacing student name 'Joe' with 'Joseph':");
        replaceName(gradeBook, "Joe", "Joseph");
        displayGradeBook(gradeBook);
        
        // Test replaceQuizGrade method
        System.out.println("\nReplacing Sally's quiz 3 score with 95:");
        replaceQuizGrade(gradeBook, "Sally", 3, 95);
        displayGradeBook(gradeBook);
        
        // Test replaceStudent method
        System.out.println("\nReplacing 'Billy' with 'William' and new quiz scores:");
        double[] newScores = {65, 75, 85, 90, 95};
        replaceStudent(gradeBook, "Billy", "William", newScores);
        displayGradeBook(gradeBook);
        
        // Test insertStudent method
        System.out.println("\nInserting 'Lisa' before 'Ada':");
        double[] lisaScores = {90, 92, 88, 95, 91};
        insertStudent(gradeBook, "Ada", "Lisa", lisaScores);
        displayGradeBook(gradeBook);
        
        // Test deleteStudent method
        System.out.println("\nDeleting 'Jimmy' from the grade book:");
        deleteStudent(gradeBook, "Jimmy");
        displayGradeBook(gradeBook);
    }
    
    /**
     * Display all students in the grade book in a table format
     * @param gradeBook The ArrayList containing Student objects
     */
    public static void displayGradeBook(ArrayList<Student> gradeBook) {
        System.out.println("\nStudent name  Q1    Q2    Q3    Q4    Q5");
        System.out.println("-------------------------------------------");
        
        // Traverse through the data structure and print each element
        for (int i = 0; i < gradeBook.size(); i++) {
            Student student = gradeBook.get(i);
            if (student != null) {
                System.out.println(student);
            }
        }
    }
    
    /**
     * Replace a student's name with a new one
     * @param gradeBook The ArrayList containing Student objects
     * @param oldName The name to be replaced
     * @param newName The new name to use
     */
    public static void replaceName(ArrayList<Student> gradeBook, String oldName, String newName) {
        for (int i = 0; i < gradeBook.size(); i++) {
            Student student = gradeBook.get(i);
            if (student != null && student.getName().equals(oldName)) {
                student.setName(newName);
                return;
            }
        }
        System.out.println("Student '" + oldName + "' not found.");
    }
    
    /**
     * Replace a specific quiz grade for a student
     * @param gradeBook The ArrayList containing Student objects
     * @param name The name of the student
     * @param quizNumber The quiz number (1-5)
     * @param newScore The new quiz score
     */
    public static void replaceQuizGrade(ArrayList<Student> gradeBook, String name, int quizNumber, double newScore) {
        for (int i = 0; i < gradeBook.size(); i++) {
            Student student = gradeBook.get(i);
            if (student != null && student.getName().equals(name)) {
                student.setQuizScore(quizNumber, newScore);
                return;
            }
        }
        System.out.println("Student '" + name + "' not found.");
    }
    
    /**
     * Replace an entire student with a new one
     * @param gradeBook The ArrayList containing Student objects
     * @param oldName The name of the student to replace
     * @param newName The name of the new student
     * @param newScores The quiz scores for the new student
     */
    public static void replaceStudent(ArrayList<Student> gradeBook, String oldName, String newName, double[] newScores) {
        for (int i = 0; i < gradeBook.size(); i++) {
            Student student = gradeBook.get(i);
            if (student != null && student.getName().equals(oldName)) {
                gradeBook.set(i, new Student(newName, newScores));
                return;
            }
        }
        System.out.println("Student '" + oldName + "' not found.");
    }
    
    /**
     * Insert a new student before another student in the grade book
     * @param gradeBook The ArrayList containing Student objects
     * @param beforeName The name of the student before whom to insert
     * @param newName The name of the new student
     * @param newScores The quiz scores for the new student
     */
    public static void insertStudent(ArrayList<Student> gradeBook, String beforeName, String newName, double[] newScores) {
        for (int i = 0; i < gradeBook.size(); i++) {
            Student student = gradeBook.get(i);
            if (student != null && student.getName().equals(beforeName)) {
                gradeBook.add(i, new Student(newName, newScores));
                return;
            }
        }
        // If student not found, add to the end
        System.out.println("Student '" + beforeName + "' not found. Adding to the end of the list.");
        gradeBook.add(new Student(newName, newScores));
    }
    
    /**
     * Delete a student from the grade book
     * @param gradeBook The ArrayList containing Student objects
     * @param name The name of the student to delete
     */
    public static void deleteStudent(ArrayList<Student> gradeBook, String name) {
        for (int i = 0; i < gradeBook.size(); i++) {
            Student student = gradeBook.get(i);
            if (student != null && student.getName().equals(name)) {
                gradeBook.remove(i);
                return;
            }
        }
        System.out.println("Student '" + name + "' not found.");
    }
}