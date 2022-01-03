package com.example.smilemini.Base

import com.hannesdorfmann.mosby3.mvp.MvpView

interface BaseMvpView: MvpView {
    fun render(baseViewState: BaseViewState)
}