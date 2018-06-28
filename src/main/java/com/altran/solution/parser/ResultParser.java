package com.altran.solution.parser;

import com.altran.solution.model.OrganizationDTO;
import com.altran.solution.model.ResultDTO;
import com.altran.solution.model.ResultsDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class ResultParser {
    private static final String RESULT = "result";
    private static final String RESULTS = "results";
    private static final String CODE = "code";
    private static final String NAME = "name";
    private static final String DATASET_FIELD_DESCRIPTION = "dataset_fields_description";
    private static final String URL_TORNADA = "url_tornada";
    private static final String ORGANIZATION = "organization";
    private static final String DESCRIPTION_TRANSLATED = "description_translated";


    public static ResultsDTO parseFromJson(String json, String language) throws ParseException {
        List<ResultDTO> resultsDto = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject response = null;
        response = (JSONObject) parser.parse(json);
        JSONObject result = (JSONObject) response.get(RESULT);
        JSONArray results = (JSONArray) result.get(RESULTS);

        for (int i=0; i<results.size(); ++i) {
            JSONObject item = (JSONObject)results.get(i);
            resultsDto.add(buildResultDto(item, language));
        }

        ResultsDTO parsedResult = new ResultsDTO();
        parsedResult.setResults(resultsDto);
        return parsedResult;
    }

    private static ResultDTO buildResultDto(JSONObject item, String language) {
        ResultDTO dto = new ResultDTO();
        dto.setCode(item.get(CODE).toString());
        dto.setDescription(item.get(DATASET_FIELD_DESCRIPTION).toString());
        JSONObject url = (JSONObject) item.get(URL_TORNADA);
        dto.setUrl(url.get(language).toString());
        dto.setOrganization(buildOrganization((JSONObject)item.get(ORGANIZATION), language));
        return dto;
    }

    private static OrganizationDTO buildOrganization(JSONObject organization, String language) {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setCode(organization.get(CODE).toString());
        dto.setName(organization.get(NAME).toString());
        JSONObject description = (JSONObject) organization.get(DESCRIPTION_TRANSLATED);
        dto.setDescription(description.get(language).toString());
        return dto;
    }
}
