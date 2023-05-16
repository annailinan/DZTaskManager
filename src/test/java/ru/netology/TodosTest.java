package ru.netology;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить дочери");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Продажи за квартал",
                "доля собственной доставки",
                "Понедельник 13:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReturnEmptyArrayWhenSearchingWithNoMatches() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить успокоительное"));
        todos.add(new Epic(2, new String[]{"Сделать домашнее задание"}));
        Task[] expected = {};
        Task[] actual = todos.search("погулять с собакой");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfTasksWhenSearchingWithOneMatch() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить успокоительное"));
        todos.add(new Epic(2, new String[]{"Сделать домашнее задание"}));
        Task[] expected = { new SimpleTask(1, "успокоительное") };
        Task[] actual = todos.search("успокоительное");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfAllTasksWhenSearchingWithEmptyQuery() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить успокоительное"));
        todos.add(new Epic(2, new String[]{"Сделать домашнее задание"}));
        Task[] expected = { new SimpleTask(1, "Купить успокоительное"), new Epic(2, new String[]{"Сделать домашнее задание"}) };
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }


}