package com.example.smilemini

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable


class LoginContract {


    interface View: BaseMvpView {
         fun emailChangeIntent(): Observable<String>
         fun passChangeIntent(): Observable<String>
         fun submitIntent():Observable<Pair<String,String>>
    }
   abstract class Presenter: MviBasePresenter<View, BaseViewState>()

    interface Interactor
    { fun proceed(email:String,pass:String):Observable<BasePartialChanges> }
}