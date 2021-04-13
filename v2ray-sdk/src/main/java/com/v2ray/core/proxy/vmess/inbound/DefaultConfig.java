// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/proxy/vmess/inbound/config.proto

package com.v2ray.core.proxy.vmess.inbound;

/**
 * Protobuf type {@code v2ray.core.proxy.vmess.inbound.DefaultConfig}
 */
public final class DefaultConfig extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:v2ray.core.proxy.vmess.inbound.DefaultConfig)
        DefaultConfigOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use DefaultConfig.newBuilder() to construct.
    private DefaultConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private DefaultConfig() {
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private DefaultConfig(
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
                    case 8: {

                        alterId_ = input.readUInt32();
                        break;
                    }
                    case 16: {

                        level_ = input.readUInt32();
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
        return ConfigOuterClass.internal_static_v2ray_core_proxy_vmess_inbound_DefaultConfig_descriptor;
    }

    @Override
    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return ConfigOuterClass.internal_static_v2ray_core_proxy_vmess_inbound_DefaultConfig_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        DefaultConfig.class, Builder.class);
    }

    public static final int ALTER_ID_FIELD_NUMBER = 1;
    private int alterId_;

    /**
     * <code>uint32 alter_id = 1;</code>
     */
    public int getAlterId() {
        return alterId_;
    }

    public static final int LEVEL_FIELD_NUMBER = 2;
    private int level_;

    /**
     * <code>uint32 level = 2;</code>
     */
    public int getLevel() {
        return level_;
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
        if (alterId_ != 0) {
            output.writeUInt32(1, alterId_);
        }
        if (level_ != 0) {
            output.writeUInt32(2, level_);
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (alterId_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(1, alterId_);
        }
        if (level_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(2, level_);
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
        if (!(obj instanceof DefaultConfig)) {
            return super.equals(obj);
        }
        DefaultConfig other = (DefaultConfig) obj;

        if (getAlterId()
                != other.getAlterId()) return false;
        if (getLevel()
                != other.getLevel()) return false;
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
        hash = (37 * hash) + ALTER_ID_FIELD_NUMBER;
        hash = (53 * hash) + getAlterId();
        hash = (37 * hash) + LEVEL_FIELD_NUMBER;
        hash = (53 * hash) + getLevel();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static DefaultConfig parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static DefaultConfig parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static DefaultConfig parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static DefaultConfig parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static DefaultConfig parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static DefaultConfig parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static DefaultConfig parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static DefaultConfig parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static DefaultConfig parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static DefaultConfig parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static DefaultConfig parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static DefaultConfig parseFrom(
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

    public static Builder newBuilder(DefaultConfig prototype) {
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
     * Protobuf type {@code v2ray.core.proxy.vmess.inbound.DefaultConfig}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:v2ray.core.proxy.vmess.inbound.DefaultConfig)
            DefaultConfigOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return ConfigOuterClass.internal_static_v2ray_core_proxy_vmess_inbound_DefaultConfig_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return ConfigOuterClass.internal_static_v2ray_core_proxy_vmess_inbound_DefaultConfig_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            DefaultConfig.class, Builder.class);
        }

        // Construct using com.v2ray.core.proxy.vmess.inbound.DefaultConfig.newBuilder()
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
            alterId_ = 0;

            level_ = 0;

            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return ConfigOuterClass.internal_static_v2ray_core_proxy_vmess_inbound_DefaultConfig_descriptor;
        }

        @Override
        public DefaultConfig getDefaultInstanceForType() {
            return DefaultConfig.getDefaultInstance();
        }

        @Override
        public DefaultConfig build() {
            DefaultConfig result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public DefaultConfig buildPartial() {
            DefaultConfig result = new DefaultConfig(this);
            result.alterId_ = alterId_;
            result.level_ = level_;
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
            if (other instanceof DefaultConfig) {
                return mergeFrom((DefaultConfig) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(DefaultConfig other) {
            if (other == DefaultConfig.getDefaultInstance()) return this;
            if (other.getAlterId() != 0) {
                setAlterId(other.getAlterId());
            }
            if (other.getLevel() != 0) {
                setLevel(other.getLevel());
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
            DefaultConfig parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (DefaultConfig) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int alterId_;

        /**
         * <code>uint32 alter_id = 1;</code>
         */
        public int getAlterId() {
            return alterId_;
        }

        /**
         * <code>uint32 alter_id = 1;</code>
         */
        public Builder setAlterId(int value) {

            alterId_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint32 alter_id = 1;</code>
         */
        public Builder clearAlterId() {

            alterId_ = 0;
            onChanged();
            return this;
        }

        private int level_;

        /**
         * <code>uint32 level = 2;</code>
         */
        public int getLevel() {
            return level_;
        }

        /**
         * <code>uint32 level = 2;</code>
         */
        public Builder setLevel(int value) {

            level_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint32 level = 2;</code>
         */
        public Builder clearLevel() {

            level_ = 0;
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


        // @@protoc_insertion_point(builder_scope:v2ray.core.proxy.vmess.inbound.DefaultConfig)
    }

    // @@protoc_insertion_point(class_scope:v2ray.core.proxy.vmess.inbound.DefaultConfig)
    private static final DefaultConfig DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new DefaultConfig();
    }

    public static DefaultConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<DefaultConfig>
            PARSER = new com.google.protobuf.AbstractParser<DefaultConfig>() {
        @Override
        public DefaultConfig parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new DefaultConfig(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<DefaultConfig> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<DefaultConfig> getParserForType() {
        return PARSER;
    }

    @Override
    public DefaultConfig getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}

