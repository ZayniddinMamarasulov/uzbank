package uz.tune.uzbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import uz.tune.uzbank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<BaseVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun hideLoading() {
        binding.progressCircular.visibility = View.GONE

    }

    fun showLoading() {
        binding.progressCircular.visibility = View.VISIBLE
    }

}