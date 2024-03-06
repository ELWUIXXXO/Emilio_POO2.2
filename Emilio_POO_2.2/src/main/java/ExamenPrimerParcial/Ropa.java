package ExamenPrimerParcial;

import java.util.List;
import lombok.Data;
import ExamenPrimerParcial.Prenda;

	
public class Ropa extends Prenda {
	
	public Ropa(String tamaño, double precioCompra, int cantidad, String genero) {
		super(tamaño, precioCompra, cantidad, genero);
		// TODO Auto-generated constructor stub
	}
	private static int contadorCodigos = 0; 
    private String codigo; 
    private String tipo; 
    private String tamaño; 

    
	
	private String generarCodigo() {
        return "R" + (++contadorCodigos); 
    }
	@Override
	protected void calcularPrecioVenta() {
	    if (tamaño != null) { 
	        if (tamaño.equals("CH") || tamaño.equals("M")) {
	            precioVenta = precioCompra * 1.1; 
	        } else { 
	            precioVenta = precioCompra * 1.2; 
	        }
	    } else {
	    }
	}
	public List<Ropa> getPrendas() {
	    return getPrendas();
	}
	public String getCantidad() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCantidad(int nuevaCantidad) {
		// TODO Auto-generated method stub
		
	}
		
}