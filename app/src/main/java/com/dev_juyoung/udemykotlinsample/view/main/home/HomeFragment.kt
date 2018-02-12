package com.dev_juyoung.udemykotlinsample.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dev_juyoung.udemykotlinsample.R
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrRepository
import com.dev_juyoung.udemykotlinsample.view.main.home.adapter.HomeRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by juyounglee on 2018. 2. 6..
 */

class HomeFragment : Fragment(), HomeContract.View {

    private val presenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment, FlickrRepository, homeAdapter, homeAdapter)
    }

    private val homeAdapter: HomeRecyclerAdapter by lazy {
        HomeRecyclerAdapter(this@HomeFragment.context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.loadFlickrPhotos()
        initLayout()
    }

    private fun initLayout() {
        homeRecyclerView.run {
            layoutManager = GridLayoutManager(this@HomeFragment.context, 2)
            adapter = homeAdapter
            smoothScrollToPosition(0)
            addOnScrollListener(recyclerViewOnScrollListener)
        }

        homeRefreshLayout.run {
            setOnRefreshListener(onRefreshListener)
        }
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = recyclerView?.childCount as Int
            val totalItemCount = homeAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if (!presenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 3) {
                presenter.loadFlickrPhotos()
            }
        }
    }

    private val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        presenter.requestPage = 1
        presenter.loadFlickrPhotos(true)
    }

    override fun hideProgress() {
        if (homeRefreshLayout.isRefreshing) {
            homeRefreshLayout.isRefreshing = false
            return
        }

        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        if (homeRefreshLayout.isRefreshing) {
            return
        }

        progressBar.visibility = View.VISIBLE
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}