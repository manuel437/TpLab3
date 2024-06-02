package producto.model.entity;

import categoria.model.entity.Categoria;

import java.util.Objects;

public class Producto {
    private String nombre;
    private static Integer cantidadProductos = 0;
    private final Integer id;
    private Categoria categoria;

    public Producto() {
        this.id = ++cantidadProductos;
    }

    public Producto(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.id = ++cantidadProductos;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Producto producto = (Producto) object;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
