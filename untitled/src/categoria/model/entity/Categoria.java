package categoria.model.entity;

import java.util.Objects;

public class Categoria {
    private String nombre;
    private final Integer id;
    private static Integer cantidadCategorias=0;
    public Categoria(String nombre) {
        this.nombre = nombre;
        this.id = ++cantidadCategorias;
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

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Categoria categoria = (Categoria) object;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
