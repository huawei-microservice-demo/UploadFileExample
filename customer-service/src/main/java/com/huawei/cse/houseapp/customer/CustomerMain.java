package com.huawei.cse.houseapp.customer;


import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;

import com.huawei.cse.houseapp.customer.service.Holder;
import com.huawei.cse.houseapp.customer.service.Person;

/**
 * Created by m00416667 on 2017/11/9.
 */


public class CustomerMain {
    public static void main(String[] args) throws Exception {
        Log4jUtils.init();
        BeanUtils.init();

        Holder h = new Holder();
        Person p = new Person();
        p.setName("xxx");
        h.setData(p);
        System.out.println(((Person)h.getData()).getName());
    }
}
