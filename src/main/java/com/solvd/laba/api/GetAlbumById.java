package com.solvd.laba.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/albums/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/_getById/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAlbumById extends AbstractApiMethodV2 {
    public GetAlbumById(String id) {
        replaceUrlPlaceholder("id", id);
    }
}
