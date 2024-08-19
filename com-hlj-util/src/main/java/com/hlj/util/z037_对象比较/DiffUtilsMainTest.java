package com.hlj.util.z037_对象比较;

import cn.hutool.json.JSONUtil;
import com.hlj.util.z037_对象比较.bo.BigBeanBO;
import com.hlj.util.z037_对象比较.bo.CenterBeanBO;
import com.hlj.util.z037_对象比较.bo.SmallBeanBO;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * DiffUtils
 *
 * @author zhangyujin
 * @date 2023/12/20
 */
public class DiffUtilsMainTest {

    @Test
    public void test1() {
        BigBeanBO newObj = instanceNew();
        BigBeanBO oldObj = instanceOld();
        DiffNode diffNode = ObjectDifferBuilder.buildDefault().compare(newObj, oldObj);

        if (diffNode.hasChanges()) {
            System.out.println("存在差异");
        }

        List<CompareNode> result = new ArrayList<>();
        diffNode.visit((node, visit) -> {
            // 排除跟节点
            if (node.getPath().toString().equals("/")) {
                return;
            }
            Object newValue = node.canonicalGet(newObj);
            Object oldValue = node.canonicalGet(oldObj);


            Compare compare = node.getFieldAnnotation(Compare.class);
            CompareNode compareNode = new CompareNode();
            compareNode.setChangeFlag(node.hasChanges());
            compareNode.setFieldPath(node.getPath().toString());
            compareNode.setFieldState(node.getState().name());
            compareNode.setOldValue(oldValue);
            compareNode.setNewValue(newValue);
            // 注意这里可能为空哦
            compareNode.setFieldName(compare.value());
            result.add(compareNode);
        });
        System.out.println(JSONUtil.toJsonStr(result));
    }


    public static BigBeanBO instanceOld() {

        SmallBeanBO smallBean = new SmallBeanBO();
        smallBean.setSmallName("oldBig");
        smallBean.setSmallAge(1);

        CenterBeanBO centerBean = new CenterBeanBO();
        // centerBean.setCenterName("oldCenter");
        centerBean.setCenterAge(2);
        centerBean.setSmallBean(smallBean);

        BigBeanBO bigBean = new BigBeanBO();
        bigBean.setBigName("oldBig");
        bigBean.setBigAge(3);
        bigBean.setCenterBean(centerBean);
        return bigBean;
    }

    public static BigBeanBO instanceNew() {

        SmallBeanBO smallBean = new SmallBeanBO();
        // 差异
        smallBean.setSmallName("Big");
        smallBean.setSmallAge(1);

        CenterBeanBO centerBean = new CenterBeanBO();
        centerBean.setCenterName("oldCenter");
        // 差异
        // centerBean.setCenterAge(2);
        centerBean.setSmallBean(smallBean);

        BigBeanBO bigBean = new BigBeanBO();
        bigBean.setBigName("oldBig");
        // 差异
        bigBean.setBigAge(-1);
        bigBean.setCenterBean(centerBean);
        return bigBean;
    }
}
