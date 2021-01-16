package sample;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class CricketPlayer implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean isSelected = false;
    private String name;
    private String jerseyNumber;
    private String salary;
    private String p_Address;
    private String f_Position;

    public CricketPlayer(String name, String number, String salary, String Address , String Pos){
        this.name=name;
        this.jerseyNumber=number;
        this.salary=salary;
        this.p_Address=Address;
        this.f_Position=Pos;
    }

    public String getName() {
        return name;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public String getSalary() {
        return salary;

    }
    public String getP_Address() {
        return p_Address;
    }

    public String getF_Position() {
        return f_Position;
    }

    public boolean isSelected(){return isSelected;}
    public void setSelected(Boolean arg){this.isSelected=arg;}
}
