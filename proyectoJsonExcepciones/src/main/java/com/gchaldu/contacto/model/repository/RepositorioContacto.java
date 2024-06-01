package com.gchaldu.contacto.model.repository;
import com.gchaldu.contacto.model.entity.Contacto;
import com.gchaldu.interfaces.IRepository;

import java.util.Map;
import java.util.Set;

public class RepositorioContacto implements IRepository {
    private Map<String, Contacto> map;

    public Map<String, Contacto> getMap() {
        return map;
    }

    @Override
    public void agregar(Object o) {
        if (o!=null&&
        o.getClass().equals(Contacto.class))
            this.map.put(((Contacto) o).getTelefono(),(Contacto)o);
    }
    @Override
    public Object leer(String id) {
        return this.map.get(id);
    }

    @Override
    public void actualizar(String id, Object o) {
        Contacto contacto = this.map.get(id);
        if (contacto!=null){
            contacto = (Contacto)o;
        }
    }

    @Override
    public void remover(String id) {
        this.map.remove(id);
    }
}
