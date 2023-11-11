package mk.ukim.finki.findbyagegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.findbyagegroup.R.id.txtAgeGroup
import mk.ukim.finki.findbyagegroup.viewmodels.AgeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var txtAgeGroup: TextView
    private lateinit var editTextAge: EditText
    private lateinit var btnSubmit: Button

    private lateinit var ageViewModel: AgeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtAgeGroup = findViewById(R.id.txtAgeGroup)
        editTextAge = findViewById(R.id.editTextAge)
        btnSubmit = findViewById(R.id.btnSubmit)


        // It's instantiated only once, but everytime the activity is created it uses the same reference.
        ageViewModel = ViewModelProvider(this)[AgeViewModel::class.java]

        editTextAge.setText(
            ageViewModel.getAgeValue().toString()
        ) // For loss, to keep the data saved. (when flipping the phone, etc.)

        btnSubmit.setOnClickListener {
            ageViewModel.setAgeValue(editTextAge.text.toString().toIntOrNull() ?: -1)
            txtAgeGroup.text = ageViewModel.calcAgeGroup() //duplicate
        }

        editTextAge.addTextChangedListener { newText ->
            ageViewModel.setAgeValue(newText.toString().toIntOrNull() ?: -1)
            txtAgeGroup.text = ageViewModel.calcAgeGroup() //duplicate
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy Invoked")
    }
}

