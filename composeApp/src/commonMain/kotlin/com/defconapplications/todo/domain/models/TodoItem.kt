package com.defconapplications.todo.domain.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

data class TodoItem(
    val id: Long,
    val title: String,
    val deadline: Deadline
)

sealed class Deadline {
    abstract val date: LocalDate
    data class Date(override val date: LocalDate) : Deadline()
    data class DateTime(
        override val date: LocalDate,
        val time: LocalTime
    ) : Deadline()
}