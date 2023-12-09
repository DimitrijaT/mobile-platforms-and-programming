package mk.ukim.finki.findbyagegroup

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.findbyagegroup.viewmodels.AgeViewModel

class ExplicitActivity : AppCompatActivity() {

    private lateinit var txtAgeGroup: TextView

    private lateinit var ageViewModel: AgeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        txtAgeGroup = findViewById(R.id.txtAgeGroup)

        ageViewModel = ViewModelProvider(this)[AgeViewModel::class.java]

        // We set the observer before we set the value
        ageViewModel.getAge().observe(this) {
            txtAgeGroup.text = ageViewModel.calcAgeGroup()
        }

        // We read the value sent from the MainActivity
        val bundle: Bundle? = intent.extras
        val age: String = bundle?.get("ageGroup")?.toString() ?: "N/A"
        ageViewModel.setAgeValue(age.toIntOrNull() ?: -1)

    }
}

