package ru.sberbank.authorization.di.component

import dagger.Component
import ru.sberbank.authorization.di.AuthorizationScope
import ru.sberbank.authorization.di.module.AuthorizationModule
import ru.sberbank.authorization.di.module.RepositoryModule
import ru.sberbank.authorization.ui.signIn.AuthorizationActivity
import ru.sberbank.authorization.ui.signUp.RegistrationActivity
import ru.sberbank.core.di.CoreComponent


@AuthorizationScope
@Component(
    modules = [
        AuthorizationModule::class,
        RepositoryModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface AuthorizationComponent {
    fun inject(authorizationActivity: AuthorizationActivity)
    fun inject(registrationActivity: RegistrationActivity)
}