public class Assertions {

    static String assertEqual(int result, int expectedResult) {
        if (result == expectedResult) {
            return "PASS";
        } else
            return "FAIL";
    }

    public static String assertEqual(String result, String expectedResult) {
        if (result.equals(expectedResult)) {
            return "PASS";
        } else
            return "FAIL";
    }
}
