package com.example.smilemini

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.smilemini.Authentication.LoginContract
import com.example.smilemini.Authentication.LoginPresenter
import com.example.smilemini.Base.BaseAct
import com.example.smilemini.Base.BaseViewState
import com.example.smilemini.Dashboard.DashboardActivity
import com.example.smilemini.databinding.ActivityLoginBinding
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.subjects.PublishSubject


class LoginAct : BaseAct(), LoginContract.View, View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    // private var requestSent = false
    private val loginEvent = PublishSubject.create<Pair<String, String>>()
  //lateinit var presenter: LoginPresenter()
    private val presenter: LoginContract.Presenter = LoginPresenter()
    //best way to do by lazy but
 // private val presenter:LoginContract.Presenter by lazy { LoginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()


    }

    private fun init() {
        presenter.attachView(this)
        binding.loginBtn.setOnClickListener(this)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun emailChangeIntent(): io.reactivex.Observable<String> =
        binding.loginEmail.textChanges().skipInitialValue().map {
            it.toString()
        }



    override fun passChangeIntent(): io.reactivex.Observable<String> =
        binding.loginPass.textChanges().skipInitialValue().map {
            it.toString()
        }


    override fun submitIntent(): io.reactivex.Observable<Pair<String, String>> {


        /*binding.loginBtn.setOnClickListener {
            binding.loginBtn.isEnabled = false
            requestSent = true
            loginEvent.onNext(true)
        }
        return loginEvent.filter { it }.map {
            Pair(binding.user!!.email, binding.user!!.pass)
        }*/
        return loginEvent
            .map { Pair(it.first, it.second) }

    }

    override fun render(baseViewState: BaseViewState) {
        binding.user=baseViewState as LoginViewState
        //binding.user = baseViewState as LoginViewState
        val code = baseViewState.response
        if (code == 0) {
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, DashboardActivity::class.java))

        } else if (code == 2) {
            Toast.makeText(this, "Error Message", Toast.LENGTH_LONG).show()
          //  startActivity(Intent(this, DashboardActivity::class.java))



        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.loginBtn -> {
                    loginEvent.onNext(Pair(binding.user!!.email, binding.user!!.pass))
                }
            }
        }
    }


}

