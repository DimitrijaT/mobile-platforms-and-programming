package mk.ukim.finki.findbyagegroup.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.findbyagegroup.R


// The Adapter controls all ViewHolder's that are initialized
class ExampleViewAdapter(private val data: MutableList<String>) :
    RecyclerView.Adapter<ExampleViewAdapter.ViewHolder>() {


    // Here we define all components that are needed to show in a SINGLE item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView: TextView
        private var currentString: String? = null

        // init method is called FIRST when the ViewHolder is initialized aka when a constructor is called
        init {
            textView = view.findViewById(R.id.txtOutput)
        }

        fun bind(currentString: String) {
            this.currentString = currentString
            this.textView.text = currentString
        }
    }

    // It's goal is to tell us what is the layout the ViewHolder (the items) will use
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_example, parent, false)
        return ViewHolder(view)

        // attachToRoot in this case is the RecyclerView
        // That means every touch event will be propagated to the RecyclerView
        // In this case we don't do that
    }


    // Counts all items in the data list
    override fun getItemCount(): Int {
        return data.size
    }

    // Here we connect the views with the data
    // position is the index of the item in the data list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}