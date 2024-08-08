package com.example.uccitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView


class FacultyAdapter(private val facultyList: List<FacultyMember>) :
    RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_faculty, parent, false)
        return FacultyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val facultyMember = facultyList[position]
        holder.titleTextView.text = facultyMember.title
        holder.nameTextView.text = facultyMember.name
        holder.emailTextView.text = facultyMember.email

        // Set the image using drawable resource ID
        holder.imageView.setImageResource(facultyMember.photoResId)
    }

    override fun getItemCount(): Int {
        return facultyList.size
    }

    class FacultyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.faculty_image_view)
        val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        val emailTextView: TextView = itemView.findViewById(R.id.email_text_view)
    }
}
