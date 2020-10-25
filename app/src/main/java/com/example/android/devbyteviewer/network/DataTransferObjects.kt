package com.example.android.devbyteviewer.network

import com.example.android.devbyteviewer.database.DatabaseVideo
import com.example.android.devbyteviewer.domain.DevByteVideo
import com.squareup.moshi.JsonClass


//data class ที่มีข้อมูลของ List<Netvorkvideo> โดยเก็บใน video
@JsonClass(generateAdapter = true)
data class NetworkVideoContainer(val videos: List<NetworkVideo>)

//class data ของ video
@JsonClass(generateAdapter = true)
data class NetworkVideo(
        val title: String,
        val description: String,
        val url: String,
        val updated: String,
        val thumbnail: String,
        val closedCaptions: String?)


//แปลงข้อมูลที่ได้จาก internet เป็นข้อมูล
fun NetworkVideoContainer.asDatabaseModel(): List<DatabaseVideo> {
    //map จะแปลงข้อมูลทุกตัวด้วยเงื่อนไขเดียวกัน ในที่นี้คือ string
    return videos.map {
        DatabaseVideo(
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail)
    }
}

