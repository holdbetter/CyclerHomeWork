import com.holdbetter.Bicycle;
import com.holdbetter.Cycler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CyclerTest
{
    private final Bicycle bicycleStark = new Bicycle("Stark Hunter 27.2 HD", 60, 25000);
    private final Bicycle bicycleStels = new Bicycle("Stels Navigator 610 D 26 V010 (2020)", 60, 23570);
    private final Bicycle[] bicycles = { bicycleStark, bicycleStels };
    private final Cycler cycler = new Cycler("Vilen",
            "Evseev",
            "Russia",
            25,
            26, bicycleStark, bicycleStels);

    @Test
    void initCycler_DataInitialization()
    {
        Assertions.assertEquals("Vilen", cycler.getName());
        Assertions.assertEquals("Evseev", cycler.getLastName());
        Assertions.assertEquals("Russia", cycler.getCountry());
        Assertions.assertEquals(25, cycler.getAge());
        Assertions.assertEquals(26, cycler.getSpeedAverage());
    }

    @Test
    void initCycler_AllBicyclesWasAdded()
    {
        assertTrue(Arrays.asList(cycler.getBicycles()).containsAll(Arrays.asList(bicycles)), "Some bicycle not in array");
    }

    @Test
    void nonNullBicycleCount_whenCalled_countIsEqualForAddedBicycles()
    {
        Assertions.assertEquals(bicycles.length, cycler.getNonNullBicycleCount(), "Not all bicycles added successfully");
    }

    @Test
    void goIn_cyclersCountIncreased()
    {
        Assertions.assertEquals(1, cycler.goIn());
        Assertions.assertEquals(1, cycler.goIn());
        Assertions.assertEquals(1, cycler.goIn());
    }

    @Test
    void goOut_cyclersCountIncreased()
    {
        Assertions.assertEquals(0, cycler.goOut());
        Assertions.assertEquals(0, cycler.goOut());
        Assertions.assertEquals(0, cycler.goOut());
    }

    @Test
    void addBicycle_argsNotNull_cyclerContainsBicycleInArray()
    {
        Bicycle bicycle = new Bicycle("Merida Big.Nine 15-D (2020)", 60, 38220);
        assertFalse(Arrays.asList(cycler.getBicycles()).contains(bicycle), "Some bicycle not in array");
        cycler.addBicycle(bicycle);
        assertTrue(Arrays.asList(cycler.getBicycles()).contains(bicycle), "Some bicycle not in array");
    }

    @ParameterizedTest
    @NullSource
    void addBicycle_argsIsNull_countNotChanges(Bicycle bicycle)
    {
        int count = cycler.getBicycles().length;
        cycler.addBicycle(bicycle);
        assertEquals(count, cycler.getBicycles().length);
    }

    @Test
    void finish_whenCalled_IsEqual()
    {
        double numerator = 10.0 / (cycler.getAge() * cycler.getAge());
        double denominator = cycler.getBicycles()[0].getMaxSpeed() * cycler.getSpeedAverage();
        assertEquals(numerator / denominator, cycler.finish());
    }

    @Test
    void checkCyclersOnTour_IsCountEqual()
    {
        Cycler cycler = new Cycler("", "", "", 0, 0.0, null);
        Cycler cycler1 = new Cycler("", "", "", 0, 0.0, null);
        Cycler cycler2 = new Cycler("", "", "", 0, 0.0, null);

        cycler.goIn();
        cycler1.goIn();
        cycler2.goIn();

        assertEquals(3, Cycler.getCyclersOnTourCount());

        cycler.goOut();
        cycler1.goOut();
        cycler2.goOut();
    }

//    @Test
//    public void cyclersOnTour_initCounter_countIsEqual()
//    {
//        Cycler cycler = new Cycler("", "", "", 0, 0.0, null);
//        Cycler cycler1 = new Cycler("", "", "", 0, 0.0, null);
//        Cycler cycler2 = new Cycler("", "", "", 0, 0.0, null);
//        assertEquals(4, Cycler.cyclersOnTour.length);
//    }

    //    @ParameterizedTest
    //    @MethodSource("bicycleArguments")
    //    void checkBicycleWasAdded(Bicycle bicycle)
    //    {
    //        assertTrue(Arrays.asList(cycler.getBicycles()).contains(bicycle), "Some bicycle not in array");
    //    }

    //    private static Stream<Arguments> bicycleArguments()
    //    {
    //        return Stream.of(
    //                Arguments.arguments(bicycleStark1),
    //                Arguments.arguments(bicycleStark2)
    //        );
    //    }
}
