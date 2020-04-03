package com.company.project.service.impl;

import com.company.project.dao.OrderItemMapper;
import com.company.project.model.OrderItem;
import com.company.project.service.OrderItemService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author: YUEXIN
 * @Date: 2020-03-30 20:03:19
 */
@Service
@Transactional
public class OrderItemServiceImpl extends AbstractService<OrderItem> implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;

}
