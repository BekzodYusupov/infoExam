package uz.gita.examm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.examm.R
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.utils.NoteDiffUtil

class AdminAdapter : RecyclerView.Adapter<AdminAdapter.VH>() {
    private val oldList: ArrayList<NoteEntity> = ArrayList()

    private var itemClickListener: ((Int) -> Unit)? = null
    private var itemLongClickListener: ((NoteEntity) -> Unit)? = null
    private var checkClickLisstener:((NoteEntity,Boolean)->Unit)? = null

    fun submitList(newItems: List<NoteEntity>) {
        val callBack = NoteDiffUtil(oldList, ArrayList(newItems))
        val calculateDiff = DiffUtil.calculateDiff(callBack)
        oldList.clear()
        oldList.addAll(newItems)
        calculateDiff.dispatchUpdatesTo(this)
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvTitleFromAdminItem)
        private val content = view.findViewById<TextView>(R.id.tvContentFromAdminItem)
        private val state = view.findViewById<CheckBox>(R.id.checkBox)

        fun bind() {
            val item = oldList[adapterPosition]
            title.text = item.title
            content.text = item.content
            state.isChecked = item.state
        }

        init {
            view.setOnClickListener {
                itemClickListener?.invoke(oldList[adapterPosition].id)
            }
            view.setOnLongClickListener {
                itemLongClickListener?.invoke(oldList[adapterPosition])
                true
            }

            state.setOnClickListener {
                checkClickLisstener?.invoke(oldList[adapterPosition],state.isChecked)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.admin_item, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = oldList.size

    fun triggerItemClickListener(block: (Int) -> Unit) {
        itemClickListener = block
    }
    fun triggerItemLongClickListener(block: (NoteEntity) -> Unit) {
        itemLongClickListener = block
    }

    fun triggerCheckClickListener(block: (NoteEntity,Boolean) -> Unit) {
        checkClickLisstener = block
    }
}