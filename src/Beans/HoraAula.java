/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Felipe
 */
public class HoraAula {
    private int id;
    private String horaAula;

    public HoraAula(int id, String horaAula) {
        this.id = id;
        this.horaAula = horaAula;
    }

    public HoraAula() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(String horaAula) {
        this.horaAula = horaAula;
    }

    @Override
    public String toString() {
        return horaAula ;
    }
    
    
    
}
