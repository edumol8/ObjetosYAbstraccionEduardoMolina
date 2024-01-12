

package ec.edu.puce.interfaces;

public class Main {

	public static void main(String[] args) {

		//Rectangulo
		Rectangulo r1 = new Rectangulo();
		r1.setBase(5.0);
		r1.setAltura(3.0);
		System.out.println("Área del rectángulo 1: " + r1.calcularArea());
		
		//Triangulo
		Triangulo t1 = new Triangulo();
		t1.setBase(5.0);
		t1.setAltura(3.0);
		System.out.println("Área del Triangulo 1: " + t1.calcularArea());
		
		//Circulo
		Círculo c1 = new Círculo();
		c1.setRadio(4.0);;
		System.out.println("Área del Circulo 1: " + c1.calcularArea());
		
	}

}
