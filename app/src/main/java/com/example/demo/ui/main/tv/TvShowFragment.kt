package com.example.demo.ui.main.tv

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.example.demo.R
import com.example.demo.core.Resource
import com.example.demo.data.remote.RemoteTvShowDataSource
import com.example.demo.databinding.FragmentTvShowBinding
import com.example.demo.domain.RetrofitClient
import com.example.demo.domain.tvshow.TvShowRepositoryImpl
import com.example.demo.presentation.TvShowViewModel
import com.example.demo.presentation.TvShowViewModelFactory
import com.example.demo.ui.main.tv.concat.PopularTvConcatAdapter
import com.example.demo.ui.main.tv.concat.TopRatedTvConcatAdapter

class TvShowFragment : Fragment(
    R.layout.fragment_tv_show,
    //TvAdapter.OnTvShowClickListener
) {
    private lateinit var concat_adapter: ConcatAdapter
    private lateinit var binding: FragmentTvShowBinding
    private val viewModel by viewModels<TvShowViewModel> {
        TvShowViewModelFactory(
            TvShowRepositoryImpl(
                RemoteTvShowDataSource(RetrofitClient.webservice)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTvShowBinding.bind(view)

        concat_adapter = ConcatAdapter()

        viewModel.fetchMainScreenTvShow().observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE

                }
                is Resource.Success->{
                    binding.progressBar.visibility = View.GONE
                    concat_adapter.apply {
                        addAdapter(
                            0,
                            PopularTvConcatAdapter(
                                TvAdapter(
                                   it.data.first.results,
                                   // this@TvShowFragment

                                )
                            )
                        )
                        addAdapter(
                            1,
                            TopRatedTvConcatAdapter(
                            TvAdapter(
                                    it.data.second.results,
                                   // this@MovieFragment
                                )
                            )
                        )
                    }
                }
                is Resource.Failure->{
                    binding.progressBar.visibility = View.GONE
                    Log.e("FetchError", "Error: $it.exception ")
                    Toast.makeText(requireContext(), "Error: ${it.exception}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        } )
    }

}