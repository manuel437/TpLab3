package carritodecompras.view;

import carritodecompras.model.entity.CarritoCompras;
import producto.model.entity.Producto;

import java.util.Scanner;

public class CarritoView {
    private static final Scanner scanner = new Scanner(System.in);
    public CarritoCompras generarCarrito(){
        return new CarritoCompras();
    }
    public String generarIdCarrito(){
        System.out.println("Se solicita ingreso del identificador del carrito: ");
        return scanner.nextLine();
    }
    public void carritoNoEncontrado(String id){
        System.out.println("No se ha encontrado carrito de id: " + id+".");
    }
    public boolean helper(){
        System.out.println("Agregar/Remover producto del carrito: ");
        String s;
        do {
            System.out.println("1: agregar");
            System.out.println("2: remover");
            s=scanner.nextLine();
            if (s.charAt(0) != '1' && s.charAt(0) != '2')
                System.out.println("Dato inválido. Reintentar:");
        } while (s.charAt(0) != '1' && s.charAt(0) != '2') ;
        return s.charAt(0)=='1';
    }

    public void avisoCreacionProducto(){
        System.out.println("Creando producto:");
    }

    public void avisoEliminacionProducto(){
        System.out.println("Eliminación de producto.");
    }

    public void avisoProductoEliminado(Producto producto){
        System.out.println("Producto:  "+producto.getNombre()+" eliminado correctamente...");
    }

    public void avisoNoExisteProducto(String id ){
        System.out.println("No existe producto de id " + id+".");
    }

    public void mostrarContenidoCarrito(CarritoCompras carritoCompras){
        System.out.println(carritoCompras.mostrarContenido());
    }
}
