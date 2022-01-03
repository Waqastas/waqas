
package com.example.smilemini.Base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


/**
 * if we use new feature
 *on older devices than we make base activity and
 *extends it with app compact activity
 * to make it compatible
 */

open class BaseAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("On Create",this.javaClass.simpleName)

    }

    override fun isInPictureInPictureMode(): Boolean {
        Log.d("Picture","Picture in Picture Mode")
        return true
    }

    override fun onResume() {
        super.onResume()
        Log.d("On Resume",this.javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.d("Paused","Paused Mode")
    }



    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}