package com.example.movieapp.MovieApp

import android.app.ProgressDialog
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    var inputMethodManager: InputMethodManager? = null
    private var progressDialog: ProgressDialog? = null


    var FM: FragmentManager? = null
    var ft: FragmentTransaction? = null
    var ReplacingFragment: Fragment? = null
    var current_tag: String? = null

    lateinit var dataSyncUpdateReceiver: DataSyncUpdateReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this)
        inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

    }


    /**
     * Shows a progressDialog.
     */
    fun showProgressDialog(msg: String?) {
        progressDialog!!.setMessage(msg)
        progressDialog!!.setCancelable(false)
        progressDialog!!.show()
    }

    /**
     * Dismisses progressDialog
     */
    fun dismissProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }

    companion object {
        @JvmField
        var backRefresh = false
        var isBackFromQueryModule = false
    }


    override fun onDestroy() {
        super.onDestroy()
        dismissProgressDialog()
    }
}