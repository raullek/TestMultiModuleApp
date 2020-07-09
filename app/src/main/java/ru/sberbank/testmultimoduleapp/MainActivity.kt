package ru.sberbank.testmultimoduleapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.sberbank.authorization.ui.AuthorizationActivity
import ru.sberbank.core.utils.InjectUtils
import ru.sberbank.testmultimoduleapp.di.component.DaggerMainComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DaggerMainComponent
            .builder()
            .coreComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)
        val intent = Intent(this,AuthorizationActivity::class.java)
        startActivity(intent)
        finish()
}
}