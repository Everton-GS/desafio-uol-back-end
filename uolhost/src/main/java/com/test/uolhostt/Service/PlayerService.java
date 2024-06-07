package com.test.uolhostt.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.uolhostt.Entity.Player;
import com.test.uolhostt.Enum.TipoEnum;
import com.test.uolhostt.Record.PlayerRecord;
import com.test.uolhostt.Repository.PlayerRepository;
import com.test.uolhostt.infra.ListaCodnome;

@Service
public class PlayerService {
    
    @Autowired      
    PlayerRepository playerRepository;

    @Autowired
    ListaCodnome listaCodnome;

    public Player cadastroPlayerMarvel(PlayerRecord playerRecord){
        if(playerRecord.tipoEnum().equals(TipoEnum.Avengers)){
            
            Player player = new Player(
                                        playerRecord.nome(), 
                                        playerRecord.email(), 
                                        playerRecord.telefone(), 
                                        listaCodnome.listaMarvel.getFirst(), 
                                        playerRecord.tipoEnum());
                                        
            playerRepository.save(player);
            listaCodnome.listaMarvel.removeFirst();
            return player;
           }
            return null;
        }

        public  Player cadastroPlayerDC(PlayerRecord playerRecord){

            if(playerRecord.tipoEnum().equals(TipoEnum.LigaDaJustica)){
                Player playerDC = new Player(
                                            playerRecord.nome(), 
                                            playerRecord.email(), 
                                            playerRecord.telefone(), 
                                            listaCodnome.listaDC.getFirst(), 
                                            playerRecord.tipoEnum());
                playerRepository.save(playerDC);
    
                listaCodnome.listaDC.removeFirst();
                return playerDC;
            }
            return null;
        }

        public List<Player> listPlayer() {
               List<Player> players = playerRepository.findAll();
            return players;
        }
    }

