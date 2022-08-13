package uz.gita.examm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.examm.R
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.utils.NoteDiffUtil

class UserAdapter : RecyclerView.Adapter<UserAdapter.VH>() {
    private val oldList: ArrayList<NoteEntity> = ArrayList()
    private var itemClickListener: ((Int) -> Unit)? = null

    fun triggerItemClickListener(block: (Int) -> Unit) {
        itemClickListener = block
    }

    fun submitList(newList: List<NoteEntity>) {
        val callBack = NoteDiffUtil(oldList, ArrayList(newList))
        val calculateDiff = DiffUtil.calculateDiff(callBack)
        oldList.clear()
        oldList.addAll(newList)
        calculateDiff.dispatchUpdatesTo(this)
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitleFromUserItem)
        private val content = view.findViewById<TextView>(R.id.tvContentFromUserItem)
        private val image = view.findViewById<ImageView>(R.id.ivUserCircle)

        fun bind() {
            val item = oldList[adapterPosition]
            title.text = item.title
            content.text = item.content
            image.setImageResource(item.img)
        }

        init {
            itemView.setOnClickListener { itemClickListener?.invoke(oldList[adapterPosition].id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.user_note_item, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = oldList.size
}