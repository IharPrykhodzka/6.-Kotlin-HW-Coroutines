package com.example.hw6coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw6coroutines.model.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItemPost.layoutManager = LinearLayoutManager(this)
        rvItemPost.adapter = AdapterPosts(getSimpleListData())

    }

    private fun getSimpleListData(): MutableList<StandardPost> {
        val list = mutableListOf<StandardPost>()

        list.add(
            StandardPost(
                0,
                Types.STANDARD_TYPE,
                R.drawable.ic_baseline_fingerprint_24,
                "20.10.2020",
                "Игорь Приходько",
                "Вы решили написать функцию, которая из количества секунд генерирует человекопонятное представление времени публикации.",
                null,
                null,
                null,
                false,
                0,
                true,
                11,
                false,
                2
            )
        )
        list.add(
            StandardPost(
                1,
                Types.EVENT_TYPE,
                R.drawable.ic_baseline_fingerprint_24,
                "19.10.2020",
                "Игорь Приходько",
                "Путь в избушку на сбор по пейнтболу.",
                null,
                null,
                "geo:55.754283,37.62002?z=15",
                true,
                123,
                false,
                0,
                true,
                44
            )
        )
        list.add(
            StandardPost(
                2,
                Types.POST_WITH_VIDEO_TYPE,
                R.drawable.ic_baseline_fingerprint_24,
                "18.10.2020",
                "Игорь Приходько",
                "Зацените легендарный клип!",
                "https://youtu.be/HyHNuVaZJ-k",
                null,
                null,
                true,
                234,
                true,
                45,
                true,
                99
            )
        )
        list.add(
            StandardPost(
                3,
                Types.PROMOTION_TYPE,
                R.drawable.ic_baseline_fingerprint_24,
                "17.10.2020",
                "Игорь Приходько",
                "Вы решили пропиариться? Обращайтесь к нам!",
                null,
                "https://www.google.com/search?q=%D1%80%D0%B5%D0%BA%D0%BB%D0%B0%D0%BC%D0%B0&oq=Htrkfvf&aqs=chrome.1.69i57j0i1i10l2j0i10i433j0i10j0i10i433j0i10l2.3670j0j9&sourceid=chrome&ie=UTF-8",
                null,
                false,
                0,
                true,
                11,
                true,
                2
            )
        )
        list.add(
            StandardPost(
                4,
                Types.RE_POST_TYPE,
                R.drawable.ic_baseline_fingerprint_24,
                "16.10.2020",
                "Игорь Приходько",
                null,
                null,
                null,
                null,
                false,
                0,
                true,
                11,
                true,
                2,
                1,
                R.drawable.ic_baseline_fingerprint_24,
                "20.10.2020",
                "Игорь Приходько",
                "Зацените легендарный клип!",
                "https://youtu.be/HyHNuVaZJ-k"
            )
        )
        return list
    }
    }

