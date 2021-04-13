// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/proxy/socks/config.proto

package com.v2ray.core.proxy.socks;

/**
 * Protobuf type {@code v2ray.core.proxy.socks.ClientConfig}
 */
public final class ClientConfig extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:v2ray.core.proxy.socks.ClientConfig)
        ClientConfigOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use ClientConfig.newBuilder() to construct.
    private ClientConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private ClientConfig() {
        server_ = java.util.Collections.emptyList();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private ClientConfig(
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
                        if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                            server_ = new java.util.ArrayList<com.v2ray.core.common.protocol.ServerEndpoint>();
                            mutable_bitField0_ |= 0x00000001;
                        }
                        server_.add(
                                input.readMessage(com.v2ray.core.common.protocol.ServerEndpoint.parser(), extensionRegistry));
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
            if (((mutable_bitField0_ & 0x00000001) != 0)) {
                server_ = java.util.Collections.unmodifiableList(server_);
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return Config.internal_static_v2ray_core_proxy_socks_ClientConfig_descriptor;
    }

    @Override
    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return Config.internal_static_v2ray_core_proxy_socks_ClientConfig_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        ClientConfig.class, Builder.class);
    }

    public static final int SERVER_FIELD_NUMBER = 1;
    private java.util.List<com.v2ray.core.common.protocol.ServerEndpoint> server_;

    /**
     * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
     */
    public java.util.List<com.v2ray.core.common.protocol.ServerEndpoint> getServerList() {
        return server_;
    }

    /**
     * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
     */
    public java.util.List<? extends com.v2ray.core.common.protocol.ServerEndpointOrBuilder>
    getServerOrBuilderList() {
        return server_;
    }

    /**
     * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
     */
    public int getServerCount() {
        return server_.size();
    }

    /**
     * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
     */
    public com.v2ray.core.common.protocol.ServerEndpoint getServer(int index) {
        return server_.get(index);
    }

    /**
     * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
     */
    public com.v2ray.core.common.protocol.ServerEndpointOrBuilder getServerOrBuilder(
            int index) {
        return server_.get(index);
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
        for (int i = 0; i < server_.size(); i++) {
            output.writeMessage(1, server_.get(i));
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        for (int i = 0; i < server_.size(); i++) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(1, server_.get(i));
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
        if (!(obj instanceof ClientConfig)) {
            return super.equals(obj);
        }
        ClientConfig other = (ClientConfig) obj;

        if (!getServerList()
                .equals(other.getServerList())) return false;
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
        if (getServerCount() > 0) {
            hash = (37 * hash) + SERVER_FIELD_NUMBER;
            hash = (53 * hash) + getServerList().hashCode();
        }
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static ClientConfig parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ClientConfig parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ClientConfig parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ClientConfig parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ClientConfig parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ClientConfig parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ClientConfig parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static ClientConfig parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static ClientConfig parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static ClientConfig parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static ClientConfig parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static ClientConfig parseFrom(
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

    public static Builder newBuilder(ClientConfig prototype) {
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
     * Protobuf type {@code v2ray.core.proxy.socks.ClientConfig}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:v2ray.core.proxy.socks.ClientConfig)
            ClientConfigOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return Config.internal_static_v2ray_core_proxy_socks_ClientConfig_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return Config.internal_static_v2ray_core_proxy_socks_ClientConfig_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            ClientConfig.class, Builder.class);
        }

        // Construct using com.v2ray.core.proxy.socks.ClientConfig.newBuilder()
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
                getServerFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            if (serverBuilder_ == null) {
                server_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
            } else {
                serverBuilder_.clear();
            }
            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return Config.internal_static_v2ray_core_proxy_socks_ClientConfig_descriptor;
        }

        @Override
        public ClientConfig getDefaultInstanceForType() {
            return ClientConfig.getDefaultInstance();
        }

        @Override
        public ClientConfig build() {
            ClientConfig result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public ClientConfig buildPartial() {
            ClientConfig result = new ClientConfig(this);
            int from_bitField0_ = bitField0_;
            if (serverBuilder_ == null) {
                if (((bitField0_ & 0x00000001) != 0)) {
                    server_ = java.util.Collections.unmodifiableList(server_);
                    bitField0_ = (bitField0_ & ~0x00000001);
                }
                result.server_ = server_;
            } else {
                result.server_ = serverBuilder_.build();
            }
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
            if (other instanceof ClientConfig) {
                return mergeFrom((ClientConfig) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(ClientConfig other) {
            if (other == ClientConfig.getDefaultInstance()) return this;
            if (serverBuilder_ == null) {
                if (!other.server_.isEmpty()) {
                    if (server_.isEmpty()) {
                        server_ = other.server_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                    } else {
                        ensureServerIsMutable();
                        server_.addAll(other.server_);
                    }
                    onChanged();
                }
            } else {
                if (!other.server_.isEmpty()) {
                    if (serverBuilder_.isEmpty()) {
                        serverBuilder_.dispose();
                        serverBuilder_ = null;
                        server_ = other.server_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                        serverBuilder_ =
                                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                        getServerFieldBuilder() : null;
                    } else {
                        serverBuilder_.addAllMessages(other.server_);
                    }
                }
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
            ClientConfig parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (ClientConfig) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int bitField0_;

        private java.util.List<com.v2ray.core.common.protocol.ServerEndpoint> server_ =
                java.util.Collections.emptyList();

        private void ensureServerIsMutable() {
            if (!((bitField0_ & 0x00000001) != 0)) {
                server_ = new java.util.ArrayList<com.v2ray.core.common.protocol.ServerEndpoint>(server_);
                bitField0_ |= 0x00000001;
            }
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<
                com.v2ray.core.common.protocol.ServerEndpoint, com.v2ray.core.common.protocol.ServerEndpoint.Builder, com.v2ray.core.common.protocol.ServerEndpointOrBuilder> serverBuilder_;

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public java.util.List<com.v2ray.core.common.protocol.ServerEndpoint> getServerList() {
            if (serverBuilder_ == null) {
                return java.util.Collections.unmodifiableList(server_);
            } else {
                return serverBuilder_.getMessageList();
            }
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public int getServerCount() {
            if (serverBuilder_ == null) {
                return server_.size();
            } else {
                return serverBuilder_.getCount();
            }
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public com.v2ray.core.common.protocol.ServerEndpoint getServer(int index) {
            if (serverBuilder_ == null) {
                return server_.get(index);
            } else {
                return serverBuilder_.getMessage(index);
            }
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder setServer(
                int index, com.v2ray.core.common.protocol.ServerEndpoint value) {
            if (serverBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureServerIsMutable();
                server_.set(index, value);
                onChanged();
            } else {
                serverBuilder_.setMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder setServer(
                int index, com.v2ray.core.common.protocol.ServerEndpoint.Builder builderForValue) {
            if (serverBuilder_ == null) {
                ensureServerIsMutable();
                server_.set(index, builderForValue.build());
                onChanged();
            } else {
                serverBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder addServer(com.v2ray.core.common.protocol.ServerEndpoint value) {
            if (serverBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureServerIsMutable();
                server_.add(value);
                onChanged();
            } else {
                serverBuilder_.addMessage(value);
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder addServer(
                int index, com.v2ray.core.common.protocol.ServerEndpoint value) {
            if (serverBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureServerIsMutable();
                server_.add(index, value);
                onChanged();
            } else {
                serverBuilder_.addMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder addServer(
                com.v2ray.core.common.protocol.ServerEndpoint.Builder builderForValue) {
            if (serverBuilder_ == null) {
                ensureServerIsMutable();
                server_.add(builderForValue.build());
                onChanged();
            } else {
                serverBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder addServer(
                int index, com.v2ray.core.common.protocol.ServerEndpoint.Builder builderForValue) {
            if (serverBuilder_ == null) {
                ensureServerIsMutable();
                server_.add(index, builderForValue.build());
                onChanged();
            } else {
                serverBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder addAllServer(
                Iterable<? extends com.v2ray.core.common.protocol.ServerEndpoint> values) {
            if (serverBuilder_ == null) {
                ensureServerIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, server_);
                onChanged();
            } else {
                serverBuilder_.addAllMessages(values);
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder clearServer() {
            if (serverBuilder_ == null) {
                server_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
                onChanged();
            } else {
                serverBuilder_.clear();
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public Builder removeServer(int index) {
            if (serverBuilder_ == null) {
                ensureServerIsMutable();
                server_.remove(index);
                onChanged();
            } else {
                serverBuilder_.remove(index);
            }
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public com.v2ray.core.common.protocol.ServerEndpoint.Builder getServerBuilder(
                int index) {
            return getServerFieldBuilder().getBuilder(index);
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public com.v2ray.core.common.protocol.ServerEndpointOrBuilder getServerOrBuilder(
                int index) {
            if (serverBuilder_ == null) {
                return server_.get(index);
            } else {
                return serverBuilder_.getMessageOrBuilder(index);
            }
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public java.util.List<? extends com.v2ray.core.common.protocol.ServerEndpointOrBuilder>
        getServerOrBuilderList() {
            if (serverBuilder_ != null) {
                return serverBuilder_.getMessageOrBuilderList();
            } else {
                return java.util.Collections.unmodifiableList(server_);
            }
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public com.v2ray.core.common.protocol.ServerEndpoint.Builder addServerBuilder() {
            return getServerFieldBuilder().addBuilder(
                    com.v2ray.core.common.protocol.ServerEndpoint.getDefaultInstance());
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public com.v2ray.core.common.protocol.ServerEndpoint.Builder addServerBuilder(
                int index) {
            return getServerFieldBuilder().addBuilder(
                    index, com.v2ray.core.common.protocol.ServerEndpoint.getDefaultInstance());
        }

        /**
         * <code>repeated .v2ray.core.common.protocol.ServerEndpoint server = 1;</code>
         */
        public java.util.List<com.v2ray.core.common.protocol.ServerEndpoint.Builder>
        getServerBuilderList() {
            return getServerFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<
                com.v2ray.core.common.protocol.ServerEndpoint, com.v2ray.core.common.protocol.ServerEndpoint.Builder, com.v2ray.core.common.protocol.ServerEndpointOrBuilder>
        getServerFieldBuilder() {
            if (serverBuilder_ == null) {
                serverBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                        com.v2ray.core.common.protocol.ServerEndpoint, com.v2ray.core.common.protocol.ServerEndpoint.Builder, com.v2ray.core.common.protocol.ServerEndpointOrBuilder>(
                        server_,
                        ((bitField0_ & 0x00000001) != 0),
                        getParentForChildren(),
                        isClean());
                server_ = null;
            }
            return serverBuilder_;
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


        // @@protoc_insertion_point(builder_scope:v2ray.core.proxy.socks.ClientConfig)
    }

    // @@protoc_insertion_point(class_scope:v2ray.core.proxy.socks.ClientConfig)
    private static final ClientConfig DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new ClientConfig();
    }

    public static ClientConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ClientConfig>
            PARSER = new com.google.protobuf.AbstractParser<ClientConfig>() {
        @Override
        public ClientConfig parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new ClientConfig(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<ClientConfig> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ClientConfig> getParserForType() {
        return PARSER;
    }

    @Override
    public ClientConfig getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}

