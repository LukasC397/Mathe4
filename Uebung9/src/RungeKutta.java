
public class RungeKutta {
	
	static double startX = 1;
	static double startY = 2;
	static double h = 0.1;
	static double endX = 1.4;
	
	
	public static void main(String[] args) {
		
		double yNeu = berechneK(startX, startY);
		double[][] array = new double[(int)Math.round((endX-startX)/h)+1][3];
		
		array[0][0] = startX;
		array[0][1] = startY;
		array[0][2] = yNeu;//neues Y für nächste Zeile
		
		for(int i = 1; i <=(int) Math.round(((endX-startX)/h)); i++) {
			array[i][0] = startX + i * h; //Xk
			array[i][1] = array[i-1][1] + array[i-1][2]; //Yk
			array[i][2]	= berechneK(array[i][0], array[i][1]); //wert für nächste Zeile
		}
		
		for(double[] wert : array) {
			System.out.println("Xk: " + wert[0]+" Näherung: " + wert[1]);
		}
	}

	
	static double func1(double x, double y) {
		//return y + Math.exp(x);
		//return x - y;
		return y*y + 3 * x; 
	}
	
	static double berechneK(double xAlt, double yAlt) {
		double k1 = h * func1(xAlt, yAlt);
		double k2 = h * func1(xAlt + h/2, yAlt + k1/2);
		double k3 = h * func1(xAlt + h/2, yAlt + k2/2);
		double k4 = h * func1(xAlt + h, yAlt + k3);
		return (1.0/6.0)*(k1 + 2*k2 + 2*k3 + k4); 	//return k
	}
}
