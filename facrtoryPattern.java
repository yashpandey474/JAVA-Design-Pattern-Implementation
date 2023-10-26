package designPatterns;
//I have picked a problem of manufacturing different iron types

class ironFactory{
	Iron iron;
	
	public Iron deliverIron(String type) {
		if(type.equals("Wrought")) {
			this.iron  = new WroughtIron("XYZ");
		}
		if(type.equals("Cast")) {
			this.iron = new CastIron("ABC");
		}
		
		this.iron = new PigIron("XYZ");
		return iron;
	}
}

abstract class Iron{
	String manufacturer;
	
	Iron(String manufacturer){
		this.manufacturer = manufacturer;
	}
}

class WroughtIron extends Iron{
	static int purity = 99;
	
	WroughtIron(String manufacturer){
		super(manufacturer);
	}
	
}
class CastIron extends Iron{
	static int purity = 85;
	
	CastIron(String manuf){
		super(manuf);
	}
}
class PigIron extends Iron{
	static int purity = 70;
	
	PigIron(String manuf){
		super(manuf);
	}
};



public class factoryPattern {
	public static void main(String[] args) {
		ironFactory ironfact = new ironFactory();
		System.out.println(ironfact.deliverIron("Wrought").manufacturer);
	}
}
