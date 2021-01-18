package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.Orders;
import com.example.demo.onlineshop.products.ProductRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CheckOutMapper {


    @Insert("insert into customers (name, surname, e_mail, address, phone) values (#{name}, #{surname}, " +
            "#{e_mail}, #{address}, #{phone})")
    void createCustomer(CheckOutForm form);

    @Select("select id, name, surname, e_mail, address, phone from customers where id = #{id}")
    Customer findOne(Long id);

    @Insert("insert into orders (customer_id) values (#{customerId}")
    void createOrder (Long customerId, Orders order);

}
