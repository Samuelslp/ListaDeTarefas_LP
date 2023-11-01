package com.listadetarefa;

public class Tarefa {
    private String nomeTarefa;

    public Tarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    @Override
    public String toString() {
        return "TAREFA: " + nomeTarefa;
    }
}
