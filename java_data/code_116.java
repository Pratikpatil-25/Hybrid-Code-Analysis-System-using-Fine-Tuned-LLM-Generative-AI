package org.gaul.s3proxy;

final class AwsHttpHeaders {
    static final String ACL = "x-amz-acl";
    static final String API_VERSION = "x-amz-api-version";
    static final String CHECKSUM_ALGORITHM = "x-amz-checksum-algorithm";
    static final String CHECKSUM_CRC64NVME = "x-amz-checksum-crc64nvme";
    static final String CHECKSUM_MODE = "x-amz-checksum-mode";
    static final String CONTENT_SHA256 = "x-amz-content-sha256";
    static final String COPY_SOURCE = "x-amz-copy-source";
    static final String COPY_SOURCE_IF_MATCH = "x-amz-copy-source-if-match";
    static final String COPY_SOURCE_IF_MODIFIED_SINCE =
            "x-amz-copy-source-if-modified-since";
    static final String COPY_SOURCE_IF_NONE_MATCH =
            "x-amz-copy-source-if-none-match";
    static final String COPY_SOURCE_IF_UNMODIFIED_SINCE =
            "x-amz-copy-source-if-unmodified-since";
    static final String COPY_SOURCE_RANGE = "x-amz-copy-source-range";
    static final String DATE = "x-amz-date";
    static final String DECODED_CONTENT_LENGTH =
            "x-amz-decoded-content-length";
    static final String METADATA_DIRECTIVE = "x-amz-metadata-directive";
    static final String REQUEST_ID = "x-amz-request-id";
    static final String SDK_CHECKSUM_ALGORITHM = "x-amz-sdk-checksum-algorithm";
    static final String STORAGE_CLASS = "x-amz-storage-class";
    static final String TRAILER = "x-amz-trailer";
    static final String TRANSFER_ENCODING = "x-amz-te";
    static final String USER_AGENT = "x-amz-user-agent";

    private AwsHttpHeaders() {
        throw new AssertionError("intentionally unimplemented");
    }
}