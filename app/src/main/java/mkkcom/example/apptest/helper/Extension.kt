package mkkcom.example.apptest.helper

import android.content.Context
import android.content.Intent
import android.os.Message
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.reactivex.rxjava3.core.Completable
import mkkcom.example.apptest.R

fun AppCompatActivity.showDialogFragment(
    fragment: Fragment,
    replace: Boolean = false,
    addToBackStack: Boolean = true,
    animation: ScreenAnimation? = ScreenAnimation.DEFAULT
){
    val transaction = supportFragmentManager.beginTransaction().apply {
        if (addToBackStack) { addToBackStack(fragment.javaClass.name) }
        animation?.let {
            setCustomAnimations(it.enter,it.exit,it.popEnter,it.popExit)
        }
    }
    if (replace) {
        transaction.replace(android.R.id.content, fragment)
    } else {
        transaction.add(android.R.id.content, fragment)
    }
    transaction.commit()

}
fun Context.showToast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()

}
fun Completable.attachProgress(progressView: SwipeRefreshLayout): Completable{
 return this
     .doOnSubscribe {  progressView.isRefreshing = true  }
     .doOnComplete { progressView.isRefreshing = false }
     .doOnError { progressView.isRefreshing = false }
     .doOnTerminate { progressView.isRefreshing = false }


}
