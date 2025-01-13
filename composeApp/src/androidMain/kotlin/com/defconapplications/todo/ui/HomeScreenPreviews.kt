package com.defconapplications.todo.ui

import ViewTodoItem
import ViewTodoSection
import androidx.compose.runtime.Composable
import com.defconapplications.todo.ui.home.HomeScreenContent
import com.defconapplications.todo.ui.home.HomeState
import com.defconapplications.todo.ui.theme.TodoTheme

@Previews
@Composable
fun HomeScreenPreview() {
    TodoTheme {
        HomeScreenContent(
            HomeState(
                listOf(
                    ViewTodoSection(
                        title = "today",
                        items = listOf(
                            ViewTodoItem("go to work", ""),
                            ViewTodoItem("take out trash", "7:30pm")
                        )
                    ),
                    ViewTodoSection(
                        title = "tomorrow",
                        items = listOf(
                            ViewTodoItem("eat something", ""),
                        )
                    ),
                )
            )
        )
    }
}