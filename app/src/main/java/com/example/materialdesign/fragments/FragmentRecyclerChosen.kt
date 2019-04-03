package com.example.materialdesign.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.R
import com.example.materialdesign.utils.recycler.CardRecyclerAdapter
import com.example.materialdesign.utils.recycler.ChosenRecyclerAdapter
import com.example.materialdesign.utils.recycler.MyItemTouchHelper

class FragmentRecyclerChosen : Fragment() {
    lateinit var recycler: RecyclerView
    internal lateinit var adapter: ChosenRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_chosen, container, false)

        adapter = ChosenRecyclerAdapter(this)
        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(view.context)
        recycler.adapter = adapter

//        val itemTouchHelper = MyItemTouchHelper(adapter)
//        itemTouchHelper.attachToRecyclerView(recycler)

        return view
    }
}