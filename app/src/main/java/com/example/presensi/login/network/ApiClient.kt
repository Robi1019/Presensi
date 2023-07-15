package com.example.presensi.login.network

import com.example.presensi.login.model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiClient {
    @FormUrlEncoded
    @POST("dbSkripsi/login_service.php")
    fun login(
        @Field("post_email") email: String,
        @Field("post_password") password: String
    ): Call<ResponseLogin>
}