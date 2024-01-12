package ec.edu.puce.interfaces;

public class Círculo implements FiguraGeometrica{

	final double PI = Math.PI;
	private double radio;
	
	
	@Override
	public double calcularArea() {

	double area= this.PI * Math.pow(this.radio, 2);
		
		return area;
	}


	
	public double getRadio() {
		return radio;
	}


	public void setRadio(double radio) {
		this.radio = radio;
	}

	
	
}
