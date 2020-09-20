package ru.sberbank.core.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.sberbank.core.di.module.CoreModule
import ru.sberbank.core.helper.DataPreferences
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class
    ]
)
interface CoreComponent {

    fun inject(app: Application)

    fun getPreferences(): DataPreferences
}