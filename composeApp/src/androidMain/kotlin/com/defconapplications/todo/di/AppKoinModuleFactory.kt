package com.defconapplications.todo.di

import com.defconapplications.todo.data.sqldelight.DatabaseDriverFactory
import com.defconapplications.todo.utils.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope

actual inline fun <reified T : ViewModel> Module.viewModel(crossinline def: Scope.() -> T) {
    viewModel<T> { def() }
}

actual fun Module.nativeDefinitions() {
    factory { DatabaseDriverFactory(androidContext()) }
}