package com.example.auction.application.repository;

import com.example.auction.application.config.CustomRepository;
import com.example.auction.application.module.Recharge;
import com.example.auction.application.module.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface RechargeRepository extends CustomRepository<Recharge, Long> {

    @Query(value = "select b.recharge_id as recharge_id,b.time, b.is_delete as is_delete, b.user_id as user_id,u.nick_name as nick_name,b.money as money,b.num as num,u.tel_number as tel_number from user u right join(select r.time ,r.is_delete, r.recharge_id,r.user_id ,sum(r.money) as money,COUNT(r.user_id) as num from member_recharge r group by r.user_id) b on u.user_id = B.user_id limit ?1,?2", nativeQuery = true)
    List<Recharge> findAllByUserId(int limit1, int limit2);
}
