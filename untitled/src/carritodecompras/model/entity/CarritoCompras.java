package carritodecompras.model.entity;

import categoria.model.entity.Categoria;
import producto.model.entity.Producto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        this.categorias.add(producto.getCategoria());
    }

    public Producto leerProducto(String id){
        for (Producto producto1:this.lista)
            if (id.equals(String.valueOf(producto1.getId()))) return producto1;
        return null;
    }

    public boolean removerProducto(Producto producto){
        boolean ans = this.getLista().remove(producto);
        this.actualizarCarrito();
        return ans;
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
        String ans = "No hay productos en el carrito.\n";
        if (this.getLista().isEmpty()) return ans;
        ans = "";
        List<Producto> list = new ArrayList<>(this.lista);
        for (Categoria categoria : this.getCategorias()){
            ans+=categoria.getNombre()+", id "+categoria.getId()+"\n";
            for (Producto p:list){
                if (p.getCategoria().getNombre().equals(categoria.getNombre())){
                    ans+=p.getNombre()+", id "+p.getId()+".\n";
                }
            }
            System.out.println();
        }
        return ans;
    }

    public void actualizarCarrito(){
        int counter;
        for (Categoria categoria:this.getCategorias()){
            counter=0;
            for (Producto producto:this.getLista()){
                if (producto.getCategoria().getNombre().equals(categoria.getNombre())){
                    counter++;
                }
                if (counter==0){
                    this.getCategorias().remove(categoria);
                }
            }
        }
    }
}
