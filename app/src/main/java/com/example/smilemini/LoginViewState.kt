package com.example.smilemini


data class LoginViewState(
    val email: String = "",
    val pass: String = "",
    val loginBtnEnabled: Boolean = false,
    var success: Boolean = false,
    var failure:Boolean=false
    ) : BaseViewState()
