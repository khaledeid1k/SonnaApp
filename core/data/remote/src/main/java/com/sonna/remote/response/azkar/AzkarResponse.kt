package com.sonna.remote.response.azkar

class AzkarResponse : ArrayList<AzkarResponseItem>()
//typealias AzkarResponse = List<AzkarResponseItem>

data class AzkarResponseItem(
    val category: String,
    val count: String,
    val description: String,
    val reference: String,
    val zekr: String
)