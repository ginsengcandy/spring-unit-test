package com.example.sparta.service.pojo;

import com.example.sparta.dto.OrderLineRequest;
import com.example.sparta.entity.Order;
import com.example.sparta.entity.OrderLine;
import com.example.sparta.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderServiceSupport {
    public static List<OrderLine> buildOrderLines(Order order, List<Product> products, List<OrderLineRequest> requests){
        // DB에 존재하지 않는 상품 ID 가 있을 경우
        if (products.size() != requests.size()) {
            throw new RuntimeException("존재하지 않는 상품은 주문할 수 없습니다 !");
        }
        List<OrderLine> orderLineList = new ArrayList<>();
        for (Product product : products) {
            for (OrderLineRequest olr : requests) {
                if (Objects.equals(product.getId(), olr.getProductId())) {
                    // 상품 구매 처리 (판매 수 up, 재고 down)
                    product.purchased(olr.getAmount());
                    // 주문 상세 내역 생성
                    orderLineList.add(new OrderLine(order, product, olr.getAmount()));
                }
            }
        }
        return orderLineList;
    }
}
