package com.example.smilemini.Authentication

import android.annotation.SuppressLint
import android.util.Log
import com.example.smilemini.Base.BasePartialChanges
import com.example.smilemini.Base.RetrofitClass
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response


open class LoginIntrector : LoginContract.Interactor {


    @SuppressLint("CheckResult")
    override fun proceed(email: String, pass: String): io.reactivex.Observable<BasePartialChanges> {
        val retrofit = RetrofitClass.retrofit.create(AuthApi::class.java)
        val request = retrofit.getUser(email, pass, "2.0").observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

        /* request.map {
             if ( it.isSuccessful){
                 return@map Observable.fromCallable{

                    LoginPartialChanges.SuccessLogin(true)
                     BasePartialChanges.Success(0)
                 }



                 Log.d("Success","Success Message")
             }
             else{
                 Log.d("Error","There is an error in your request")}

         }*/


        /*  val responseFailure=request.errorBody()?.equals(0)

         //  val respose2=request.map { it.errorBody()?.equals(0) }
    |      val responseError=request.errorBody()?.equals(0)*/
        //val responseError=request.errorBody()

//        if (responseSuccess)
//        { return Observable.fromCallable {
//         //   LoginPartialChanges.SuccessLogin(responseSuccess)
//            BasePartialChanges.Success(0)
//            LoginPartialChanges.SuccessLogin(true)
//        }
//        }
//        else{
        /*  return Observable.fromCallable {
              BasePartialChanges.Error("there is an error in your request")
              LoginPartialChanges.FailureLogin(true) }*/

        return request.map {

            if (it.isSuccessful) {
               val tokens= saveToken(it)
         // val bdy=it.body().toString()
           //  Log.d("body",bdy)

                /*     val token =JSONObject(it.toString()).getJSONObject("{token}")
                     val userName=token.get("username")
                  val userId=token.get("customerId").toString()

                val request2nd= RetrofitClass.retrofit.create(GettingInformation::class.java).getUserDetails(userId,"id")
                     request2nd.map {
                         if (it.isSuccessful)
                         {
                             val bodySuccess=it.body().toString()

                             Log.d("Second Request",bodySuccess)
                         }
                     }*/

              val  req= RetrofitClass.retrofit.create(GettingInformationApi::class.java)
               val request2nd =req.getUserDetails(tokens.getLong("customerId").toString(),"id").observeOn(AndroidSchedulers.mainThread())
                   .subscribeOn(Schedulers.io())
                request2nd.subscribe {


                    if (it.isSuccessful)
                    {
                        val successBody=it.body().toString()

                    val customerID=tokens.getLong("customerId").toString()

                    Log.d("successResponse",successBody)

                }
                    else
                    {
                        val errorBody=it.errorBody().toString()
                        Log.d("errorResponse",errorBody)

                    }
                }
                LoginPartialChanges.SuccessLogin(true)
                 BasePartialChanges.Success(0)
            }
            else {
                it.errorBody()
                LoginPartialChanges.FailureLogin(true)
                BasePartialChanges.Error("There is an Error")
            }
        }
    }
    private fun saveToken(responseBodyRetrofit: Response<ResponseBody>): JSONObject {
        val token = JSONObject(responseBodyRetrofit.body()?.string()!!).getJSONObject("token")

        return token
    }
}

