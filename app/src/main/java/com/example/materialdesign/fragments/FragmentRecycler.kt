package com.example.materialdesign.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.*
import com.example.materialdesign.R
import com.example.materialdesign.utils.recycler.CardRecyclerAdapter
import com.example.materialdesign.utils.recycler.MyItemTouchHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentRecycler : Fragment() {
    lateinit var buttonStart: FloatingActionButton
    lateinit var recycler: RecyclerView
    internal lateinit var adapter: CardRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)

        initRecycler(view)

        buttonStart = view.findViewById(R.id.button_start)
        buttonStart.setOnClickListener { Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show() }

        return view
    }

    private fun initRecycler(view: View) {
        adapter = CardRecyclerAdapter(this)
        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(view.context)
        recycler.adapter = adapter
        val itemTouchHelper = MyItemTouchHelper(adapter)
        itemTouchHelper.attachToRecyclerView(recycler)
    }

}

// Центровка карточки посередине
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(recycler)