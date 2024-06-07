package com.test.uolhostt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.uolhostt.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Long>  {
    
    @Query(value = "Select * from db_player where email=:email",nativeQuery = true)
    Player findByEmail(String email);
    
    @Query(value = "Select * from db_player",nativeQuery = true)
    Player findPlayerAll();
}
