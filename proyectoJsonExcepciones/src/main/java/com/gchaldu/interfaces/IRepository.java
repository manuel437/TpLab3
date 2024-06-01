package com.gchaldu.interfaces;

public interface IRepository {
    void agregar (Object o);
    Object leer(String id);
    void actualizar(String id, Object o);
    void remover(String id);
}
