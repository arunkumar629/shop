package com.arun.shop.dao;
import com.arun.shop.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository    extends CrudRepository<Product,Long>{

}
