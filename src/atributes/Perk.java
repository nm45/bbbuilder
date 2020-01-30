package atributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
@SuppressWarnings("unused")
public final class Perk implements Serializable{
	
	private static final long serialVersionUID = 778436289048909543L;
	
	private String name,desc;
	public Perk(String name,String desc) {
		this.name=name;
		this.desc=desc;
	}
	protected void save_perk() throws IOException {
		File f=new File("/perks/"+name+".perk");
		if(f.exists()) {
			System.err.println("ERROR CODE: 444");
			return;
		}
		FileOutputStream fout = new FileOutputStream("/perks/"+name+".perk");
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
