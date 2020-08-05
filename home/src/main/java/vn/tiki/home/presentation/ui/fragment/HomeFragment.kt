package vn.tiki.home.presentation.ui.fragment

import androidx.fragment.app.viewModels
import vn.tiki.home.R
import vn.tiki.home.presentation.viewmodel.HomeViewModel
import vn.tiki.ui.fragment.BaseFragment

class HomeFragment : BaseFragment() {
    private val homeViewModel by viewModels<HomeViewModel>()

    override val layoutResId: Int
        get() = R.layout.fragment_home

}