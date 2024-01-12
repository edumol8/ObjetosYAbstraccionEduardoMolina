package ec.edu.puce.clasesAbstractas;

public class Main {

	public static void main(String[] args) {

		//Rectangulo
		Rectangulo r1 = new Rectangulo("Rectángulo 1");
		r1.setBase(7);
		r1.setAltura(15);
		System.out.println(r1.toString());
		
		Rectangulo r2 = new Rectangulo("Rectángulo 2");
		r2.setBase(7);
		r2.setAltura(10);
		System.out.println(r2.toString());
		
		//Triangulo
		Triangulo t1 = new Triangulo("Triangulo 1"); 
		t1.setBase(6);
		t1.setAltura(15);
		System.out.println(t1.toString());
		
		//Círculo
		Circulo c1 = new Circulo("Círculo 1");
		c1.setRadio(5);
		System.out.println(c1.toString());
		
		//Cual rectangulo es mayor
		System.out.println("\nQué rectángulo es mayor?");
		if (r1.mayorQue(r2))
			System.out.println( "El mayor es: " + r1.toString() );
		else
			System.out.println( "El mayor es: "+ r2.toString() );

		
	}

}