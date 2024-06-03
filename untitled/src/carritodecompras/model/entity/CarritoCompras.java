package carritodecompras.model.entity;

import categoria.model.entity.Categoria;
import producto.model.entity.Producto;

import java.util.*;

public class CarritoCompras {
    private List<Producto> lista;
    private Set<Categoria> categorias;
    private static Integer cantidadCarritos = 0;
    private final String id;

    public CarritoCompras() {
        this.lista=new ArrayList<>();
        this.id= String.valueOf(++cantidadCarritos);
        this.categorias = new HashSet<>();
    }

    public List<Producto> getLista() {
        return lista;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public String getId() {
        return id;
    }

    public void agregarProducto(Producto producto){
        for (Producto producto1:this.lista)
        {
            if (producto1.getNombre().equals(producto.getNombre()))
                return;
        }
        this.lista.add(producto);
    }

    public void agregarCategoria(Categoria categoria){
        for (Categoria categoria1:this.getCategorias()){
            if (categoria1.getNombre().equals(categoria.getNombre()))return;
        }
        this.getCategorias().add(categoria);
    }

    public Producto leerProducto(String id){
        for (Producto producto1:this.lista)
            if (id.equals(String.valueOf(producto1.getId()))) return producto1;
        return null;
    }

    public boolean removerProducto(Producto producto){
        return this.getLista().remove(producto);
    }

    public String listarCategorias(){
        String ans = "Aún no hay productos\n";
        if (this.categorias.isEmpty()) return ans;
        else{
            ans = "";
            for (Categoria categoria:this.categorias)
                ans+=categoria.getNombre()+", id "+
                        categoria.getId()+".\n";
        }
        return ans;
    }

    @Override
    public String toString() {
        return "CARRO "+this.getId()+"\nCategorías:\n" + this.listarCategorias()+
                "cantidad de productos: " + this.lista.size()+
                ".";
    }

    public String mostrarContenido(){
        StringBuilder ans = new StringBuilder("No hay productos en el carrito.");
        if (this.getLista().isEmpty()) return ans.toString();
        ans = new StringBuilder();
        for (Categoria categoria : this.getCategorias()){
            ans.append(categoria.getNombre()).append(" (ID: ").append(categoria.getId()).append(")\n");
            for (Producto p:this.getLista()){
                if (p.getCategoria().getNombre().equals(categoria.getNombre())){
                    ans.append(p.getNombre()).append(", id ").append(p.getId()).append(".\n");
                }
            }
        }
        return ans.toString();
    }

    public void actualizarCarrito(){
        List<Categoria> eliminar = new ArrayList<>(this.getCategorias());
        int counter  = 0;
        for (Categoria c : this.getCategorias()){
            counter = 0;
            for (Producto p: this.getLista()){
                if (p.getCategoria().getNombre().equals(c.getNombre()))
                    counter++;
            }
            if (counter == 0) eliminar.add(c);
        }
        for (Categoria c:eliminar){
            this.getCategorias().remove(c);
        }
    }
}
