package mk.ukim.finki.findbyagegroup.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.findbyagegroup.R
import mk.ukim.finki.findbyagegroup.databinding.FragmentFirstBinding
import mk.ukim.finki.findbyagegroup.viewmodels.NicknameViewModel

class FirstFragment : Fragment(R.layout.fragment_first) {

//    OLD WAY:
//    private lateinit var btnGoToSecondFragment: Button

    // This is the binding object that will be used to access the views in the layout
    // It converts the layout to a binding object
    // It converts the name of the layout to camel case and adds the word Binding
    private var _binding: FragmentFirstBinding? = null

    // We make sure to reset the binding when the fragment is destroyed
    private val binding get() = _binding!!

    private val nicknameViewModel: NicknameViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        OLD WAY:
//        btnGoToSecondFragment = view.findViewById(R.id.btnGoToSecondFragment)

        // At first it isn't bound to anything so we need to bind it
        _binding = FragmentFirstBinding.bind(view)

        // Forward us from the first fragment to the second fragment
        // We must use fragment manager from the parent activity
        binding.btnGoToSecondFragment.setOnClickListener {

            nicknameViewModel.selectNickname(binding.editNickname.text.toString())
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, SecondFragment())
                setReorderingAllowed(true)

                // Now we can do this!
                addToBackStack(null)
            }
        }

        nicknameViewModel.nickname.observe(viewLifecycleOwner) {
            binding.textView.text = it
        }

    }
}






