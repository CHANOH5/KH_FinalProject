package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.OrderPageItemDTO;

public interface OrderService {
	
	public List<OrderPageItemDTO> getProductsInfo(List<OrderPageItemDTO> orders);
	// 주문페이지에서 상품을 조회하려는 인터페이스 
	// OrderPageItemDTO의 정보들을 List형태로 받음
	// 조회된 상품 정보를 OrderPageItemDTO 객체로 매핑하여 리스트 형태로 반환
}