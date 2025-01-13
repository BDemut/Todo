package com.defconapplications.todo.data.sqldelight

import app.cash.sqldelight.ColumnAdapter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

val dateAdapter = object : ColumnAdapter<LocalDate, Long> {
    override fun decode(databaseValue: Long): LocalDate =
        LocalDate.fromEpochDays(databaseValue.toInt())

    override fun encode(value: LocalDate): Long =
        value.toEpochDays().toLong()
}

val timeAdapter = object : ColumnAdapter<LocalTime, Long> {
    override fun decode(databaseValue: Long): LocalTime =
        LocalTime.fromSecondOfDay(databaseValue.toInt())

    override fun encode(value: LocalTime): Long =
        value.toSecondOfDay().toLong()
}