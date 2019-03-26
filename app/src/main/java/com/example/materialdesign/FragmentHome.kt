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

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                adapter.move(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.delete(viewHolder.adapterPosition)
            }

            override fun isLongPressDragEnabled(): Boolean {
                return super.isLongPressDragEnabled()
            }
        })
        itemTouchHelper.attachToRecyclerView(recycler)

//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(recycler)

        return view
    }

}
