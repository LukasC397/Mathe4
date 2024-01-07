
public class Uebung11 {

	public static void main(String args[]) {
		int a = 247;
		int b = 221;  //a > b
		//euk(a,b);
		
		int[] primzahlen = {2,3,5,7,11,13,17,19,23,29,31,37};
		
		int p = 6375; // muss > 1 sein
				
		zerlegung(p);
		
		dio(899,203, 319);
		
	}

	public static Bezot euk(int a, int b) {
		int r0 = a;
		int r1 = b;
		int x0 = 1;
		int x1 = 0;
		int y0 = 0;
		int y1 = 1;
		
		int rneu = 0;
		int xneu = 0;
		int yneu = 0;
		int q = 0;
		while (r1 != 0) {
			rneu = r0 % r1;
			q = r0 / r1;
			xneu = x0 - q * x1;
			yneu = y0 - q * y1;
			
			r0 = r1;
			r1 = rneu;
			x0 = x1;
			x1 = xneu;
			y0 = y1;
			y1 = yneu;
		}
		Bezot erg = new Bezot(x0, y0, r0);
		System.out.println("ggt = " + r0 + " x= " + x0 + " y= " + y0);
		return erg;
	}

	static void zerlegung (int p) {
		int[] primzahlen = {2,3,5,7,11,13,17,19,23,29,31,37};
		String erg = "";
		while (!isPrim(p)) {
			for(int i = 0; i < primzahlen.length; i++) {
				if(p % primzahlen[i] == 0) {
					erg+= primzahlen[i] + " * ";
					p /= primzahlen[i];
					break;
				}
			}
		}
		erg += p;
		System.out.println(erg);
	}
	
	static boolean isPrim(int a) {
		for(int i = 2; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void dio(int a, int b, int c) {
		Bezot bezo = euk(a,b);
		
		if(c % bezo.getG() != 0) return; //getG = ggt
		int zw = c / bezo.getG();
		System.out.println("x0 = " + bezo.getX() * zw + " y0 = "+ bezo.getY() * zw);
	}
}
