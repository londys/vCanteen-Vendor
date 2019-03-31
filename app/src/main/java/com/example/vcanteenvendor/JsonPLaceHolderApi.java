package com.example.vcanteenvendor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface JsonPlaceHolderApi {

    @GET("b/5c9c37331c56bb1ec38f9c67/2")
    Call<Vendor> getVendor(@Query("vendorID") int vendorId);

    @GET("v1/vendor-main/{vendorId}/orders")
    Call<OrderList> getOrder(@Path("vendorId") int vendorId);

    /*@FormUrlEncoded
    @POST("b/5c9c37331c56bb1ec38f9c67/2")
    Call<Vendor> getVendor(
            @Field("vendorID") int vendorId
    );*/

    @POST("orders")
    Call<List<Order>> getOrders(@Query("vendorId") Integer vendorId, @Query("orderStutus") String orderStatus);

    @PUT("b/5c9c37331c56bb1ec38f9c67/2")
    Call<Vendor> getVendor2(@Query("vendorID") int vendorId, @Body Vendor vendor);

}
