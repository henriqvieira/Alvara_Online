/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Irla Silva
 */
public class Atividade {
    private String secao; //A, B, C
    private int divisao; //01...03
    private String denominacao; //industria, comercio
    

    public Atividade(String secao, int divisao, String denominacao) {
        this.secao = secao;
        this.divisao = divisao;
        this.denominacao = denominacao;
    }
    
    public Atividade(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public int getDivisao() {
        return divisao;
    }

    public void setDivisao(int divisao) {
        this.divisao = divisao;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }
    
    public List<Atividade> list() {
        List<Atividade> atividades = new LinkedList<Atividade>();
        atividades.add(new Atividade("industria"));
        atividades.add(new Atividade("comercio"));
        return atividades;
    }
}
