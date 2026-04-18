package org.elasticsearch.rest.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.tasks.TaskCancelledException;


public abstract class RestActionListener<Response> implements ActionListener<Response> {

    private static final Logger logger = LogManager.getLogger(RestActionListener.class);

    protected final RestChannel channel;

    protected RestActionListener(RestChannel channel) {
        this.channel = channel;
    }

    @Override
    public final void onResponse(Response response) {
        try {
            ensureOpen();
            processResponse(response);
        } catch (Exception e) {
            onFailure(e);
        }
    }

    protected abstract void processResponse(Response response) throws Exception;

    protected void ensureOpen() {
        if (channel.request().getHttpChannel().isOpen() == false) {
            throw new TaskCancelledException("response channel [" + channel.request().getHttpChannel() + "] closed");
        }
    }

    @Override
    public final void onFailure(Exception e) {
        try {
            channel.sendResponse(new RestResponse(channel, e));
        } catch (Exception inner) {
            inner.addSuppressed(e);
            logger.warn("failed to send failure response", inner);
        }
    }
}