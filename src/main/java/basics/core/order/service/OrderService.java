package basics.core.order.service;

import basics.core.order.Order;

public interface OrderService {
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
