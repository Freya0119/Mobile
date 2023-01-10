package com.example.mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.adapter.RepayAdapter
import com.example.mobile.databinding.RepayShowListBinding
import com.example.mobile.viewmodel.RepayViewModel

class RepayRecyclerViewShowFragment : Fragment() {
    private var _binding: RepayShowListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    private var viewModel = RepayViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)

        _binding = RepayShowListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView = repayLogRecyclerview
        }

        val adapter = RepayAdapter()
        recyclerView.adapter = adapter
        //TODO: Test
        viewModel.updateItems()
        adapter.submitList(viewModel.allItems)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}