package meza.jonathan.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TareaViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    val tvCant = itemView.findViewById<TextView>(R.id.tvCant)
    val tvMes = itemView.findViewById<TextView>(R.id.tvMes)
    val tvGains = itemView.findViewById<TextView>(R.id.tvGains)
    val tvInteres = itemView.findViewById<TextView>(R.id.tvInteres)
}