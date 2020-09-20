package ru.sberbank.authorization.di.module

import dagger.Module
import dagger.Provides
import ru.sberbank.authorization.data.datasource.FirebaseSource
import ru.sberbank.authorization.di.AuthorizationScope
import ru.sberbank.authorization.domain.AuthorizationRepository
import ru.sberbank.authorization.domain.AuthorizationRepositoryImpl

@Module
class RepositoryModule {
    @Provides
    @AuthorizationScope
    fun getAuthorizationRepository(authorizationRepositoryImpl: AuthorizationRepositoryImpl)
            : AuthorizationRepository =
        authorizationRepositoryImpl

    @Provides
    @AuthorizationScope
    fun provideFirebaseSource() = FirebaseSource()
}