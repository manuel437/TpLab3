package producto.controller;

import producto.model.entity.Producto;
import producto.model.repository.ProductoRepository;
import producto.view.ProductoView;

public class ProductoController {
    private ProductoView productoView;
    private ProductoRepository productoRepository;

    public ProductoController() {
        this.productoView=new ProductoView();
        this.productoRepository = new ProductoRepository();
    }

    public ProductoView getProductoView() {
        return productoView;
    }

    public ProductoRepository getProductoRepository() {
        return productoRepository;
    }

    public Producto generarProducto(String nombre){
        Producto buscar = (Producto) this.getProductoRepository().leer(nombre);
        if (buscar != null)return buscar;
        buscar = this.getProductoView().generarProducto(nombre);
        this.getProductoRepository().agregar(buscar);
        return buscar;

    }
}
