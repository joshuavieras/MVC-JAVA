package JavaMVCControllers;
import JavaMVCModels.*;
import JavaMVCViews.*;
public class HelloWorldController {
	private HelloWorldModel model = new HelloWorldModel();
	
public void startApplication() {
	
	HelloWorldView view = new HelloWorldView();
	view.setVisible(true);
	
}
public String getMessage(String path) {
	try {
		return model.getData(path);
	}catch(Exception er) {
		return "There was an error.";
	}
}
public boolean writeMessage(String message,String path) {
	try {
		return model.writeData(message);
	}catch(Exception er) {
		return false;
	}
}
}
