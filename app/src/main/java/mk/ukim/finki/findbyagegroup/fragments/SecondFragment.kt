package mk.ukim.finki.findbyagegroup.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import mk.ukim.finki.findbyagegroup.R
import mk.ukim.finki.findbyagegroup.databinding.FragmentSecondBinding
import mk.ukim.finki.findbyagegroup.dialogs.NicknameDialogFragment
import mk.ukim.finki.findbyagegroup.dialogs.SimpleDialogFragment
import mk.ukim.finki.findbyagegroup.viewmodels.NicknameViewModel


class SecondFragment : Fragment(R.layout.fragment_second) {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    // PROBLEM: It uses the scope of the fragment, not the activity
//    private val nicknameViewModel: NicknameViewModel by viewModels()
    // CORRECT
    private val nicknameViewModel: NicknameViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSecondBinding.bind(view)

        nicknameViewModel.nickname.observe(viewLifecycleOwner) {
            binding.txtMyNickname.text = it
        }

        binding.btnOpenSimpleDialog.setOnClickListener {
            // We show the dialog
            // We use childFragmentManager because we are in a fragment
            // The tag is used to identify the dialog
            SimpleDialogFragment().show(childFragmentManager, "SimpleDialogFragment")
        }

        binding.btnOpenNicknameDialog.setOnClickListener {
            NicknameDialogFragment().show(childFragmentManager, "NicknameDialogFragment")
        }

    }
}
