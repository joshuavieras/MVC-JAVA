package JavaMVCControllers;
import JavaMVCModels.HelloWorldModel;
import JavaMVCModels.LoginModel;
import JavaMVCViews.LoginView;
public class LoginController {
	public void startApplication() {
		LoginView view = new LoginView();
		view.setVisible(true);
	}
	
	public boolean getCredentials(String user, String pass) {
		try {
			LoginModel model = new LoginModel();
			return model.getCredentials(user, pass);
		}catch(Exception er) {
			return false;
		}
	}
}
