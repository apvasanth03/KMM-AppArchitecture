package com.vasanth.kmm.apparchitecture.android.ui.userlist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vasanth.kmm.apparchitecture.android.ui.common.base.BaseComponentFragment
import com.vasanth.kmm.apparchitecture.android.ui.userlist.components.UserListScreen
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserListSideEffect
import com.vasanth.kmm.apparchitecture.presentation.userlist.viewmodel.UserListViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : BaseComponentFragment() {

    private val viewModel: UserListViewModel by viewModel()

    // region Fragment Methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setUpViewModelBindings()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @Composable
    override fun CreateContent() {
        UserListScreen()
    }
    // endregion

    // region Helper Methods.
    private fun setUpViewModelBindings() {
        observeSideEffect()
    }

    // region ViewModel SideEffect
    private fun observeSideEffect() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sideEffect.collect {
                    handleSideEffect(it)
                }
            }
        }
    }

    private fun handleSideEffect(it: UserListSideEffect) {
        when (it) {
            is UserListSideEffect.NavigateToUserDetailScreen -> {
                navigateToUserDetailScreen(it)
            }
        }
    }

    private fun navigateToUserDetailScreen(sideEffect: UserListSideEffect.NavigateToUserDetailScreen) {
        // Not yet Implemented
    }
    // endregion
    // endregion
}