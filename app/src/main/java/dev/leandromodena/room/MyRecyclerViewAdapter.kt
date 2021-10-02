package dev.leandromodena.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.leandromodena.room.database.Subscriber
import dev.leandromodena.room.databinding.ListItemBinding

class MyRecyclerViewAdapter(
    private val addClick: (Subscriber) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {

    private val subscribersList = ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribersList[position], addClick)
    }

    override fun getItemCount() = subscribersList.size

    fun setList(subscribers: List<Subscriber>) {
        subscribersList.clear()
        subscribersList.addAll(subscribers)
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(subscriber: Subscriber, addClick: (Subscriber) -> Unit) {
        binding.emailTextView.text = subscriber.email
        binding.nameTextView.text = subscriber.name
        binding.listView.setOnClickListener {
            addClick(subscriber)
        }
    }
}