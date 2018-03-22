package com.example.auction.application.repository;

import com.example.auction.application.module.Breach;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BreachRepository extends CrudRepository<Breach, Long>{
    List<Breach> findAll(Pageable pageable);

    @Query(value = "select b.breach_id as breach_id,b.time, b.is_delete as is_delete, b.user_id as user_id,u.nick_name as nick_name,b.product_id,b.num as num,u.tel_number as tel_number from user u right join(select r.time ,r.is_delete, r.breach_id,r.product_id,r.user_id ,COUNT(r.user_id) as num from breach_table r group by r.user_id) b on u.user_id = B.user_id limit ?1,?2", nativeQuery = true)
    List<Breach> findAllByUserId(int limit1, int limit2);
}
