package com.aos.matgar.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

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

}
