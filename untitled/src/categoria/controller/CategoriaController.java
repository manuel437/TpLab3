package categoria.controller;

import categoria.model.entity.Categoria;
import categoria.model.repository.CategoriaRepository;
import categoria.view.CategoriaView;

public class CategoriaController {
    private CategoriaView categoriaView;
    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaView categoriaView, CategoriaRepository categoriaRepository) {
        this.categoriaView = categoriaView;
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaView getCategoriaView() {
        return categoriaView;
    }

    public CategoriaRepository getCategoriaRepository() {
        return categoriaRepository;
    }

    /**
     * Esta función genera una categoría. Crea una nueva siempre que no exista en el repositorio de categorías.
     * @param nombre El nombre de la categoría.
     * @return La categoría encontrada/creada.
     * */
    public Categoria generarCategoria(String nombre){
        Categoria buscar = (Categoria) this.getCategoriaRepository().leer(nombre);
        if (buscar != null)return buscar;
        buscar = this.getCategoriaView().generarCategoria(nombre);
        this.getCategoriaRepository().agregar(buscar);
        return buscar;
    }


}
