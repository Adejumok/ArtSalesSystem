package com.africa.artSalesSystem.component.service;

import com.africa.artSalesSystem.component.dto.request.AddArtRequest;
import com.africa.artSalesSystem.component.dto.request.EditArtRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtResponse;
import com.africa.artSalesSystem.component.dto.response.EditArtResponse;
import com.africa.artSalesSystem.component.models.Art;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface ArtService {
    AddArtResponse addArt(AddArtRequest addArtRequest) throws IOException;

    Art findArtById(Long artId);
    Art findArtByArtTitle(String artTitle);
    List<Art> getAllArts();
    void deleteArt(String artId);
    void saveArt(Art art);

    EditArtResponse editArt(EditArtRequest editArtRequest);
}
