package com.example.contactlabel


import android.annotation.SuppressLint

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var rvContacts: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvContacts = findViewById<View>(R.id.rvContacts) as RecyclerView


        getContact
    }

    val getContact: Unit
        @SuppressLint("Range") get() {
            val contactVOList: MutableList<ContactVO> = ArrayList()

            var contactVO: ContactVO

            val contentResolver = contentResolver
            val cursor: Cursor? = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME.uppercase() + " ASC")
            if (cursor!!.getCount() > 0) {
                while (cursor.moveToNext()) {
                    val hasPhoneNumber: Int =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                             .toInt()
                    if (hasPhoneNumber > 0) {
                        val id: String =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                        val name: String =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME.uppercase()))



                        contactVO = ContactVO()


                        val phoneCursor: Cursor? = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", arrayOf(id),
                            null
                        )
                        if (phoneCursor!!.moveToNext()) {
                            val phoneNumber: String =
                                phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            contactVO.contactNumber = phoneNumber
                        }
                        phoneCursor.close()
                        val emailCursor: Cursor? = contentResolver.query(
                            ContactsContract.CommonDataKinds.Email.CON