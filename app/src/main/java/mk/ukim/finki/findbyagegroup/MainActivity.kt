package mk.ukim.finki.findbyagegroup

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.findbyagegroup.extensions.toInt
import mk.ukim.finki.findbyagegroup.viewmodels.AgeViewModel
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var txtAgeGroup: TextView
    private lateinit var editTextAge: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnGoToExplicitActivity: Button
    private lateinit var btnGoToImplicitActivityOpenMaps: Button
    private lateinit var btnGoToImplicitActivitySendMail: Button
    private lateinit var btnGoToImplicitActivityCalendar: Button
    private lateinit var btnGoToImplicitActivityWebSite: Button

    private lateinit var ageViewModel: AgeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtAgeGroup = findViewById(R.id.txtAgeGroup)
        editTextAge = findViewById(R.id.editTextAge)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnGoToExplicitActivity = findViewById<Button>(R.id.btnGoToExplicitActivity)
        btnGoToImplicitActivityOpenMaps = findViewById<Button>(R.id.btnGoToImplicitActivityOpenMaps)
        btnGoToImplicitActivitySendMail = findViewById<Button>(R.id.btnGoToImplicitActivitySendMail)
        btnGoToImplicitActivityCalendar = findViewById<Button>(R.id.btnGoToImplicitActivityCalendar)
        btnGoToImplicitActivityWebSite = findViewById<Button>(R.id.btnGoToImplicitActivityWebSite)


        // It's instantiated only once, but everytime the activity is created it uses the same reference.
        ageViewModel = ViewModelProvider(this)[AgeViewModel::class.java]

        editTextAge.setText(
            ageViewModel.getAgeValue().toString()
        ) // For loss, to keep the data saved. (when flipping the phone, etc.)

        btnSubmit.setOnClickListener {
            ageViewModel.setAgeValue(editTextAge.text.toInt())
        }

        // EXPLICIT INTENT
        btnGoToExplicitActivity.setOnClickListener {
            Intent(this, ExplicitActivity::class.java).let { i ->
                i.putExtra("ageGroup", editTextAge.text.toString())
                startActivity(i)
            }
        }

        // IMPLICIT INTENT - Opening Maps
        btnGoToImplicitActivityOpenMaps.setOnClickListener {
//          Android knows that we want to open google maps.
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://maps.google.com/?q=Rugjer%20Boskovikj%20Skopje")
            ).let { i ->
                startActivity(i)
            }
        }

        // IMPLICIT INTENT - Sending Mail
        btnGoToImplicitActivitySendMail.setOnClickListener {
            Intent(Intent.ACTION_SEND).let { emailIntent ->
                emailIntent.type = "text/plain"
                emailIntent.putExtra(
                    Intent.EXTRA_EMAIL,
                    arrayOf("dimitrijatimeskidimitrija@gmail.com")
                )
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email Body")
                startActivity(emailIntent)
            }
        }

        // IMPLICIT INTENT - Using Calendar
        btnGoToImplicitActivityCalendar.setOnClickListener {
            Intent(
                Intent.ACTION_INSERT,
                CalendarContract.Events.CONTENT_URI
            ).let { calendarIntent ->
                val beginTime: Calendar = Calendar.getInstance()
                beginTime.set(2012, 0, 19, 7, 30)
                val endTime: Calendar = Calendar.getInstance()
                endTime.set(2012, 0, 19, 10, 30)

                // We see these parameters from the intent's documentation.
                calendarIntent.putExtra(
                    CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    beginTime.timeInMillis
                )
                calendarIntent.putExtra(
                    CalendarContract.EXTRA_EVENT_END_TIME,
                    endTime.timeInMillis
                )
                calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class")
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo")
                startActivity(calendarIntent)
            }
        }

        // IMPLICIT INTENT - Opening a Web Site
        btnGoToImplicitActivityWebSite.setOnClickListener {
            val webpage: Uri = Uri.parse("https://www.android.com/")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(webIntent)
        }

        editTextAge.addTextChangedListener { newText ->
            ageViewModel.setAgeValue(newText.toInt())
        }

        ageViewModel.getAge().observe(this) {
            txtAgeGroup.text = ageViewModel.calcAgeGroup()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy Invoked")
    }
}

