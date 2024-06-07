package com.test.uolhostt.infra;


import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.annotation.PostConstruct;

@Component
public class ListaCodnome {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public final LinkedList<String> listaMarvel = new LinkedList<>();
    public final LinkedList<String> listaDC = new LinkedList<>();

    @Value("${vingadores}")
    private String jsonVingador;

    @Value("${DC}")
    private String xmlDc;

    public ListaCodnome(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void listarHeroiMarvel() {

        try {
            ResponseEntity<String> nomeResposta = restTemplate.getForEntity(jsonVingador, String.class);
            if(nomeResposta.getStatusCode().value()==200){
             String requestResposta=nomeResposta.getBody();

             JsonNode jsonNode = objectMapper.readTree(requestResposta);
           
             ArrayNode vingadores = (ArrayNode) jsonNode.get("vingadores");
 
             for (JsonNode nomes : vingadores) {
                 listaMarvel.add(nomes.get("codinome").asText());
             }
             System.out.println(listaMarvel);
            }else{
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @PostConstruct
    public void listaDc(){
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder= builderFactory.newDocumentBuilder();
            Document document = (Document) builder.parse(xmlDc);
            NodeList nodeList = document.getElementsByTagName("codinome");

            for(int i=0;i<nodeList.getLength();i++){
              Element  codinameDC = (Element) nodeList.item(i);
              String elemento=codinameDC.getTextContent();
              listaDC.add(elemento);
            }
            System.out.println(listaDC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
