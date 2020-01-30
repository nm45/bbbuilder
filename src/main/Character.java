package main;

import java.util.Vector;

import atributes.Attribute;
@SuppressWarnings("unused")
public class Character {
	private Attribute atributes[];
	private String name;
	Character(String name,Vector <Integer> atributes,Vector <Integer> stars){
		atributes_init(atributes,stars);
		this.name=name;
		
	}
	
	private void atributes_init(Vector <Integer> atributes,Vector <Integer> stars) {
		if(atributes.size()!=8) {
			System.err.println("ERROR CODE: 783");
			return;
		}
		if(stars.size()!=8) {
			System.err.println("ERROR CODE: 784");
			return;	
		}
		this.atributes[0]=new Attribute("HP", atributes.elementAt(1), stars.elementAt(1));
		this.atributes[1]=new Attribute("Max Fatigue", atributes.elementAt(2), stars.elementAt(2));
		this.atributes[2]=new Attribute("Resolve", atributes.elementAt(3), stars.elementAt(3));
		this.atributes[3]=new Attribute("Initiative", atributes.elementAt(4), stars.elementAt(4));
		this.atributes[4]=new Attribute("Melee Skill", atributes.elementAt(5), stars.elementAt(5));
		this.atributes[5]=new Attribute("Ranged Skill", atributes.elementAt(6), stars.elementAt(6));
		this.atributes[6]=new Attribute("Melee Defence", atributes.elementAt(7), stars.elementAt(7));
		this.atributes[7]=new Attribute("Ranged Defence", atributes.elementAt(8), stars.elementAt(8));
	}
	
}
