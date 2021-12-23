package com.pss.clean_architecture_sample.view

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.pss.clean_architecture_sample.R
import com.pss.clean_architecture_sample.base.BaseActivity
import com.pss.clean_architecture_sample.databinding.ActivityMainBinding
import com.pss.clean_architecture_sample.viewmode.MainViewModel
import com.pss.clean_architecture_sample.widget.utils.ScreenState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()


    override fun init() {
        binding.activity= this
        observeViewModel()
    }

    fun clickSearchBtn(view: View){
        mainViewModel.getUserRepo(binding.githubNameEditTxt.text.toString())
    }

    private fun observeViewModel(){
        mainViewModel.mutableScreenState.observe(this,{
            Log.d("로그","$it")
            when(it){
                ScreenState.RENDER -> shortShowToast("성공!")
                ScreenState.ERROR -> shortShowToast("에러 발생!!")
                else -> shortShowToast("알수없는 에러 발생!!")
            }
        })

        mainViewModel.eventUserRepo.observe(this,{
            it.map { item ->
                binding.responseTxt.text = item.url
            }
        })
    }
}