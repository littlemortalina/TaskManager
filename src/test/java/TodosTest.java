import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInOneSimpleTask() { // поиск по одной простой задаче
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        Task[] result = todos.search("Позвонить родителям");
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(simpleTask, result[0]);
    }

    @Test
    public void shouldSearchInSimpleTaskMultiple() { // поиск по нескольким простым задачам
        SimpleTask task1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "Позвонить сестре");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);

        Task[] result = todos.search("Позвонить");
        assertEquals(2, result.length);
        Assertions.assertArrayEquals(new Task[]{task1, task2}, result);
    }

    @Test
    public void shouldSearchInOneMeetingByTopic() { // поиск по одной встрече по теме
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);
        Task[] result1 = todos.search("Выкатка 3й версии приложения");
        Assertions.assertEquals(1, result1.length);
        Assertions.assertEquals(meeting, result1[0]);
    }

    @Test
    public void shouldSearchInOneMeetingByProject() { // поиск по одной встрече по проекту
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);
        Task[] result = todos.search("Приложение НетоБанка");
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(meeting, result[0]);
    }

    @Test
    public void shouldSearchInMeetingByTopicMultiple() { // поиск по нескольким встречам по теме
        Meeting meeting1 = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(557,
                "Выкатка 4й версии приложения",
                "Приложение банка",
                "В среду после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] result = todos.search("Выкатка");
        Assertions.assertEquals(2, result.length);
        Assertions.assertArrayEquals(new Task[]{meeting1, meeting2}, result);
    }

    @Test
    public void shouldSearchInMeetingByProjectMultiple() { // поиск по нескольким встречам по проекту
        Meeting meeting1 = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(557,
                "Выкатка 4й версии приложения",
                "Приложение банка",
                "В среду после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] result = todos.search("Приложение");
        Assertions.assertEquals(2, result.length);
        Assertions.assertArrayEquals(new Task[]{meeting1, meeting2}, result);
    }

    @Test
    public void shouldSearchInOneEpic() { // поиск по одному эпику
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        Task[] result = todos.search("Молоко");
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(epic, result[0]);
    }

    @Test
    public void shouldSearchInSEpicMultiple() { // поиск по нескольким эпикам
        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        String[] subtasks2 = {"Молоко", "Яйца", "Булка"};
        Epic epic1 = new Epic(55, subtasks1);
        Epic epic2 = new Epic(57, subtasks2);
        Todos todos = new Todos();
        todos.add(epic1);
        todos.add(epic2);
        Task[] result = todos.search("Молоко");
        Assertions.assertEquals(2, result.length);
        Assertions.assertArrayEquals(new Task[]{epic1, epic2}, result);
    }
}

