package com.example.demo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.demo.core.Resource
import com.example.demo.domain.tvshow.TvShowRepository
import kotlinx.coroutines.Dispatchers

class TvShowViewModel(private val repo: TvShowRepository):ViewModel() {
    fun fetchMainScreenTvShow() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
           emit(Resource.Success(Pair(repo.getTopRatedTvShow(),repo.getTopRatedTvShow())) )
        }catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}
class TvShowViewModelFactory(private val repo: TvShowRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TvShowRepository::class.java).newInstance(repo)
    }
}