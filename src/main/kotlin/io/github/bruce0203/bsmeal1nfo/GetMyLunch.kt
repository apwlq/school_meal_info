package io.github.bruce0203.bsmeal1nfo

import com.leeseojune.neisapi.NeisApi
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat
import java.util.*


fun getMyLunch(): String {
    val neis = NeisApi.Builder()
        .build()

    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByAbsoluteDay(getNowDate(), sch.scCode, sch.schoolCode)
    return meal.lunch.joinToString("\n")
}

fun getMyDinner(): String {
    val neis = NeisApi.Builder()
        .build()

    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByAbsoluteDay(getNowDate(), sch.scCode, sch.schoolCode)
    return meal.dinner.joinToString("\n")
}

fun getNowDate(): String = run {
    val cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"))
    val dt1 = SimpleDateFormat("YYYYMMdd")
    dt1.format(cal.time).toString()
}
