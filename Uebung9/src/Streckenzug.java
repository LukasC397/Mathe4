
public class Streckenzug {
	
	static double startX = 0;
	static double startY = 1;
	static double h = 0.1;
	static double endX = 0.4;
	
	
	public static void main(String[] args) {
		
		double yNeu = neuesY(startX, startY);
		double[][] array = new double[(int)Math.round((endX-startX)/h)+1][3]; //anpassen wegen ungenauigkeit
		
		array[0][0] = startX;
		array[0][1] = startY;
		array[0][2] = yNeu;//neues Y für nächste Zeile
		
		for(int i = 1; i <= (int) Math.round(((endX-startX)/h)); i++) {	//anpassen wegen ungenauigkeit
			array[i][0] = startX + i * h; //Xk
			array[i][1] = array[i-1][1] + array[i-1][2]; //Yk
			array[i][2]	= neuesY(array[i][0], array[i][1]); //wert für nächste Zeile
			System.out.println(i);
		}
		
		for(double[] wert : array) {
			System.out.println("Xk: " + wert[0]+" Näherung: " + wert[1]);
		}
	}

	static double func1(double x, double y) {
		//return y + Math.exp(x); //Aufgabe 9.1 a
		//return x - y; //aufgabe 9.2 b
		return y*y + 3*x; //aufgabe 9.3
	}
	
	static double neuesY(double xAlt, double yAlt) {
		return h * func1(xAlt, yAlt);
	}
	
	
}
