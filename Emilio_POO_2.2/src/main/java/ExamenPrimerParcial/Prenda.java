package ExamenPrimerParcial;

import lombok.Data;

@Data
	
public abstract class Prenda {
    private String codigo;
    protected String tamaño;
    protected double precioCompra;
    protected double precioVenta;

    public Prenda(String tamaño, double precioCompra, int cantidad, String genero) {
        this.tamaño = tamaño;
        this.precioCompra = precioCompra;
        this.codigo = generarCodigo();
        calcularPrecioVenta();
    }

    private String generarCodigo() {
        return "PR" + (++contadorCodigos);
    }

    public static int contadorCodigos = 0;

    protected abstract void calcularPrecioVenta();

    public String getCodigo() {
        return codigo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
}
