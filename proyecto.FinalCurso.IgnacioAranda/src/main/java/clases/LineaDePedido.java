package clases;
//TODO Implementar DAO
public class LineaDePedido {
	private Producto producto;
	private short cantidad;	
	
	public LineaDePedido(Producto producto, short cantidad) {
		setProducto(producto);
		setCantidad(cantidad);
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public short getCantidad() {
		return cantidad;
	}
	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return getProducto() + "\tCantidad: " + getCantidad() + "\n";
	}
	
	
	
}
