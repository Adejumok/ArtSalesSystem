package com.africa.artSalesSystem.component.service;

import com.africa.artSalesSystem.component.dto.request.AddArtRequest;
import com.africa.artSalesSystem.component.dto.request.EditArtRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtResponse;
import com.africa.artSalesSystem.component.dto.response.EditArtResponse;
import com.africa.artSalesSystem.component.service.cloud.CloudService;
import com.africa.artSalesSystem.exception.ArtSalesSystemException;
import com.africa.artSalesSystem.component.models.Art;
import com.africa.artSalesSystem.component.repositories.ArtRepository;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
 class ArtServiceImpl implements ArtService{
    private final ArtRepository artRepository;
    private final CloudService cloudService;
    @Override
    public AddArtResponse addArt(AddArtRequest addArtRequest) throws IOException {
        Art foundArt = artRepository.findByArtTitle(addArtRequest.getArtTitle()).orElse(null);
        if(foundArt != null){
            throw new ArtSalesSystemException("Art with title "+addArtRequest.getArtTitle()+" already exist",400);
        }
        Art savedArt = getAddedArt(addArtRequest);
        AddArtResponse addArtResponse = new AddArtResponse();
        BeanUtils.copyProperties(savedArt,addArtResponse);
        return addArtResponse;
    }

    private Art getAddedArt(AddArtRequest addArtRequest) {
        Art art = new Art();
        art.setArtPrice(addArtRequest.getArtPrice());
        art.setArtDescription(addArtRequest.getArtDescription());
        art.setArtType(addArtRequest.getArtType());
        art.setArtTitle(addArtRequest.getArtTitle());
        return artRepository.save(art);
    }

    @Override
    public Art findArtById(Long artId) {
        Optional<Art> foundArt = artRepository.findById(artId);
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

    @Override
    public void saveArt(Art art) {
        artRepository.save(art);
    }

    @Override
    public EditArtResponse editArt(EditArtRequest editArtRequest) {
        Art foundArt = findArtById(editArtRequest.getId());
        if (foundArt != null){
            editArt(editArtRequest, foundArt);
            EditArtResponse editArtResponse = new EditArtResponse();
            BeanUtils.copyProperties(foundArt, editArtResponse);
            editArtResponse.setMessage("Art with id "+editArtRequest.getId()+" successfully updated.");
            return editArtResponse;

        }
        throw new ArtSalesSystemException("Art with id "+editArtRequest.getId()+" not found.", 400);
    }

    private void editArt(EditArtRequest editArtRequest, Art foundArt) {
        foundArt.setArtTitle(editArtRequest.getArtTitle());
        foundArt.setArtType(editArtRequest.getArtType());
        foundArt.setArtPrice(editArtRequest.getArtPrice());
        foundArt.setArtDescription(editArtRequest.getArtDescription());
        artRepository.save(foundArt);
    }
}
