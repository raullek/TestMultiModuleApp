package ru.sberbank.core.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Provides

class CoreModule(val context: Application) {
    companion object {
        const val preferencesName = "PREF_NAME"
    }

    @Provides
    fun getSharedPreferences(): SharedPreferences =
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)

}