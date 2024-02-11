package com.solvd.laba;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.api.GetAlbumById;
import com.solvd.laba.api.GetAlbums;
import com.solvd.laba.api.PatchAlbumById;
import com.solvd.laba.api.PostAlbum;
import com.solvd.laba.domain.Album;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void getAlbum() {
        GetAlbums getAlbums = new GetAlbums();
        getAlbums.callAPIExpectSuccess();
        getAlbums.validateResponseAgainstSchema("api/_get/rs.schema");
    }

    @Test
    public void getAlbumById() {
        //Let's say to get Album id 2, but can be specified in constructor
        GetAlbumById getAlbumById = new GetAlbumById("2");
        getAlbumById.callAPIExpectSuccess();
        getAlbumById.validateResponse();
    }

    @Test
    public void getAlbumByIdWithError() {
        //Id 3 is assigned, but rs.json has id 2
        GetAlbumById getAlbumById = new GetAlbumById("3");
        getAlbumById.callAPIExpectSuccess();
        getAlbumById.validateResponse();
    }

    @Test
    public void postAlbum() {
        PostAlbum postAlbum = new PostAlbum();
        postAlbum.setProperties("api/_post/album.properties");
        postAlbum.callAPIExpectSuccess();
        postAlbum.validateResponse();
    }

    @Test
    public void postAlbumMissingFields() {
        PostAlbum postAlbum = new PostAlbum();
        postAlbum.setProperties("api/_post/album.properties");
        postAlbum.getProperties().remove("userId");
        postAlbum.callAPIExpectSuccess();
        postAlbum.validateResponse();
    }

    @Test
    public void patchAlbum() throws JsonProcessingException {
        PostAlbum postAlbum = new PostAlbum();
        postAlbum.setProperties("api/_post/album.properties");
        String albumString = postAlbum.callAPIExpectSuccess().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        Album album = objectMapper.readValue(albumString, Album.class);
        album.setTitle("IAMNOTTHESAMEANYMORE");
        PatchAlbumById patchAlbumById = new PatchAlbumById(String.valueOf(album.getId()));
        patchAlbumById.addProperty("album", album);
        patchAlbumById.callAPIExpectSuccess();
        patchAlbumById.validateResponse();
    }

}
