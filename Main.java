import java.applet.Applet;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        // Create an instance of the register class
        register m2 = new register();

        // Assuming state is initialized within the register class
        int state = m2.getState();
        System.out.println(state);


        if (state == 1) {
            //new Dashboard();
        } else {
            m2.login();
        }
    }
}
