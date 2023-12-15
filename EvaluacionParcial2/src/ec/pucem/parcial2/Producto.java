package ec.pucem.parcial2;

public class Producto  {
	
	private String Codigo;
	private String Detalle;
	private double Precio;
	private int Cantidad;
	private double Iva;
	private double TotalIva;
	private double Total;
	
	
	public Producto(String codigo, String detalle, double precio, int cantidad) {
		super();
		this.Codigo = codigo;
		this.Detalle = detalle;
		this.Precio = precio;
		this.Cantidad = cantidad;
		this.Total = this.Precio*this.Cantidad;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public double getIva() {
		return Iva;
	}
	public void setIva(double iva) {
		Iva = iva;
	}
	public double getTotalIva() {
		return TotalIva;
	}
	public void setTotalIva(double totalIva) {
		TotalIva = totalIva;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}


	

	
	
}//fin clase
