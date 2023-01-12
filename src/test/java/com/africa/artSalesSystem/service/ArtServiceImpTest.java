package com.africa.artSalesSystem.service;

import com.africa.artSalesSystem.component.service.ArtService;
import com.africa.artSalesSystem.component.dto.request.AddArtRequest;
import com.africa.artSalesSystem.component.dto.request.EditArtRequest;
import com.africa.artSalesSystem.component.dto.response.AddArtResponse;
import com.africa.artSalesSystem.component.dto.response.EditArtResponse;
import com.africa.artSalesSystem.exception.ArtSalesSystemException;
import com.africa.artSalesSystem.component.models.enums.ArtType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Slf4j
public class ArtServiceImpTest {

    @Autowired
    ArtService artService;
    AddArtRequest addArtRequest;
    AddArtRequest addArtRequest2;
    EditArtRequest editArtRequest;

    @BeforeEach
    void setUp(){
        addArtRequest = AddArtRequest.builder()
                .artTitle("Adeweh the Industrial Designer")
                .artPrice(BigDecimal.valueOf(1000))
                .artType(ArtType.FILM).build();
        addArtRequest2 = AddArtRequest.builder()
                .artTitle("Adeweh the Industrial Designer")
                .artType(ArtType.FILM)
                .build();
        editArtRequest = EditArtRequest.builder()
                .artTitle("Abang the Industrial Designer")
                .artType(ArtType.SCULPTURE)
                .artPrice(BigDecimal.valueOf(800))
                .build();
    }

    @Test
    void addRequestTest() throws IOException {
        AddArtResponse response = artService.addArt(addArtRequest);
        assertThat(response).isNotNull();
        log.info("The response message is -> {}", response);
    }

    @Test
    void sameArtAddRequestGetErrorTest() throws IOException {
        AddArtResponse response = artService.addArt(addArtRequest2);
        assertThrows(ArtSalesSystemException.class,()-> artService.addArt(addArtRequest2));
        assertThat(response.getArtTitle()).isEqualTo("Adeweh the Industrial Designer");
    }

    @Test
    void editArtTest(){
        String artId = "";
        EditArtResponse response = artService.editArt(artId, editArtRequest);
        assertThat(response.getArtTitle()).isEqualTo("Abang the Industrial Designer");
        assertThat(response).isNotNull();

    }
}
