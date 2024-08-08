package com.example.uccitapp

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import androidx.fragment.app.Fragment


private class FacultyFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var facultyAdapter: FacultyAdapter
    private val facultyList = mutableListOf(
        FacultyMember("President", R.drawable.screenshot__186_, "Mr. Colin Gyles", "@ucc.edc.jm"),
        FacultyMember("Dean", R.drawable.screennrose, "Mrs. Natalie Rose", "deanmst@ucc.edu.jm"),
        FacultyMember("Head of Department", R.drawable.faculty, "Mr. Otis Osbourne", "ithod@ucc.edu.jm"),
        FacultyMember("Programme Officer", R.drawable.faculty, "Mrs. Pamella Reid", "itprogrammeofficer2@ucc.edu.jm"),
        FacultyMember("Programme Officer", R.drawable.faculty, "Mr. Craig Wilmot", "itprogofficer4@ucc.edu.jm"),
        FacultyMember("Team member of DSS", R.drawable.faculty, "Mr. Oneil Dowe", "@ucc.edu.jm")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_faculty, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        facultyAdapter = FacultyAdapter(facultyList)
        recyclerView.adapter = facultyAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}

