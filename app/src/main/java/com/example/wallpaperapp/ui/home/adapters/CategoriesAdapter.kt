package com.example.wallpaperapp.ui.home.adapters


import com.example.wallpaperapp.utils.base.BaseDiffUtils
import com.example.wallpaperapp.utils.loadImage
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.data.model.home.ResponseCategories
import com.example.wallpaperapp.databinding.ItemCategoriesBinding
import javax.inject.Inject

class CategoriesAdapter @Inject constructor() : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var items = emptyList<ResponseCategories.ResponseCategoriesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    inner class ViewHolder(private val binding: ItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ResponseCategories.ResponseCategoriesItem) {
            binding.apply {
                //Image
                item.coverPhoto?.urls?.regular?.let {
                    image.loadImage(it)
                }
                titleTxt.text = item.title
                //Click
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item.id!!, item.title!!)
                    }
                }
            }
        }
    }

    private var onItemClickListener: ((String, String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String, String) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<ResponseCategories.ResponseCategoriesItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, data)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = data
        diffUtils.dispatchUpdatesTo(this)
    }
}