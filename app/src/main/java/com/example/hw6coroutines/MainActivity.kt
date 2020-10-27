package com.example.hw6coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw6coroutines.model.*
import io.ktor.client.request.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItemPost.layoutManager = LinearLayoutManager(this)
        getSimpleListData()

    }

    private fun getSimpleListData() = launch {
        val listFromServer = withContext(Dispatchers.IO) {
            Api.client.get<List<StandardPost>>(Api.url)
        }
        rvItemPost.adapter = AdapterPosts(
            listOf(StandardPost(
                0,
                Types.STANDARD_TYPE,
                R.drawable.ic_baseline_fingerprint_24,
                "27.10.2020",
                "Игорь Приходько",
                "" +
                        "" +
                        "",
                null,
                null,
                null,
                false,
                0,
                false,
                0,
                false,
                0
                ))
        )
        progressBar.visibility = View.VISIBLE
        delay(5000)
        progressBar.visibility = View.GONE
        rvItemPost.adapter = AdapterPosts(listFromServer)
    }
}

