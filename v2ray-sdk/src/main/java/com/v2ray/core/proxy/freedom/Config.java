// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/proxy/freedom/config.proto

package com.v2ray.core.proxy.freedom;

/**
 * Protobuf type {@code v2ray.core.proxy.freedom.Config}
 */
public final class Config extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:v2ray.core.proxy.freedom.Config)
        ConfigOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use Config.newBuilder() to construct.
    private Config(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private Config() {
        domainStrategy_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private Config(
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
                        int rawValue = input.readEnum();

                        domainStrategy_ = rawValue;
                        break;
                    }
                    case 16: {

                        timeout_ = input.readUInt32();
                        break;
                    }
                    case 26: {
                        DestinationOverride.Builder subBuilder = null;
                        if (destinationOverride_ != null) {
                            subBuilder = destinationOverride_.toBuilder();
                        }
                        destinationOverride_ = input.readMessage(DestinationOverride.parser(), extensionRegistry);
                        if (subBuilder != null) {
                            subBuilder.mergeFrom(destinationOverride_);
                            destinationOverride_ = subBuilder.buildPartial();
                        }

                        break;
                    }
                    case 32: {

                        userLevel_ = input.readUInt32();
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
        return ConfigOuterClass.internal_static_v2ray_core_proxy_freedom_Config_descriptor;
    }

    @Override
    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return ConfigOuterClass.internal_static_v2ray_core_proxy_freedom_Config_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        Config.class, Builder.class);
    }

    /**
     * Protobuf enum {@code v2ray.core.proxy.freedom.Config.DomainStrategy}
     */
    public enum DomainStrategy
            implements com.google.protobuf.ProtocolMessageEnum {
        /**
         * <code>AS_IS = 0;</code>
         */
        AS_IS(0),
        /**
         * <code>USE_IP = 1;</code>
         */
        USE_IP(1),
        UNRECOGNIZED(-1),
        ;

        /**
         * <code>AS_IS = 0;</code>
         */
        public static final int AS_IS_VALUE = 0;
        /**
         * <code>USE_IP = 1;</code>
         */
        public static final int USE_IP_VALUE = 1;


        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException(
                        "Can't get the number of an unknown enum value.");
            }
            return value;
        }

        /**
         * @deprecated Use {@link #forNumber(int)} instead.
         */
        @Deprecated
        public static DomainStrategy valueOf(int value) {
            return forNumber(value);
        }

        public static DomainStrategy forNumber(int value) {
            switch (value) {
                case 0:
                    return AS_IS;
                case 1:
                    return USE_IP;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<DomainStrategy>
        internalGetValueMap() {
            return internalValueMap;
        }

        private static final com.google.protobuf.Internal.EnumLiteMap<
                DomainStrategy> internalValueMap =
                new com.google.protobuf.Internal.EnumLiteMap<DomainStrategy>() {
                    public DomainStrategy findValueByNumber(int number) {
                        return DomainStrategy.forNumber(number);
                    }
                };

        public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
            return Config.getDescriptor().getEnumTypes().get(0);
        }

        private static final DomainStrategy[] VALUES = values();

        public static DomainStrategy valueOf(
                com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException(
                        "EnumValueDescriptor is not for this type.");
            }
            if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[desc.getIndex()];
        }

        private final int value;

        private DomainStrategy(int value) {
            this.value = value;
        }

        // @@protoc_insertion_point(enum_scope:v2ray.core.proxy.freedom.Config.DomainStrategy)
    }

    public static final int DOMAIN_STRATEGY_FIELD_NUMBER = 1;
    private int domainStrategy_;

    /**
     * <code>.v2ray.core.proxy.freedom.Config.DomainStrategy domain_strategy = 1;</code>
     */
    public int getDomainStrategyValue() {
        return domainStrategy_;
    }

    /**
     * <code>.v2ray.core.proxy.freedom.Config.DomainStrategy domain_strategy = 1;</code>
     */
    public DomainStrategy getDomainStrategy() {
        @SuppressWarnings("deprecation")
        DomainStrategy result = DomainStrategy.valueOf(domainStrategy_);
        return result == null ? DomainStrategy.UNRECOGNIZED : result;
    }

    public static final int TIMEOUT_FIELD_NUMBER = 2;
    private int timeout_;

    /**
     * <code>uint32 timeout = 2 [deprecated = true];</code>
     */
    @Deprecated
    public int getTimeout() {
        return timeout_;
    }

    public static final int DESTINATION_OVERRIDE_FIELD_NUMBER = 3;
    private DestinationOverride destinationOverride_;

    /**
     * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
     */
    public boolean hasDestinationOverride() {
        return destinationOverride_ != null;
    }

    /**
     * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
     */
    public DestinationOverride getDestinationOverride() {
        return destinationOverride_ == null ? DestinationOverride.getDefaultInstance() : destinationOverride_;
    }

    /**
     * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
     */
    public DestinationOverrideOrBuilder getDestinationOverrideOrBuilder() {
        return getDestinationOverride();
    }

    public static final int USER_LEVEL_FIELD_NUMBER = 4;
    private int userLevel_;

    /**
     * <code>uint32 user_level = 4;</code>
     */
    public int getUserLevel() {
        return userLevel_;
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
        if (domainStrategy_ != DomainStrategy.AS_IS.getNumber()) {
            output.writeEnum(1, domainStrategy_);
        }
        if (timeout_ != 0) {
            output.writeUInt32(2, timeout_);
        }
        if (destinationOverride_ != null) {
            output.writeMessage(3, getDestinationOverride());
        }
        if (userLevel_ != 0) {
            output.writeUInt32(4, userLevel_);
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (domainStrategy_ != DomainStrategy.AS_IS.getNumber()) {
            size += com.google.protobuf.CodedOutputStream
                    .computeEnumSize(1, domainStrategy_);
        }
        if (timeout_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(2, timeout_);
        }
        if (destinationOverride_ != null) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(3, getDestinationOverride());
        }
        if (userLevel_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(4, userLevel_);
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
        if (!(obj instanceof Config)) {
            return super.equals(obj);
        }
        Config other = (Config) obj;

        if (domainStrategy_ != other.domainStrategy_) return false;
        if (getTimeout()
                != other.getTimeout()) return false;
        if (hasDestinationOverride() != other.hasDestinationOverride()) return false;
        if (hasDestinationOverride()) {
            if (!getDestinationOverride()
                    .equals(other.getDestinationOverride())) return false;
        }
        if (getUserLevel()
                != other.getUserLevel()) return false;
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
        hash = (37 * hash) + DOMAIN_STRATEGY_FIELD_NUMBER;
        hash = (53 * hash) + domainStrategy_;
        hash = (37 * hash) + TIMEOUT_FIELD_NUMBER;
        hash = (53 * hash) + getTimeout();
        if (hasDestinationOverride()) {
            hash = (37 * hash) + DESTINATION_OVERRIDE_FIELD_NUMBER;
            hash = (53 * hash) + getDestinationOverride().hashCode();
        }
        hash = (37 * hash) + USER_LEVEL_FIELD_NUMBER;
        hash = (53 * hash) + getUserLevel();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static Config parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Config parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Config parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Config parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Config parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Config parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Config parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static Config parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Config parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static Config parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Config parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static Config parseFrom(
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

    public static Builder newBuilder(Config prototype) {
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
     * Protobuf type {@code v2ray.core.proxy.freedom.Config}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:v2ray.core.proxy.freedom.Config)
            ConfigOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return ConfigOuterClass.internal_static_v2ray_core_proxy_freedom_Config_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return ConfigOuterClass.internal_static_v2ray_core_proxy_freedom_Config_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Config.class, Builder.class);
        }

        // Construct using com.v2ray.core.proxy.freedom.Config.newBuilder()
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
            domainStrategy_ = 0;

            timeout_ = 0;

            if (destinationOverrideBuilder_ == null) {
                destinationOverride_ = null;
            } else {
                destinationOverride_ = null;
                destinationOverrideBuilder_ = null;
            }
            userLevel_ = 0;

            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return ConfigOuterClass.internal_static_v2ray_core_proxy_freedom_Config_descriptor;
        }

        @Override
        public Config getDefaultInstanceForType() {
            return Config.getDefaultInstance();
        }

        @Override
        public Config build() {
            Config result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public Config buildPartial() {
            Config result = new Config(this);
            result.domainStrategy_ = domainStrategy_;
            result.timeout_ = timeout_;
            if (destinationOverrideBuilder_ == null) {
                result.destinationOverride_ = destinationOverride_;
            } else {
                result.destinationOverride_ = destinationOverrideBuilder_.build();
            }
            result.userLevel_ = userLevel_;
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
            if (other instanceof Config) {
                return mergeFrom((Config) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(Config other) {
            if (other == Config.getDefaultInstance()) return this;
            if (other.domainStrategy_ != 0) {
                setDomainStrategyValue(other.getDomainStrategyValue());
            }
            if (other.getTimeout() != 0) {
                setTimeout(other.getTimeout());
            }
            if (other.hasDestinationOverride()) {
                mergeDestinationOverride(other.getDestinationOverride());
            }
            if (other.getUserLevel() != 0) {
                setUserLevel(other.getUserLevel());
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
            Config parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (Config) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int domainStrategy_ = 0;

        /**
         * <code>.v2ray.core.proxy.freedom.Config.DomainStrategy domain_strategy = 1;</code>
         */
        public int getDomainStrategyValue() {
            return domainStrategy_;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.Config.DomainStrategy domain_strategy = 1;</code>
         */
        public Builder setDomainStrategyValue(int value) {
            domainStrategy_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.Config.DomainStrategy domain_strategy = 1;</code>
         */
        public DomainStrategy getDomainStrategy() {
            @SuppressWarnings("deprecation")
            DomainStrategy result = DomainStrategy.valueOf(domainStrategy_);
            return result == null ? DomainStrategy.UNRECOGNIZED : result;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.Config.DomainStrategy domain_strategy = 1;</code>
         */
        public Builder setDomainStrategy(DomainStrategy value) {
            if (value == null) {
                throw new NullPointerException();
            }

            domainStrategy_ = value.getNumber();
            onChanged();
            return this;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.Config.DomainStrategy domain_strategy = 1;</code>
         */
        public Builder clearDomainStrategy() {

            domainStrategy_ = 0;
            onChanged();
            return this;
        }

        private int timeout_;

        /**
         * <code>uint32 timeout = 2 [deprecated = true];</code>
         */
        @Deprecated
        public int getTimeout() {
            return timeout_;
        }

        /**
         * <code>uint32 timeout = 2 [deprecated = true];</code>
         */
        @Deprecated
        public Builder setTimeout(int value) {

            timeout_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint32 timeout = 2 [deprecated = true];</code>
         */
        @Deprecated
        public Builder clearTimeout() {

            timeout_ = 0;
            onChanged();
            return this;
        }

        private DestinationOverride destinationOverride_;
        private com.google.protobuf.SingleFieldBuilderV3<
                DestinationOverride, DestinationOverride.Builder, DestinationOverrideOrBuilder> destinationOverrideBuilder_;

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public boolean hasDestinationOverride() {
            return destinationOverrideBuilder_ != null || destinationOverride_ != null;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public DestinationOverride getDestinationOverride() {
            if (destinationOverrideBuilder_ == null) {
                return destinationOverride_ == null ? DestinationOverride.getDefaultInstance() : destinationOverride_;
            } else {
                return destinationOverrideBuilder_.getMessage();
            }
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public Builder setDestinationOverride(DestinationOverride value) {
            if (destinationOverrideBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                destinationOverride_ = value;
                onChanged();
            } else {
                destinationOverrideBuilder_.setMessage(value);
            }

            return this;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public Builder setDestinationOverride(
                DestinationOverride.Builder builderForValue) {
            if (destinationOverrideBuilder_ == null) {
                destinationOverride_ = builderForValue.build();
                onChanged();
            } else {
                destinationOverrideBuilder_.setMessage(builderForValue.build());
            }

            return this;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public Builder mergeDestinationOverride(DestinationOverride value) {
            if (destinationOverrideBuilder_ == null) {
                if (destinationOverride_ != null) {
                    destinationOverride_ =
                            DestinationOverride.newBuilder(destinationOverride_).mergeFrom(value).buildPartial();
                } else {
                    destinationOverride_ = value;
                }
                onChanged();
            } else {
                destinationOverrideBuilder_.mergeFrom(value);
            }

            return this;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public Builder clearDestinationOverride() {
            if (destinationOverrideBuilder_ == null) {
                destinationOverride_ = null;
                onChanged();
            } else {
                destinationOverride_ = null;
                destinationOverrideBuilder_ = null;
            }

            return this;
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public DestinationOverride.Builder getDestinationOverrideBuilder() {

            onChanged();
            return getDestinationOverrideFieldBuilder().getBuilder();
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        public DestinationOverrideOrBuilder getDestinationOverrideOrBuilder() {
            if (destinationOverrideBuilder_ != null) {
                return destinationOverrideBuilder_.getMessageOrBuilder();
            } else {
                return destinationOverride_ == null ?
                        DestinationOverride.getDefaultInstance() : destinationOverride_;
            }
        }

        /**
         * <code>.v2ray.core.proxy.freedom.DestinationOverride destination_override = 3;</code>
         */
        private com.google.protobuf.SingleFieldBuilderV3<
                DestinationOverride, DestinationOverride.Builder, DestinationOverrideOrBuilder>
        getDestinationOverrideFieldBuilder() {
            if (destinationOverrideBuilder_ == null) {
                destinationOverrideBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                        DestinationOverride, DestinationOverride.Builder, DestinationOverrideOrBuilder>(
                        getDestinationOverride(),
                        getParentForChildren(),
                        isClean());
                destinationOverride_ = null;
            }
            return destinationOverrideBuilder_;
        }

        private int userLevel_;

        /**
         * <code>uint32 user_level = 4;</code>
         */
        public int getUserLevel() {
            return userLevel_;
        }

        /**
         * <code>uint32 user_level = 4;</code>
         */
        public Builder setUserLevel(int value) {

            userLevel_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint32 user_level = 4;</code>
         */
        public Builder clearUserLevel() {

            userLevel_ = 0;
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


        // @@protoc_insertion_point(builder_scope:v2ray.core.proxy.freedom.Config)
    }

    // @@protoc_insertion_point(class_scope:v2ray.core.proxy.freedom.Config)
    private static final Config DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new Config();
    }

    public static Config getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Config>
            PARSER = new com.google.protobuf.AbstractParser<Config>() {
        @Override
        public Config parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new Config(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<Config> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Config> getParserForType() {
        return PARSER;
    }

    @Override
    public Config getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}

