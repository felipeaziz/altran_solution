package com.altran.solution;

import com.altran.solution.model.OrganizationDTO;
import com.altran.solution.model.ResultDTO;

public class TestParent {

    protected ResultDTO expected;

    protected void createExpectedResults() {
        expected = new ResultDTO();
        expected.setUrl("http://mediambient.gencat.cat/ca/05_ambits_dactuacio/atmosfera/qualitat_de_laire/");
        expected.setCode("qualitat_aire_detall");
        expected.setDescription("La font origen  de la 'Qualitat de l'aire a la ciutat de Barcelona'  \u00e9s la Direcci\u00f3 General de Qualitat Ambiental i Canvi Clim\u00e0tic de la Generalitat de Catalunya  i  els 3 nivells de la dada qualitativa, que al fitxer s\u2019anomenen qualitat_01, qualitat_02 i qualitat_03  \u00e9s troben detallats a __ [Qu\u00e8 \u00e9s l'\u00cdndex Catal\u00e0 de Qualitat de l'Aire?](http://mediambient.gencat.cat/ca/05_ambits_dactuacio/atmosfera/qualitat_de_laire/avaluacio/icqa/que_es_lindex_catala_de_qualitat_de_laire/index.html)__\r\n\r\nL'Ajuntament de Barcelona,  ara facilitador d'aquestes dades t\u00e9 establert una classificaci\u00f3 en 5 nivells que pot \u00e9sser consultada a __ [Classificaci\u00f3 de l\u2019Estat de la Qualitat de l\u2019Aire de Barcelona (EQAB)     ](https://ajuntament.barcelona.cat/qualitataire/ca/classificaci-de-l-estat-de-la-qualitat-de-l-aire-de-barcelona-eqab)__");
        expected.setOrganization(createExpectedOrganization());
    }

    protected OrganizationDTO createExpectedOrganization() {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setName("medi-ambient");
        dto.setDescription("Medi ambient");
        dto.setCode("medi-ambient");
        return dto;
    }
}
