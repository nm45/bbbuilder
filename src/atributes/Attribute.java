package atributes;
@SuppressWarnings("unused")
public final class Attribute {
	private String name;
	private int value,stars;
	private int growth[],max_growth,min_growth;
	public Attribute(String name,int value,int stars){
		this.name=name;
		this.value=value;
		this.stars=stars;
		attribute_growth();
		calculate_growth();
	}
	
	private synchronized void attribute_growth() {
		if(name=="HP" || name=="Max Fatigue" || name=="Resolve" || name=="Ranged Skill") {
			switch (stars) {
			case 0: set_growth(2,4);
			case 1: set_growth(3,4);
			case 2: set_growth(0,4);
			case 3: set_growth(4,5);
			}
		}
		else if(name=="Initiative") {
			switch (stars) {
			case 0: set_growth(3,5);
			case 1: set_growth(4,5);
			case 2: set_growth(0,5);
			case 3: set_growth(5,6);
			}
		}
		else if(name=="Melee Skill" || name=="Melee Defence" || name=="Ranged Defence") {
			switch (stars) {
			case 0: set_growth(1,3);
			case 1: set_growth(2,3);
			case 2: set_growth(0,3);
			case 3: set_growth(3,4);
			}
		}
		else {
			System.err.println("ERROR CODE: 554");
			return;
		}
	}
	
	private void set_growth(int min,int max) {
		growth[0]=min;
		growth[1]=max;
	}
	
	private synchronized void calculate_growth(){
		this.min_growth=growth[0]*10;
		this.max_growth=growth[1]*10;
	}
}
