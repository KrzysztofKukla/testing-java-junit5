package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Krzysztof Kukla
 */
@Tag("modelRepeated")
public interface ModelRepeatedTest {

    //RepetitionInfo is NOT available for non repeatedTest
    //so this interface can implement only class that contains only @RepeatedTest
    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("DisplayName test-> " + testInfo.getDisplayName());
        System.out.println("Current repetition-> " + repetitionInfo.getCurrentRepetition());

    }

}
