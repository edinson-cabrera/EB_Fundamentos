package upc.edu.examenfinal.hospedaje.command.application.infra;

import javax.persistence.Column;
import javax.persistence.Id;

public class Hospedaje {
    @Id
    @Column(length=25)
    public String text;
    public String userId;

    public Hospedaje(){

    }
    public Hospedaje(String text, String userId){
        this.text = text;
        this.userId = userId;
    }
}
