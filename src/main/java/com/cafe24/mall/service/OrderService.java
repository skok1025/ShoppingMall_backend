package com.cafe24.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mall.repository.OrderDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
}
