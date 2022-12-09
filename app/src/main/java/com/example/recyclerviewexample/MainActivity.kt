package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var btnAdd:Button? = null
    private var etAdd:EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf<Todo>(
            Todo("feeding my Cat",false),
            Todo("progamming ",true),
            Todo("go to gym",true)
        )

        val adapter = TodoAdaptor(todoList)
        val recycleViewTodo:RecyclerView? = findViewById(R.id.recycleViewTodo)
        recycleViewTodo?.adapter = adapter
        recycleViewTodo?.layoutManager = LinearLayoutManager(this)

        btnAdd = findViewById(R.id.btnAdd)
        btnAdd?.setOnClickListener {
            etAdd = findViewById(R.id.etAdd)
            todoList.add(Todo(etAdd?.text.toString(),false))
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}