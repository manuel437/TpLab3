package concecionariaController.automovil.model.entity;

public class Automovil {
    private static int conter = 0;
    private int id;
    private String model;
    private String marca;

    private int precio;

    public Automovil(int id, String model, String marca,  int precio) {
        this.id = id;
        this.model = model;
        this.marca = marca;
        this.precio = precio;
    }

    public Automovil(String model, String marca, int precio) {

        this.id = ++conter;
        this.model = model;
        this.marca = marca;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                '}';
    }
}
