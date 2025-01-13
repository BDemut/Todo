package com.defconapplications.todo.data.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.defconapplications.todo.TodoItemsDB

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(TodoItemsDB.Schema, "items.db")
    }
}
