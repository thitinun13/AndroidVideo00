package com.example.android.devbyteviewer

import android.app.Application
import android.os.Build
import androidx.work.*

import com.example.android.devbyteviewer.work.RefreshDataWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

// ตั้งค่าการทำงานเบื้องหลังผ่าน WorkManager
class DevByteApplication : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)


    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }

    //delayedInit เพื่อให้ app ทำงานไม่ล่าช้า
    private fun delayedInit() {
        applicationScope.launch {
            Timber.plant(Timber.DebugTree())
            setupRecurringWork()
        }
    }

    //set WorkManager ให้ดึงข้อมูลเป็นระยะๆ หรือ ทุกวัน
    private fun setupRecurringWork() {

        val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresCharging(true)
                .setRequiresBatteryNotLow(true)
                .apply {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setRequiresDeviceIdle(true)
                    }
                }
                .build()

        //PeriodicWorkRequest PeriodicWorkRequest จะเหมาะกับสั่ง Task ให้ทำงานเป็นระยะๆ อย่างเช่นคอย Sync ข้อมูลจาก Web Server ทุกๆ 2 ชั่วโมง หรือส่ง Log ที่บันทึกเก็บไว้ในเครื่องขึ้น Web Server ทุกๆ 24 ชั่วโมง
        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build()

        Timber.d("WorkManager: Periodic Work request for sync is scheduled")
        WorkManager.getInstance().enqueueUniquePeriodicWork(
                RefreshDataWorker.WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP, // ExistingPeriodicWorkPolicy คือ การแจกแจงนโยบายการแก้ปัญหาความขัดแย้ง Keep หากมีงานที่รอดำเนินการอยู่ (ยังไม่เสร็จสมบูรณ์) โดยใช้ชื่อเฉพาะเดียวกันไม่ต้องทำอะไรเลย
                repeatingRequest)                                                                      //Replace หากมีงานที่รอดำเนินการอยู่ (ยังไม่เสร็จสมบูรณ์) โดยใช้ชื่อเฉพาะเดียวกันให้ยกเลิกและลบทิ้ง
    }
}
