package model;

public class Country implements Comparable<Country>{
	String name;
	private Medal manGold;
	private Medal manPlate;
	private Medal womanGold;
	private Medal manBronze;
	private Medal womanPlate;
	private Medal womanBronze;
	private String order;
	
	public Country(String name,Medal manGold, Medal manPlate,Medal manBronze,Medal womanGold, Medal womanPlate,Medal womanBronze,String order) {
		this.name=name;
		this.manGold = manGold;
		this.manPlate = manPlate;
		this.manBronze = manBronze;
		this.womanGold = womanGold;
		this.womanPlate = womanPlate;
		this.womanBronze = womanBronze;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Medal getManGold() {
		return manGold;
	}

	public void setManGold(Medal manGold) {
		this.manGold = manGold;
	}

	public Medal getManPlate() {
		return manPlate;
	}

	public void setManPlate(Medal manPlate) {
		this.manPlate = manPlate;
	}

	public Medal getWomanGold() {
		return womanGold;
	}

	public void setWomanGold(Medal womanGold) {
		this.womanGold = womanGold;
	}

	public Medal getManBronze() {
		return manBronze;
	}

	public void setManBronze(Medal manBronze) {
		this.manBronze = manBronze;
	}

	public Medal getWomanPlate() {
		return womanPlate;
	}

	public void setWomanPlate(Medal womanPlate) {
		this.womanPlate = womanPlate;
	}

	public Medal getWomanBronze() {
		return womanBronze;
	}

	public void setWomanBronze(Medal womanBronze) {
		this.womanBronze = womanBronze;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public int calculateGolds() {
		int golds = manGold.getQuantity()+womanGold.getQuantity();
		return golds;
	}
	
	public int calculateSilvers() {
		int silver = manPlate.getQuantity()+womanPlate.getQuantity();
		return silver;
	}
	
	public int calculateBronze() {
		int bronze = manBronze.getQuantity()+womanBronze.getQuantity();
		return bronze;
	}
	
	@Override
	public int compareTo(Country o) {
		// TODO Auto-generated method stub
		Country A = this;
		Country B = o;
		int output = 0;
		if(order.equals("1")) {
			 output = (int) (B.manGold.getQuantity()-A.manGold.getQuantity());
			if(output == 0) {
				output = (int) (B.manPlate.getQuantity()-A.manPlate.getQuantity());
				if(output == 0) {
					output = (int) (B.manBronze.getQuantity()-A.manBronze.getQuantity());
					if(output == 0) {
						output = B.name.compareTo(A.name);
					}
				}
			}
		}else if(order.equals("2")) {
			output = (int) (A.womanGold.getQuantity()-B.womanGold.getQuantity());
			if(output == 0) {
				output = (int) (A.womanPlate.getQuantity()-B.womanPlate.getQuantity());
				if(output == 0) {
					output = (int) (A.womanBronze.getQuantity()-B.womanBronze.getQuantity());
					if(output == 0) {
						output = A.name.compareTo(B.name);
						output*=-1;
					}
				}
			}
		}else {

			output = (int) B.calculateGolds()-A.calculateGolds();
			if(output == 0) {
				output = (int) B.calculateSilvers()-A.calculateSilvers();
				if(output == 0) {
					output = (int) B.calculateBronze()-A.calculateBronze();;
					if(output == 0) {
						output = (B.name.compareTo(A.name));
					}
				}
			}
		}
		return output;
	}
	
	public String toString() {
		String out = "";
		if(order.equals("1")) {
		 out += name+" "+manGold.getQuantity()+" "+manPlate.getQuantity()+" "+manBronze.getQuantity();
		}else if(order.equals("2")) {
		 out += name+" "+womanGold.getQuantity()+" "+womanPlate.getQuantity()+" "+womanBronze.getQuantity();
		}else {
			int golds = calculateGolds();
			int silver = calculateSilvers();
			int bronze = calculateBronze();
			out += name+" "+golds+" "+silver+" "+bronze;
		}
		return out;
	}
}
