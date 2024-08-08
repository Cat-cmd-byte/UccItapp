package com.example.uccitapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class CourseFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var courseAdapter: CourseAdapter
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        fetchCourses()
        return view
    }

    private fun fetchCourses() {
        db.collection("courses").get()
            .addOnSuccessListener { result ->
                val courseList = result.map { document ->
                    Course(
                        document.getString("code") ?: "",
                        document.getString("name") ?: "",
                        document.getLong("credits")?.toInt() ?: 0,
                        document.getString("prerequisites") ?: "",
                        document.getString("description") ?: ""
                    )
                }
                courseAdapter = CourseAdapter(courseList)
                recyclerView.adapter = courseAdapter
            }
            .addOnFailureListener { exception ->
                Log.e("CourseFragment", "Error fetching courses", exception)
            }
    }
}

