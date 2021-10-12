package com.example.kotlinetut
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinetut.databinding.ItemTodoBinding

class TodoAdapter(private  var todos:List<Todo>, ):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
    {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
         holder.bind(todos[position])
    }
    override fun getItemCount(): Int {
        return  todos.size
    }
    inner class TodoViewHolder(private  val binding: ItemTodoBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(todo:Todo){
          Log.d("todoadded","to do holder inner class - ${todo.title}")
          binding.tvTitle.text = todo.title
          binding.cbDone.text = todo.isChecked.toString()
        }
    }
}