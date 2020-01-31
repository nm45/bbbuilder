package main;

import java.io.IOException;

import atributes.Perk;

public class bbb_main {

	public static void main(String[] args) {
		try {
			Main_init.start_init();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
