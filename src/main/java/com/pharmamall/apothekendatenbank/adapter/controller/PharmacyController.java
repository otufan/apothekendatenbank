package com.pharmamall.apothekendatenbank.adapter.controller;

import com.pharmamall.apothekendatenbank.application.dto.ApothekeDTO;
import com.pharmamall.apothekendatenbank.application.port.in.ApothekeUseCase;
import com.pharmamall.apothekendatenbank.domain.Apotheke;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@RequestMapping()
public class ApothekeController {

    public ApothekeUseCase apothekeUseCase;

    //TODO findbyid ile kullanici herhangi birisi bütün bilgilere ulasabilir
    // o yüzden normal kullanici icin bir findmethod yazalim--- burada linke mesela admin vs yazilabilir
    @GetMapping("/apotheke/{id}")
    public ResponseEntity<ApothekeDTO> getApothekeById(@PathVariable Long id) {

        ApothekeDTO apothekeDTO = apothekeUseCase.findById(id);
        return new ResponseEntity<>(apothekeDTO, HttpStatus.OK);
    }

    @GetMapping("/apotheke/all")
    public ResponseEntity<List<ApothekeDTO>> getAllApotheken(){
        List<ApothekeDTO> apotheken = apothekeUseCase.fetchAllApotheke();
        return new ResponseEntity<>(apotheken, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, Boolean>> registerApotheke(@Valid @RequestBody Apotheke apotheke) {

        apothekeUseCase.createApotheke(apotheke);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Apotheke ist erfolgreich erstellt!", true);
        return new ResponseEntity<>(map, HttpStatus.CREATED); //Response 201
    }

    @PutMapping("/apotheke/{id}/update")
    public ResponseEntity<Map<String, Boolean>> updateApotheke(@PathVariable Long id,
            @Valid @RequestBody ApothekeDTO apothekeDTO) {

        apothekeUseCase.updateApotheke(id, apothekeDTO);
        Map<String, Boolean> map = new HashMap<>();
        map.put("erfolgreich", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/apotheke/{id}/delete")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {

        apothekeUseCase.removeById(id);

        Map<String, Boolean> map = new HashMap<>();
        map.put("erfolgreich", true);

        return new ResponseEntity<>(map, HttpStatus.OK);


    }

}
