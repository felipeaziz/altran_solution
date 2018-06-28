package com.altran.solution.api;

import com.altran.solution.model.ResultsDTO;
import com.altran.solution.parser.ResultParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Helper que auxilia nas chamadas REST da API da Marvel.
 * 
 * @author sfonseca
 *
 */
@Component
public class MavenApiHelper {
	
    private static final String PRIVATE_KEY = "5330d355e49bd202e20b3156e0b1221def0eff2b";
    
    private static final String PUBLIC_KEY = "ab6b3198982999015c00ad382c77bfdd";

    //TODO - check the uri
    private static final String AJUNTAMENT_URL = "http://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search";
    
    public ResultsDTO getResults(String language) {
        ResultsDTO dto = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            dto = restTemplate.getForObject(AJUNTAMENT_URL, ResultsDTO.class);
            String response = restTemplate.getForObject(AJUNTAMENT_URL, String.class);
            dto = ResultParser.parseFromJson(response, language);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return dto;
    }

//    /**
//     * Consulta na API de personagens /v1/public/characters pelo nome
//     * @param name
//     * @return
//     */
//    public ApiReturn<MarvelCharacter> getCharacter(String name) {
//        MultivaluedMap<String, String> params = getAuthenticationParams();
//
//        if(name != null && !name.isEmpty()) {
//        	params.add("name", name);
//        }
//
//        Client client = Client.create();
//		WebResource restService = client.resource( MAVEN_API_URI + "characters");
//
//		ClientResponse response = restService.queryParams(params).get(ClientResponse.class);
//
//		if (response.getStatus() != 200) {
//		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//
//		return response.getEntity(new GenericType<ApiReturn<MarvelCharacter>>(){});
//    }
//
//
//    /**
//     * Adiciona os parametros exigidos pela API da Marvel
//     * @return
//     */
//    private MultivaluedMap<String, String> getAuthenticationParams() {
//        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
//        String ts = Long.toString(System.currentTimeMillis());
//        queryParams.add("ts", ts);
//        queryParams.add("hash", generateHash(ts));
//        queryParams.add("apikey", PUBLIC_KEY);
//        return queryParams;
//    }
//
//    private String generateHash(String ts) {
//        return DigestUtils.md5Hex(ts + PRIVATE_KEY + PUBLIC_KEY);
//    }
//
//    /**
//     * Consulta na API de Comics /v1/public/characters/{characterId}/comics pelo id do personagem
//     * @param characterId
//     * @return
//     */
//    public ApiReturn<Comic> getComics(Integer characterId) {
//        MultivaluedMap<String, String> params = getAuthenticationParams();
//
//        Client client = Client.create();
//		WebResource restService = client.resource( MAVEN_API_URI + "characters/" + characterId + "/comics");
//
//		ClientResponse response = restService.queryParams(params).get(ClientResponse.class);
//
//		if (response.getStatus() != 200) {
//		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//
//		return response.getEntity(new GenericType<ApiReturn<Comic>>(){});
//    }
}
