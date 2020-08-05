package vn.tiki.home.presentation.ui.fragment

import android.content.Context
import androidx.fragment.app.viewModels
import vn.tiki.home.R
import vn.tiki.home.presentation.factory.HomeViewModelFactory
import vn.tiki.home.presentation.ui.activity.HomeActivity
import vn.tiki.home.presentation.viewmodel.HomeViewModel
import vn.tiki.ui.fragment.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    @Inject
    internal lateinit var homeViewModelFactory: HomeViewModelFactory
    private val homeViewModel by viewModels<HomeViewModel> { homeViewModelFactory }

    override val layoutResId: Int
        get() = R.layout.fragment_home

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as HomeActivity).homeComponent.inject(this)
    }

}