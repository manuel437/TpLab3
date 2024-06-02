package producto.view;

import categoria.model.entity.Categoria;
import producto.model.entity.Producto;

import java.util.Scanner;

public class ProductoView {
    private final Scanner scanner = new Scanner(System.in);
    public Producto generarProducto(Categoria categoria){
        Producto ans=new Producto();
        String nombre;
        System.out.println("Producto: nombre");
        nombre= scanner.nextLine();
        ans.setNombre(nombre);
        ans.setCategoria(categoria);
        return ans;
    }

    public void mostrarProductos(String productos){
        System.out.println(productos);
    }

    public String generarIdProducto(){
        System.out.println("Ingresar id del producto:");
        return scanner.nextLine();
    }
}
