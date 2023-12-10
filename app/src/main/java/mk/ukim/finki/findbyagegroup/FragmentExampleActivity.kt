package mk.ukim.finki.findbyagegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import mk.ukim.finki.findbyagegroup.dialogs.NicknameDialogFragment
import mk.ukim.finki.findbyagegroup.fragments.FirstFragment
import mk.ukim.finki.findbyagegroup.viewmodels.NicknameViewModel

class FragmentExampleActivity : AppCompatActivity(), NicknameDialogFragment.NicknameDialogListener {
    private val nicknameViewModel: NicknameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example) // Треба да има контејнер во кој ќе се менаџираат фрагментите


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                // New instance of FirstFragment is created and added to the container
                replace(R.id.fragment_container_view, FirstFragment())
                setReorderingAllowed(true)
                // NEVER ADD THIS THE FIRST TIME YOU ADD A FRAGMENT
//            addToBackStack(null)
            }
        }

    }
    override fun onDialogPositiveClick(nickname: String) {
        nicknameViewModel.selectNickname(nickname)
    }
    override fun onDialogNegativeClick(dialog: DialogFragment) {
        nicknameViewModel.selectNickname("N/A")
    }
}


