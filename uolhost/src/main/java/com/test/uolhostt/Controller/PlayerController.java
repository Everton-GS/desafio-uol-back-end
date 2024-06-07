package com.test.uolhostt.Controlle;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.uolhostt.Entity.Player;
import com.test.uolhostt.Enum.TipoEnum;
import com.test.uolhostt.Record.PlayerRecord;
import com.test.uolhostt.Repository.PlayerRepository;
import com.test.uolhostt.Service.PlayerService;
import com.test.uolhostt.infra.ListaCodnome;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ListaCodnome listaCodnome;

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @PostMapping(value = "/registrar")
    public ResponseEntity<?> cadastrarPlayer(@RequestBody @Valid PlayerRecord playerRecord) throws SQLException {
        try {

            Player player = playerRepository.findByEmail(playerRecord.email());

            if (player ==null && playerRecord.tipoEnum()==TipoEnum.Avengers && listaCodnome.listaMarvel.size()>0) {
                playerService.cadastroPlayerMarvel(playerRecord);
                return ResponseEntity.ok().build();
            }
             else if (player==null && playerRecord.tipoEnum()==TipoEnum.LigaDaJustica && listaCodnome.listaDC.size()>0) {
                playerService.cadastroPlayerDC(playerRecord);
                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.badRequest().body("Lista sem opção, pois número total de codnome foi atingido");
            }
        } catch (Exception e) {
            logger.error("Erro ao cadastrar player", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<?> listarPlayer() {
        try {
            List<Player> player = playerService.listPlayer();
            return ResponseEntity.ok(player);
        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }
    }

}
