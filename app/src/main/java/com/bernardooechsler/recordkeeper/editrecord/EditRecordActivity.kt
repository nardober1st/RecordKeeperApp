package com.bernardooechsler.recordkeeper.editrecord

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.bernardooechsler.recordkeeper.databinding.ActivityEditRecordBinding

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding

    private val screenData: ScreenData by lazy {

    }

    // Creating the sharedPreferences to store os values in a file
//    private val runningPreferences: SharedPreferences by lazy { getSharedPreferences("running", Context.MODE_PRIVATE) }
    private val recordPreferences: SharedPreferences by lazy {
        getSharedPreferences(
            "running",
            Context.MODE_PRIVATE
        )
    }

    //    private val distance: String? by lazy { intent.getStringExtra("Distance") }
    private val record: String? by lazy { intent.getStringExtra("Distance") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        title = "$distance Record"

//        ***EXAMPLE FROM VIDEO-CLASS***
//        val applicationPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        applicationPreferences.edit {
//            putString("Some application data", "Application preference value here")
//        }
//
//        val activityPreferences = getPreferences(Context.MODE_PRIVATE)
//        activityPreferences.edit {
//            putInt("Some activity data", 15)
//        }
//
//        val fileNamePreferences = getSharedPreferences("some shared preference file name", Context.MODE_PRIVATE)
//        fileNamePreferences.edit {
//            putBoolean("Some preference file name data", false)
//        }

//        binding.buttonSave.setOnClickListener {
//            saveRecord()
//            finish()
//        }
//        binding.buttonDelete.setOnClickListener { }
        setupUi()
        displayRecord()
    }

    private fun setupUi() {
        title = "$record Record"
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()
        }
    }

    // Since we made the "distance variable" a class property and we initialized it by lazy, we can remove in the function's parameter
    // Before was: private fun displayRecord(distance: String?) and we were initializing the variable distance in onCreate()
    private fun displayRecord() {
        // We made the var runningPreferences a class property and we initialized it by lazy
//        runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        binding.editTextRecord.setText(recordPreferences.getString("$record record", null))
        binding.editTextDate.setText(recordPreferences.getString("$record date", null))
    }

    // Since we made the "distance variable" a class property and we initialized it by lazy, we can remove in the function's parameter
    // Before was: private fun saveRecord(distance: String?) and we were initializing the variable distance in onCreate()
    private fun saveRecord() {
        // This will take the context of the editTextRecord and convert it to a String (toString())
        val record = binding.editTextRecord.text.toString()
        // This will take the context of the editTextDate and convert it to a String (toString())
        val date = binding.editTextDate.text.toString()

        // Old way of doing it
//        val editor = runningPreferences.edit()
//        editor.putString("record", record)
//        editor.putString("date", date)
//        editor.apply()

        // We made the var runningPreferences a class property and we initialized it by lazy
//        runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        recordPreferences.edit {
            // We are using the 'distance' the we got from MainActivity through an intent to store the values in a file
            // If we didn't do that, each time we add a record or data, one would override the other
            putString("${this@EditRecordActivity.record} record", record)
            putString("${this@EditRecordActivity.record} date", date)
        }
    }

    private fun clearRecord() {
        recordPreferences.edit {
            remove("$record record")
            remove("$record date")
        }
    }

    data class ScreenData(
        val record: String,
        val sharedPreferencesName: String,
        val recordFieldHint: String
    )
}