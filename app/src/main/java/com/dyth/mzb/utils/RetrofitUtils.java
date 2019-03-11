package com.dyth.mzb.utils;

import com.dyth.mzb.infomation.beans.comments.Comments;
import com.dyth.mzb.infomation.beans.comments.CommentsListResponse;
import com.dyth.mzb.infomation.beans.givelike.GiveLikeResponse;
import com.dyth.mzb.infomation.beans.content.MessageResponse;
import com.dyth.mzb.infomation.beans.newssearch.NewssearchResponse;
import com.dyth.mzb.infomation.beans.thelabel.TheLable;
import com.dyth.mzb.infomation.beans.usercollection.UserCollectionResponse;
import com.dyth.mzb.my.base.updata.UpdataResponse;
import com.dyth.mzb.topic.bean.MyTopiccs;
import com.dyth.mzb.utils.apiServer.ApiServer;
import com.dyth.mzb.utils.network.NetworkCallBack;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtils;
    private final ApiServer apiServer;

    private RetrofitUtils(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URLManger.DYTH_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiServer = retrofit.create(ApiServer.class);
    }

    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }



    public<T> void post(String url, final NetworkCallBack<T> networkCallBack){
        apiServer.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        Gson gson = new Gson();
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public<T> void post(String url, String ChannelId, final NetworkCallBack<T> networkCallBack){

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setChannelId(ChannelId);
        messageResponse.setCursor("0");
        final Gson gson = new Gson();
        String s = gson.toJson(messageResponse);
        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.post(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public<T> void post(String url, Map<String,Object> map, final NetworkCallBack<T> networkCallBack){
        apiServer.post(url,map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        Gson gson = new Gson();
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public<T> void postCollection(String url, final NetworkCallBack<T> networkCallBack){
        final Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        map.put("userId","e7d9914be4214263ad8e2a3e88e72263");
        map.put("cursor","0");

        apiServer.post(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public<T> void postUserCollection(String url,String objectId ,String type,final NetworkCallBack<T> networkCallBack){

        UserCollectionResponse userCollectionResponse = new UserCollectionResponse();
        userCollectionResponse.setUserId("e7d9914be4214263ad8e2a3e88e72263");
        userCollectionResponse.setObjectId(objectId);
        userCollectionResponse.setObjectType("0");
        userCollectionResponse.setType(type);
        final Gson gson = new Gson();
        String s = gson.toJson(userCollectionResponse);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.post(url,requestBody).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public<T> void postLike(String url, String objectId, String type, final NetworkCallBack<T> networkCallBack){
        GiveLikeResponse giveLikeResponse = new GiveLikeResponse();
        giveLikeResponse.setObjectType("0");
        giveLikeResponse.setUserId("e7d9914be4214263ad8e2a3e88e72263");
        giveLikeResponse.setType(type);
        giveLikeResponse.setObjectId(objectId);
        final Gson gson = new Gson();
        String s = gson.toJson(giveLikeResponse);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.postLike(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public<T> void postComments(String url, String objectId, String content, final NetworkCallBack<T> networkCallBack){
        Comments comments = new Comments();
        comments.setObjectType("0");
        comments.setUserId("e7d9914be4214263ad8e2a3e88e72263");
        comments.setContent(content);
        comments.setObjectId(objectId);
        final Gson gson = new Gson();
        String s = gson.toJson(comments);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.postComments(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public<T> void postCommentsList(String url, String objectId, final NetworkCallBack<T> networkCallBack){
        CommentsListResponse commentsListResponse = new CommentsListResponse();
        commentsListResponse.setObjectId(objectId);
        commentsListResponse.setObjectType("0");
        commentsListResponse.setCursor(0);
        final Gson gson = new Gson();
        String s = gson.toJson(commentsListResponse);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.postCommentsList(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public<T> void postTheLabel(String url, String keyword, final NetworkCallBack<T> networkCallBack){
        NewssearchResponse newssearchResponse = new NewssearchResponse();
        newssearchResponse.setCursor("0");
        newssearchResponse.setKeyword(keyword);
        final Gson gson = new Gson();
        String s = gson.toJson(newssearchResponse);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.postCommentsList(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public<T> void Post(String url, File file, final NetworkCallBack<T> networkCallBack){
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userId", "e7d9914be4214263ad8e2a3e88e72263")
                .addFormDataPart("headImageFile", file.getName(), RequestBody.create(MediaType.parse("image/*"), file)).build();

        apiServer.Post(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody value) {
                Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                Type actualTypeArgument = actualTypeArguments[0];
                Gson gson = new Gson();
                try {
                    T result = gson.fromJson(value.string(), actualTypeArgument);
                    networkCallBack.getSucces(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public<T> void PostUpdata(String url, String birthday, String nickname, String personalProfile, String professionId, String sex, final NetworkCallBack<T> networkCallBack){
        UpdataResponse updataResponse = new UpdataResponse();
        updataResponse.setUserId("e7d9914be4214263ad8e2a3e88e72263");
        updataResponse.setBirthday(birthday);
        updataResponse.setNickname(nickname);
        updataResponse.setPersonalProfile(personalProfile);
        updataResponse.setProfessionId(professionId);
        updataResponse.setSex(sex);
        final Gson gson = new Gson();
        String s = gson.toJson(updataResponse);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.postCommentsList(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public<T> void Post(String url,String s,final NetworkCallBack<T> networkCallBack){
        final Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), s);
        apiServer.postCommentsList(url,requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Type[] genericInterfaces = networkCallBack.getClass().getGenericInterfaces();
                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                        Type actualTypeArgument = actualTypeArguments[0];
                        try {
                            T result = gson.fromJson(value.string(), actualTypeArgument);
                            networkCallBack.getSucces(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



}
