package ExamenPrimerParcial;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Venta {
    private List<Ropa> prendasVendidas;
    private Inventario inventario;

    public Venta(Inventario inventario) {
        this.prendasVendidas = new ArrayList<>();
        this.inventario = inventario;
    }

    public boolean realizarVenta(String codigo, int cantidad) {
        if (!inventario.verificarDisponibilidad(codigo, cantidad)) {
            System.out.println(" No hay mas unidades ");
            return false;
        }

        for (Ropa prenda : inventario.getPrendas()) {
            if (prenda.getCodigo().equals(codigo)) {
                prenda.setCantidad(getCantidad() - cantidad);
                agregarPrendaVendida(prenda);
                inventario.actualizarInventario(codigo, cantidad);
                return true;
            }
        }

        System.out.println("La prenda no se encuentra en el inventario");
        return false;
    }

    private int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void agregarPrendaVendida(Ropa prenda) {
        prendasVendidas.add(prenda);
    }

    public void mostrarVentas() {
        System.out.println("Prenda | Tamaño | Cantidad | Precio Compra | Precio Venta");
        for (Ropa prenda : prendasVendidas) {
            System.out.println(prenda.getTamaño() + " | " + prenda.getTamaño() + " | "
        + prenda.getCantidad() + " | " + prenda.getPrecioCompra() + " | " + prenda.getPrecioVenta());
        }
    }
}
