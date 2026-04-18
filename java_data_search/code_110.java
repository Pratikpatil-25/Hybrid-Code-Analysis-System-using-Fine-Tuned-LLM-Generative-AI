package org.carlspring.strongbox.providers.search;

import org.carlspring.strongbox.storage.search.SearchRequest;
import org.carlspring.strongbox.storage.search.SearchResult;
import org.carlspring.strongbox.storage.search.SearchResults;


public interface SearchProvider
{
    String getAlias();

    SearchResults search(SearchRequest searchRequest)
            throws SearchException;

    
    SearchResult findExact(SearchRequest searchRequest);

    boolean contains(SearchRequest searchRequest)
            throws SearchException;

}