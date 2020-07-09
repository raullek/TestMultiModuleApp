package ru.sberbank.authorization.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.sberbank.authorization.R
import ru.sberbank.authorization.di.component.DaggerAuthorizationComponent
import ru.sberbank.core.helper.DataPreferences
import ru.sberbank.core.utils.InjectUtils
import javax.inject.Inject

class AuthorizationActivity :AppCompatActivity(){

    @Inject
    lateinit var dataPreferences: DataPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorization_screen)


        DaggerAuthorizationComponent
            .builder()
            .coreComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)

        dataPreferences.saveInt("hello",1)
    }
}