package com.lmf.esdemo;

import com.lmf.esdemo.entity.Chance;
import com.lmf.esdemo.entity.User;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EsdemoApplicationTests {

    @Autowired
    SolrClient solrClient;


    @Test
    void contextLoads() {
        List<Chance> list = new ArrayList<Chance>();
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        solrQuery.setStart(0);
        solrQuery.setRows(5);
        try {
            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse != null){
                list = queryResponse.getBeans(Chance.class);
                for (Chance c :list) {
                    System.out.println(c.getChcCustName()+c.getChcId());
                }
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
