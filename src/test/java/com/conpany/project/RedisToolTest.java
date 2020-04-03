package com.conpany.project;

import com.company.project.core.RedisTool;
import com.company.project.dao.OrderItemMapper;
import com.company.project.model.OrderItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class RedisToolTest extends Tester {
    @Autowired(required = false)
    private RedisTool redis;

    @Autowired(required = false)
    private OrderItemMapper orderItemMapper;

    @Test
    public void setKeyTest() {
        redis.set("key1", "Redis test !");
    }

    @Test
    public void getKeyTest() {
        Object key1 = redis.get("key1");
        System.out.println("----------------" + key1.toString());
    }

    @Test
    public void setHasKeyTest() {
//        OrderItem orderItem = new OrderItem(1, "AA", "A00001", new Date(), "Admin", new Date(), "Admin");
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1);
        OrderItem orderItem1 = orderItemMapper.selectByPrimaryKey(orderItem);
        List<OrderItem> orderItems = orderItemMapper.selectAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("OrderItem", orderItem1);
        redis.lSet("OrderItems", orderItems);
        redis.hashSet("OrderItem", map);
    }

    @Test
    public void deleteTest() {
        redis.del("key1");
        redis.del("OrderItem");
        redis.del("OrderItems");
    }
}
