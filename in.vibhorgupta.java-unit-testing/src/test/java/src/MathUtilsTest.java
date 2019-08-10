package src;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {


    //It is Not Backward Compatible
    //yet can be made using different syntax

    MathUtils mathUtils;

    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {

        System.out.println("This needs to run before All");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("test working"+testInfo + "withtags " + testInfo.getDisplayName());

    }

    @AfterEach
    void cleanUp() {

        System.out.println("Cleaning up code ....");
    }

    @Tag("Area of Something")
    @Test
    void computeTestArea() {
        assertEquals(314.1592653589793, mathUtils.computeTestArea(10), "Test worked perfectly");
    }

    @Tag("Maths")
    @RepeatedTest(4)
    void testDivide(RepetitionInfo repetitionInfo) {
        mathUtils.divide(1, 0);
        assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0), "Divide by 0 should throw");
    }

    @Test
    @DisplayName("test disabled method")
    @Disabled
    void testDisabled() {
        fail("This test is disabled");

    }
    @Tag("Maths")
    @Test
    @DisplayName("multiply method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2), ""),
                () -> assertEquals(0, mathUtils.multiply(2, 0), ""),
                () -> assertEquals(-2, mathUtils.multiply(2, -1), "")
        );

    }

    @Nested
    class AddTest {

        @Tag("Maths")
        @DisplayName("add  method positive")
        @Test
        void testAddPositive() {
            System.out.println("test working");
            int expectedValue = 2;
            int actualValue = mathUtils.add(1, 1);
            assertEquals(expectedValue, actualValue);

//        assertIterableEquals();
//        assertArrayEquals();
//        assertAll();
//        assertFalse();
        }
        @Tag("Maths")
        @DisplayName("add  method negative")
        @Test
        void testAddNegative() {
            testReporter.publishEntry("test working"+testInfo + "withtags " + testInfo.getTags());
            int expectedValue = -2;
            int actualValue = mathUtils.add(-1, -1);
            assertEquals(expectedValue, actualValue);


        }

    }
}