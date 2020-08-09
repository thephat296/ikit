package vn.tiki.home.presentation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_home.*
import vn.tiki.extensions.safeObserve
import vn.tiki.home.R
import vn.tiki.home.presentation.ui.activity.HomeActivity
import vn.tiki.home.presentation.ui.adapter.HomeAdapter
import vn.tiki.home.presentation.ui.factory.HomeViewHolderFactory
import vn.tiki.home.presentation.ui.factory.HomeViewModelFactory
import vn.tiki.home.presentation.ui.viewmodel.HomeViewModel
import vn.tiki.ui.fragment.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    @Inject
    internal lateinit var homeViewModelFactory: HomeViewModelFactory
    private val homeViewModel by viewModels<HomeViewModel> { homeViewModelFactory }

    @Inject
    internal lateinit var homeViewHolderFactory: HomeViewHolderFactory

    private lateinit var adapter: HomeAdapter

    override val layoutResId: Int
        get() = R.layout.fragment_home

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as HomeActivity).homeComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HomeAdapter(homeViewHolderFactory)
        rvHome.adapter = adapter
        rvHome.setHasFixedSize(true)
        homeViewModel.homeItems.safeObserve(this, Observer {
            refreshLayout.isRefreshing = false
            adapter.submitList(it)
        })

        refreshLayout.setOnRefreshListener {
            homeViewModel.fetchHomeItems()
        }
    }

}