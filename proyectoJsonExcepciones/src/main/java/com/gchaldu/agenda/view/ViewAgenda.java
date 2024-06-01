package com.gchaldu.agenda.view;

import com.gchaldu.agenda.model.entity.Agenda;

import java.util.Scanner;

public class ViewAgenda {
    private final Scanner scanner = new Scanner(System.in);

    public ViewAgenda() {
    }
    public Agenda generarAgenda(){
        return new Agenda();
    }
}
