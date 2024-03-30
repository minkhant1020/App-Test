package mkkcom.example.apptest.taskandbackstack
import android.app.ActivityManager
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.viewbinding.ViewBinding
import mkkcom.example.apptest.BaseActivity

abstract class BaseTaskAndBackstackActivity<VB : ViewBinding> : BaseActivity<VB> (){

    override fun onResume() {
        super.onResume()

        this.logTaskAndActivity()
    }

    private fun logTaskAndActivity() {
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val tasks = activityManager.appTasks

        Log.d("TAG", "Task Count = ${tasks.count()}")

        tasks.forEachIndexed { index, appTask ->
            Log.d("TAG", "Activity Count of Task ${index+1} = ${appTask.taskInfo.numActivities}")
        }

        Log.d("TAG", "----------------------------------------------------------------")
    }

    protected fun listenButtonClick(
        buttonOne: View,
        buttonTwo: View,
        buttonThree: View,
        buttonFour: View,
        buttonFive: View,
        buttonSix: View,
    ){
        buttonOne.setOnClickListener { this.goOneActivity() }
        buttonTwo.setOnClickListener { this.goTwoActivity() }
        buttonThree.setOnClickListener { this.goThreeActivity() }
        buttonFour.setOnClickListener { this.goFourActivity() }
        buttonFive.setOnClickListener { this.goFiveActivity() }
        buttonSix.setOnClickListener { this.goSixActivity() }
    }



    private fun goOneActivity(){

        val intent= OneActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goTwoActivity(){

        val intent= TwoActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goThreeActivity(){

        val intent= ThreeActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goFourActivity(){

        val intent= FourActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goFiveActivity(){

        val intent= FiveActivity.getInstance(this)
        //intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
       // intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        //intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        //intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK
       // intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        //intent.flags=Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        //intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
        //intent.flags=Intent.FLAG_ACTIVITY_NO_ANIMATION
        //intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
        //intent.flags=Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
        //intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        //intent.flags=Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
       // intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_FORWARD_RESULT
        //intent.flags=Intent.FLAG_ACTIVITY_FORWARD_RESULT
        //intent.flags=Intent.FLAG_ACTIVITY_FORWARD_RESULT or Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY




        startActivity(intent)

    }
    private fun goSixActivity(){

        val intent= SixActivity.getInstance(this)
        startActivity(intent)

    }

}