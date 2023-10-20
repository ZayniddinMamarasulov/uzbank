package uz.tune.uzbank.views.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import uz.tune.uzbank.BaseFragment
import uz.tune.uzbank.R
import uz.tune.uzbank.databinding.FragmentCardsBinding
import uz.tune.uzbank.models.RateModel

class CardsFragment : BaseFragment(R.layout.fragment_cards) {

    private val viewModel by viewModels<CardsFragmentVM>()

    private lateinit var binding: FragmentCardsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            userNameLiveData.observe(viewLifecycleOwner, userNameObserver)
            userAgeLiveData.observe(viewLifecycleOwner, userAgeObserver)
            ratesLiveData.observe(viewLifecycleOwner, ratesObserver)
        }

        hideGlobalLoading()
    }

    private val userNameObserver = Observer<String?> {
        binding.tvUserName.text = it
    }

    private val userAgeObserver = Observer<Int?> {
        binding.tvTitle.text = it.toString()
    }

    private val ratesObserver = Observer<List<RateModel>> {
        binding.tvUserName.text = it[0].CcyNm_UZ
    }
}