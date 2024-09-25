package mkkcom.example.apptest.api

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.api.model.Api
import mkkcom.example.apptest.api.model.Movie
import mkkcom.example.apptest.api.model.MoviePage
import mkkcom.example.apptest.databinding.ActivityNetworkBinding
import mkkcom.example.apptest.databinding.GridViewItemBinding
import mkkcom.example.apptest.helper.ScreenAnimation
import mkkcom.example.apptest.helper.attachProgress
import mkkcom.example.apptest.helper.showDialogFragment
import mkkcom.example.apptest.helper.showToast
import mkkcom.example.apptest.userinterface.fragments.AddProductFragment
import mkkcom.example.apptest.viewmodel.MyVM
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.androidx.viewmodel.ext.android.viewModel


@Suppress("DEPRECATION")
class NetworkActivity : BaseActivity<ActivityNetworkBinding>() {


    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, NetworkActivity::class.java)


        }
    }


    override val pageTitle: String
        get() = "Network Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityNetworkBinding {
        return ActivityNetworkBinding.inflate(layoutInflater)
    }

    private val myVM: MyVM by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.fetchMovies()

        binding.swipeRefreshLayout.setOnRefreshListener {
            this.fetchMovies()




        }
        this.fetchMovies()

    }

    override fun onStart() {
        super.onStart()
        myVM.movieSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                this.setupCustomAdapter(it.results)
            }, Throwable::printStackTrace)
            .addTo(disposable)
    }

    private fun fetchMovies() {

        this.myVM.fetchMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .attachProgress(binding.swipeRefreshLayout)
            .subscribe()
            .addTo(disposable)
       
    }

     /*private fun fetchMovies() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/discover/movie?language=en-US&page=1")
            .get()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwZWUwMTIyZWJhNWVkMjI0MWY4YWU5OWNmMGQyYTcyMyIsIm5iZiI6MTcyNDIzMDY1NS4zODA4ODEsInN1YiI6IjY2YzVhNWRjNjVmOWE3ZDRmYWY3Mzk1ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1B7cq3tRL0FgA75oRVIeG1s7nBEI0QfAavtkEaORgUk"
            )
            .build()

        AsyncTask.execute {
            val response = client.newCall(request).execute()
            val body = response.body?.string()

            Log.d("TEST_LOG", "Status Code: ${response.code}")
            Log.d("TEST_LOG", "Success: ${response.isSuccessful}")
            Log.d("TEST_LOG", "Body: $body")

            var moviePage: MoviePage? = null

            body?.let {
                try {
                    val gson = Gson()
                    moviePage = gson.fromJson(it, MoviePage::class.java)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            runOnUiThread {
                binding.swipeRefreshLayout.isRefreshing = false
                moviePage?.let {
                    setupCustomAdapter(it.results)

                }
            }
        }
        AsyncTask.execute {
            val response = apiService.getMovies()


        }
    }*/


    private fun testAuthentication() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/authentication")
            .get()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwZWUwMTIyZWJhNWVkMjI0MWY4YWU5OWNmMGQyYTcyMyIsIm5iZiI6MTcyNDIzMDY1NS4zODA4ODEsInN1YiI6IjY2YzVhNWRjNjVmOWE3ZDRmYWY3Mzk1ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1B7cq3tRL0FgA75oRVIeG1s7nBEI0QfAavtkEaORgUk"
            )
            .build()

        AsyncTask.execute {
            val response = client.newCall(request).execute()

            Log.d("TEST_LOG", "Status Code: ${response.code}")
            Log.d("TEST_LOG", "Success: ${response.isSuccessful}")
            Log.d("TEST_LOG", "Body: ${response.body?.string()}")
        }
    }


     private fun setupCustomAdapter(movies: List<Movie>) {
        val adapter = GridAdapter(movies)

        binding.rvMovie.setOnItemClickListener { _, _, position, _ ->
            val     item = adapter.getItem(position) as? Movie
            val name = item?.title ?: "Unknown"
            this@NetworkActivity.showToast(name)
            showDialogFragment(
                AddProductFragment.getInstance(),
                animation = ScreenAnimation.ENTER_UP_EXIT_STAY
            )

        }
        binding.rvMovie.adapter = adapter
    }

}

private class GridAdapter(val items: List<Movie>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.count()
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = GridViewItemBinding.inflate(LayoutInflater.from(p2?.context))
        binding.title.text = items[p0].title
        binding.desc.text = items[p0].release_date
        val posterUrl =
            "https://image.tmdb.org/t/p/w154${items[p0].poster_path}"

        Glide.with(binding.image.context)
            .load(posterUrl)
            .into(binding.image)



        return binding.root
    }
}


