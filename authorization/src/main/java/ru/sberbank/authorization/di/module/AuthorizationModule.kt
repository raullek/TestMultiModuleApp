package ru.sberbank.authorization.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.sberbank.authorization.helper.ViewModelFactory
import ru.sberbank.authorization.ui.signUp.RegistrationViewModel
import ru.sberbank.core.di.ViewModelKey
import javax.inject.Singleton

@Module
abstract class AuthorizationModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: RegistrationViewModel): ViewModel


}