package com.chainreaction.moviesassignmentapp.presentations.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.chainreaction.core.bases.BaseListAdapter
import com.chainreaction.core.bases.BaseViewHolder
import com.chainreaction.moviesassignmentapp.R
import com.chainreaction.moviesassignmentapp.databinding.ItemTvShowBinding
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow

class TvShowAdapter : BaseListAdapter<BaseViewHolder<TvShow>, TvShow>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemTvShowBinding>(
            inflater, R.layout.item_tv_show, parent, false
        )
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<TvShow>, position: Int) {
        holder.bind(getItem(position), position, getOnItemClickListener())
    }

    companion object {

        val DIFF_CALLBACK: DiffUtil.ItemCallback<TvShow> =
            object : DiffUtil.ItemCallback<TvShow>() {
                override fun areContentsTheSame(
                    oldItem: TvShow,
                    newItem: TvShow
                ): Boolean {
                    return oldItem.name == newItem.name
                }

                override fun areItemsTheSame(
                    oldItem: TvShow,
                    newItem: TvShow
                ): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}