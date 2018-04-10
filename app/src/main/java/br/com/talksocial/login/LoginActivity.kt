package br.com.talksocial.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.talksocial.R
import br.com.talksocial.timeline.TimelineActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        viewModel.authUser.observe(this, Observer { authUser ->
            authUser?.let {
                signIn()
            }
        })

        viewModel.authError.observe(this, Observer { authError ->
            authError?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        btn_sign_in.setOnClickListener {

            if (et_email.text.toString().isBlank()) {
                et_email.error = "invalid email"
                return@setOnClickListener
            }

            if (et_password.text.toString().isBlank()) {
                et_password.error = "invalid password"
                return@setOnClickListener
            }

            viewModel.signIn(et_email.text.toString(), et_password.text.toString())
        }
    }

    private fun signIn() {
        startActivity(TimelineActivity.newIntent(this))
    }
}