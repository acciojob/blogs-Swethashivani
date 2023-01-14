package com.driver.repositories;

import com.driver.models.Blog;
import com.driver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Modifying
    @Query("update User s set s.userName = :#{#user.userName}, " +
            "s.password = :#{#user.password}, " +
            "s.firstName = :#{#user.firstName} ," +
            "s.lastName = :#{#user.lastName} " +
            "where s.id = :#{#user.id}")
    int updateUserDetails(User user);
    User findByUsername(String userName);


}
