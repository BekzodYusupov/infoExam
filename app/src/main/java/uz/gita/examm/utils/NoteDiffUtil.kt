package uz.gita.examm.utils

import androidx.recyclerview.widget.DiffUtil
import uz.gita.examm.data.room.entities.NoteEntity

class NoteDiffUtil(private val oldList:ArrayList<NoteEntity>, private val newList:ArrayList<NoteEntity>):DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id &&
                oldList[oldItemPosition].title == newList[newItemPosition].title &&
                oldList[oldItemPosition].content == newList[newItemPosition].content &&
                oldList[oldItemPosition].state == newList[newItemPosition].state




}