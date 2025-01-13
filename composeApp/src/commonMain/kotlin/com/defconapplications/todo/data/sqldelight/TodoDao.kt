package com.defconapplications.todo.data.sqldelight

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.defconapplications.todo.Item
import com.defconapplications.todo.TodoItemsDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

class TodoDao(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = TodoItemsDB(
        driver = databaseDriverFactory.createDriver(),
        ItemAdapter = Item.Adapter(
            deadline_dateAdapter = dateAdapter,
            deadline_timeAdapter = timeAdapter
        )
    )
    private val dbQuery = database.todoItemsDBQueries

    fun getItems(): Flow<List<Item>> = dbQuery.getItems()
        .asFlow()
        .mapToList(Dispatchers.IO)

    fun removeItem(id: Long) = dbQuery.removeItem(id)

    fun insertItem(title: String, deadlineDate: LocalDate, deadlineTime: LocalTime?) =
        dbQuery.insertItem(null, title, deadlineDate, deadlineTime)
}

