
public class main {
	static double h = 0.001; //bereich um den start X wert zum Abschätzen der Ableitung
	static double epsilon = 0.001;	//genauigkeit des abbruchs
	
	public static void main(String[] args) {
		double x = 0; //startwert
		double lambda0 = 5; //Schrittweite
		System.out.println(berechneLokalesMinimum(x,lambda0));
	}
	
	static double insertInFunction(double x) {
		return 0.0005*Math.pow(x, 6)-0.01*Math.pow(x, 5)+0.12*Math.pow(x, 4)-0.5*Math.pow(x, 3)+0.75*Math.pow(x, 2)-0.4*x;
	};
	
	static double approx1Ableitung(double x, double h) {
		return (insertInFunction(x+h)-insertInFunction(x-h)) / (2*h);
	}
	
	static double approx2Ableitung(double x, double h) {
		return (insertInFunction(x+h) - 2*insertInFunction(x)+insertInFunction(x-h)) / (h*h);
	}
	
	static double berechneLokalesMinimum(double x, double lambda) { // lambda = schrittweite
		double Xi = x;
		double XiPlus1 = x;
		while(!abbruch(XiPlus1,epsilon)) {
			Xi = XiPlus1;
			XiPlus1 = Xi - lambda*approx1Ableitung(Xi,h);
			if(insertInFunction(XiPlus1) >= insertInFunction(Xi)) { //über den hubbel gesprungen
				lambda = neuesLambda(lambda, Xi);
				XiPlus1 = Xi - lambda*approx1Ableitung(Xi,h);
			}
			else { //if(insertInFunction(XiPlus1) < insertInFunction(Xi)) wir sind noch nicht am Ziel
			lambda = neuesLambda2(lambda, Xi);
			XiPlus1 = Xi - lambda*approx1Ableitung(Xi,h);
			}
		}
		
		return XiPlus1;
	}
	
	static boolean abbruch(double x, double epsilon) {
		return  Math.abs(approx1Ableitung(x,h)) < epsilon;
		//return  Math.abs(approx1Ableitung(x,h)) == 0;
	}
	
	static double neuesLambda(double altesLambda, double xAlt) {//kleinere Schrittweite wird gesucht
		double xNeu;
		
		do {
			altesLambda /= 2;
			xNeu = xAlt - altesLambda * approx1Ableitung(xAlt,h);
		}
		while(insertInFunction(xNeu) >= insertInFunction(xAlt));
		
		return altesLambda; //neue Schrittweite
	}
	
	static double neuesLambda2(double altesLambda, double xAlt) { //größere Schrittweite wird gesucht
		double xNeuAlteSchrittweite;
		double xNeuNeueSchrittweite;
		
			xNeuAlteSchrittweite = xAlt - altesLambda * approx1Ableitung(xAlt,h);
			altesLambda *= 2;
			xNeuNeueSchrittweite = xAlt - altesLambda * approx1Ableitung(xAlt,h);
		
		if(insertInFunction(xNeuNeueSchrittweite) < insertInFunction(xNeuAlteSchrittweite)) {
			return altesLambda;
		}
		
		return altesLambda/2;
	}
}

