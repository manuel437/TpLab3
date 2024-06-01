package com.gchaldu.contacto.view;

import com.gchaldu.contacto.model.entity.Contacto;

import java.util.Scanner;

public class ViewContacto {
    private final Scanner scanner = new Scanner(System.in);

    public ViewContacto() {
    }
    public Contacto generarContacto(){
        Contacto contacto = new Contacto();
        String nombre,telefono,email;
        System.out.println("Ingresar Contacto:nombre ");
        nombre = scanner.nextLine();
        System.out.println("Ingresar Contacto:telefono ");
        telefono = scanner.nextLine();
        System.out.println("Ingresar Contacto:email ");
        email = scanner.nextLine();
        contacto.setNombre(nombre);
        contacto.setTelefono(telefono);
        contacto.setEmail(email);
        return contacto;
    }
}
