package com.booisajerk.flyer.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.booisajerk.flyer.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.*

class SpaceListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: SpaceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false).apply {
            //TODO find the newer way for this
            viewModel = ViewModelProviders.of(this@SpaceListFragment).get(SpaceListViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel?.fetchSpaceList()

        setUpAdapter()
        setUpObservers()
    }

    private fun setUpAdapter() {
        val viewModel = binding.viewModel
        if(viewModel != null) {
            adapter = SpaceListAdapter(binding.viewModel!!)
            Log.d(TAG, "ViewModel is not null. setting adapter to SpaceListAdapter")

            val layoutManager = LinearLayoutManager(activity)
            list_recycler_view.layoutManager = layoutManager
            list_recycler_view.adapter = adapter
        }
    }

    private fun setUpObservers() {
        binding.viewModel?.spaceListLive?.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "spaceListLive has been updated. Observer observed it")
            adapter.updateList(it)
        })

        binding.viewModel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            val toast = Toast.makeText(activity, "Toasty!",Toast.LENGTH_LONG)
            toast.show()
        })
    }

    companion object {
        fun newInstance() = SpaceListFragment()
        const val TAG = "SpaceListFragment"
    }
}