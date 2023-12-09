package mk.ukim.finki.findbyagegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mk.ukim.finki.findbyagegroup.adapters.StudentsAdapter
import mk.ukim.finki.findbyagegroup.data.studentsList

class StudentsListActivity : AppCompatActivity() {

    private lateinit var listView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        // This is for Picasso to log the image loading process.
        Picasso.get().isLoggingEnabled = true

        listView = findViewById(R.id.listView)

        listView.adapter = StudentsAdapter(studentsList())
    }
}


