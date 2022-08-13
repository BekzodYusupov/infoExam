package uz.gita.examm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import uz.gita.examm.R
import uz.gita.examm.data.models.IntroModel

class IntroAdapter : RecyclerView.Adapter<IntroAdapter.VH>() {
    private val oldList: ArrayList<IntroModel> = ArrayList()

    fun submitList(newList:ArrayList<IntroModel>) {
        oldList.addAll(newList)
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitle)
        private val content = view.findViewById<TextView>(R.id.tvContent)
        private val imageHolder = view.findViewById<ImageView>(R.id.ivImageHolder)
        private val bg = view.findViewById<ConstraintLayout>(R.id.bg)

        fun bind() {
            val item = oldList[adapterPosition]
            title.text = item.title
            content.text = item.content
            imageHolder.setImageResource(item.introImg)
            bg.setBackgroundResource(item.bgColor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.intro_item, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()
    override fun getItemCount(): Int = oldList.size
}