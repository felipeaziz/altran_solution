package com.altran.solution.cache;

import com.altran.solution.model.ResultsDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Save in memory the searches already made using the API
 * @author Felipe Ibrahim
 *
 */
public class ResultCache {
    private final static ResultCache instance = new ResultCache();
    public Map<String, ResultsDTO> cache = new HashMap<>();

    private ResultCache() {
    }

    /**
     * Get the cache instance.
     * @return ResultCache singleton instance.
     */
    public static ResultCache getInstance() {
        return instance;
    }

    /**
     * Add the result search in the cache.
     * @param result
     */
    public void add(ResultsDTO result, String language) {
        cache.put(language, result);

    }

    /**
     * Do the search in the cache.
     * @return The Result if already exists in cache.
     */
    public ResultsDTO get(String language) {
        return cache.get(language);
    }
}
