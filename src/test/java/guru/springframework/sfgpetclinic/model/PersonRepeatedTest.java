package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import java.util.Set;

/**
 * @author Krzysztof Kukla
 */
public class PersonRepeatedTest implements ModelRepeatedTest {

    @DisplayName("My Repeated test of->")
    @RepeatedTest(value = 10, name = RepeatedTest.DISPLAY_NAME_PLACEHOLDER + RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    void repeatedTest() throws Exception {

    }

    @RepeatedTest(5)
        //TestInfo and RepetitionInfo will be inject
    void repeatedTestWithDependencyInjection(TestInfo testInfo, RepetitionInfo repetitionInfo) throws Exception {
        String displayName = testInfo.getDisplayName();
        Set<String> tags = testInfo.getTags();
        System.out.println(displayName+"-> ");
        tags.forEach((t)-> System.out.println("tag-> "+t));
        System.out.println("current-> "+repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    void repetitionInfo(){

    }
}
