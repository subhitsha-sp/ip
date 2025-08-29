package bubbles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    @Test
    public void showAdd_success() {
        Ui ui = new Ui();
        Task taskName = new Task("suby");
        int taskCount = 12;

        String result = ui.showAdd(taskName, taskCount);

        String expected = """
            New bubble added to your list 📃
            suby
            Wohoo! You've got 12 sparkly tasks floating in your list! ✨""";

        assertEquals(expected, result);
    }
}
