package ru.sberbank.authorization.di.component

import dagger.Component
import ru.sberbank.authorization.di.AuthorizationScope
import ru.sberbank.authorization.di.module.AuthorizationModule
import ru.sberbank.authorization.ui.AuthorizationActivity
import ru.sberbank.core.di.CoreComponent


@AuthorizationScope
@Component(
    modules = [AuthorizationModule::class],
    dependencies = [CoreComponent::class]
)
interface AuthorizationComponent {
    fun inject(authorizationActivity: AuthorizationActivity)

}