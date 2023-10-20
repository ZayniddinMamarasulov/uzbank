package uz.tune.uzbank

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions

open class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    val navAnimOptions = NavOptions.Builder().setEnterAnim(R.anim.activity_open_from_right_to_left)
        .setExitAnim(R.anim.activity_close_from_right_to_left)
        .setPopEnterAnim(R.anim.activity_open_from_left_to_right)
        .setPopExitAnim(R.anim.activity_close_from_left_to_right).build()


    fun showGlobalLoading() {
        (requireActivity() as MainActivity).showLoading()
    }

    fun hideGlobalLoading() {
        (requireActivity() as MainActivity).hideLoading()
    }
}