package com.example.smilemini.Base

abstract class BasePartialChanges: PartialChangesCallback
{
   object Loading: PartialChangesCallback {
       override fun reduce(state: BaseViewState): BaseViewState {
           state.loading=false
           state.showError=true
           state.errorMessage=""
           state.response=1
           return state
       }

   }

    class Error(val message:String="",var code: Int =2) : BasePartialChanges() {
        override fun reduce(state: BaseViewState): BaseViewState {
           return state.failure(errorMessage = message,response = code)
        }

    }
    class Success(var code:Int): BasePartialChanges()
    {
        override fun reduce(state: BaseViewState): BaseViewState {
            return state.success(response = code)
        }

    }


}