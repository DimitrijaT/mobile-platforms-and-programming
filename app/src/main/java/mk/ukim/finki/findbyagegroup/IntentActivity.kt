package mk.ukim.finki.findbyagegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentActivity : AppCompatActivity() {

    private lateinit var txtAgeGroup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        txtAgeGroup = findViewById(R.id.txtAgeGroup)

        val bundle: Bundle? = intent.extras

        txtAgeGroup.text = bundle?.get("ageValue").toString()

    }
}