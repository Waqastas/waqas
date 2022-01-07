package com.example.smilemini

import io.reactivex.Observable


class LoginPresenter(private val interactor: LoginContract.Interactor = LoginIntrector())
    : LoginContract.Presenter() {

    override fun bindIntents() {
        val emailChange = intent { it.emailChangeIntent() }.map {
            LoginPartialChanges.emailChange(it)
        }

        val passwordChange = intent { it.passChangeIntent() }.map {
            LoginPartialChanges.passChange(it)
        }
        val submitIntent = intent { it.submitIntent() }.switchMap { interactor.proceed(it.first, it.second) }

        val intentObservable: Observable<BasePartialChanges> = Observable.merge(
            emailChange, passwordChange, submitIntent)
        subscribeViewState(intentObservable.scan(LoginViewState(), this::ViewStateReducer),
            LoginContract.View::render
        )
    }

    private fun ViewStateReducer(

        previousState: BaseViewState,
        partialChanges: BasePartialChanges
    ) = partialChanges.reduce(previousState)

}