package com.pss.clean_architecture_sample.viewmode

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pss.clean_architecture_sample.base.BaseViewModel
import com.pss.clean_architecture_sample.widget.utils.ScreenState
import com.pss.clean_architecture_sample.widget.utils.SingleLiveEvent
import com.pss.domain.model.GithubResponse
import com.pss.domain.usecase.GetUserRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserRepoUseCase: GetUserRepoUseCase
) : BaseViewModel() {
    val eventUserRepo: LiveData<List<GithubResponse>> get() = _eventUserRepo
    private val _eventUserRepo = SingleLiveEvent<List<GithubResponse>>()


    fun getUserRepo(owner: String) = viewModelScope.launch {
        val response = getUserRepoUseCase.execute(this@MainViewModel, owner)
        if(response == null) mutableScreenState.postValue(ScreenState.ERROR) else {
            mutableScreenState.postValue(ScreenState.RENDER)
            _eventUserRepo.postValue(response!!)
        }
    }
}