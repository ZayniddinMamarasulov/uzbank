package uz.tune.uzbank.views.transfers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import uz.tune.uzbank.R
import uz.tune.uzbank.databinding.FragmentTransfersBinding

class TransfersFragment : Fragment() {

    private lateinit var binding: FragmentTransfersBinding

    private val viewModel by viewModels<TransfersFragmentVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransfersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTest.setOnClickListener {
            binding.tvTest.text = "Hello"
            viewModel.setTemp(binding.tvTest.text.toString())
        }

        viewModel.getTemp().observe(viewLifecycleOwner, Observer {
            binding.tvTest.text = it
        })
    }
}