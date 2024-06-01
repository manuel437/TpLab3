package com.gchaldu.agenda.model.entity;
import com.gchaldu.contacto.model.entity.Contacto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agenda {
    private Map<String, Contacto> map;

    public Agenda() {
        this.map=new HashMap<>();
    }

    public void agregarContacto(Contacto contacto){
        this.map.put(contacto.getTelefono(), contacto);
    }

    public Contacto leerContacto(String telefono){
        return  this.map.get(telefono);
    }

    public void actualizarContacto(String telefono, Contacto contacto){
        this.map.replace(telefono, contacto);
    }
    public Contacto removerContacto(String telefono){
        return this.map.remove(telefono);
    }
}