package com.xunqi.gulimall.seckill.controller;

import com.xunqi.common.utils.R;
import com.xunqi.gulimall.seckill.service.SeckillService;
import com.xunqi.gulimall.seckill.to.SeckillSkuRedisTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-07-10 11:01
 **/

@RestController
public class SeckillController {


    @Autowired
    private SeckillService seckillService;

    /**
     * 当前时间可以参与秒杀的商品信息
     * @return
     */
    @GetMapping(value = "/getCurrentSeckillSkus")
    public R getCurrentSeckillSkus() {

        //获取到当前可以参加秒杀商品的信息
        List<SeckillSkuRedisTo> vos = seckillService.getCurrentSeckillSkus();

        return R.ok().setData(vos);
    }


    /**
     * 根据skuId查询商品是否参加秒杀活动
     * @param skuId
     * @return
     */
    @GetMapping(value = "/sku/seckill/{skuId}")
    public R getSkuSeckilInfo(@PathVariable("skuId") Long skuId) {

        SeckillSkuRedisTo to = seckillService.getSkuSeckilInfo(skuId);

        return R.ok().setData(to);
    }


    @GetMapping(value = "/kill")
    public R seckill(@RequestParam("killId") String killId,
                     @RequestParam("key") String key,
                     @RequestParam("num") Integer num) {

        //1、判断是否登录

        return R.ok();
    }

}
