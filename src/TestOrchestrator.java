import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// TODO add async
public enum TestOrchestrator {
    TEST_ORCHESTRATOR;
    private Method[] getTestMethods() throws ClassNotFoundException {
        Class<?> testSuit = Class.forName("TestSuite");
        return testSuit.getDeclaredMethods();
    }
    private Map<String, String> buildResults(Method[] methods) {
        Map<String,String> methodNamesOutputsMap = new HashMap<>();
        for (Method method:methods
        ) {
            try {
                methodNamesOutputsMap.put(method.getName(), method.invoke(methods).toString());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return methodNamesOutputsMap;
    }

    private void printSummary(Map<String, String> mapOfMethodNamesAndOutputs){
        mapOfMethodNamesAndOutputs.forEach((k, v) -> System.out.printf( "%-15s %15s %n",k,v));
    }
    void runTestSuite() {
        try {
            printSummary(buildResults(getTestMethods()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
