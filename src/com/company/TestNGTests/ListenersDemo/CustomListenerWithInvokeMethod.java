package ListenersDemo;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListenerWithInvokeMethod implements IInvokedMethodListener {

    /*
    This method runs before ANY method is run inside our testNG class. Not only the test methods.
     */
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("beforeInvocation: " + testResult.getTestClass().getName() +
                " => " + method.getTestMethod().getMethodName());
    }

    /*
    This method runs after ANY method is run inside our testNG class. Not only the test methods.
    */
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("afterInvocation: " + testResult.getTestClass().getName() +
                " => " + method.getTestMethod().getMethodName());
    }
}
