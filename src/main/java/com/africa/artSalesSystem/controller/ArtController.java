package com.africa.artSalesSystem.controller;

import com.africa.artSalesSystem.component.dto.request.AddArtRequest;
import com.africa.artSalesSystem.component.dto.request.EditArtRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtResponse;
import com.africa.artSalesSystem.component.dto.response.EditArtResponse;
import com.africa.artSalesSystem.component.models.Art;
import com.africa.artSalesSystem.component.service.ArtService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/art")
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
public class ArtController {

    private final ArtService artService;

    @PostMapping("/addArt")
    public ResponseEntity<?> addArt(@NonNull @RequestBody AddArtRequest addArtRequest) throws IOException {
      AddArtResponse addArtResponse = artService.addArt(addArtRequest);
        return new ResponseEntity<>(addArtResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getArt/{artId}")
    public ResponseEntity<?> getArt(@PathVariable Long artId){
        Art art = artService.findArtById(artId);
        return new ResponseEntity<>(art, HttpStatus.OK);
    }

    @GetMapping("/getAllArts")
    public ResponseEntity<?> getAllArts(){
        List<Art> arts = artService.getAllArts();
        return new ResponseEntity<>(arts, HttpStatus.OK);
    }

    @PatchMapping("/editArt/{artId}")
    public ResponseEntity<?> editArt(@RequestBody EditArtRequest request, @PathVariable String artId){
        EditArtResponse response = artService.editArt(artId,request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{artId}")
    public ResponseEntity<?> deleteArt(@PathVariable String artId){
        artService.deleteArt(Long.valueOf(artId));
        return new ResponseEntity<>("Art successfully deleted", HttpStatus.OK);
    }



}
