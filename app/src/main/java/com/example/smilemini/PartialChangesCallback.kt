package com.example.smilemini

interface PartialChangesCallback {
    fun reduce(state: BaseViewState): BaseViewState
}