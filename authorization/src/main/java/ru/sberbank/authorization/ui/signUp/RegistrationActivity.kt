package ru.sberbank.authorization.ui.signUp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.registration_screen.*
import ru.sberbank.authorization.R
import ru.sberbank.authorization.di.component.DaggerAuthorizationComponent
import ru.sberbank.authorization.helper.Result
import ru.sberbank.core.utils.InjectUtils
import javax.inject.Inject
import kotlin.apply

class RegistrationActivity : AppCompatActivity() {

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory
    private lateinit var model: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_screen)

        DaggerAuthorizationComponent
            .builder()
            .coreComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)

        model = ViewModelProvider(this, modelFactory).get(RegistrationViewModel::class.java)

        apply.setOnClickListener {
            model.signIn(edit_login.text.toString(), edit_pass.text.toString())
        }
        model.authResult.observe(this, Observer {
            when (it.status) {
                Result.Status.LOADING -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                Result.Status.SUCCESS -> {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
                Result.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })


    }
}