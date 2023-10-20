package uz.tune.uzbank.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import uz.tune.uzbank.BaseFragment
import uz.tune.uzbank.R
import uz.tune.uzbank.databinding.FragmentHomeBinding
import uz.tune.uzbank.databinding.FragmentMainBinding

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMyCards.setOnClickListener {
            Navigation.findNavController(
                requireActivity(), R.id.general_nav_fragment
            ).navigate(
                R.id.cardsFragment,
                bundleOf(
                    Pair("user_name", "Akmaljonbek"),
                    Pair("user_age", 24)
                ),
                navAnimOptions
            )
        }
    }

    private fun showResult(result: String) {
        // viewModel qaytargan natijani xml da ko'rsat
    }
}