package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonpHttpMessageConverter4;
import entity.R;
import util.OkHttpUtil;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class RequestSender {

    public static R get(String url,Map<String,String> header, Map<String,String> param){
        OkHttpUtil okHttpUtil = OkHttpUtil.builder().url(url);
        //添加表头
        header.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                okHttpUtil.addHeader(s,s2);
            }
        });
        //添加请求参数
        param.forEach((key,value)->{
            okHttpUtil.addParam(key,value);
        });
        String res = okHttpUtil.get().sync();
        R r = JSON.parseObject(res, R.class);
        return r;
    }

    public static R post(String url,Map<String,String> header, Map<String,String> param){
        OkHttpUtil okHttpUtil = OkHttpUtil.builder().url(url);
        //添加表头
        header.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                okHttpUtil.addHeader(s,s2);
            }
        });
        //添加请求参数
        param.forEach((key,value)->{
            okHttpUtil.addParam(key,value);
        });
        String res = okHttpUtil.post(true).sync();
        R r = JSON.parseObject(res, R.class);
        return r;
    }
}
