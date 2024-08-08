package com.example.uccitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CourseAdapter(private val courseList: List<Course>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.bind(course)
    }

    override fun getItemCount() = courseList.size

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val codeTextView: TextView = itemView.findViewById(R.id.course_code)
        private val nameTextView: TextView = itemView.findViewById(R.id.course_name)
        private val creditsTextView: TextView = itemView.findViewById(R.id.course_credits)
        private val prerequisitesTextView: TextView = itemView.findViewById(R.id.course_prerequisites)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.course_description)

        fun bind(course: Course) {
            codeTextView.text = course.code
            nameTextView.text = course.name
            creditsTextView.text = course.credits.toString()
            prerequisitesTextView.text = course.prerequisites
            descriptionTextView.text = course.description
        }
    }
}

