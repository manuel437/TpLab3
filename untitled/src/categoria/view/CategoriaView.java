package categoria.view;

import categoria.model.entity.Categoria;

import java.util.Scanner;

public class CategoriaView {
    private final Scanner scanner = new Scanner(System.in);
    public Categoria generarCategoria(){
        String nombre;
        System.out.println("Ingresar categoría: nombre ");
        nombre=scanner.nextLine();
        return new Categoria(nombre);
    }
    public Categoria generarCategoria(String nombre){
        return new Categoria(nombre);
    }
    public String generarNombreCat(){
        System.out.println("Ingresar Categoría: nombre");
        return scanner.nextLine();
    }
}
