package ru.poloska.airvisual.error

import android.content.Context
import androidx.appcompat.app.AlertDialog

/**
 * User: yakimov
 * Date: 2020-02-20
 * Time: 10:48
 */
class ErrorDialog(context: Context) : AlertDialog(context) {

    private val builder = Builder(context)

    fun dialogWithRetry(retry: () -> Unit): AlertDialog {
      return builder.setMessage("Something broker")
            .setPositiveButton("retry"){_,_ ->
                retry
            }.create()
    }
}