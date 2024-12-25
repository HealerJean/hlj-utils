package com.hlj.util.z038_tree工具;

import cn.hutool.json.JSONUtil;
import com.hlj.util.z038_tree工具.domain.MenuVo;
import com.hlj.util.z038_tree工具.utils.TreeUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TestMain
 *
 * @author zhangyujin
 * @date 2024/8/2
 */
public class TestMain {


    /**
     * 构建一棵树
     */
    @Test
    public void makeTree() {
        MenuVo menu0 = new MenuVo(0L, -1L);
        MenuVo menu1 = new MenuVo(1L, 0L);
        MenuVo menu2 = new MenuVo(2L, 0L);
        MenuVo menu3 = new MenuVo(3L, 1L);
        MenuVo menu4 = new MenuVo(4L, 1L);
        MenuVo menu5 = new MenuVo(5L, 2L);
        MenuVo menu6 = new MenuVo(6L, 2L);
        MenuVo menu7 = new MenuVo(7L, 3L);
        MenuVo menu8 = new MenuVo(8L, 3L);
        MenuVo menu9 = new MenuVo(9L, 4L);
        //基本数据
        List<MenuVo> menuList = Arrays.asList(menu0, menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9);
        //合成树
        List<MenuVo> tree = TreeUtil.makeTree(menuList, x -> x.getPId() == -1L, (x, y) -> x.getId().equals(y.getPId()), MenuVo::setSubMenus);
        System.out.println(JSONUtil.toJsonStr(tree));
        //  [{"id":0,"pId":-1,"rank":0,"subMenus":[{"id":1,"pId":0,"rank":0,"subMenus":[{"id":3,"pId":1,"rank":0,"subMenus":[{"id":7,"pId":3,"rank":0,"subMenus":[]},{"id":8,"pId":3,"rank":0,"subMenus":[]}]},{"id":4,"pId":1,"rank":0,"subMenus":[{"id":9,"pId":4,"rank":0,"subMenus":[]}]}]},{"id":2,"pId":0,"rank":0,"subMenus":[{"id":5,"pId":2,"rank":0,"subMenus":[]},{"id":6,"pId":2,"rank":0,"subMenus":[]}]}]}]
    }






}
