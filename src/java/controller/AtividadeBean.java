/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.annotation.ManagedBean;
import model.Atividade;

/**
 *
 * @author Irla Silva
 */
@ManagedBean
public class AtividadeBean {
    private List<Atividade> atividades;
    
    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    
    public List<Atividade> preencheAtividades(){
        this.atividades.add(new Atividade("A", 1, "industria"));
        this.atividades.add(new Atividade("B", 2, "comercio"));
        return atividades;
    }
}
