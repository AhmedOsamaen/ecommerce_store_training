package com.aos.matgar.Order;

import com.aos.matgar.Address.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(long orderId){
        return orderRepository.findFirstById(orderId);
    }

    public ResponseEntity saveOrder(Order order){
        try {
            orderRepository.save(order);
            return new ResponseEntity("Saved Successfully", HttpStatus.OK);
        }catch (Exception e){
            logger.error("Failure in Order Save",e);
            return new ResponseEntity("Failure in Order Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity saveAllOrders(List<Order> orders){
        try {
            orderRepository.saveAll(orders);
            return new ResponseEntity("Saved Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Order Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity deleteOrderById(long orderId){
        try {
            orderRepository.deleteById(orderId);
            return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Order Delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
