package tests;

public class Hex {

	public static void main(String[] args) {
	    String decimal = "10"; // Decimal
	    String hexa = "0XAA"; // Hexa
	    String octal = "077"; // Octal

	    Integer number = Integer.decode(decimal);
	    System.out.println("String [" + decimal + "] = " + number);

	    number = Integer.decode(hexa);
	    System.out.println("String [" + hexa + "] = " + number);

	    number = Integer.decode(octal);
	    System.out.println("String [" + octal + "] = " + number);		
	    	    
	    String bin = Integer.toBinaryString(Integer.decode("0XA")) ;
	    int r = Integer.parseInt(bin, 2) ;
	    System.out.println(r + ":  " + bin);
	}

}
