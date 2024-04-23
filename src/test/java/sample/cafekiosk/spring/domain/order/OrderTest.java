package sample.cafekiosk.spring.domain.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductType;

@ActiveProfiles("test")
class OrderTest {

    @DisplayName("주문 생성 시 상품 리스트에서 주문의 총 금액을 계산한다")
    @Test
    void calculateTotalPrice() {
        //given
        List<Product> products = List.of(createProduct("001", 1000),
                createProduct("002", 2000));
        LocalDateTime registeredDateTime = LocalDateTime.now();
        //when
        Order order = Order.create(products, registeredDateTime);

        //then
        assertThat(order.getTotalPrice()).isEqualTo(order.getTotalPrice());

      }

    @DisplayName("주문 생성 시 주문 상태는 INIT이다.")
    @Test
    void init() {
        //given
        List<Product> products = List.of(createProduct("001", 1000),
                createProduct("002", 2000));
        LocalDateTime registeredDateTime = LocalDateTime.now();
        //when
        Order order = Order.create(products, registeredDateTime);

        //then
        assertThat(order.getOrderStatus()).isEqualByComparingTo(OrderStatus.INIT); //todo - enum값은 그 자체로

    }


    @DisplayName("주문 생성 시 주문 등록 시간을 기록 한다.")
    @Test
    void registeredDateTime() {
        //given
        LocalDateTime registeredDateTime = LocalDateTime.now();
        List<Product> products = List.of(createProduct("001", 1000),
                createProduct("002", 2000));

        //when
        Order order = Order.create(products, registeredDateTime);

        //then
        assertThat(order.getRegisteredDateTime()).isEqualTo(registeredDateTime); //todo - enum값은 그 자체로

    }




    private Product createProduct(String productNumber, int price) {
        return Product.builder()
                .type(ProductType.HANDMADE)
                .productNumber(productNumber)
                .sellingStatus(SELLING)
                .price(price)
                .name("메뉴 이름")
                .build();
    }


}