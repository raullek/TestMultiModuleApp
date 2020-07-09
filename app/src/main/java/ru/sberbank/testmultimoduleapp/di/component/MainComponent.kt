package ru.sberbank.testmultimoduleapp.di.component

import dagger.Component
import ru.sberbank.core.di.CoreComponent
import ru.sberbank.testmultimoduleapp.MainActivity
import ru.sberbank.testmultimoduleapp.di.MainScope
import ru.sberbank.testmultimoduleapp.di.module.MainModule
import javax.inject.Singleton


@MainScope
@Component(
    modules = [MainModule::class],
    dependencies = [CoreComponent::class]
)
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}