package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.dto.request.AddArtRequest;
import com.africa.artSalesSystem.dto.response.AddArtResponse;
import com.africa.artSalesSystem.exception.ArtSalesSystemException;
import com.africa.artSalesSystem.models.Art;
import com.africa.artSalesSystem.models.enums.ArtType;
import com.africa.artSalesSystem.repositories.ArtRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ArtServiceImpl implements ArtService{
    private final ArtRepository artRepository;
    @Override
    public AddArtResponse addArt(AddArtRequest addArtRequest) {
        Art foundArt = artRepository.findByArtTitle(addArtRequest.getArtTitle()).orElse(null);
        if(foundArt != null){
            throw new ArtSalesSystemException("Art with title "+addArtRequest.getArtTitle()+" already exist",400);
        }
        foundArt = Art.builder()
                .artDescription(addArtRequest.getArtDescription())
                .artPrice(addArtRequest.getArtPrice())
                .artType(addArtRequest.getArtType())
                .artTitle(addArtRequest.getArtTitle())
                .build();
        Art savedArt = artRepository.save(foundArt);
        AddArtResponse addArtResponse = new AddArtResponse();
        BeanUtils.copyProperties(savedArt,addArtResponse);
        return addArtResponse;
    }

    @Override
    public Art findArtById(String artId) {
        Optional<Art> foundArt = artRepository.findById(Long.valueOf(artId));
        if(foundArt.isEmpty()){
            throw new ArtSalesSystemException("Art with Id "+artId+" not found", 404);
        }
        return foundArt.get();
    }

    @Override
    public Art findArtByArtTitle(String artTitle) {
        Optional<Art> foundArt = artRepository.findByArtTitle(artTitle);
        if(foundArt.isEmpty()){
            throw new ArtSalesSystemException("Art with title "+artTitle+" not found", 404);
        }
        return foundArt.get();
    }

    @Override
    public List<Art> getAllArts() {
        return artRepository.findAll();
    }

    @Override
    public void deleteArt(String artId) {
        Optional<Art> foundArt = artRepository.findById(Long.valueOf(artId));
        if(foundArt.isEmpty()){
            throw new ArtSalesSystemException("Art with id "+artId+" not found", 404);
        }
        artRepository.delete(foundArt.get());
    }
}
