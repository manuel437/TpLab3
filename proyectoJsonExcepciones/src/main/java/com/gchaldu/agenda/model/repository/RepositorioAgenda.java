package com.gchaldu.agenda.model.repository;

import com.gchaldu.agenda.model.entity.Agenda;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAgenda {
    private List<Agenda> list;

    public RepositorioAgenda() {
        this.list = new ArrayList<>();
    }

    public List<Agenda> getList() {
        return list;
    }
}
