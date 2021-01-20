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
public class AlunoTurma {

    private int id;
    private Turma idTurma;
    private String nomeTurma, nomeAluno;
    private Aluno idAluno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String toString() {
        return "AlunoTurma{" + "id=" + id + ", idTurma=" + idTurma + ", nomeTurma=" + nomeTurma + ", nomeAluno=" + nomeAluno + ", idAluno=" + idAluno + '}';
    }

   

    
}
