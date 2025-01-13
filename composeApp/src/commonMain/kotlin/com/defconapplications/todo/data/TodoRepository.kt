import com.defconapplications.todo.data.sqldelight.TodoDao
import com.defconapplications.todo.domain.models.Deadline
import com.defconapplications.todo.domain.models.TodoItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.Month

class TodoRepository(
    private val dao: TodoDao,
) {
    private val dbScope = CoroutineScope(Dispatchers.IO)
    init {
        listOf(
            TodoItem(1,"Task 1", Deadline.Date(LocalDate(2024, Month.DECEMBER, 1))),
            TodoItem(1,"Task 2", Deadline.DateTime(LocalDate(2024, Month.MAY, 6), LocalTime(7, 30))),
            TodoItem(1,"Task 3", Deadline.Date(LocalDate(2024, Month.JUNE, 15))),
            TodoItem(1,"Task 4", Deadline.Date(LocalDate(2024, Month.JUNE, 16))),
            TodoItem(1,"Task 5", Deadline.Date(LocalDate(2024, Month.JUNE, 16))),
            TodoItem(1,"Task 6", Deadline.Date(LocalDate(2024, Month.JUNE, 1))),
            TodoItem(1,"Task 7", Deadline.Date(LocalDate(2024, Month.JUNE, 2))),
            TodoItem(1,"Task 8", Deadline.Date(LocalDate(2024, Month.JUNE, 3)))
        ).forEach {
            insert(it.title, it.deadline)
        }
    }

    val items = dao.getItems()
        .map { allItems ->
            allItems.map {
                val deadline = if (it.deadline_time == null) {
                    Deadline.Date(it.deadline_date)
                } else {
                    Deadline.DateTime(it.deadline_date, it.deadline_time)
                }
                TodoItem(it.id, it.title, deadline)
            }
        }

    fun insert(title: String, deadline: Deadline) {
        dbScope.launch {
            dao.insertItem(title, deadline.date, (deadline as? Deadline.DateTime)?.time)
        }
    }

    fun delete(id: Long) {
        dbScope.launch {
            dao.removeItem(id)
        }
    }
}