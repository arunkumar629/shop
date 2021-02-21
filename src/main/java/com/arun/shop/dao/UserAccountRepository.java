package com.arun.shop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arun.shop.entity.UserAccount;

@Repository
public interface UserAccountRepository  extends CrudRepository<UserAccount,Long>{

}
