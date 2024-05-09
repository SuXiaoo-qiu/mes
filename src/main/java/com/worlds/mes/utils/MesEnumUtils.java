package com.worlds.mes.utils;

public class MesEnumUtils {
    //状态码 200:OK 400:错误的请求 401:未经授权 403:被禁止的 404:未找到 500:内部服务器错误
    public static final Integer CODE_200 = 200;
    public static final Integer CODE_400 = 400;
    public static final Integer CODE_401 = 401;
    public static final Integer CODE_403 = 403;
    public static final Integer CODE_404 = 404;
    public static final Integer CODE_500 = 500;
    public static final Integer CODE_5000 = 5000;//5000:没查询到数据
    public static final Integer CODE_5001 = 5001;// 5001:数据不允许为空
    public static final Integer CODE_5002 = 5002;// 注册失败
    public static final Integer CODE_5003 = 5003;// 数据新增失败


    //redis 过期时间 有效期30分钟 1800秒
    public static final Integer RedisTimeout = 86400; //24小时
    //1800000;  有效期30分钟 1800000毫秒
    public static final Integer TokenTimeout = 86400000 ;//24小时
    //60;  有效期1分钟
    public static final Integer CodeTimeOut = 60 ;//一分钟

    /**
     * 订单的状态，1已创建、2已审核、3已排产、4已生产、5已完成
     */
    public static final Integer OODER_CODE_1 = 1;// 已创建
    public static final Integer OODER_CODE_2 = 2;// 已审核
    public static final Integer OODER_CODE_3 = 3;// 已排产
    public static final Integer OODER_CODE_4 = 4;// 已生产
    public static final Integer OODER_CODE_5 = 5;// 已完成
}
