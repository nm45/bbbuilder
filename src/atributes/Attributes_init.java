package atributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

public abstract class Attributes_init {
	private static final File perks_dir=new File("Perks");
	private static final Vector <String> basic_perks_names= new Vector <String>();
	private static final Vector <String> basic_perks_desc= new Vector <String>();
	private static final Vector <Integer> basic_perks_tiers= new Vector <Integer>();
	public static Vector <Perk> perks=new Vector <Perk>();
	
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
		basic_perks_names.add("Fast Adaptation");
		basic_perks_desc.add("Adapt to your opponent's moves! Gain an additional stacking +8% chance to hit with each attack that misses an opponent. Bonus is reset upon landing a hit.\r\n" + 
				"Note: For the purposes of a reset on ranged attacks, hitting terrain blocking the target counts as a hit and will reset the counter.");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Crippling Strikes");
		basic_perks_desc.add("Cripple your enemies! Lowers the threshold to inflict injuries by 33% for both melee and ranged attacks.");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Colossus");
		basic_perks_desc.add("Bring it on! Hitpoints are increased by 25%, which also reduces the chance to sustain debilitating injuries when being hit.\r\n" + 
				"Note: the bonus is always retroactively updated with maximum hitpoints.");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Nine Lives");
		basic_perks_desc.add("Once per battle, upon receiving a killing blow, survive instead with a few hitpoints left. The next hit is likely to kill you for good, of course.\r\n" + 
				"Note: hitpoints gained are a random number between 5-10.");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Bags and Belts");
		basic_perks_desc.add("Unlock two extra bag slots to carry all your favorite things. Items placed in bags no longer give a penalty to Maximum Fatigue, except for two-handed weapons");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Pathfinder");
		basic_perks_desc.add("Learn to move on difficult terrain. Action Point costs for movement on all terrain is reduced by -1 to a minimum of 2 Action Points per tile, and Fatigue cost is reduced to half. Changing height levels also has no additional Action Point cost anymore.");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Adrenaline");
		basic_perks_desc.add("Unlocks the 'Adrenaline' skill (0 AP and 20 Fatigue cost) which puts you first in the turn order for the next round, to have another turn before your enemies do. Feel the adrenaline rushing through your veins!\r\n" + 
				"Note: if two characters are using Adrenaline the one with the highest Initiative will act first.");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Recover");
		basic_perks_desc.add("Unlocks the 'Recover' skill which allows for resting a turn (9 AP cost) in order to reduce accumulated Fatigue by 50%.");
		basic_perks_tiers.add(1);
		
		basic_perks_names.add("Student");
		basic_perks_desc.add("Everything can be learned if you put your mind to it. Gain additional 20% experience from battle. At the eleventh character level, you gain an additional perk point upon and this perk becomes inert.");
		basic_perks_tiers.add(1);
		
		
	}
	/*
	 * basic_perks_names.add("");
		basic_perks_desc.add("");
		basic_perks_tiers.add();
	 */
	
	private synchronized static void load_perks() {
		for(File file:perks_dir.listFiles()) {
			FileInputStream fi;
			try {
				fi = new FileInputStream(file);
				ObjectInputStream oi = new ObjectInputStream(fi);
				perks.add((Perk) oi.readObject());
				System.out.println(perks.lastElement().name);
				fi.close();
				oi.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized static void perks_creation() {
		for(int x=1;x<basic_perks_names.size();x++) {
			Perk tmp=new Perk(basic_perks_names.elementAt(x), basic_perks_desc.elementAt(x), basic_perks_tiers.elementAt(x));
			try {
				tmp.save_perk();
			} catch (IOException e) {
				e.printStackTrace();
			}
			tmp=null;
		}
	}
}
