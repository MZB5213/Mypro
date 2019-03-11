package com.dyth.mzb.utils.apiServer;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2018/12/25.
 */

public interface ApiServer {


    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<ResponseBody>PostCOM(@Url String url,@Body RequestBody requestBody);

    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<ResponseBody>post(@Url String url);

    @POST
    @Headers("Content-Type:application/json")
    Observable<ResponseBody>post(@Url String url, @Body RequestBody requestBody);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody>post(@Url String url,@FieldMap Map<String,Object> map);

    @POST
    @Headers("Content-Type:application/json")
    Observable<ResponseBody>postUpdata(@Url String url,@Body RequestBody requestBody);

    @POST
    @Headers("Content-Type:application/json")
    Observable<ResponseBody>postLike(@Url String url,@Body RequestBody requestBody);

    @POST
    @Headers("Content-Type:application/json")
    Observable<ResponseBody>postComments(@Url String url,@Body RequestBody requestBody);

    @POST
    @Headers("Content-Type:application/json")
    Observable<ResponseBody>postCommentsList(@Url String url,@Body RequestBody requestBody);

    @POST
    Observable<ResponseBody>Post(@Url String url,@Body RequestBody requestBody);

    @POST
    @Headers("Content-Type:application/json")
    Observable<ResponseBody>postTopic(@Url String url,@Body RequestBody requestBody);

}
