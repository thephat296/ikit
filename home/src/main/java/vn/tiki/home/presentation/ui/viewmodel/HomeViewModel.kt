package vn.tiki.home.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import vn.tiki.coroutines.CoroutinesDispatcherProvider
import vn.tiki.home.domain.usecase.GetBannersUseCase
import vn.tiki.home.domain.usecase.GetQuickLinksUseCase

/**
 * Created by phatvt2 on 8/5/20
 */

class HomeViewModel(
    private val dispatcherProvider: CoroutinesDispatcherProvider,
    private val getBannersUseCase: GetBannersUseCase,
    private val getQuickLinksUseCase: GetQuickLinksUseCase
) : ViewModel()