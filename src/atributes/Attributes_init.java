package atributes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

public abstract class Attributes_init {
	private static final File perks_dir=new File("Perks");
	private static final File perks_basic=new File("PerksList.dat");
	private static final Vector <String> basic_perks_names= new Vector <String>();
	private static final Vector <Integer> basic_perks_tiers= new Vector <Integer>();
	private static Vector <Perk> perks=new Vector <Perk>();
	
	public static Perk search_perk(String name) {
		for(Perk x:perks) {
			if(x.name==name) {
				return x;
			}
		}
		return null;
	}
	
	public static void init() {
		create_dirs();
		load_perks();
	}
	
	
	private synchronized static void create_dirs() {
		if(!perks_dir.exists()) {
			perks_dir.mkdir();
			basic_perks_init();
			perks_creation();
		}
	}
	
	private synchronized static void basic_perks_init() {
		if(!perks_dir.exists()) {
			System.err.println("ERROR CODE: 636");
			return;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(perks_basic));
			String line=reader.readLine();
			while(line!=null) {
				String name="";
				int tier=0;
				int y=0;
				for(int x=0;x<line.length();x++) {
					if(line.charAt(x)==';')
						y+=1;
					if(y==0)
						name+=line.charAt(x);
					else if(y==1)
						tier=Character.getNumericValue(line.charAt(x));
				}
				basic_perks_names.add(name);
				basic_perks_tiers.add(tier);
				line=reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("ERROR CODE: 637");
			return;
		}
		
		
	}
	/*
	 * basic_perks_names.add("");
		basic_perks_tiers.add();
	 */
	
	private synchronized static void load_perks() {
		for(File file:perks_dir.listFiles()) {
			FileInputStream fi;
			try {
				fi = new FileInputStream(file);
				ObjectInputStream oi = new ObjectInputStream(fi);
				perks.add((Perk) oi.readObject());
				fi.close();
				oi.close();
			} catch (FileNotFoundException e) {
				System.err.println("ERROR CODE: 641");
				return;
			} catch (ClassNotFoundException e) {
				System.err.println("ERROR CODE: 642");
				return;
			} catch (IOException e) {
				System.err.println("ERROR CODE: 643");
				return;
			}
		}
	}
	
	private synchronized static void perks_creation() {
		for(int x=1;x<basic_perks_names.size();x++) {
			Perk tmp=new Perk(basic_perks_names.elementAt(x), basic_perks_tiers.elementAt(x));
			try {
				tmp.save_perk();
			} catch (IOException e) {
				System.err.println("ERROR CODE: 651");
				return;
			}
			tmp=null;
		}
	}
}
