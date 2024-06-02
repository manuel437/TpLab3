package categoria.model.repository;
import categoria.model.entity.Categoria;
import interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;
//Repositorio de objetos de tipo 'Categoría'
public class CategoriaRepository implements IRepository {
    //atributo único (la colección en sí misma=
    private List<Categoria> list;
    //Constructor de la clase.
    public CategoriaRepository() {
        this.list = new ArrayList<>();
    }
    @Override
    public void agregar(Object o) {
        //Se agrega el objeto a la lista
        //El objeto debe
        //  - ser distinto de null
        //  - ser de clase 'Categoria'
        //  - no debe existir en el repo una categoría con el mismo nombre
        if (o!=null&&o.getClass().equals(Categoria.class))
            if (!this.list.contains(o))
                this.list.add((Categoria) o);
    }
    @Override
    public Object leer(String id) {
        //Busca la categoría con un identificador
        //Si el nombre de alguna categoría coincide con el id la retorna
        //Si ninguna categoría coincide con el id retorna null
        for (Categoria categoria:this.list){
            if (categoria.getNombre().equals(id))return categoria;
        }
        return null;
    }
    @Override
    public void actualizar(String id, Object o) {
        //El objeto que ingresa debe:
        //  - ser distinto de null
        //  - ser un objeto de clase 'Categoria'
        //  - no debe haber una categoria con el mismo nombre ya existente en el repo
        if (
                o != null &&
                o.getClass().equals(Categoria.class) &&
                !this.list.contains(o)
        )
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).getNombre().equals(id)) {
                }
            }
        else return;
    }
    @Override
    public boolean remover(String id) {
        for (Categoria categoria : this.list)
            if (categoria.getNombre().equals(id))
                return true;
        return false;
    }
}
