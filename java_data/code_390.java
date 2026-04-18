package org.apache.solr.handler.clustering.carrot2;

import java.util.Set;

import com.google.common.collect.ImmutableSet;




public interface CarrotParams {

  String CARROT_PREFIX = "carrot.";

  String ALGORITHM = CARROT_PREFIX + "algorithm";
  
  String TITLE_FIELD_NAME = CARROT_PREFIX + "title";
  String URL_FIELD_NAME = CARROT_PREFIX + "url";
  String SNIPPET_FIELD_NAME = CARROT_PREFIX + "snippet";
  String LANGUAGE_FIELD_NAME = CARROT_PREFIX + "lang";
  String CUSTOM_FIELD_NAME = CARROT_PREFIX + "custom";
  
  String PRODUCE_SUMMARY = CARROT_PREFIX + "produceSummary";
  String SUMMARY_FRAGSIZE = CARROT_PREFIX + "fragSize";
  String SUMMARY_SNIPPETS = CARROT_PREFIX + "summarySnippets";

  String NUM_DESCRIPTIONS = CARROT_PREFIX + "numDescriptions";
  String OUTPUT_SUB_CLUSTERS = CARROT_PREFIX + "outputSubClusters";
  String LEXICAL_RESOURCES_DIR = CARROT_PREFIX + "lexicalResourcesDir";
  String LANGUAGE_CODE_MAP = CARROT_PREFIX + "lcmap";

  public static final Set<String> CARROT_PARAM_NAMES = ImmutableSet.of(
          ALGORITHM, TITLE_FIELD_NAME, URL_FIELD_NAME, SNIPPET_FIELD_NAME, LANGUAGE_FIELD_NAME,
          PRODUCE_SUMMARY, SUMMARY_FRAGSIZE, SUMMARY_SNIPPETS, NUM_DESCRIPTIONS, OUTPUT_SUB_CLUSTERS, 
          LEXICAL_RESOURCES_DIR);
}