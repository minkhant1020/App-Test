package mkkcom.example.apptest.userinterface

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityDialogBinding
import mkkcom.example.apptest.databinding.CustomDialogBinding
import java.time.Year
import java.util.Calendar
import java.util.Objects

class DialogActivity : BaseActivity<ActivityDialogBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, DialogActivity ::class.java)

        }
    }

    override val pageTitle: String get() = "Dialog"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDialogBinding {
        return ActivityDialogBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnAlertDialog.setOnClickListener {this.showAlertDialog(
            "This is test alert dialog",
            "Test Dialog",
               Pair("Ok",{})

        )}
        binding.btnCustomDialog.setOnClickListener { this.showCustomDialog() }
        binding.btnDatePickerDialog.setOnClickListener { this.showDatePicker() }
        binding.btnTimePickerDialog.setOnClickListener { this.showTimePicker() }
    }

    private fun showAlertDialog(
        message: String ,
        title: String? = null,
        positive: Pair<String , () -> Unit> ? = null

        ){
         AlertDialog.Builder(this).apply {
             setTitle(title)
             setMessage(message)
             setNegativeButton("Cancel"){_ ,_ ->
                 Toast.makeText(this@DialogActivity,"Negative",Toast.LENGTH_LONG).show()
             }
                 setOnDismissListener {
                     Log.d("TAG", "showAlertDialog ")
                 }
                     .setCancelable(true)
             positive?.let {
                 setPositiveButton(it.first){ _ , _ ->
                     it.second.invoke()
                 }
             }

             create()
             show()
         }
        }
    private fun showCustomDialog(){
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        val dialog: AlertDialog = AlertDialog.Builder(this)
          .setView(dialogBinding.root)

            .setOnCancelListener {
                Log.d("TAG", "Cancel Custom Dialog ")
            }

          .setOnDismissListener {
                Log.d("TAG", "Dismiss Custom Dialog ")
            }
                .create()
              dialog.show()
            dialogBinding.btnShow.setOnClickListener {
                Toast.makeText(this,dialogBinding.edtMessage.text.toString(),Toast.LENGTH_LONG).show()
               dialog.dismiss()
            }
            dialogBinding.btnCancel.setOnClickListener {
               dialogBinding.edtMessage.text?.clear()
            }
          }
    private fun showDatePicker() {

        val dialog = DatePickerDialog(this)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        dialog.datePicker.updateDate(year,month,1)
        dialog.datePicker.maxDate = c.time.time

        c.set(Calendar.YEAR,year-1)
        c.add(Calendar.YEAR,-1)
        dialog.datePicker.minDate=c.time.time

        dialog.setOnDateSetListener { datePicker, y, m, d ->
            c.set(Calendar.YEAR,y)
            c.set(Calendar.MONTH,m)
            c.set(Calendar.DATE,d)
            Toast.makeText(this,c.time.toString(),Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }
    private fun showTimePicker(){
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

       val dialog = TimePickerDialog(this,
           { view, hourOfDay, minute ->  },hour,minute,false)



        TimePickerDialog.OnTimeSetListener { view, H, M ->
            c.set(Calendar.HOUR_OF_DAY,H)
            c.set(Calendar.MINUTE,M)
            Toast.makeText(this,c.time.time.toString(),Toast.LENGTH_LONG).show()

        }


        dialog.show()


    }

        }