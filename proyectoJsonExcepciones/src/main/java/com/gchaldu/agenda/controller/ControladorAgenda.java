package com.gchaldu.agenda.controller;

import com.gchaldu.agenda.view.ViewAgenda;
import com.gchaldu.contacto.controller.ControladorContacto;

public class ControladorAgenda {
    private ControladorContacto controladorContacto;
    private ViewAgenda viewAgenda;

    public ControladorAgenda(ControladorContacto controladorContacto, ViewAgenda viewAgenda) {
        this.controladorContacto = controladorContacto;
        this.viewAgenda = viewAgenda;
    }

    public ControladorContacto getControladorContacto() {
        return controladorContacto;
    }

    public ViewAgenda getViewAgenda() {
        return viewAgenda;
    }
}
