import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void ShouldFindMatchesInSimpleTaskPositive() { // позитивный тест для matches у простой задачи
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertEquals(true, task.matches("Позвонить родителям"));
    }

    @Test
    public void ShouldFindMatcheInSimpleTaskNegative() { // негативный тест для matches у простой задачи
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertEquals(false, task.matches("Купить хлеб"));
    }


    @Test
    public void ShouldFindMatchesInMeetingsTopicPositive() { // позитивный тест для matches у встречи по теме
        Meeting meeting = new Meeting( // позитивный тест для matches у встречи
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertEquals(true, meeting.matches("Выкатка 3й версии приложения"));

    }

    @Test
    public void ShouldFindMatchesInMeetingsProjectPositive() { // позитивный тест для matches у встречи по проекту
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertEquals(true, meeting.matches("Приложение НетоБанка"));
    }

    @Test
    public void ShouldFindMatchesInMeetingsNegative() { // негативный тест для matches у встречи
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertEquals(false, meeting.matches("На следующей неделе"));
    }

    @Test
    public void ShouldFindMatchesInEpicPositive() { // позитивный тест для matches у эпика
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertEquals(true, epic.matches("Хлеб"));
    }

    @Test
    public void ShouldFindMatchesInEpicNegative() { // негативный тест для matches у эпика
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertEquals(false, epic.matches("Колбаса"));
    }
}
