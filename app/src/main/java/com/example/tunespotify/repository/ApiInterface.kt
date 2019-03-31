package com.example.tunespotify.repository

import com.example.tunespotify.model.RefreshToken
import com.example.tunespotify.util.ApiEndpoints
import com.example.tunespotify.util.Constants
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST
    fun refreshToken(
        @Header(Constants.AUTHORIZATION) authorization: String,
        @Field(Constants.REFRESH_TOKEN) refreshToken: String,
        @Field(Constants.GRANT_TYPE) grantType: String = Constants.REFRESH_TOKEN,
        @Url url: String = ApiEndpoints.BASE_URL_ACCOUNTS + ApiEndpoints.TOKEN_ENDPOINT
    ): Call<RefreshToken>

    @GET("v1/me/top/{type}")
    fun getUserTopArtistAndTracks(@Path("type") type: String): Single<ResponseBody>
}