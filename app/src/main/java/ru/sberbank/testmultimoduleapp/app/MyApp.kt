package ru.sberbank.testmultimoduleapp.app

import android.app.Application
import ru.sberbank.core.di.CoreComponent
import ru.sberbank.core.di.CoreComponentProvider
import ru.sberbank.core.di.DaggerCoreComponent
import ru.sberbank.core.di.module.CoreModule

class MyApp :Application(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }



}