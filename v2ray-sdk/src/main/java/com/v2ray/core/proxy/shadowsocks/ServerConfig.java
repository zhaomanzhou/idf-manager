// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/proxy/shadowsocks/config.proto

package com.v2ray.core.proxy.shadowsocks;

/**
 * Protobuf type {@code v2ray.core.proxy.shadowsocks.ServerConfig}
 */
public final class ServerConfig extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:v2ray.core.proxy.shadowsocks.ServerConfig)
        ServerConfigOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use ServerConfig.newBuilder() to construct.
    private ServerConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private ServerConfig() {
        network_ = java.util.Collections.emptyList();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private ServerConfig(
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

                        udpEnabled_ = input.readBool();
                        break;
                    }
                    case 18: {
                        com.v2ray.core.common.protocol.User.Builder subBuilder = null;
                        if (user_ != null) {
                            subBuilder = user_.toBuilder();
                        }
                        user_ = input.readMessage(com.v2ray.core.common.protocol.User.parser(), extensionRegistry);
                        if (subBuilder != null) {
                            subBuilder.mergeFrom(user_);
                            user_ = subBuilder.buildPartial();
                        }

                        break;
                    }
                    case 24: {
                        int rawValue = input.readEnum();
                        if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                            network_ = new java.util.ArrayList<Integer>();
                            mutable_bitField0_ |= 0x00000004;
                        }
                        network_.add(rawValue);
                        break;
                    }
                    case 26: {
                        int length = input.readRawVarint32();
                        int oldLimit = input.pushLimit(length);
                        while (input.getBytesUntilLimit() > 0) {
                            int rawValue = input.readEnum();
                            if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                                network_ = new java.util.ArrayList<Integer>();
                                mutable_bitField0_ |= 0x00000004;
                            }
                            network_.add(rawValue);
                        }
                        input.popLimit(oldLimit);
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
            if (((mutable_bitField0_ & 0x00000004) != 0)) {
                network_ = java.util.Collections.unmodifiableList(network_);
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return Config.internal_static_v2ray_core_proxy_shadowsocks_ServerConfig_descriptor;
    }

    @Override
    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return Config.internal_static_v2ray_core_proxy_shadowsocks_ServerConfig_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        ServerConfig.class, Builder.class);
    }

    private int bitField0_;
    public static final int UDP_ENABLED_FIELD_NUMBER = 1;
    private boolean udpEnabled_;

    /**
     * <pre>
     * UdpEnabled specified whether or not to enable UDP for Shadowsocks.
     * Deprecated. Use 'network' field.
     * </pre>
     *
     * <code>bool udp_enabled = 1 [deprecated = true];</code>
     */
    @Deprecated
    public boolean getUdpEnabled() {
        return udpEnabled_;
    }

    public static final int USER_FIELD_NUMBER = 2;
    private com.v2ray.core.common.protocol.User user_;

    /**
     * <code>.v2ray.core.common.protocol.User user = 2;</code>
     */
    public boolean hasUser() {
        return user_ != null;
    }

    /**
     * <code>.v2ray.core.common.protocol.User user = 2;</code>
     */
    public com.v2ray.core.common.protocol.User getUser() {
        return user_ == null ? com.v2ray.core.common.protocol.User.getDefaultInstance() : user_;
    }

    /**
     * <code>.v2ray.core.common.protocol.User user = 2;</code>
     */
    public com.v2ray.core.common.protocol.UserOrBuilder getUserOrBuilder() {
        return getUser();
    }

    public static final int NETWORK_FIELD_NUMBER = 3;
    private java.util.List<Integer> network_;
    private static final com.google.protobuf.Internal.ListAdapter.Converter<
            Integer, com.v2ray.core.common.net.Network> network_converter_ =
            new com.google.protobuf.Internal.ListAdapter.Converter<
                    Integer, com.v2ray.core.common.net.Network>() {
                public com.v2ray.core.common.net.Network convert(Integer from) {
                    @SuppressWarnings("deprecation")
                    com.v2ray.core.common.net.Network result = com.v2ray.core.common.net.Network.valueOf(from);
                    return result == null ? com.v2ray.core.common.net.Network.UNRECOGNIZED : result;
                }
            };

    /**
     * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
     */
    public java.util.List<com.v2ray.core.common.net.Network> getNetworkList() {
        return new com.google.protobuf.Internal.ListAdapter<
                Integer, com.v2ray.core.common.net.Network>(network_, network_converter_);
    }

    /**
     * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
     */
    public int getNetworkCount() {
        return network_.size();
    }

    /**
     * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
     */
    public com.v2ray.core.common.net.Network getNetwork(int index) {
        return network_converter_.convert(network_.get(index));
    }

    /**
     * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
     */
    public java.util.List<Integer>
    getNetworkValueList() {
        return network_;
    }

    /**
     * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
     */
    public int getNetworkValue(int index) {
        return network_.get(index);
    }

    private int networkMemoizedSerializedSize;

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
        getSerializedSize();
        if (udpEnabled_ != false) {
            output.writeBool(1, udpEnabled_);
        }
        if (user_ != null) {
            output.writeMessage(2, getUser());
        }
        if (getNetworkList().size() > 0) {
            output.writeUInt32NoTag(26);
            output.writeUInt32NoTag(networkMemoizedSerializedSize);
        }
        for (int i = 0; i < network_.size(); i++) {
            output.writeEnumNoTag(network_.get(i));
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (udpEnabled_ != false) {
            size += com.google.protobuf.CodedOutputStream
                    .computeBoolSize(1, udpEnabled_);
        }
        if (user_ != null) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(2, getUser());
        }
        {
            int dataSize = 0;
            for (int i = 0; i < network_.size(); i++) {
                dataSize += com.google.protobuf.CodedOutputStream
                        .computeEnumSizeNoTag(network_.get(i));
            }
            size += dataSize;
            if (!getNetworkList().isEmpty()) {
                size += 1;
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt32SizeNoTag(dataSize);
            }
            networkMemoizedSerializedSize = dataSize;
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
        if (!(obj instanceof ServerConfig)) {
            return super.equals(obj);
        }
        ServerConfig other = (ServerConfig) obj;

        if (getUdpEnabled()
                != other.getUdpEnabled()) return false;
        if (hasUser() != other.hasUser()) return false;
        if (hasUser()) {
            if (!getUser()
                    .equals(other.getUser())) return false;
        }
        if (!network_.equals(other.network_)) return false;
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
        hash = (37 * hash) + UDP_ENABLED_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
                getUdpEnabled());
        if (hasUser()) {
            hash = (37 * hash) + USER_FIELD_NUMBER;
            hash = (53 * hash) + getUser().hashCode();
        }
        if (getNetworkCount() > 0) {
            hash = (37 * hash) + NETWORK_FIELD_NUMBER;
            hash = (53 * hash) + network_.hashCode();
        }
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static ServerConfig parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ServerConfig parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ServerConfig parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ServerConfig parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ServerConfig parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ServerConfig parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ServerConfig parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static ServerConfig parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static ServerConfig parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static ServerConfig parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static ServerConfig parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static ServerConfig parseFrom(
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

    public static Builder newBuilder(ServerConfig prototype) {
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
     * Protobuf type {@code v2ray.core.proxy.shadowsocks.ServerConfig}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:v2ray.core.proxy.shadowsocks.ServerConfig)
            ServerConfigOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return Config.internal_static_v2ray_core_proxy_shadowsocks_ServerConfig_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return Config.internal_static_v2ray_core_proxy_shadowsocks_ServerConfig_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            ServerConfig.class, Builder.class);
        }

        // Construct using com.v2ray.core.proxy.shadowsocks.ServerConfig.newBuilder()
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
            udpEnabled_ = false;

            if (userBuilder_ == null) {
                user_ = null;
            } else {
                user_ = null;
                userBuilder_ = null;
            }
            network_ = java.util.Collections.emptyList();
            bitField0_ = (bitField0_ & ~0x00000004);
            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return Config.internal_static_v2ray_core_proxy_shadowsocks_ServerConfig_descriptor;
        }

        @Override
        public ServerConfig getDefaultInstanceForType() {
            return ServerConfig.getDefaultInstance();
        }

        @Override
        public ServerConfig build() {
            ServerConfig result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public ServerConfig buildPartial() {
            ServerConfig result = new ServerConfig(this);
            int from_bitField0_ = bitField0_;
            int to_bitField0_ = 0;
            result.udpEnabled_ = udpEnabled_;
            if (userBuilder_ == null) {
                result.user_ = user_;
            } else {
                result.user_ = userBuilder_.build();
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                network_ = java.util.Collections.unmodifiableList(network_);
                bitField0_ = (bitField0_ & ~0x00000004);
            }
            result.network_ = network_;
            result.bitField0_ = to_bitField0_;
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
            if (other instanceof ServerConfig) {
                return mergeFrom((ServerConfig) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(ServerConfig other) {
            if (other == ServerConfig.getDefaultInstance()) return this;
            if (other.getUdpEnabled() != false) {
                setUdpEnabled(other.getUdpEnabled());
            }
            if (other.hasUser()) {
                mergeUser(other.getUser());
            }
            if (!other.network_.isEmpty()) {
                if (network_.isEmpty()) {
                    network_ = other.network_;
                    bitField0_ = (bitField0_ & ~0x00000004);
                } else {
                    ensureNetworkIsMutable();
                    network_.addAll(other.network_);
                }
                onChanged();
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
            ServerConfig parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (ServerConfig) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int bitField0_;

        private boolean udpEnabled_;

        /**
         * <pre>
         * UdpEnabled specified whether or not to enable UDP for Shadowsocks.
         * Deprecated. Use 'network' field.
         * </pre>
         *
         * <code>bool udp_enabled = 1 [deprecated = true];</code>
         */
        @Deprecated
        public boolean getUdpEnabled() {
            return udpEnabled_;
        }

        /**
         * <pre>
         * UdpEnabled specified whether or not to enable UDP for Shadowsocks.
         * Deprecated. Use 'network' field.
         * </pre>
         *
         * <code>bool udp_enabled = 1 [deprecated = true];</code>
         */
        @Deprecated
        public Builder setUdpEnabled(boolean value) {

            udpEnabled_ = value;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * UdpEnabled specified whether or not to enable UDP for Shadowsocks.
         * Deprecated. Use 'network' field.
         * </pre>
         *
         * <code>bool udp_enabled = 1 [deprecated = true];</code>
         */
        @Deprecated
        public Builder clearUdpEnabled() {

            udpEnabled_ = false;
            onChanged();
            return this;
        }

        private com.v2ray.core.common.protocol.User user_;
        private com.google.protobuf.SingleFieldBuilderV3<
                com.v2ray.core.common.protocol.User, com.v2ray.core.common.protocol.User.Builder, com.v2ray.core.common.protocol.UserOrBuilder> userBuilder_;

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public boolean hasUser() {
            return userBuilder_ != null || user_ != null;
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public com.v2ray.core.common.protocol.User getUser() {
            if (userBuilder_ == null) {
                return user_ == null ? com.v2ray.core.common.protocol.User.getDefaultInstance() : user_;
            } else {
                return userBuilder_.getMessage();
            }
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public Builder setUser(com.v2ray.core.common.protocol.User value) {
            if (userBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                user_ = value;
                onChanged();
            } else {
                userBuilder_.setMessage(value);
            }

            return this;
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public Builder setUser(
                com.v2ray.core.common.protocol.User.Builder builderForValue) {
            if (userBuilder_ == null) {
                user_ = builderForValue.build();
                onChanged();
            } else {
                userBuilder_.setMessage(builderForValue.build());
            }

            return this;
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public Builder mergeUser(com.v2ray.core.common.protocol.User value) {
            if (userBuilder_ == null) {
                if (user_ != null) {
                    user_ =
                            com.v2ray.core.common.protocol.User.newBuilder(user_).mergeFrom(value).buildPartial();
                } else {
                    user_ = value;
                }
                onChanged();
            } else {
                userBuilder_.mergeFrom(value);
            }

            return this;
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public Builder clearUser() {
            if (userBuilder_ == null) {
                user_ = null;
                onChanged();
            } else {
                user_ = null;
                userBuilder_ = null;
            }

            return this;
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public com.v2ray.core.common.protocol.User.Builder getUserBuilder() {

            onChanged();
            return getUserFieldBuilder().getBuilder();
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        public com.v2ray.core.common.protocol.UserOrBuilder getUserOrBuilder() {
            if (userBuilder_ != null) {
                return userBuilder_.getMessageOrBuilder();
            } else {
                return user_ == null ?
                        com.v2ray.core.common.protocol.User.getDefaultInstance() : user_;
            }
        }

        /**
         * <code>.v2ray.core.common.protocol.User user = 2;</code>
         */
        private com.google.protobuf.SingleFieldBuilderV3<
                com.v2ray.core.common.protocol.User, com.v2ray.core.common.protocol.User.Builder, com.v2ray.core.common.protocol.UserOrBuilder>
        getUserFieldBuilder() {
            if (userBuilder_ == null) {
                userBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                        com.v2ray.core.common.protocol.User, com.v2ray.core.common.protocol.User.Builder, com.v2ray.core.common.protocol.UserOrBuilder>(
                        getUser(),
                        getParentForChildren(),
                        isClean());
                user_ = null;
            }
            return userBuilder_;
        }

        private java.util.List<Integer> network_ =
                java.util.Collections.emptyList();

        private void ensureNetworkIsMutable() {
            if (!((bitField0_ & 0x00000004) != 0)) {
                network_ = new java.util.ArrayList<Integer>(network_);
                bitField0_ |= 0x00000004;
            }
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public java.util.List<com.v2ray.core.common.net.Network> getNetworkList() {
            return new com.google.protobuf.Internal.ListAdapter<
                    Integer, com.v2ray.core.common.net.Network>(network_, network_converter_);
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public int getNetworkCount() {
            return network_.size();
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public com.v2ray.core.common.net.Network getNetwork(int index) {
            return network_converter_.convert(network_.get(index));
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public Builder setNetwork(
                int index, com.v2ray.core.common.net.Network value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ensureNetworkIsMutable();
            network_.set(index, value.getNumber());
            onChanged();
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public Builder addNetwork(com.v2ray.core.common.net.Network value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ensureNetworkIsMutable();
            network_.add(value.getNumber());
            onChanged();
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public Builder addAllNetwork(
                Iterable<? extends com.v2ray.core.common.net.Network> values) {
            ensureNetworkIsMutable();
            for (com.v2ray.core.common.net.Network value : values) {
                network_.add(value.getNumber());
            }
            onChanged();
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public Builder clearNetwork() {
            network_ = java.util.Collections.emptyList();
            bitField0_ = (bitField0_ & ~0x00000004);
            onChanged();
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public java.util.List<Integer>
        getNetworkValueList() {
            return java.util.Collections.unmodifiableList(network_);
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public int getNetworkValue(int index) {
            return network_.get(index);
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public Builder setNetworkValue(
                int index, int value) {
            ensureNetworkIsMutable();
            network_.set(index, value);
            onChanged();
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public Builder addNetworkValue(int value) {
            ensureNetworkIsMutable();
            network_.add(value);
            onChanged();
            return this;
        }

        /**
         * <code>repeated .v2ray.core.common.net.Network network = 3;</code>
         */
        public Builder addAllNetworkValue(
                Iterable<Integer> values) {
            ensureNetworkIsMutable();
            for (int value : values) {
                network_.add(value);
            }
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


        // @@protoc_insertion_point(builder_scope:v2ray.core.proxy.shadowsocks.ServerConfig)
    }

    // @@protoc_insertion_point(class_scope:v2ray.core.proxy.shadowsocks.ServerConfig)
    private static final ServerConfig DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new ServerConfig();
    }

    public static ServerConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ServerConfig>
            PARSER = new com.google.protobuf.AbstractParser<ServerConfig>() {
        @Override
        public ServerConfig parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new ServerConfig(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<ServerConfig> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ServerConfig> getParserForType() {
        return PARSER;
    }

    @Override
    public ServerConfig getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
