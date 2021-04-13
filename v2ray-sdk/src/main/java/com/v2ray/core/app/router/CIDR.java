// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/router/config.proto

package com.v2ray.core.app.router;

/**
 * <pre>
 * IP for routing decision, in CIDR form.
 * </pre>
 * <p>
 * Protobuf type {@code v2ray.core.app.router.CIDR}
 */
public final class CIDR extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:v2ray.core.app.router.CIDR)
        CIDROrBuilder {
    private static final long serialVersionUID = 0L;

    // Use CIDR.newBuilder() to construct.
    private CIDR(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private CIDR() {
        ip_ = com.google.protobuf.ByteString.EMPTY;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private CIDR(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
        int mutable_bitField0_ = 0;
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        done = true;
                        break;
                    case 10: {

                        ip_ = input.readBytes();
                        break;
                    }
                    case 16: {

                        prefix_ = input.readUInt32();
                        break;
                    }
                    default: {
                        if (!parseUnknownField(
                                input, unknownFields, extensionRegistry, tag)) {
                            done = true;
                        }
                        break;
                    }
                }
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(
                    e).setUnfinishedMessage(this);
        } finally {
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return ConfigOuterClass.internal_static_v2ray_core_app_router_CIDR_descriptor;
    }

    @Override
    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return ConfigOuterClass.internal_static_v2ray_core_app_router_CIDR_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        CIDR.class, Builder.class);
    }

    public static final int IP_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString ip_;

    /**
     * <pre>
     * IP address, should be either 4 or 16 bytes.
     * </pre>
     *
     * <code>bytes ip = 1;</code>
     */
    public com.google.protobuf.ByteString getIp() {
        return ip_;
    }

    public static final int PREFIX_FIELD_NUMBER = 2;
    private int prefix_;

    /**
     * <pre>
     * Number of leading ones in the network mask.
     * </pre>
     *
     * <code>uint32 prefix = 2;</code>
     */
    public int getPrefix() {
        return prefix_;
    }

    private byte memoizedIsInitialized = -1;

    @Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (!ip_.isEmpty()) {
            output.writeBytes(1, ip_);
        }
        if (prefix_ != 0) {
            output.writeUInt32(2, prefix_);
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (!ip_.isEmpty()) {
            size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(1, ip_);
        }
        if (prefix_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(2, prefix_);
        }
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CIDR)) {
            return super.equals(obj);
        }
        CIDR other = (CIDR) obj;

        if (!getIp()
                .equals(other.getIp())) return false;
        if (getPrefix()
                != other.getPrefix()) return false;
        if (!unknownFields.equals(other.unknownFields)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + IP_FIELD_NUMBER;
        hash = (53 * hash) + getIp().hashCode();
        hash = (37 * hash) + PREFIX_FIELD_NUMBER;
        hash = (53 * hash) + getPrefix();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static CIDR parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static CIDR parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static CIDR parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static CIDR parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static CIDR parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static CIDR parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static CIDR parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static CIDR parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static CIDR parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static CIDR parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static CIDR parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static CIDR parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CIDR prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
            BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    /**
     * <pre>
     * IP for routing decision, in CIDR form.
     * </pre>
     * <p>
     * Protobuf type {@code v2ray.core.app.router.CIDR}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:v2ray.core.app.router.CIDR)
            CIDROrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return ConfigOuterClass.internal_static_v2ray_core_app_router_CIDR_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return ConfigOuterClass.internal_static_v2ray_core_app_router_CIDR_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            CIDR.class, Builder.class);
        }

        // Construct using com.v2ray.core.app.router.CIDR.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            ip_ = com.google.protobuf.ByteString.EMPTY;

            prefix_ = 0;

            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return ConfigOuterClass.internal_static_v2ray_core_app_router_CIDR_descriptor;
        }

        @Override
        public CIDR getDefaultInstanceForType() {
            return CIDR.getDefaultInstance();
        }

        @Override
        public CIDR build() {
            CIDR result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public CIDR buildPartial() {
            CIDR result = new CIDR(this);
            result.ip_ = ip_;
            result.prefix_ = prefix_;
            onBuilt();
            return result;
        }

        @Override
        public Builder clone() {
            return super.clone();
        }

        @Override
        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                Object value) {
            return super.setField(field, value);
        }

        @Override
        public Builder clearField(
                com.google.protobuf.Descriptors.FieldDescriptor field) {
            return super.clearField(field);
        }

        @Override
        public Builder clearOneof(
                com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return super.clearOneof(oneof);
        }

        @Override
        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                int index, Object value) {
            return super.setRepeatedField(field, index, value);
        }

        @Override
        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                Object value) {
            return super.addRepeatedField(field, value);
        }

        @Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof CIDR) {
                return mergeFrom((CIDR) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(CIDR other) {
            if (other == CIDR.getDefaultInstance()) return this;
            if (other.getIp() != com.google.protobuf.ByteString.EMPTY) {
                setIp(other.getIp());
            }
            if (other.getPrefix() != 0) {
                setPrefix(other.getPrefix());
            }
            this.mergeUnknownFields(other.unknownFields);
            onChanged();
            return this;
        }

        @Override
        public final boolean isInitialized() {
            return true;
        }

        @Override
        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            CIDR parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (CIDR) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private com.google.protobuf.ByteString ip_ = com.google.protobuf.ByteString.EMPTY;

        /**
         * <pre>
         * IP address, should be either 4 or 16 bytes.
         * </pre>
         *
         * <code>bytes ip = 1;</code>
         */
        public com.google.protobuf.ByteString getIp() {
            return ip_;
        }

        /**
         * <pre>
         * IP address, should be either 4 or 16 bytes.
         * </pre>
         *
         * <code>bytes ip = 1;</code>
         */
        public Builder setIp(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }

            ip_ = value;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * IP address, should be either 4 or 16 bytes.
         * </pre>
         *
         * <code>bytes ip = 1;</code>
         */
        public Builder clearIp() {

            ip_ = getDefaultInstance().getIp();
            onChanged();
            return this;
        }

        private int prefix_;

        /**
         * <pre>
         * Number of leading ones in the network mask.
         * </pre>
         *
         * <code>uint32 prefix = 2;</code>
         */
        public int getPrefix() {
            return prefix_;
        }

        /**
         * <pre>
         * Number of leading ones in the network mask.
         * </pre>
         *
         * <code>uint32 prefix = 2;</code>
         */
        public Builder setPrefix(int value) {

            prefix_ = value;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * Number of leading ones in the network mask.
         * </pre>
         *
         * <code>uint32 prefix = 2;</code>
         */
        public Builder clearPrefix() {

            prefix_ = 0;
            onChanged();
            return this;
        }

        @Override
        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFields(unknownFields);
        }

        @Override
        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }


        // @@protoc_insertion_point(builder_scope:v2ray.core.app.router.CIDR)
    }

    // @@protoc_insertion_point(class_scope:v2ray.core.app.router.CIDR)
    private static final CIDR DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new CIDR();
    }

    public static CIDR getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CIDR>
            PARSER = new com.google.protobuf.AbstractParser<CIDR>() {
        @Override
        public CIDR parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new CIDR(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<CIDR> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<CIDR> getParserForType() {
        return PARSER;
    }

    @Override
    public CIDR getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
