package com.zeng.library.web;

import com.zeng.library.pojo.OrderBook;
import com.zeng.library.service.OrderBookService;
import com.zeng.library.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderBookController {
    @Autowired
    OrderBookService orderBookService;
    @GetMapping("/orderbooks/{uid}")
    public Page4Navigator<OrderBook> list(@PathVariable("uid") int cid, @RequestParam(value = "start",defaultValue = "0")int start,
                                          @RequestParam(value = "size",defaultValue = "10")int size){
        start = start<0?0:start;
        Page4Navigator<OrderBook> page = orderBookService.list(cid,start,size,5);
        return page;
    }
    @GetMapping("/orderbooks")
    public Page4Navigator<OrderBook> listAll(@RequestParam(value = "start",defaultValue = "0")int start,
                                          @RequestParam(value = "size",defaultValue = "10")int size){
        start = start<0?0:start;
        Page4Navigator<OrderBook> page = orderBookService.listAll(start,size,5);
        return page;
    }
    @DeleteMapping("/orderbooks")
    public String delete(int id){
        orderBookService.delete(id);
        return null;
    }
    @PostMapping("/orderbooks")
    public Object add(@RequestBody OrderBook bean){
        orderBookService.add(bean);
        return bean;
    }
}
