package com.example.smilemini.Authentication

import com.example.smilemini.Base.BasePartialChanges
import com.example.smilemini.Base.BaseViewState
import com.example.smilemini.LoginViewState


sealed class LoginPartialChanges : BasePartialChanges() {

     data class emailChange(private val newValue: String) : LoginPartialChanges() {

         override fun reduce(state: BaseViewState): BaseViewState {
             return (state as LoginViewState).copy(
                 email = newValue,
                 loginBtnEnabled = newValue.isNotEmpty() && state.pass.isNotEmpty()
             )
         }
     }


     data class passChange(private val newValue: String) : LoginPartialChanges() {
         override fun reduce(state: BaseViewState): BaseViewState {
             return (state as LoginViewState).copy(
                 pass = newValue,
                 loginBtnEnabled = newValue.isNotEmpty() && state.email.isNotEmpty()
             )

         }

     }


    data class SuccessLogin(private val isSucess: Boolean) : LoginPartialChanges() {
        override fun reduce(state: BaseViewState): BaseViewState {
            state as LoginViewState
            state.success = isSucess
            return state
        }

    }
    data class FailureLogin(private val isFailure: Boolean) : LoginPartialChanges() {
        override fun reduce(state: BaseViewState): BaseViewState {
            state as LoginViewState
            state.failure = isFailure
            return state
        }

    }

}