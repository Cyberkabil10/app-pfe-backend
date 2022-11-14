package com.Med.authentication.teleConsult.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Med.authentication.teleConsult.model.User;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
    public User findByEmail(String email);
    public User save(User user);

    //public void persist(User user);
    //public User saveOrUpdate(User user);


}


