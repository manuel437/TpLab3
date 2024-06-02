package interfaces;
public interface IRepository {
    void agregar(Object o);
    Object leer(String id);
    void actualizar(String id, Object o);
    boolean remover(String id);
}