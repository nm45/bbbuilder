package characters;

import atributes.Attribute;

public final class Character {
	String name;
	Attribute attributes[];
	Character(String name){
		this.name=name;
	}
	public void set_attribute(String name,int value,int stars) {
		switch(name) {
		case "HP":attributes[0]=new Attribute(name,value,stars);
		case "Max Fatigue":attributes[1]=new Attribute(name,value,stars);
		case "Resolve":attributes[2]=new Attribute(name,value,stars);
		case "Initiative":attributes[3]=new Attribute(name,value,stars);
		case "Melee Skill":attributes[4]=new Attribute(name,value,stars);
		case "Ranged Skill":attributes[5]=new Attribute(name,value,stars);
		case "Melee Defence":attributes[6]=new Attribute(name,value,stars);
		case "Ranged Defence":attributes[7]=new Attribute(name,value,stars);
		}
	}
}
