package mk.ukim.finki.findbyagegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.findbyagegroup.adapters.ExampleViewAdapter

class ListViewActivity : AppCompatActivity() {

    private lateinit var listView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView = findViewById(R.id.ListView)

        listView.adapter = ExampleViewAdapter(loadData())
    }

    private fun loadData(): MutableList<String> {
        return mutableListOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
            "Item 11",
            "Item 12",
            "Item 13",
            "Item 14",
            "Item 15",
            "Item 16",
            "Item 17",
            "Item 18",
            "Item 19",
            "Item 20",
            "Item 21",
            "Item 22",
            "Item 23",
            "Item 24",
            "Item 25",
            "Item 26",
            "Item 27",
            "Item 28",
            "Item 29",
            "Item 30"
        )
    }
}



