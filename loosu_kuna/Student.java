
public class Student {
    // Instance variables for student name and quiz scores
    private String name;
    private double[] quizScores;
    
    /**
     * Constructor for Student objects
     * @param name The student's name
     * @param quizScores The student's quiz scores (should be 5)
     */
    public Student(String name, double[] quizScores) {
        this.name = name;
        this.quizScores = new double[5];
        
        // Copy provided quiz scores, or use defaults if not enough are provided
        for (int i = 0; i < 5; i++) {
            if (quizScores != null && i < quizScores.length) {
                this.quizScores[i] = quizScores[i];
            } else {
                this.quizScores[i] = 0.0;
            }
        }
    }
    
    /**
     * Get a specific quiz score
     * @param quizNumber The quiz number (1-5)
     * @return The score for the specified quiz
     */
    public double getQuizScore(int quizNumber) {
        if (quizNumber >= 1 && quizNumber <= 5) {
            return quizScores[quizNumber - 1];
        } else {
            return -1.0; // Invalid quiz number
        }
    }
    
    /**
     * Set a specific quiz score
     * @param quizNumber The quiz number (1-5)
     * @param newScore The new quiz score
     */
    public void setQuizScore(int quizNumber, double newScore) {
        if (quizNumber >= 1 && quizNumber <= 5) {
            quizScores[quizNumber - 1] = newScore;
        }
    }
    
    /**
     * Get the student's name
     * @return The student's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the student's name
     * @param name The new name for the student
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns a string representation of the student
     * @return A string containing the student's name and quiz scores
     */
    @Override
    public String toString() {
        return String.format("%-15s %-5.0f %-5.0f %-5.0f %-5.0f %-5.0f", 
                             name, 
                             quizScores[0], 
                             quizScores[1], 
                             quizScores[2], 
                             quizScores[3], 
                             quizScores[4]);
    }
}