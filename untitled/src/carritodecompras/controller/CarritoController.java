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
        //seleción del carrito.
        String id = this.getCarritoView().generarIdCarrito();
        CarritoCompras carritoCompras = (CarritoCompras) this.carritoRepository.leer(id);

        //si existe el carrito
        if (carritoCompras != null){
            carritoView.mostrarContenidoCarrito(carritoCompras);
            Producto producto;
            String nombreCat;
            Categoria categoria;
            //eleccion: agregar/remover
            boolean eleccion =this.carritoView.eleccion();
            if (eleccion){
                //Agregar producto
                this.carritoView.mensajeCreacionProducto();
                nombreCat=this.categoriaController.getCategoriaView().generarNombreCat().toUpperCase();

                categoria = categoriaController.generarCategoria(nombreCat);

                producto = productoController.getProductoView().generarProducto(categoria);
                carritoCompras.agregarProducto(producto);
            }
            else {
                //Remover producto
                carritoView.mensajeEliminacionProducto();
                id = productoController.getProductoView().generarIdProducto();
                producto = carritoCompras.leerProducto(id);
                if (producto!=null){ //encuentra carro
                    carritoCompras.removerProducto(producto);
                    carritoCompras.actualizarCarrito();
                    carritoView.mensajeProductoEliminado(producto);
                }
                else carritoView.mensajeNoExisteProducto(id); //no encuentra carro
            }
            //No existe el carrito.
        }else this.carritoView.mensajeCarritoNoEncontrado(id);
    }
}
