
/**
 * @author Ole Reichhelm
 * @version 1.0
 */
public class Exams
{
    private Exam[] examSafe = new Exam[10];
    
    public Exams()
    {
        for(int i = 0; i < 5; i++){ 
            examSafe[i] = new Exam(i + 1, 10);
        }
    }

    public Exam getExamByIndex(int n){
        Exam desiredExam = null; 
        if(0 <= n && n < examSafe.length){
            desiredExam = examSafe[n];
        }
        return desiredExam; 
    }
     
    public void printExams(){
        for(int i = 0; i < examSafe.length; i++){
            if(examSafe[i] != null){
                System.out.println("Klausur Nr." + examSafe[i].getExamNumber()); 
                System.out.print("Durschnittsnote: ");
                if(Double.isNaN(examSafe[i].meanGrade())){
                    System.out.println("In diesem Exam sind noch keine Noten vorhanden");
                } else {
                    System.out.println(examSafe[i].meanGrade());
                }
                System.out.println(" ");
            }
        }
    }
    
    public void addExam(Exam addedExam){
       boolean spotFound = false; 
       for(int i = 0; i < examSafe.length && !spotFound; i++){
           if(examSafe[i] == null){
               examSafe[i] = addedExam;
               spotFound = true; 
           }
       }
       if(!spotFound){
           System.out.println("Es können keine weiteren Prüfungsergebnisse erfasst werden!");
       }
    }
    
    /**
     * Annahme: Der User entfernt eine Klausur anhand der "examNumber" des Objekts und nicht anhand des Indexes. 
     * Dem User ist die Reihenfolge der Klausuren ggf. nicht bekannt. 
    **/
    public void removeExam(int desiredExam){
        boolean itemfound = false;
        for(int i = 0; i < examSafe.length; i++){
            if(examSafe[i] != null && examSafe[i].getExamNumber() == desiredExam){
                examSafe[i] = null;
                itemfound = true;
            }
        }
        if(itemfound == false){
            System.out.println("Das angegebenen Examen existiert nicht und kann somit nicht gelöscht werden");
        }
    }
}
