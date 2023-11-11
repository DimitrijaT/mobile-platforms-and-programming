package mk.ukim.finki.findbyagegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import mk.ukim.finki.findbyagegroup.R.id.txtAgeGroup

class MainActivity : AppCompatActivity() {

    private lateinit var txtAgeGroup: TextView
    private lateinit var editTextAge: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtAgeGroup = findViewById(R.id.txtAgeGroup)
        editTextAge = findViewById(R.id.editTextAge)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val ageGroup: String = calcAgeGroup(editTextAge.text.toString().toIntOrNull() ?: -1)
//            txtAgeGroup.setText(ageGroup) // Does the same as .text = ageGroup
            txtAgeGroup.text = ageGroup
        }
    }

    fun calcAgeGroup(age: Int): String {
        return when (age) {
            in 0..14 -> "Child";
            in 15..24 -> "Youth";
            in 25..64 -> "Adult";
            in 65..200 -> "Senior";
            else -> "Not Known"
        }
    }
}

