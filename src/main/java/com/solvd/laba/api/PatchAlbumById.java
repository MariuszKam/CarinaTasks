package com.solvd.laba.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/albums/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/_patch/rq.json")
@ResponseTemplatePath(path = "api/_patch/rs.schema")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchAlbumById extends AbstractApiMethodV2 {
    public PatchAlbumById(String id) {
        replaceUrlPlaceholder("id", id);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
