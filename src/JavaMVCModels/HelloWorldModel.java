package JavaMVCModels;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloWorldModel {
	
String myfile = "src/texto.txt";

public String getData(String path)throws FileNotFoundException, IOException{
	myfile=path;
	if(!(new File(myfile).isFile())) {
		
	Files.createFile(Paths.get(myfile));
	}
	String data;
	try(BufferedReader reader=new BufferedReader(new FileReader(myfile))){
		StringBuilder string =new StringBuilder();
		String line= reader.readLine();
		while(line!=null) {
			string.append(line+"\n");
			line=reader.readLine();
		}
		data=string.toString();
	}catch(Exception er) {
		data=er.getMessage();
	}
	return data;
}
public boolean writeData(String data) throws IOException, FileNotFoundException{
	try(BufferedWriter writer =new BufferedWriter(new FileWriter(myfile))){
		writer.write(data);
		return true;
	}catch(Exception er) {
		return false;
	}
}


}
