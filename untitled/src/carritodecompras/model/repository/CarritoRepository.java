package carritodecompras.model.repository;
import carritodecompras.model.entity.CarritoCompras;
import interfaces.IRepository;
import producto.model.entity.Producto;

import java.util.*;

public class CarritoRepository implements IRepository {
    private Map<String,CarritoCompras> list;
    public CarritoRepository() {
        this.list = new HashMap<>();
    }

    public Map<String, CarritoCompras> getList() {
        return list;
    }

    @Override
    public void agregar(Object o) {
        if (o!=null&&
        o.getClass().equals(CarritoCompras.class)&&
        this.list.get(o)==null){
            this.list.put(((CarritoCompras) o).getId(), (CarritoCompras) o);
        }
    }
    @Override
    public Object leer(String id) {
        Set<Map.Entry<String,CarritoCompras>> set=this.list.entrySet();
        for (Map.Entry<String,CarritoCompras> entry:set){
            if (entry.getValue().getId().equals(id))
                return entry.getValue();
        }
        return null;
    }
    @Override
    public void actualizar(String id, Object o) {
        if (o!=null&&
                o.getClass().equals(CarritoCompras.class)&&
                this.list.get(o)==null)
        {
            Set<Map.Entry<String,CarritoCompras>> set=this.list.entrySet();
            for (Map.Entry<String,CarritoCompras> entry:set){
                if (entry.getValue().getId().equals(id))
                    entry.setValue((CarritoCompras) o);
            }
        }
    }
    @Override
    public boolean remover(String id) {
        return this.list.remove(id) != null;
    }
}