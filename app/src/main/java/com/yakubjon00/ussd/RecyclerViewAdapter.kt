package com.yakubjon00.ussd


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

var isExpanded = false

class RecyclerViewAdapter(private val groupItem: GroupItem) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    companion object {
        const val VIEW_HEADER = 0
        const val VIEW_SUB = 1
    }


    sealed class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {
            private val titleTextView = itemView.findViewById<TextView>(R.id.tv_title)
            private val descTextView = itemView.findViewById<TextView>(R.id.tv_desc)
            private val btn_arrow = itemView.findViewById<ImageView>(R.id.btn_arrow)


            fun onBind(header: GroupItem.Header, onClickListener: View.OnClickListener) {
                titleTextView.text = header.txtTitle
                descTextView.text = header.txtDesc



                if (isExpanded) {
                    btn_arrow.setImageResource(R.drawable.ic_arrow_up)
                } else {
                    btn_arrow.setImageResource(R.drawable.ic_arrow_down)
                }

                itemView.setOnClickListener { view ->
                    onClickListener.onClick(view)
                }

            }
        }

        class SubItemViewHolder(itemView: View) : ViewHolder(itemView) {
            private val btn_ulanish = itemView.findViewById<Button>(R.id.btn_ulanish)

            fun onBind(item: GroupItem.Item) {
                btn_ulanish.text = item.txtButton

                btn_ulanish.setOnClickListener {
                    Toast.makeText(mContext, "Ulanish", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_HEADER -> {
                ViewHolder.HeaderViewHolder(
                    layoutInflater.inflate(
                        R.layout.header_item,
                        parent,
                        false
                    )
                )
            }
            else -> {
                ViewHolder.SubItemViewHolder(
                    layoutInflater.inflate(
                        R.layout.sub_item,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (holder) {
            is ViewHolder.HeaderViewHolder -> holder.onBind(groupItem.header, onHeaderClicked())
            is ViewHolder.SubItemViewHolder -> holder.onBind(groupItem.itemList[position - 1])
        }

    }

    override fun getItemCount(): Int {
        if (isExpanded) {
            return groupItem.itemList.size + 1
        } else
            return 1
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return VIEW_HEADER
        } else
            return VIEW_SUB
    }

    private fun onHeaderClicked() = View.OnClickListener {
        isExpanded = !isExpanded

        if (isExpanded) {
            notifyItemRangeInserted(1, groupItem.itemList.size)
            notifyItemChanged(0)
        } else {
            notifyItemRangeRemoved(1, groupItem.itemList.size)
            notifyItemChanged(0)
        }

    }

}