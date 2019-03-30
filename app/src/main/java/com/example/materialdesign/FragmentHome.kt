package com.example.materialdesign


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*

class FragmentHome : Fragment() {
    lateinit var recycler: RecyclerView
    lateinit var adapter: CardRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        adapter = CardRecyclerAdapter(this)
        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(view.context)
        recycler.adapter = adapter

        val itemTouchHelper = MyItemTouchHelper(adapter)
        itemTouchHelper.attachToRecyclerView(recycler)


        return view
    }

}

// Центровка карточки посередине
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(recycler)