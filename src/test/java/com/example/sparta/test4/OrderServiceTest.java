package com.example.sparta.test4;

import com.example.sparta.repository.OrderLineRepository;
import com.example.sparta.repository.OrderRepository;
import com.example.sparta.repository.ProductRepository;
import com.example.sparta.service.OrderService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Mocking 시 컨텍스트 로드를 더 빠르게 하기 위해
public class OrderServiceTest {
    // final은 붙이지 않는 이유?
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private OrderLineRepository orderLineRepository;

    @InjectMocks
    private OrderService orderService;

//    @Test
//    void test() {}
}
