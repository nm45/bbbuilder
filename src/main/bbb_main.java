package main;

import java.io.IOException;

public class bbb_main {

	public static void main(String[] args) {
		try {
			Main_init.start_init();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
