package listenersdemo;

import org.testng.*;

/*
This class contains all the methods of the CustomListenerWithInvokeMethod, CustomListenerWithSuite and
CustomListenerWithTests. This way we can run all the custom listeners together in a test suite with this CustomListener
class that was defined within the <Listeners> tag in the testng-listeners.xml file.
 */
public class CustomListenersPostRefactor implements IInvokedMethodListener, ITestListener, ISuiteListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // This method runs before ANY method is run inside our testNG class. Not only the test methods.
        System.out.println("beforeInvocation: " + testResult.getTestClass().getName() +
                " => " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // This method runs after ANY method is run inside our testNG class. Not only the test methods.
        System.out.println("afterInvocation: " + testResult.getTestClass().getName() +
                " => " + method.getTestMethod().getMethodName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        // When test method starts
        System.out.println("onTestStart -> Test Name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // If test method is successful
        System.out.println("onTestSuccess -> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // If test method is failed
        System.out.println("onTestFailure -> Test Name: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // If test method is failed
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Ignore this
    }

    @Override
    public void onStart(ITestContext context) {
        // Before <test> tag of xml file
        System.out.println("onStart -> Test Tag Name: " + context.getName());
        ITestNGMethod methods[] = context.getAllTestMethods();
        System.out.println("These methods will be executed in this test tag:");
        for (ITestNGMethod method : methods) {
            System.out.println(method.getMethodName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        // After <test> tag of xml file
        System.out.println("onFinish -> Test Tag Name: " + context.getName());
    }

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
