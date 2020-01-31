package atributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
@SuppressWarnings("unused")
public final class Perk implements Serializable{
	
	private static final long serialVersionUID = 778436289048909543L;
	
	public String name,desc;
	private int tier;
	public Perk(String name,String desc,int tier) {
		this.name=name;
		this.desc=desc;
		this.tier=tier;
	}
	public void save_perk() throws IOException {
		File f=new File("Perks/"+name+".perk");
		
		if(f.exists()) {
			System.err.println("ERROR CODE: 444");
			return;
		}
		FileOutputStream fout = new FileOutputStream("Perks/"+name+".perk");
	    ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
		fout.close();
		if(!f.exists()) {
			System.err.println("ERROR CODE: 445");
			return;
		}
	}
}
