package com.example.smilemini

open class BaseViewState {
     var loading:Boolean=false
     var showError:Boolean=false
     var message:String=""
     var response:Int=1
     var errorMessage:String=""
    fun success(
        loading:Boolean=false,
        showError:Boolean=false,
        response:Int
    ): BaseViewState
    {
        this.loading=loading
        this.showError=showError
        this.response=response
        return this
    }

    fun failure(
        loading: Boolean=false,
        showError: Boolean=true,
        errorMessage: String,
        response: Int
    ): BaseViewState
    {
        this.loading=loading
        this.response=response
        this.showError=showError
        this.errorMessage=errorMessage
        return this

    }
}