package com.hemmati.coroutineskoinsampleproject.domain.model.videos


data class Mostviewedvideo(
    val `360d`: Boolean,
    val autoplay: Boolean,
    val big_poster: String,
    val create_date: String,
    val deleteurl: String,
    val duration: Int,
    val frame: String,
    val id: String,
    val isHidden: Boolean,
    val official: String,
    val process: String,
    val profilePhoto: String,
    val sdate: String,
    val sdate_timediff: Int,
    val small_poster: String,
    val title: String,
    val uid: String,
    val userid: String,
    val username: String,
    val video_date_status: String,
    val visit_cnt: Int
)