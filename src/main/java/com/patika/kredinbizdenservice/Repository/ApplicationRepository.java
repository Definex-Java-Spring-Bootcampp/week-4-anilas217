package com.patika.kredinbizdenservice.Repository;

import com.patika.kredinbizdenservice.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByUserId(long userId);

    @Query("SELECT a FROM Application a WHERE a.user.id = :userId")
    Application findApplicationByUserId(@Param("userId") long userId);
}
