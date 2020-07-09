package ru.sberbank.core.utils

import android.content.Context
import ru.sberbank.core.di.CoreComponent
import ru.sberbank.core.di.CoreComponentProvider

object InjectUtils {

    fun provideBaseComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
        }
    }

}