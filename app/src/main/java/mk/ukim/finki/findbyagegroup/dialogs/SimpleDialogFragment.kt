package mk.ukim.finki.findbyagegroup.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import mk.ukim.finki.findbyagegroup.R

class SimpleDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it) // We create a new Alert Dialog Builder
            builder.setMessage(R.string.simple_dialog_title) // We set the message of the dialog
                .setPositiveButton(R.string.ok, DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss() // We dismiss the dialog
                })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

