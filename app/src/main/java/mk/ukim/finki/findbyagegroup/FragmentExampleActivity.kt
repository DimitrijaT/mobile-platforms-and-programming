package mk.ukim.finki.findbyagegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import mk.ukim.finki.findbyagegroup.fragments.FirstFragment

class FragmentExampleActivity : AppCompatActivity() {
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
}


