package carritodecompras.controller;

import carritodecompras.model.entity.CarritoCompras;
import carritodecompras.model.repository.CarritoRepository;
import carritodecompras.view.CarritoView;
import categoria.controller.CategoriaController;
import categoria.model.entity.Categoria;
import producto.controller.ProductoController;
import producto.model.entity.Producto;

import java.util.HashSet;
import java.util.Set;

public class CarritoController {
    private Set<Categoria> categorias;
    private CategoriaController categoriaController;
    private ProductoController productoController;
    private CarritoView carritoView;
    private CarritoRepository carritoRepository;

    public CarritoController(CategoriaController categoriaController,ProductoController productoController,CarritoView carritoView, CarritoRepository carritoRepository) {
        this.categoriaController = categoriaController;
        this.productoController=productoController;
        this.carritoView = carritoView;
        this.carritoRepository = carritoRepository;
        this.categorias = new HashSet<>();
    }

    public CategoriaController getCategoriaController() {
        return categoriaController;
    }

    public ProductoController getProductoController() {
        return productoController;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    //Retorna el conjunto de categorias de un carrito recibido por parámetro
    public Set<Categoria> getCategorias(CarritoCompras carritoCompras) {
        return categorias;
    }
    //Retorna la vista
    public CarritoView getCarritoView() {
        return carritoView;
    }
    //Retorna el carritoRepository
    public CarritoRepository getCarritoRepository() {
        return carritoRepository;
    }

    public void createCarrito(){
        /*
        * Se crea un carrito y se guarda en el carritoRepository.*/
        CarritoCompras carritoCompras;
        carritoCompras = this.getCarritoView().generarCarrito();
        this.getCarritoRepository().agregar(carritoCompras);
    }

    public CarritoCompras readCarrito(){
        /*
        * Se busca el carrito por id
        * si se encuentra se retorna
        * si no se encuentra se retorna null*/
        String id = this.getCarritoView().generarIdCarrito();
        return (CarritoCompras) this.getCarritoRepository().leer(id);
    }

    /*Se actualiza la información del carrito. Sea:
    * Agregar o remover un producto del mismo.*/
    public void updateCarritoCompras(){
        String id = this.getCarritoView().generarIdCarrito();
        CarritoCompras carritoCompras = (CarritoCompras) this.carritoRepository.leer(id);
        if (carritoCompras != null){
            carritoView.mostrarContenidoCarrito(carritoCompras);
            Producto producto;
            String nombreCat;
            Categoria categoria;
            boolean eleccion =this.carritoView.helper();
            if (eleccion){
                //Agregar producto
                /*
                * Revisar que la categoría no exista para no crear una igual.*/
                this.carritoView.avisoCreacionProducto();
                nombreCat=this.categoriaController.getCategoriaView().generarNombreCat();
                categoria = (Categoria) this.categoriaController.getCategoriaRepository().leer(nombreCat);
                if (categoria==null) //cat. no existe, se crea una nueva.
                    categoria = categoriaController.getCategoriaView().generarCategoria(nombreCat);
                producto = productoController.getProductoView().generarProducto(categoria);
                carritoCompras.agregarProducto(producto);
            }
            else {
                //Remover producto
                carritoView.avisoEliminacionProducto();
                id = productoController.getProductoView().generarIdProducto();
                producto = carritoCompras.leerProducto(id);
                if (producto!=null){ //encuentra carro
                    carritoCompras.removerProducto(producto);
                    carritoView.avisoProductoEliminado(producto);
                }
                else carritoView.avisoNoExisteProducto(id); //no encuentra carro
            }
        }else this.carritoView.carritoNoEncontrado(id);
    }
}
