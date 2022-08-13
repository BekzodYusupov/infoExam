package uz.gita.examm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.gita.examm.R

class PagerAddAdapter : RecyclerView.Adapter<PagerAddAdapter.VH>() {
    private val oldList: ArrayList<Int> = ArrayList()

    fun submitList(newList: ArrayList<Int>) {
        oldList.clear()
        oldList.addAll(newList)
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.ivPagerAddImage)

        fun bind() {
            val item = oldList[adapterPosition]
            image.setImageResource(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_pager_add, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = oldList.size


}