package com.robinhood.store.search;

import com.robinhood.models.api.ApiInstrument;
import com.robinhood.models.api.search.ApiSearchContent;
import com.robinhood.models.api.search.ApiSearchItem;
import com.robinhood.models.api.search.ApiSearchResult;
import com.robinhood.models.api.search.SearchResponse;
import com.robinhood.models.crypto.p315ui.UiCurrencyPair2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;


@Metadata(m3635d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0001¨\u0006\u0004"}, m3636d2 = {"toSearchResponse", "", "Lcom/robinhood/models/api/search/SearchResponse;", "Lcom/robinhood/models/api/search/ApiSearchResult;", "lib-store-search_externalDebug"}, m3637k = 2, m3638mv = {2, 1, 0}, m3640xi = 48)
@SourceDebugExtension


public final class SearchStore8 {
    public static final List<SearchResponse> toSearchResponse(List<ApiSearchResult> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (ApiSearchResult apiSearchResult : list) {
            ApiSearchContent content = apiSearchResult.getContent();
            SearchResponse tokenizedEtf = null;
            if (content instanceof ApiSearchContent.InstrumentContent) {
                List<ApiSearchItem.InstrumentItem> data = ((ApiSearchContent.InstrumentContent) content).getData();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
                Iterator<T> it = data.iterator();
                while (it.hasNext()) {
                    arrayList2.add(ApiInstrument.toDbInstrument$default(((ApiSearchItem.InstrumentItem) it.next()).getInstrument(), null, 1, null));
                }
                tokenizedEtf = new SearchResponse.Instruments(apiSearchResult.getDisplay_title(), arrayList2);
            } else if (content instanceof ApiSearchContent.CurrencyPairContent) {
                List<ApiSearchItem.CurrencyPairItem> data2 = ((ApiSearchContent.CurrencyPairContent) content).getData();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data2, 10));
                Iterator<T> it2 = data2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(UiCurrencyPair2.toUiModel(((ApiSearchItem.CurrencyPairItem) it2.next()).getCurrencyPair()));
                }
                tokenizedEtf = new SearchResponse.CurrencyPairs(apiSearchResult.getDisplay_title(), arrayList3);
            } else if (content instanceof ApiSearchContent.CuratedListContent) {
                List<ApiSearchItem.CuratedListItem> data3 = ((ApiSearchContent.CuratedListContent) content).getData();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data3, 10));
                Iterator<T> it3 = data3.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(((ApiSearchItem.CuratedListItem) it3.next()).getCuratedList());
                }
                tokenizedEtf = new SearchResponse.CuratedLists(arrayList4);
            } else if (content instanceof ApiSearchContent.DeeplinkContent) {
                List<ApiSearchItem.DeeplinkItem> data4 = ((ApiSearchContent.DeeplinkContent) content).getData();
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data4, 10));
                Iterator<T> it4 = data4.iterator();
                while (it4.hasNext()) {
                    arrayList5.add(((ApiSearchItem.DeeplinkItem) it4.next()).getDeeplink());
                }
                tokenizedEtf = new SearchResponse.Deeplinks(apiSearchResult.getDisplay_title(), arrayList5);
            } else if (content instanceof ApiSearchContent.EducationContent) {
                List<ApiSearchItem.EducationItem> data5 = ((ApiSearchContent.EducationContent) content).getData();
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data5, 10));
                Iterator<T> it5 = data5.iterator();
                while (it5.hasNext()) {
                    arrayList6.add(((ApiSearchItem.EducationItem) it5.next()).getItem());
                }
                tokenizedEtf = new SearchResponse.Education(apiSearchResult.getDisplay_title(), arrayList6);
            } else if (content instanceof ApiSearchContent.CryptoContent) {
                tokenizedEtf = new SearchResponse.Crypto(apiSearchResult.getDisplay_title(), ((ApiSearchContent.CryptoContent) content).getData(), apiSearchResult.getTrailing_header_content());
            } else if (content instanceof ApiSearchContent.ActiveFuturesContent) {
                String display_title = apiSearchResult.getDisplay_title();
                List<ApiSearchItem.FuturesContractItem> data6 = ((ApiSearchContent.ActiveFuturesContent) content).getData();
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data6, 10));
                Iterator<T> it6 = data6.iterator();
                while (it6.hasNext()) {
                    arrayList7.add(((ApiSearchItem.FuturesContractItem) it6.next()).getItem());
                }
                tokenizedEtf = new SearchResponse.FuturesResponse.ActiveFutures(display_title, arrayList7);
            } else if (content instanceof ApiSearchContent.NonActiveFuturesContent) {
                String display_title2 = apiSearchResult.getDisplay_title();
                List<ApiSearchItem.FuturesContractItem> data7 = ((ApiSearchContent.NonActiveFuturesContent) content).getData();
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data7, 10));
                Iterator<T> it7 = data7.iterator();
                while (it7.hasNext()) {
                    arrayList8.add(((ApiSearchItem.FuturesContractItem) it7.next()).getItem());
                }
                tokenizedEtf = new SearchResponse.FuturesResponse.NonActiveFutures(display_title2, arrayList8);
            } else if (content instanceof ApiSearchContent.FuturesContractsContent) {
                String display_title3 = apiSearchResult.getDisplay_title();
                List<ApiSearchItem.FuturesContractItem> data8 = ((ApiSearchContent.FuturesContractsContent) content).getData();
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data8, 10));
                Iterator<T> it8 = data8.iterator();
                while (it8.hasNext()) {
                    arrayList9.add(((ApiSearchItem.FuturesContractItem) it8.next()).getItem());
                }
                tokenizedEtf = new SearchResponse.FuturesResponse.FuturesContracts(display_title3, arrayList9);
            } else if (content instanceof ApiSearchContent.FuturesProductsContent) {
                String display_title4 = apiSearchResult.getDisplay_title();
                List<ApiSearchItem.FuturesProductItem> data9 = ((ApiSearchContent.FuturesProductsContent) content).getData();
                ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data9, 10));
                Iterator<T> it9 = data9.iterator();
                while (it9.hasNext()) {
                    arrayList10.add(((ApiSearchItem.FuturesProductItem) it9.next()).getItem());
                }
                tokenizedEtf = new SearchResponse.FuturesResponse.FuturesProducts(display_title4, arrayList10);
            } else if (content instanceof ApiSearchContent.EventContractsContent) {
                String display_title5 = apiSearchResult.getDisplay_title();
                List<ApiSearchItem.EventContractItem> data10 = ((ApiSearchContent.EventContractsContent) content).getData();
                ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data10, 10));
                Iterator<T> it10 = data10.iterator();
                while (it10.hasNext()) {
                    arrayList11.add(((ApiSearchItem.EventContractItem) it10.next()).getItem());
                }
                tokenizedEtf = new SearchResponse.EventContracts(display_title5, arrayList11);
            } else if (content instanceof ApiSearchContent.MarketIndexes) {
                String display_title6 = apiSearchResult.getDisplay_title();
                List<ApiSearchItem.MarketIndexes> data11 = ((ApiSearchContent.MarketIndexes) content).getData();
                ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data11, 10));
                Iterator<T> it11 = data11.iterator();
                while (it11.hasNext()) {
                    arrayList12.add(((ApiSearchItem.MarketIndexes) it11.next()).getItem().toDbModel());
                }
                tokenizedEtf = new SearchResponse.MarketIndexes(display_title6, arrayList12);
            } else if (content instanceof ApiSearchContent.PerpetualsContent) {
                tokenizedEtf = new SearchResponse.Perpetuals(((ApiSearchContent.PerpetualsContent) content).getData());
            } else if (content instanceof ApiSearchContent.TokenizedStockContent) {
                tokenizedEtf = new SearchResponse.TokenizedStock(apiSearchResult.getDisplay_title(), ((ApiSearchContent.TokenizedStockContent) content).getData(), apiSearchResult.getTrailing_header_content());
            } else if (content instanceof ApiSearchContent.TokenizedEtfContent) {
                tokenizedEtf = new SearchResponse.TokenizedEtf(apiSearchResult.getDisplay_title(), ((ApiSearchContent.TokenizedEtfContent) content).getData(), apiSearchResult.getTrailing_header_content());
            } else if (!(content instanceof ApiSearchContent.Unknown)) {
                throw new NoWhenBranchMatchedException();
            }
            if (tokenizedEtf != null) {
                arrayList.add(tokenizedEtf);
            }
        }
        return arrayList;
    }
}