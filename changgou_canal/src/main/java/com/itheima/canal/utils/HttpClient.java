//package com.itheima.canal.utils;
//
//import okhttp3.*;
//
//import java.io.IOException;
//
///**
// * @author zzh
// * @description: TODO
// * @date 2023年07月12日 10:47
// */
//public class HttpClient {
//    public static void doGet(String url) {
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                System.out.println("调用成功"+response.message());
//            }
//        });
//    }
//}
