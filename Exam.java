
/**
 * @author Ole Reichhelm
 * @version 1.0
 */
public class Exam
{
    private int examNumber; 
    private String[] students; 
    private double[] grades;
    
    public Exam(int initExamNumber, int initNumberOfExaminee){
        examNumber = initExamNumber;
        students = new String[initNumberOfExaminee];
        grades = new double[initNumberOfExaminee]; 
    }
    
    public void setExamNumber(int n){
        examNumber = n; 
    }
    
    public int getExamNumber(){
        return examNumber; 
    }
    
    public void addStudent(String name){
        boolean freeSpaceFound = false; 
        if (students[students.length - 1] != null){
            System.out.print("Keine weiteren Prüfungsplätze vorhanden");
        }
        for (int i = 0; i < students.length && !freeSpaceFound; i++){
            if(students[i] == null){
                students[i] = name; 
                freeSpaceFound = true; 
            }
        }
    }
    
    public void printStudents(){
        for(String student: students){
            if(student != null){
                System.out.println(student);
            }
        }
    }
    
    public void setStudentGrade(String name, double grade){
    boolean studentFound = false; 
    for(int i = 0; i < grades.length && !studentFound; i++){
        if(name.equals(students[i])){ //equals
            grades[i] = grade; 
            studentFound = true; 
        }
    }
    if(!studentFound){
            System.out.println("Kein Student mit diesem Namen gefunden");
        }
    }
     
    public double meanGrade(){
        double addedGrade = 0, numberOfGrades = 0;
        for (int i = 0; i < students.length; i++){
            if(students[i] != null){
                addedGrade = addedGrade + grades[i]; 
                numberOfGrades++;
            }
        }
        return addedGrade / numberOfGrades; 
    }
     
    public double bestGrade(){
        double bestGrade = 6; 
        for(double grade: grades){
            if(grade != 0 && Double.compare(grade, bestGrade) == -1){
                bestGrade = grade; 
            }
        }
        return bestGrade; 
    }
    
    public String[] studentsWithGrade(double grade){
        String[] studentsWithGrade = new String[amountOfGrades(grade)];
        int j = 0, k = 0;
        while(k < students.length){
            if(students[k] != null && Double.compare(grades[k], grade) == 0){
                studentsWithGrade[j] = students[k];
                j++;
            }
            k++; 
        }
        return studentsWithGrade;
    }
    
    private int amountOfGrades(double grade){
        int amountOfGrades = 0; 
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && Double.compare(grades[i], grade) == 0){
                amountOfGrades++;
            }
        }
        return amountOfGrades; 
    }
    
    public void bestStudents(){
        double bestGrade = bestGrade(); 
        for (String bestStudents: studentsWithGrade(bestGrade)){
            System.out.println(bestStudents);
        }
    }
     
    public void printStudentsWithGrades(){
        for(int i = 0; i < students.length; i++){
            if(grades[i] != 0){
                if(Double.compare(0.9, grades[i]) == -1 && Double.compare(grades[i], 1.6) == -1){
                    System.out.println("sehr gut: " + students[i]);
                } else if(Double.compare(1.5, grades[i]) == -1 && Double.compare(grades[i], 2.6) == -1){
                    System.out.println("gut: " + students[i]);
                } else if(Double.compare(2.5, grades[i]) == -1 && Double.compare(grades[i], 3.6) == -1){
                    System.out.println("befriedigend: " + students[i]);
                } else if(Double.compare(3.5, grades[i]) == -1 && Double.compare(grades[i], 4.1) == -1){
                    System.out.println("ausreichend: " + students[i]);
                } else{
                    System.out.println("mangelhaft: " + students[i]);
                }
            }
        }
    }
}
