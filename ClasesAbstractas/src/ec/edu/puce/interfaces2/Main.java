package ec.edu.puce.interfaces2;

public class Main {

	public static void main(String[] args) {

		//Rectangulo
		Rectangulo r1 = new Rectangulo("Rectángulo 1");
		r1.setBase(7);
		r1.setAltura(15);
		System.out.println(r1.toString());
		
		Rectangulo r2 = new Rectangulo("Rectángulo 2");
		r2.setBase(7);
		r2.setAltura(15);
		System.out.println(r2.toString());
		
		if (r1.mayorQue(r2))
			System.out.println( "El mayor es: " + r1.toString() );
		else
			System.out.println( "El mayor es: "+ r2.toString() );

		
	}

}