package com.triarc.tutorial.android.retrofit_rxjava.utility

import android.content.Context
import android.net.ConnectivityManager
import android.text.TextUtils

/**
 * Created by Devanshu Verma on 5/2/19
 */
object Utils {

    private const val MONDAY    = 1
    private const val TUESDAY   = 2
    private const val WEDNESDAY = 3
    private const val THURSDAY  = 4
    private const val FRIDAY    = 5
    private const val SATURDAY  = 6
    private const val SUNDAY    = 7

    fun getPrefix(time: String?): String {
        return if(time.isNullOrEmpty()) {
            ""
        } else {
            val splitTime = time.split(":")
            val hour   = splitTime[0].toInt()
            val minute = splitTime[1].toInt()
            if((hour in 0..5) && (minute in 0..59))
                "Early"
            else
                ""
        }
    }

    fun getSchedule(prefix: String, dayDescriptor:String, timeDescriptor: String): String {
        var schedule = if(!TextUtils.isEmpty(prefix)) prefix else ""
        schedule     = if(!TextUtils.isEmpty(schedule)) "$schedule $dayDescriptor" else "$dayDescriptor"
        schedule     = if(!TextUtils.isEmpty(timeDescriptor)) "$schedule $timeDescriptor" else "$schedule"

        return schedule
    }

    fun getDayDescriptor(days: List<String>?): String {
        if(days.isNullOrEmpty())
            return ""

        var total = 0

        days.forEach {day ->
            when(day) {
                "Monday"    -> total += MONDAY
                "Tuesday"   -> total += TUESDAY
                "Wednesday" -> total += WEDNESDAY
                "Thursday"  -> total += THURSDAY
                "Friday"    -> total += FRIDAY
                "Saturday"  -> total += SATURDAY
                "Sunday"    -> total += SUNDAY
            }
        }

        return (when(total) {
            13 -> "Weekend"
            15 -> "Weekday"
            28 -> ""
            else -> days.joinToString(", ")
        })
    }

    fun getTimeDescriptor(time: String?): String {
        return if(time.isNullOrEmpty()) {
            ""
        } else {
            val splitTime = time.split(":")
            val hour   = splitTime[0].toInt()
            val minute = splitTime[1].toInt()
            if((hour in 0..11) && (minute in 0..59))
                "Mornings"
            else if((hour in 12..17) && (minute in 0..59))
                "Afternoons"
            else if((hour in 18..23) && (minute in 0..59))
                "Nights"
            else
                ""
        }
    }

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}
