package producto.model.repository;

import interfaces.IRepository;
import producto.model.entity.Producto;

import java.util.*;

public class ProductoRepository implements IRepository {
    Map<String,Producto> productoMap;

    public ProductoRepository() {
        productoMap = new HashMap<>();
    }

    @Override
    public void agregar(Object o) {
        if (o!=null&&o.getClass().equals(Producto.class)){
            if (this.productoMap.get(((Producto) o).getNombre())!=null)
                    this.productoMap.put(((Producto) o).getNombre(),(Producto)o);
        }
    }

    @Override
    public Object leer(String id) {
        Set<Map.Entry<String,Producto>> set = this.productoMap.entrySet();
        for (Map.Entry<String,Producto> entry:set)
        {
            if (entry.getValue().getNombre().equals(id)) return entry.getValue();
        }
        return null;
    }

    @Override
    public void actualizar(String id, Object o) {
        if (
                o!=null
                && o.getClass().equals(Producto.class)
        ){
            Set<Map.Entry<String,Producto>> set = this.productoMap.entrySet();
            for(Map.Entry<String,Producto> entry:set){
                if (entry.getValue().getNombre().equals(id)){
                    entry.setValue((Producto) o);
                    break;
                }
            }
        }
    }

    @Override
    public boolean remover(String id) {
        return this.productoMap.remove(id) != null;
    }

    public String getProductos(){
        String ans = "";
        Set<Map.Entry<String, Producto>> set = this.productoMap.entrySet();
        for (Map.Entry<String, Producto> entry:set){
            ans+=entry.getValue().toString()+"\n";
        }
        return ans;
    }
}
