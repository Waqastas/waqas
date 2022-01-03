package com.example.smilemini.Base

import com.example.smilemini.Base.BaseViewState

interface PartialChangesCallback {
    fun reduce(state: BaseViewState): BaseViewState
}