package ExamenPrimerParcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;
import ExamenPrimerParcial.Ropa;

@Data

public class Inventario {
    private List<Ropa> prendas;

    public Inventario() {
        prendas = new ArrayList<>();
    }

    public boolean verificarDisponibilidad(String codigo, int cantidad) {
        for (Ropa prenda : prendas) {
            if (prenda.getCodigo().equals(codigo) && getCantidad() >= cantidad) {
                return true;
            }
        }
        return false;
    }

    private int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void actualizarInventario(String codigo, int cantidadVendida) {
        for (Ropa prenda : prendas) {
            if (prenda.getCodigo().equals(codigo)) {
                int nuevaCantidad = getCantidad() - cantidadVendida;
                if (nuevaCantidad >= 0) {
                    prenda.setCantidad(nuevaCantidad);
                } else {
                    System.out.println(" No hay sufientes piezas");
                }
                break;
            }
        }
    }

    public void mostrarInventario() {
        System.out.println("Prenda | Tamaño | Cantidad | Precio Compra | Precio Venta");
        for (Ropa prenda : prendas) {
            System.out.println(prenda.getTamaño() + " | " + prenda.getTamaño() + " | " 
        + prenda.getCantidad() + " | " + prenda.getPrecioCompra() + " | " + prenda.getPrecioVenta());
        }
    }
    public void agregarPrenda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de prenda:");
        String tipo = scanner.nextLine();
        System.out.println("Ingrese el tamaño de la prenda:");
        String tamaño = scanner.nextLine();
        System.out.println("Ingrese la cantidad de la prenda:");
        int cantidad = scanner.nextInt();
        System.out.println("Ingrese el precio de compra de la prenda:");
        double precioCompra = scanner.nextDouble();
        scanner.nextLine(); 
        String codigo = generarCodigo();
        Ropa prenda = new Ropa(codigo, precioCompra, cantidad, codigo);
        agregarPrenda(prenda);

        System.out.println("Prenda agregada exitosamente.");
    }

    private String generarCodigo() {

        return "R" + (++contadorCodigos);
    }

    private static int contadorCodigos = 0;

    public void agregarPrenda(Ropa prenda) {
        prendas.add(prenda);
    }


	public void mostrarPrendasConCodigos() {
		// TODO Auto-generated method stub
		
	}

	
}
