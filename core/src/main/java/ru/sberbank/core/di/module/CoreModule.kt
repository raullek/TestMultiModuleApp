package ru.sberbank.core.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.sberbank.core.helper.DataPreferences
import ru.sberbank.core.helper.DataPreferencesImpl
import javax.inject.Singleton

@Module
class CoreModule(val context: Application) {
    companion object {
        const val preferencesName = "PREF_NAME"
    }

    @Provides
    @Singleton
    fun getSharedPreferences(): SharedPreferences =
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun getPreferences(dataPreferences: DataPreferencesImpl): DataPreferences = dataPreferences


}