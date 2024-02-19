package com.montecastelo.todolist.api

import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.GET

interface CatsApi {
    /*
    {
		"_id": "591f9894d369931519ce358f",
		"__v": 0,
		"text": "A female cat will be pregnant for approximately 9 weeks - between 62 and 65 days from conception to delivery.",
		"updatedAt": "2018-01-04T01:10:54.673Z",
		"deleted": false,
		"source": "api",
		"sentCount": 5
	}
    */
    @GET("/facts/random?animal_type=cat&amount=1")
    fun getCatFact(): Call<CatFactResponse>
}

@Serializable
data class CatFactResponse(
    val _id: String,
    val __v: Int,
    val text: String,
    val updatedAt: String,
    val deleted: Boolean,
    val source: String,
    val sentCount: Int
)