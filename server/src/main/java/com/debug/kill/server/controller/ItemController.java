package com.debug.kill.server.controller;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.server.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author WYF
 * @since 2020-04-28
 */
@Controller
public class ItemController {
    private static Logger logger = LoggerFactory.getLogger(ItemController.class);

    private static final String prefix = "item";

    @Autowired
    private IItemService itemService;
    /**
     * @Description: 获取秒杀商品
     * @Param: []
     * @Return: java.lang.String
     * @Author: WYF
     * @Date: 2020/4/28 13:33
     */
    @GetMapping(value = {"/", "/index", prefix + "/list", prefix + "/index.html"})
    public String list(ModelMap modelMap) {
        try {
            //获取
            List<ItemKill> list = itemService.getKillItem();
            modelMap.put("list", list);
            logger.info("获取商品：{}",list);
        } catch (Exception e) {
            logger.error("获取待秒杀商品的异常:", e.fillInStackTrace());
            return "redirect:/base/error";
        }
        return "list";
    }

    /**
     * @Description: 获取某个秒杀商品的详情
     * @Param: []
     * @Return: java.lang.String
     * @Author: WYF
     * @Date: 2020/4/28 13:33
     */
    @GetMapping(prefix+"/detail/{id}")
    public String getDetail(@PathVariable("id")Integer id,ModelMap modelMap) {
        if (id <=0 || id==null ) {
            logger.error("获取某个秒杀商品的详情失败，请输入有效id");
            return "redirect:/base/error";
        }
        try {
            //获取
            ItemKill list = itemService.getKillItemDetail(id);
            modelMap.put("detail", list);
            logger.info("获取商品详情 {}",list);
        } catch (Exception e) {
            logger.error("获取待秒杀商品的异常:", e.fillInStackTrace());
            return "redirect:/base/error";
        }
        return "info";
    }

}

