package com.defconapplications.todo.di

import com.defconapplications.todo.data.sqldelight.DatabaseDriverFactory
import com.defconapplications.todo.utils.ViewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope

actual inline fun <reified T : ViewModel> Module.viewModel(crossinline def: Scope.() -> T) {
    factory<T> { def() }
}

actual fun Module.nativeDefinitions() {
    factory { DatabaseDriverFactory() }
}