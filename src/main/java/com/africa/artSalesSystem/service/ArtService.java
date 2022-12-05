package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.dto.request.AddArtRequest;
import com.africa.artSalesSystem.dto.response.AddArtResponse;
import com.africa.artSalesSystem.models.Art;

import java.util.List;

public interface ArtService {
    AddArtResponse addArt(AddArtRequest addArtRequest);
    Art findArtById(String artId);
    Art findArtByArtTitle(String artTitle);
    List<Art> getAllArts();
    void deleteArt(String artId);
}
