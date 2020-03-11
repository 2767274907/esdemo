package com.lmf.esdemo.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "chance")
public class Chance {
  @Id
  @Field
  private Integer chcId;
  @Field
  private String chcCustName;
  @Field
  private String chcSource;

  public Integer getChcId() {
    return chcId;
  }

  public void setChcId(Integer chcId) {
    this.chcId = chcId;
  }

  public String getChcCustName() {
    return chcCustName;
  }

  public void setChcCustName(String chcCustName) {
    this.chcCustName = chcCustName;
  }

  public String getChcSource() {
    return chcSource;
  }

  public void setChcSource(String chcSource) {
    this.chcSource = chcSource;
  }
}
