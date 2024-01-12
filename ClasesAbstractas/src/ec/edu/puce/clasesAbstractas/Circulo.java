package ec.edu.puce.clasesAbstractas;

public class Circulo extends FiguraGeometrica{

	private double radio;
	
	public Circulo (String nombre) {
		super(nombre);
	}
	
	
	@Override
	public double calcularArea() {
		
		return 3.1416 * this.radio;

	}
	
	
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
	
	
}