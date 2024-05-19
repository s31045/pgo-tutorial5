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
}
