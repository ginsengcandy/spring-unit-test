package com.example.sparta.repository;

import com.example.sparta.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 입력받은 시간 이후 데이터를 가져옴
    List<Order> findByCreatedAtIsAfter(LocalDateTime from);
}