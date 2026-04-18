package com.equinix.pulumi.fabric.inputs;

import com.equinix.pulumi.fabric.inputs.GetAdvertisedRoutesFilter;
import com.equinix.pulumi.fabric.inputs.GetAdvertisedRoutesPagination;
import com.equinix.pulumi.fabric.inputs.GetAdvertisedRoutesSort;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetAdvertisedRoutesPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetAdvertisedRoutesPlainArgs Empty = new GetAdvertisedRoutesPlainArgs();

    
    @Import(name="connectionId", required=true)
    private String connectionId;

    
    public String connectionId() {
        return this.connectionId;
    }

    
    @Import(name="filter", required=true)
    private GetAdvertisedRoutesFilter filter;

    
    public GetAdvertisedRoutesFilter filter() {
        return this.filter;
    }

    
    @Import(name="pagination", required=true)
    private GetAdvertisedRoutesPagination pagination;

    
    public GetAdvertisedRoutesPagination pagination() {
        return this.pagination;
    }

    
    @Import(name="sort")
    private @Nullable GetAdvertisedRoutesSort sort;

    
    public Optional<GetAdvertisedRoutesSort> sort() {
        return Optional.ofNullable(this.sort);
    }

    private GetAdvertisedRoutesPlainArgs() {}

    private GetAdvertisedRoutesPlainArgs(GetAdvertisedRoutesPlainArgs $) {
        this.connectionId = $.connectionId;
        this.filter = $.filter;
        this.pagination = $.pagination;
        this.sort = $.sort;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetAdvertisedRoutesPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetAdvertisedRoutesPlainArgs $;

        public Builder() {
            $ = new GetAdvertisedRoutesPlainArgs();
        }

        public Builder(GetAdvertisedRoutesPlainArgs defaults) {
            $ = new GetAdvertisedRoutesPlainArgs(Objects.requireNonNull(defaults));
        }

        
        public Builder connectionId(String connectionId) {
            $.connectionId = connectionId;
            return this;
        }

        
        public Builder filter(GetAdvertisedRoutesFilter filter) {
            $.filter = filter;
            return this;
        }

        
        public Builder pagination(GetAdvertisedRoutesPagination pagination) {
            $.pagination = pagination;
            return this;
        }

        
        public Builder sort(@Nullable GetAdvertisedRoutesSort sort) {
            $.sort = sort;
            return this;
        }

        public GetAdvertisedRoutesPlainArgs build() {
            if ($.connectionId == null) {
                throw new MissingRequiredPropertyException("GetAdvertisedRoutesPlainArgs", "connectionId");
            }
            if ($.filter == null) {
                throw new MissingRequiredPropertyException("GetAdvertisedRoutesPlainArgs", "filter");
            }
            if ($.pagination == null) {
                throw new MissingRequiredPropertyException("GetAdvertisedRoutesPlainArgs", "pagination");
            }
            return $;
        }
    }

}