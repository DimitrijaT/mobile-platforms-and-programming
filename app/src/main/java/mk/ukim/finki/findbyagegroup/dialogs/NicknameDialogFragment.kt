package mk.ukim.finki.findbyagegroup.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import mk.ukim.finki.findbyagegroup.R

class NicknameDialogFragment : DialogFragment() {
    interface NicknameDialogListener {
        fun onDialogPositiveClick(nickname: String)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    // We need to get the reference from the class that implements this interface
    // This is the Activity
    // We will get the reference in the onAttach method
    lateinit var listener: NicknameDialogListener
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            var inflater = requireActivity().layoutInflater
            val view: View = inflater.inflate(R.layout.dialog_nickname, null)
            val editDialogNickname = view.findViewById<EditText>(R.id.editDialogNickname)
            builder.setView(view) // From the view we will extract the EditText
                .setPositiveButton(R.string.ok, DialogInterface.OnClickListener { dialog, id ->
                    listener.onDialogPositiveClick(
                        editDialogNickname.text.toString()
                    )
                }).setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id -> this })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // We get the reference to the activity
        try {
            listener = context as NicknameDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "${context.toString()} must implement NicknameDialogListener"
            )
        }
    }
}

