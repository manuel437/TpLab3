package categoria.controller;

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
}
