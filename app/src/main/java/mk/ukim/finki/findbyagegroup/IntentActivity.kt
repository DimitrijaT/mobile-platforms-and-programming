package mk.ukim.finki.findbyagegroup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.findbyagegroup.viewmodels.AgeViewModel

class IntentActivity : AppCompatActivity() {

    private lateinit var txtAgeGroup: TextView
    private lateinit var btnSubmit: Button

    private lateinit var ageViewModel: AgeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        txtAgeGroup = findViewById(R.id.txtAgeGroup)
        btnSubmit = findViewById(R.id.btnSubmit)

        // It's instantiated only once, but everytime the activity is created it uses the same reference.
        ageViewModel = ViewModelProvider(this)[AgeViewModel::class.java]

        val bundle: Bundle? = intent.extras

        // 1. Needs to be before the setting of the value
        ageViewModel.getAge().observe(this) {
            txtAgeGroup.text = ageViewModel.calcAgeGroup()
        }
        // 2. This setting is synchronous, so we need the previous observer already set.
        ageViewModel.setAgeValue(bundle?.get("ageValue").toString().toIntOrNull() ?: -1)


        btnSubmit.setOnClickListener { _ ->
            Intent().let { intent ->
                intent.putExtra("ageGroup", ageViewModel.calcAgeGroup())
                setResult(Activity.RESULT_OK, intent)
                //since this Activity did it's job (it sent a result) we will call:
                finish()
            }
        }

    }
}