package com.altran.solution.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class 	ResultsDTO {

	private List<ResultDTO> results;

	public List<ResultDTO> getResults() {
		return this.results;
	}

	public void setResults(List<ResultDTO> results) {
		this.results = results;
	}
	
}