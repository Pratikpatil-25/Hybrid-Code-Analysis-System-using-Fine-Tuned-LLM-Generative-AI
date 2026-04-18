package org.elasticsearch.action;

import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.rest.action.EmptyResponseListener;
import org.elasticsearch.transport.TransportResponse;
import org.elasticsearch.xcontent.ToXContent;
import org.elasticsearch.xcontent.XContent;


public abstract class ActionResponse extends TransportResponse {

    public ActionResponse() {}

    
    public static final class Empty extends ActionResponse {

        private Empty() {  }

        public static final ActionResponse.Empty INSTANCE = new ActionResponse.Empty();

        @Override
        public String toString() {
            return "ActionResponse.Empty{}";
        }

        @Override
        public void writeTo(StreamOutput out) {}
    }
}