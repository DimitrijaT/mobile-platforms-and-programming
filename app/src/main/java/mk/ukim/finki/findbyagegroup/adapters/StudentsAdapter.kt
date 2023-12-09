package mk.ukim.finki.findbyagegroup.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mk.ukim.finki.findbyagegroup.R
import mk.ukim.finki.findbyagegroup.data.Student

class StudentsAdapter(val data: MutableList<Student>) :
    RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {


    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var studentTextView: TextView
        private var studentImageView: ImageView

        private var currentStudent: Student?

        init {
            studentTextView = itemView.findViewById(R.id.student_info)
            studentImageView = itemView.findViewById(R.id.student_photo)
            currentStudent = null
        }

        fun bind(student: Student) {
            this.currentStudent = student
            studentTextView.text = "${student.firstName} ${student.lastName}"
            // for images we will use a library for showing images from internet called Picasso
            Picasso.get().load(currentStudent?.photoUrl)
                .resize(50, 50)
                .centerCrop()
                .into(studentImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(data[position])
    }

}