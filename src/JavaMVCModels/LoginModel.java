package JavaMVCModels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.Mac;

public class LoginModel {
	
	InputStream imps=this.getClass().getResourceAsStream("/credenciales.txt");
	InputStreamReader iR =new InputStreamReader(imps);
	public boolean getCredentials(String usuario, String contrasena)throws FileNotFoundException, IOException{
		boolean verificacredenciales=false;
		
		try(BufferedReader reader=new BufferedReader(iR)){
			String line= reader.readLine();
			while(line!=null&&verificacredenciales==false) {
				String[] datos=line.split("-");
				if(datos[0].equals(usuario)&&datos[1].equals(contrasena)) {
					verificacredenciales=true;
				}else {
					line= reader.readLine();
				}
			}
			return verificacredenciales;
		}catch(Exception er) {
			return verificacredenciales;
		}

	}
}
