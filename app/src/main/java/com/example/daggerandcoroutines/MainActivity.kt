package com.example.daggerandcoroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.daggerandcoroutines.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        apiCallForShowUpcomingEventData()


    }

    @SuppressLint("NotifyDataSetChanged", "SuspiciousIndentation")
    private fun apiCallForShowUpcomingEventData(
    ) {
        viewModel.getEventUpcommingListApiData("", "", "", "1")
        lifecycleScope.launchWhenStarted {
            viewModel.eventUpcommingApiData.collect {
                when (it.status) {
                    Status.LOADING -> {
//                        binding.progress.visibility = View.VISIBLE
                    }

                    Status.SUCCESS -> {

                        Toast.makeText(this@MainActivity,
                            it.data!!.data?.cat_wise_event_list?.get(0)?.name, Toast.LENGTH_LONG
                        ).show()
                    }

                    Status.ERROR -> {

                    }
                }
            }
        }
    }
}