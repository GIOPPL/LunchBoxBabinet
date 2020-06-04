package com.gioppl.lunchboxcabinet.trsform;

import android.content.Context;

import com.gioppl.lunchboxcabinet.bean.BoxBean;
import com.gioppl.lunchboxcabinet.bean.DistributionBoxBean;
import com.gioppl.lunchboxcabinet.okgo.JsonCallback;
import com.gioppl.lunchboxcabinet.okgo.MyResponse;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;


public class CabinetToolsHttp {
    //为用户分配餐盒
    public static String DISTRIBUTE_BOX="https://data.wadd.vip/api/v3.mealinterface/distribution_grid";
    //取走餐盒
    public static String USER_BORROW_BOX="https://data.wadd.vip/api/v3.mealinterface/user_borrow_box";
    //管理员取走餐盒
    public static String ADMIN_BORROW_BOX="https://data.wadd.vip/api/v3.mealinterface/user_borrow_box";
    //格口置空
    public static String LET_CABINET_EMPTY="https://data.wadd.vip/api/v3.mealinterface/edit_grid";
    //获取餐盒列表
    public static String BOX_LIST="https://data.wadd.vip/api/v3.mealinterface/box_list";
    //用户归还餐盘
    public static String USER_RETURN_BOX="https://data.wadd.vip/api/v3.mealinterface/admin_return_box";
    //管理员归还餐盘
    public static String ADMIN_RETURN_BOX="https://data.wadd.vip/api/v3.mealinterface/user_return_box";

    /**
     * 获取分配餐盒标志
     * 返回设备编号
     */
    public static void getDistributeBox(Context context, String deviceId, String uid,String code,final DistributionBoxCallBack callBack){
        OkGo.<MyResponse<DistributionBoxBean>>post(DISTRIBUTE_BOX)
                .tag(context)
                .params("device_id", deviceId)
                .params("uid", uid)
                .params("code", code)
                .execute(new JsonCallback<MyResponse<DistributionBoxBean>>() {
                    @Override
                    public void onSuccess(Response<MyResponse<DistributionBoxBean>> response) {
                        if (response.body().getCode() == 200) {
                            callBack.result(response.body().getData());
                        }else {
                            callBack.result(response.body().getData());
                        }
                    }

                });

    }
    /**
     * 格口置空
     * 返回是否成功
     */
    public static void letCabinetEmpty(Context context, String device_id,String name_line, final LetCabinetEmptyCallBack callBack){

        OkGo.<MyResponse<String>>post(LET_CABINET_EMPTY)
                .tag(context)
                .params("device_id", device_id)
                .params("name_line", name_line)
                .execute(new JsonCallback<MyResponse<String>>() {
                    @Override
                    public void onSuccess(Response<MyResponse<String>> response) {
                        if (response.body().getCode() == 200) {
                            callBack.result(true);
                        }else {
                            callBack.result(false);
                        }
                    }
                });

    }
    /**
     * 获取餐盒列表
     * 返回餐盒列表
     */
    public static void getBoxList(Context context, String device_id, final BoxListCallBack callBack){

        OkGo.<MyResponse<BoxBean>>post(BOX_LIST)
                .tag(context)
                .params("device_id", device_id)
                .execute(new JsonCallback<MyResponse<BoxBean>>() {
                    @Override
                    public void onSuccess(Response<MyResponse<BoxBean>> response) {
                        if (response.body().getCode() == 200) {
                            callBack.result(response.body().getData());
                        }else {
                            callBack.result(null);
                        }
                    }
                });
    }
    /**
     * 获取餐盒列表
     * 返回是否成功
     */
    public static void borrowBox(Context context, String device_id, String grid_id , String box_sn , String order_id  , final BorrowBox callBack){

        OkGo.<MyResponse<String>>post(USER_BORROW_BOX)
                .tag(context)
                .params("device_id", device_id)
                .params("grid_id", grid_id)
                .params("box_sn", box_sn)
                .params("order_id", order_id)
                .execute(new JsonCallback<MyResponse<String>>() {
                    @Override
                    public void onSuccess(Response<MyResponse<String>> response) {
                        if (response.body().getCode() == 200) {
                            callBack.result(true);
                        }else {
                            callBack.result(false);
                        }
                    }
                });
    }
    /**
     * 管理员取走餐盘
     * 返回是否成功
     */
    public static void borrowBoxAdmin(Context context, String device_id, String name_line  , final BorrowBox callBack){

        OkGo.<MyResponse<String>>post(ADMIN_BORROW_BOX)
                .tag(context)
                .params("device_id", device_id)
                .params("name_line", name_line)
                .execute(new JsonCallback<MyResponse<String>>() {
                    @Override
                    public void onSuccess(Response<MyResponse<String>> response) {
                        if (response.body().getCode() == 200) {
                            callBack.result(true);
                        }else {
                            callBack.result(false);
                        }
                    }
                });
    }
    /**
     * 管理员归还餐盘
     * 返回是否成功
     */
    public static void returnBoxAdmin(Context context, String device_id, String box_id , String grid_id , final ReturnBox callBack){

        OkGo.<MyResponse<String>>post(ADMIN_RETURN_BOX)
                .tag(context)
                .params("device_id", device_id)
                .params("box_id", box_id)
                .params("grid_id", grid_id)
                .execute(new JsonCallback<MyResponse<String>>() {
                    @Override
                    public void onSuccess(Response<MyResponse<String>> response) {
                        if (response.body().getCode() == 200) {
                            callBack.result(true);
                        }else {
                            callBack.result(false);
                        }
                    }
                });
    }
    /**
     * 用户归还餐盘
     * 返回是否成功
     */
    public static void returnBoxUser(Context context, String device_id, String box_id , String grid_id , final ReturnBox callBack){

        OkGo.<MyResponse<String>>post(USER_RETURN_BOX)
                .tag(context)
                .params("device_id", device_id)
                .params("box_id", box_id)
                .params("grid_id", grid_id)
                .execute(new JsonCallback<MyResponse<String>>() {
                    @Override
                    public void onSuccess(Response<MyResponse<String>> response) {
                        if (response.body().getCode() == 200) {
                            callBack.result(true);
                        }else {
                            callBack.result(false);
                        }
                    }
                });
    }

    public interface DistributionBoxCallBack{
        void result(DistributionBoxBean bean);
    }
    public interface LetCabinetEmptyCallBack{
        void result(boolean isSuccess);
    }
    public interface BoxListCallBack{
        void result(BoxBean boxBean);
    }
    public interface BorrowBox{
        void result(boolean isSuccess);
    }
    public interface ReturnBox{
        void result(boolean isSuccess);
    }

}
