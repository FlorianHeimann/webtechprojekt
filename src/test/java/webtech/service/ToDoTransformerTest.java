package webtech.service;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import webtech.persistence.ToDoEntity;

import java.time.LocalDate;

import static org.mockito.Mockito.doReturn;

class ToDoTransformerTest implements WithAssertions {

    private final ToDoTransformer underTest = new ToDoTransformer();

    @Test
    @DisplayName("should transform PersonEntity to Person")
    void should_transform_person_entity_to_person() {
        LocalDate dateNow = LocalDate.now();

        // given
        var toDoEntity = Mockito.mock(ToDoEntity.class);
        doReturn(111L).when(toDoEntity).getId();
        doReturn("Test ToDo").when(toDoEntity).getTask();
        doReturn(true).when(toDoEntity).isDone();
        doReturn(dateNow).when(toDoEntity).getDueTo();
        doReturn(dateNow).when(toDoEntity).getCreated();
        doReturn("Test").when(toDoEntity).getOwner();

        // when
        var result = underTest.transformEntity(toDoEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getTask()).isEqualTo("Test ToDo");
        assertThat(result.isDone()).isEqualTo(true);
        assertThat(result.getDueTo()).isEqualTo(dateNow);
        assertThat(result.getCreated()).isEqualTo(dateNow);
        assertThat(result.getOwner()).isEqualTo("Test");
    }

    @Test
    @DisplayName("should transform PersonEntity to Person")
    void should_fail_to_transform_person_entity_to_person_with_Task() {
        LocalDate dateNow = LocalDate.now();

        // given
        var toDoEntity = Mockito.mock(ToDoEntity.class);
        doReturn(111L).when(toDoEntity).getId();
        doReturn("Test ToDo").when(toDoEntity).getTask();
        doReturn(true).when(toDoEntity).isDone();
        doReturn(dateNow).when(toDoEntity).getDueTo();
        doReturn(dateNow).when(toDoEntity).getCreated();
        doReturn("Test").when(toDoEntity).getOwner();

        // when
        var result = underTest.transformEntity(toDoEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getTask()).isNotEqualTo("falsche Aussage");
        assertThat(result.isDone()).isEqualTo(true);
        assertThat(result.getDueTo()).isEqualTo(dateNow);
        assertThat(result.getCreated()).isEqualTo(dateNow);
        assertThat(result.getOwner()).isEqualTo("Test");
    }

    @Test
    @DisplayName("should transform PersonEntity to Person")
    void should_fail_to_transform_person_entity_to_person_with_DueTo() {
        LocalDate dateNow = LocalDate.now();

        // given
        var toDoEntity = Mockito.mock(ToDoEntity.class);
        doReturn(111L).when(toDoEntity).getId();
        doReturn("Test ToDo").when(toDoEntity).getTask();
        doReturn(true).when(toDoEntity).isDone();
        doReturn(dateNow).when(toDoEntity).getDueTo();
        doReturn(dateNow).when(toDoEntity).getCreated();
        doReturn("Test").when(toDoEntity).getOwner();

        // when
        var result = underTest.transformEntity(toDoEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getTask()).isEqualTo("Test ToDo");
        assertThat(result.isDone()).isEqualTo(true);
        assertThat(result.getDueTo()).isNotEqualTo(LocalDate.now().atStartOfDay());
        assertThat(result.getCreated()).isEqualTo(dateNow);
        assertThat(result.getOwner()).isEqualTo("Test");
    }
}
