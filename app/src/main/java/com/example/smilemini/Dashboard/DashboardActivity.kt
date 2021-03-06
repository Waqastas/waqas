package com.example.smilemini.Dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.smilemini.*
import com.example.smilemini.Base.BaseAct
import com.example.smilemini.Data_Share.MenuDataShare
import com.example.smilemini.Recharge.MenuRecharge
import com.example.smilemini.Service.MenuService
import com.example.smilemini.Voucher.MenuVoucher
import com.google.android.material.navigation.NavigationView

class DashboardActivity : BaseAct(),NavigationView.OnNavigationItemSelectedListener {

//   var buttomNav:BottomNavigationView?=null
   var drawerLayout:DrawerLayout?=null
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.toolbar)




        //buttomNav=findViewById<BottomNavigationView>(R.id.bottomNavigation)
        actionBar?.title = ""
         drawerLayout=findViewById<DrawerLayout>(R.id.drawer_layout)




        toolbar.setNavigationOnClickListener(View.OnClickListener {
            drawerLayout?.openDrawer((GravityCompat.START))
        })

        getDashboard()
    }




    private fun getDashboard() {

        val fragmentMan = supportFragmentManager
        val fragTrans = fragmentMan.beginTransaction()
        fragTrans.replace(R.id.dashboard_fragments, DashboardFragment())
        fragTrans.commit()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentMan = supportFragmentManager
        val fragTrans = fragmentMan.beginTransaction()

        when(item.itemId)
        {
            R.id.menu_home ->{
                fragTrans.replace(R.id.dashboard_fragments, DashboardFragment())
                fragTrans.commit()
            }
            R.id.menu_recharge ->{
                fragTrans.replace(R.id.dashboard_fragments, MenuRecharge())
                fragTrans.commit()
            }
            R.id.menu_services ->{
                fragTrans.replace(R.id.dashboard_fragments, MenuService())
                fragTrans.commit()
            }
            R.id.menu_voucher ->{
                fragTrans.replace(R.id.dashboard_fragments, MenuVoucher())
                fragTrans.commit()
            }
            R.id.menu_data_share ->
            {
                fragTrans.replace(R.id.dashboard_fragments, MenuDataShare())
                fragTrans.commit()
            }
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

}

