package com.chainreaction.moviesassignmentapp.presentations.home

import android.view.View
import com.chainreaction.core.bases.BaseViewHolder
import com.chainreaction.core.extensions.toViewClickListener
import com.chainreaction.moviesassignmentapp.databinding.ItemTvShowBinding
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow

class TvShowViewHolder(private val item: ItemTvShowBinding) : BaseViewHolder<TvShow>(item) {

    override fun bind(
        model: TvShow, position: Int, clickListener: ((view: View, model: TvShow, position: Int) -> Unit)?
    ) {
        item.tvShow = model
        item.clickListener = clickListener.toViewClickListener(model, position)
    }
}