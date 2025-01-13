package com.defconapplications.todo.di

import TodoRepository
import com.defconapplications.todo.data.sqldelight.DatabaseDriverFactory
import com.defconapplications.todo.data.sqldelight.TodoDao
import com.defconapplications.todo.ui.home.HomeScreenViewModel
import com.defconapplications.todo.ui.home.mappers.HomeTodoItemSectionMapper
import com.defconapplications.todo.utils.ViewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope
import org.koin.dsl.module

object AppKoinModuleFactory {
    fun create() = module {
        nativeDefinitions()

        factory { TodoDao(databaseDriverFactory = get()) }

        single { TodoRepository(dao = get()) }

        factory { HomeTodoItemSectionMapper() }

        viewModel { HomeScreenViewModel(repository = get(), mapper = get()) }
    }
}

expect inline fun <reified T : ViewModel> Module.viewModel(crossinline def: Scope.() -> T)

expect fun Module.nativeDefinitions()