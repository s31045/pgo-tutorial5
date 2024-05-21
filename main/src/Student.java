import java.util.ArrayList;
import java.util.Date;

public class Student {
    public String imie;
    public String nazwisko;
    public String email;
    public String adres;
    public String telefon;
    public String index;
    public String status;

    public Date dataUrodzenia;
    public ArrayList<Grade> oceny = new ArrayList<Grade>();

     static ArrayList<Student> studenci = new ArrayList();
    StudyProgramme program;

    public int semestr = 0;
    static int count = 0;

    public Student(String imie,String nazwisko, String email,String adres,String telefon, Date dataUrodzenia){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.adres = adres;
        this.telefon = telefon;
        this.dataUrodzenia = dataUrodzenia;
        this.index = generateIndex();
        this.status = getStatus();
    }

    private String generateIndex(){
        return "s" + count;
    }


    private String getStatus(){
        if(semestr == 0){
            return "Kandydat";
        }else if(semestr > 0){
            return "Student";
        }else if(semestr >= 7){
            return "Absolwent";
        }else{
            return "";
        }
    }

    public void addGrade(int ocena,String Przedmiot){
        Grade o = new Grade(ocena, Przedmiot);
        oceny.add(o);
    }

    public static void addStudent(Student student){
        studenci.add(student);
    }

    public void enrollStudent(StudyProgramme Program){
        program = Program;
    }

    public int getNumberOfITN(){
        int count = 0;

        for(int i = 0; i< oceny.size(); i++){
            if(oceny.get(i).oceny == 2){
                count++;
            }
        }
        return count;
    }

    public static void promoteAllStudents(){
        for(int i = 0; i <studenci.size(); i++){
            Student student = studenci.get(i);

            if(student.getNumberOfITN() < student.program.ITN && student.status != "Graduate"){
                student.semestr++;
            }else{
                System.out.println("Student nie może być promowany.");
                return;
            }
        }

    }

    public static void displayInfoAboutAllStudents(){
        for(int i = 0; i < studenci.size(); i++){
            Student student = studenci.get(i);
            System.out.println(student.imie + " "+ student.nazwisko + " - " + student.semestr);
        }

    }

}
