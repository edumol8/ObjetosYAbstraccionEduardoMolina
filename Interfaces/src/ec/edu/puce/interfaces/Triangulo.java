package ec.edu.puce.interfaces;

public class Triangulo implements FiguraGeometrica {

	private double base;
	private double altura;
	
	@Override
	public double calcularArea() {

		double area= (this.altura * this.base)/2;

		return area;
	}

	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	
}
