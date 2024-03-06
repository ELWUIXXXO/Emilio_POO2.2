package ExamenPrimerParcial;

import lombok.Data;
import ExamenPrimerParcial.Prenda;
import ExamenPrimerParcial.Ropa;
import ExamenPrimerParcial.Inventario;
import ExamenPrimerParcial.Venta;

import java.util.Scanner;

@Data

public class TiendaRopa {
	
	    public static void main(String[] args) {
	        Inventario inventario = new Inventario();
	        Venta venta = new Venta(inventario);
	        Scanner scanner = new Scanner(System.in);
	        
	       
	        while (true) {
	            System.out.println("\nMenu de la Tienda de Ropa:");
	            System.out.println("1. Dar de alta prenda");
	            System.out.println("2. Mostrar inventario");
	            System.out.println("3. Codigos de prendas");
	            System.out.println("4. Realizar venta");
	            System.out.println("5. Mostrar ventas realizadas");
	            System.out.println("6. Salir");
	            System.out.print("Que desea realizar: ");
	            int opcion = scanner.nextInt();
	            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Código de la prenda: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Precio de compra: ");
                    double precioCompra = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Género: ");
                    String genero = scanner.next();
                    System.out.print("Tipo: ");
                    String tipo = scanner.next();
                    System.out.print("Tamaño: ");
                    String tamaño = scanner.next();
                    inventario.agregarPrenda(new Ropa(codigo, precioCompra, cantidad, genero));
                    System.out.println("Prenda agregada exitosamente.");
                    break;
                case 2:
                    inventario.mostrarInventario();
                    break;
                case 3:
                	inventario.mostrarPrendasConCodigos();
                     break;
                case 4:
                	   System.out.print("Codigo de la prenda a vender: ");
                       String codigoVenta = scanner.nextLine();
                       System.out.print("Cantidad a vender: ");
                       int cantidadVenta = scanner.nextInt();
                       if (inventario.verificarDisponibilidad(codigoVenta, cantidadVenta)) {
                           if (venta.realizarVenta(codigoVenta, cantidadVenta)) {
                               System.out.println("Venta realizada ");
                           } else {
                               System.out.println("Error");
                           }
                       } else {
                           System.out.println("La prenda no esta disponible");
                       }
                       break;
                case 5:
                	 venta.mostrarVentas();
                     break;    
                case 6:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no permitida");
            }
	        }
	    }
	    public static void mostrarCodigosPrendas(Inventario inventario) {
	        System.out.println("\nCodigo de las prendas en el inventario:");
	        for (Ropa prenda : inventario.getPrendas()) {
	            System.out.println("Codigo: " + prenda.getCodigo() + ", Tipo: " + prenda.getTamaño() 
	            + ", Tamaño: " + prenda.getTamaño());
	        }
	    }
	}