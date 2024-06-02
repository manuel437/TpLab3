import carritodecompras.controller.CarritoController;
import carritodecompras.model.entity.CarritoCompras;
import carritodecompras.model.repository.CarritoRepository;
import carritodecompras.view.CarritoView;
import categoria.controller.CategoriaController;
import categoria.model.repository.CategoriaRepository;
import categoria.view.CategoriaView;
import producto.controller.ProductoController;
import producto.model.repository.ProductoRepository;
import producto.view.ProductoView;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        CategoriaView categoriaView = new CategoriaView();
        CategoriaRepository categoriaRepository = new CategoriaRepository();
        CategoriaController categoriaController = new CategoriaController(categoriaView,categoriaRepository);
        ProductoView productoView = new ProductoView();
        ProductoRepository productoRepository = new ProductoRepository();
        ProductoController productoController = new ProductoController();
        CarritoView carritoView = new CarritoView();
        CarritoRepository carritoRepository = new CarritoRepository();
        CarritoController carritoController = new CarritoController(categoriaController,productoController,carritoView,carritoRepository);
        String s="";
        do {
            prinMenu();
            s = scanner.nextLine();
            try{
                switch (s.charAt(0)){
                    case '0':
                        break;
                    case '1':
                        listarCarritos(carritoController);
                        break;
                    case '2':
                        agregarCarro(carritoController);
                        break;
                    case '3':
                        removerCarro(carritoController);
                        break;
                    case '4':
                        seleccionarCarro(carritoController);
                        break;
                    default:
                        System.out.println("Ingreso inválido");
                        break;
                }

            } catch (StringIndexOutOfBoundsException e){
                System.out.println("Ingreso inválido");
                s="a";
            }
        } while (s.charAt(0)!='0');
        scanner.close();
    }

    public static void prinMenu(){
        System.out.println("""
                        GESTION DE CARRITOS DE COMPRA:
                1) listar carritos
                2) agregar nuevo carrito
                3) eliminar carrito
                4) seleccionar carrito
                
                0 - salir.
                """);
    }

    public static void listarCarritos(CarritoController carritoController){
        Map<String,CarritoCompras> map = carritoController.getCarritoRepository().getList();
        if (map.isEmpty()) {
            System.out.println("Aún no hay carritos.");
            return;
        }
        Set<Map.Entry<String,CarritoCompras>>set=map.entrySet();
        for (Map.Entry<String,CarritoCompras> entry:set){
            System.out.println("Carrito, id " + entry.getKey()+"." +
                    "\n"+entry.getValue().toString());
        }
    }

    public static void agregarCarro(CarritoController carritoController){
        System.out.println("Agregar carro");
        carritoController.createCarrito();
    }

    public static void removerCarro(CarritoController carritoController){
        System.out.println("Eliminar carro");
        boolean remover = carritoController.getCarritoRepository().remover(
                carritoController.getCarritoView().generarIdCarrito()
        );
        if (remover) System.out.println("Se ha eliminado el carrito correctamente...");
        else System.out.println("No se ha podido eliminar el carro.");
    }

    public static void seleccionarCarro(CarritoController carritoController){
        carritoController.updateCarritoCompras();
    }
}