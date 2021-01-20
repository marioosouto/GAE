/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Mario Souto
 */
public class Turma {

    private String nometurma;
    private int idturma, idaluno;
    private Instrutor instrutor;
    private Sala salaafk;

    public Sala getSalaafk() {
        return salaafk;
    }

    public void setSalaafk(Sala salaafk) {
        this.salaafk = salaafk;
    }
    

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public String getNometurma() {
        return nometurma;
    }

    public void setNometurma(String nometurma) {
        this.nometurma = nometurma;
    }

    public int getIdturma() {
        return idturma;
    }

    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    @Override
    public String toString() {
        return this.nometurma;
    }


}
