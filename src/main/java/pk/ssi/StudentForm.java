package pk.ssi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentForm {
	
    private String imie;
    private String nazwisko;
    private String uczelnia;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id = -1;

    public StudentForm(){}

    public StudentForm(int id, String imie, String nazwisko, String uczelnia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.uczelnia = uczelnia;
        this.id = id;
    }
    
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getUczelnia() {
        return uczelnia;
    }

    public void setUczelnia(String uczelnia) {
        this.uczelnia = uczelnia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
