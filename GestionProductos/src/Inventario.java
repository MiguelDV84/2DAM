import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Integer> stock = new HashMap<>();

    public Inventario() {
        stock.put("Leche", 5);
        stock.put("Mantequilla", 3);
        stock.put("Agua", 2);
        stock.put("Patatas", 3);
        stock.put("Cerveza", 2);
        stock.put("Cebolla", 1);
        stock.put("Brocoli", 8);
        stock.put("Lejía", 2);
        stock.put("Suavizante", 3);
        stock.put("Zumo Naranaja", 1);
        stock.put("Café", 9);
        stock.put("Yogurt natural", 2);
        stock.put("Pan blanco", 1);
        stock.put("Pan integral", 2);
    }

    public synchronized boolean comprarProducto(String producto, int cantidad) {
        System.out.println(Thread.currentThread().getName() +
                            " quiere comprar " + cantidad +
                            " de" + producto);

        //Verificar si el producto existe en el stock
        if(!stock.containsKey(producto)) {
            System.out.println("El " + producto + " no existe en el inventario");

            return false;
        }

        try{
            //Comprobar que no haya suficiente stock, preguntar por qué no se pueda usar if
            while(stock.get(producto) < cantidad) {
                System.out.println("No hay stock suficiente, quedan: " + stock.get(producto));
                wait();
            }

            //Realizar comprar y actualizar stock
            int nuevoStock = stock.get(producto) - cantidad;
            stock.put(producto, nuevoStock);
            System.out.println("Compra realizada: " + producto + ": " + cantidad);

            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            return false;
        }
    }

    public synchronized boolean reponerProducto(String producto, int cantidad) {
        // Si el producto no existe añade el producto
        if(!stock.containsKey(producto)) {
            stock.put(producto, cantidad); // Añade producto nuevo
            System.out.println("Producto añadido: " + producto + " con " + cantidad + " unidades.");

            return false;
        }

        // Si el producto existe reponer producto
        int nuevoStock = stock.get(producto) + cantidad;
        stock.put(producto, nuevoStock);
        System.out.println("Repuesto realizado: " + producto + ": " + cantidad);
        // Avisa a los hilos que están esperando
        notifyAll();

        return true;
    }
}
