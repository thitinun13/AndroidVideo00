package com.example.android.devbyteviewer.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
//ถ้าหากมี service มากกว่า 1 ต้องทำเป็น file แยก service

//ใช้ ratroitfit เพื่อดึงข้อมูลรายการ playlist จากพาท devbytes
interface DevbyteService {
    @GET("devbytes")
    suspend fun getPlaylist(): NetworkVideoContainer
}

//เข้าถึงข้อมูลผ่าน internet โดยเรียกผ่าน DevByteNetwork.devbytes.getPlaylist ()
object DevByteNetwork {

    // ตั้ง path url เพื่อให้รูว่าจะดึงข้อมูล json มาจากที่ไหน
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val devbytes = retrofit.create(DevbyteService::class.java)

}


