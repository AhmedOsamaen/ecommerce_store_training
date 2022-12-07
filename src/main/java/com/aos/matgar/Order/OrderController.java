package com.aos.matgar.Order;

import com.aos.matgar.order_product.order_product;
import com.aos.matgar.order_product.order_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private order_productService order_productService;

    @GetMapping("getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("getOrderById/{orderId}")
    public Order getOrderById(@PathVariable("orderId")String orderId){
        return orderService.getOrderById(Long.valueOf(orderId));
    }

    @PostMapping("saveOrder")
    public ResponseEntity saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PostMapping("deleteOrder")
    public ResponseEntity deleteOrder(@RequestBody Map order){
        return orderService.deleteOrderById(Long.valueOf(order.get("orderId").toString()) );
    }

    @PostMapping("getProductsByOrderId")
    public List<order_product> getProductsByOrderId(@RequestBody Order order){
        System.out.println("getProductsByOrderId:- " + orderService.getOrderById(Long.valueOf(order.getId())).getOrder_products());
        List<order_product> orders = orderService.getOrderById(Long.valueOf(order.getId())).getOrder_products()
                .stream()
                .filter(orderProduct -> orderProduct.getOrder().getId() == order.getId() )
                .collect(Collectors.toList());

        return orders;
    }

}
