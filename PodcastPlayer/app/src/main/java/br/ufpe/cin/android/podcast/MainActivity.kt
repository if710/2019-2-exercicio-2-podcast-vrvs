package br.ufpe.cin.android.podcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = ItemFeedAdapter(listOf())
        recycler_view.layoutManager = LinearLayoutManager(this)

        doAsync {
            val xml = URL("https://s3-us-west-1.amazonaws.com/podcasts.thepolyglotdeveloper.com/podcast.xml").readText()
            val itemFeedList : List<ItemFeed> = Parser.parse(xml)

            uiThread {
                recycler_view.adapter = ItemFeedAdapter(itemFeedList)
            }
        }
    }
}
