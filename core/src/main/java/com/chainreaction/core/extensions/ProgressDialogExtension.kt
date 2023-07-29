package com.chainreaction.core.extensions

import com.chainreaction.core.ProgressDialog

fun ProgressDialog.showProgressDialog(){
    this.show()
}


fun ProgressDialog.hideProgressDialog(){
    this.dismiss()
}

