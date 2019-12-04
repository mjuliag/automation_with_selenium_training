package ListenersDemo;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomListenerWithSuite implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        // When <suite> tag starts
        System.out.println("onStart: before suite starts");
    }

    @Override
    public void onFinish(ISuite suite) {
        // When <suite> tag completes
        System.out.println("onFinish: after suite completes");
    }
}
