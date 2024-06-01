package com.gchaldu.contacto.controller;

import com.gchaldu.contacto.model.repository.RepositorioContacto;
import com.gchaldu.contacto.view.ViewContacto;

public class ControladorContacto {
    private ViewContacto viewContacto;
    private RepositorioContacto repositorioContacto;

    public ControladorContacto(ViewContacto viewContacto, RepositorioContacto repositorioContacto) {
        this.viewContacto = viewContacto;
        this.repositorioContacto = repositorioContacto;
    }

    public ViewContacto getViewContacto() {
        return viewContacto;
    }

    public RepositorioContacto getRepositorioContacto() {
        return repositorioContacto;
    }
}
