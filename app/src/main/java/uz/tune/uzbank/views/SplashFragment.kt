package uz.tune.uzbank.views

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import uz.tune.uzbank.BaseFragment
import uz.tune.uzbank.R

class SplashFragment : BaseFragment(R.layout.fragment_splash) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val options = NavOptions.Builder()
            .setPopUpTo(R.id.splashFragment, true)
            .setEnterAnim(R.anim.activity_open_from_right_to_left)
            .setExitAnim(R.anim.activity_close_from_right_to_left)
            .setPopEnterAnim(R.anim.activity_open_from_left_to_right)
            .setPopExitAnim(R.anim.activity_close_from_left_to_right)
            .build()


        Handler().postDelayed({
            findNavController().navigate(
                R.id.mainFragment,
                bundleOf(),
                options
            )
        }, 2000)
    }


}