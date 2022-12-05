package com.africa.artSalesSystem.controller;

import com.africa.artSalesSystem.dto.request.AddArtRequest;
import com.africa.artSalesSystem.dto.response.AddArtResponse;
import com.africa.artSalesSystem.models.Art;
import com.africa.artSalesSystem.service.ArtService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/art")
@AllArgsConstructor
public class ArtController {

    private final ArtService artService;


    @PostMapping("/addArt")
    public ResponseEntity<?> addArt(@NonNull @RequestBody AddArtRequest addArtRequest){
      AddArtResponse addArtResponse = artService.addArt(addArtRequest);
        return new ResponseEntity<>(addArtResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{artId}")
    public ResponseEntity<?> getArt(@PathVariable String artId){
        Art art = artService.findArtById(artId);
        return new ResponseEntity<>(art, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllArts(){
        List<Art> arts = artService.getAllArts();
        return new ResponseEntity<>(arts, HttpStatus.OK);
    }

    @DeleteMapping("/{artId}")
    public ResponseEntity<?> deleteArt(@PathVariable String artId){
        artService.deleteArt(artId);
        return new ResponseEntity<>("Art successfully deleted", HttpStatus.OK);
    }


}
