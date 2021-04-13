// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/policy/config.proto

package com.v2ray.core.app.policy;

/**
 * Protobuf type {@code v2ray.core.app.policy.Config}
 */
public final class Config extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:v2ray.core.app.policy.Config)
        ConfigOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use Config.newBuilder() to construct.
    private Config(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private Config() {
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
                    case 10: {
                        if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                            level_ = com.google.protobuf.MapField.newMapField(
                                    LevelDefaultEntryHolder.defaultEntry);
                            mutable_bitField0_ |= 0x00000001;
                        }
                        com.google.protobuf.MapEntry<Integer, Policy>
                                level__ = input.readMessage(
                                LevelDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                        level_.getMutableMap().put(
                                level__.getKey(), level__.getValue());
                        break;
                    }
                    case 18: {
                        SystemPolicy.Builder subBuilder = null;
                        if (system_ != null) {
                            subBuilder = system_.toBuilder();
                        }
                        system_ = input.readMessage(SystemPolicy.parser(), extensionRegistry);
                        if (subBuilder != null) {
                            subBuilder.mergeFrom(system_);
                            system_ = subBuilder.buildPartial();
                        }

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
        return ConfigOuterClass.internal_static_v2ray_core_app_policy_Config_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    @Override
    protected com.google.protobuf.MapField internalGetMapField(
            int number) {
        switch (number) {
            case 1:
                return internalGetLevel();
            default:
                throw new RuntimeException(
                        "Invalid map field number: " + number);
        }
    }

    @Override
    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return ConfigOuterClass.internal_static_v2ray_core_app_policy_Config_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        Config.class, Builder.class);
    }

    private int bitField0_;
    public static final int LEVEL_FIELD_NUMBER = 1;

    private static final class LevelDefaultEntryHolder {
        static final com.google.protobuf.MapEntry<
                Integer, Policy> defaultEntry =
                com.google.protobuf.MapEntry
                        .<Integer, Policy>newDefaultInstance(
                                ConfigOuterClass.internal_static_v2ray_core_app_policy_Config_LevelEntry_descriptor,
                                com.google.protobuf.WireFormat.FieldType.UINT32,
                                0,
                                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                                Policy.getDefaultInstance());
    }

    private com.google.protobuf.MapField<
            Integer, Policy> level_;

    private com.google.protobuf.MapField<Integer, Policy>
    internalGetLevel() {
        if (level_ == null) {
            return com.google.protobuf.MapField.emptyMapField(
                    LevelDefaultEntryHolder.defaultEntry);
        }
        return level_;
    }

    public int getLevelCount() {
        return internalGetLevel().getMap().size();
    }

    /**
     * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
     */

    public boolean containsLevel(
            int key) {

        return internalGetLevel().getMap().containsKey(key);
    }

    /**
     * Use {@link #getLevelMap()} instead.
     */
    @Deprecated
    public java.util.Map<Integer, Policy> getLevel() {
        return getLevelMap();
    }

    /**
     * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
     */

    public java.util.Map<Integer, Policy> getLevelMap() {
        return internalGetLevel().getMap();
    }

    /**
     * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
     */

    public Policy getLevelOrDefault(
            int key,
            Policy defaultValue) {

        java.util.Map<Integer, Policy> map =
                internalGetLevel().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    /**
     * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
     */

    public Policy getLevelOrThrow(
            int key) {

        java.util.Map<Integer, Policy> map =
                internalGetLevel().getMap();
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return map.get(key);
    }

    public static final int SYSTEM_FIELD_NUMBER = 2;
    private SystemPolicy system_;

    /**
     * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
     */
    public boolean hasSystem() {
        return system_ != null;
    }

    /**
     * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
     */
    public SystemPolicy getSystem() {
        return system_ == null ? SystemPolicy.getDefaultInstance() : system_;
    }

    /**
     * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
     */
    public SystemPolicyOrBuilder getSystemOrBuilder() {
        return getSystem();
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
        com.google.protobuf.GeneratedMessageV3
                .serializeIntegerMapTo(
                        output,
                        internalGetLevel(),
                        LevelDefaultEntryHolder.defaultEntry,
                        1);
        if (system_ != null) {
            output.writeMessage(2, getSystem());
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        for (java.util.Map.Entry<Integer, Policy> entry
                : internalGetLevel().getMap().entrySet()) {
            com.google.protobuf.MapEntry<Integer, Policy>
                    level__ = LevelDefaultEntryHolder.defaultEntry.newBuilderForType()
                    .setKey(entry.getKey())
                    .setValue(entry.getValue())
                    .build();
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(1, level__);
        }
        if (system_ != null) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(2, getSystem());
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

        if (!internalGetLevel().equals(
                other.internalGetLevel())) return false;
        if (hasSystem() != other.hasSystem()) return false;
        if (hasSystem()) {
            if (!getSystem()
                    .equals(other.getSystem())) return false;
        }
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
        if (!internalGetLevel().getMap().isEmpty()) {
            hash = (37 * hash) + LEVEL_FIELD_NUMBER;
            hash = (53 * hash) + internalGetLevel().hashCode();
        }
        if (hasSystem()) {
            hash = (37 * hash) + SYSTEM_FIELD_NUMBER;
            hash = (53 * hash) + getSystem().hashCode();
        }
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
     * Protobuf type {@code v2ray.core.app.policy.Config}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:v2ray.core.app.policy.Config)
            ConfigOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return ConfigOuterClass.internal_static_v2ray_core_app_policy_Config_descriptor;
        }

        @SuppressWarnings({"rawtypes"})
        protected com.google.protobuf.MapField internalGetMapField(
                int number) {
            switch (number) {
                case 1:
                    return internalGetLevel();
                default:
                    throw new RuntimeException(
                            "Invalid map field number: " + number);
            }
        }

        @SuppressWarnings({"rawtypes"})
        protected com.google.protobuf.MapField internalGetMutableMapField(
                int number) {
            switch (number) {
                case 1:
                    return internalGetMutableLevel();
                default:
                    throw new RuntimeException(
                            "Invalid map field number: " + number);
            }
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return ConfigOuterClass.internal_static_v2ray_core_app_policy_Config_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Config.class, Builder.class);
        }

        // Construct using com.v2ray.core.app.policy.Config.newBuilder()
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
            internalGetMutableLevel().clear();
            if (systemBuilder_ == null) {
                system_ = null;
            } else {
                system_ = null;
                systemBuilder_ = null;
            }
            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return ConfigOuterClass.internal_static_v2ray_core_app_policy_Config_descriptor;
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
            int from_bitField0_ = bitField0_;
            int to_bitField0_ = 0;
            result.level_ = internalGetLevel();
            result.level_.makeImmutable();
            if (systemBuilder_ == null) {
                result.system_ = system_;
            } else {
                result.system_ = systemBuilder_.build();
            }
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
            if (other instanceof Config) {
                return mergeFrom((Config) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(Config other) {
            if (other == Config.getDefaultInstance()) return this;
            internalGetMutableLevel().mergeFrom(
                    other.internalGetLevel());
            if (other.hasSystem()) {
                mergeSystem(other.getSystem());
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

        private int bitField0_;

        private com.google.protobuf.MapField<
                Integer, Policy> level_;

        private com.google.protobuf.MapField<Integer, Policy>
        internalGetLevel() {
            if (level_ == null) {
                return com.google.protobuf.MapField.emptyMapField(
                        LevelDefaultEntryHolder.defaultEntry);
            }
            return level_;
        }

        private com.google.protobuf.MapField<Integer, Policy>
        internalGetMutableLevel() {
            onChanged();
            ;
            if (level_ == null) {
                level_ = com.google.protobuf.MapField.newMapField(
                        LevelDefaultEntryHolder.defaultEntry);
            }
            if (!level_.isMutable()) {
                level_ = level_.copy();
            }
            return level_;
        }

        public int getLevelCount() {
            return internalGetLevel().getMap().size();
        }

        /**
         * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
         */

        public boolean containsLevel(
                int key) {

            return internalGetLevel().getMap().containsKey(key);
        }

        /**
         * Use {@link #getLevelMap()} instead.
         */
        @Deprecated
        public java.util.Map<Integer, Policy> getLevel() {
            return getLevelMap();
        }

        /**
         * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
         */

        public java.util.Map<Integer, Policy> getLevelMap() {
            return internalGetLevel().getMap();
        }

        /**
         * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
         */

        public Policy getLevelOrDefault(
                int key,
                Policy defaultValue) {

            java.util.Map<Integer, Policy> map =
                    internalGetLevel().getMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        /**
         * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
         */

        public Policy getLevelOrThrow(
                int key) {

            java.util.Map<Integer, Policy> map =
                    internalGetLevel().getMap();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key);
        }

        public Builder clearLevel() {
            internalGetMutableLevel().getMutableMap()
                    .clear();
            return this;
        }

        /**
         * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
         */

        public Builder removeLevel(
                int key) {

            internalGetMutableLevel().getMutableMap()
                    .remove(key);
            return this;
        }

        /**
         * Use alternate mutation accessors instead.
         */
        @Deprecated
        public java.util.Map<Integer, Policy>
        getMutableLevel() {
            return internalGetMutableLevel().getMutableMap();
        }

        /**
         * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
         */
        public Builder putLevel(
                int key,
                Policy value) {

            if (value == null) {
                throw new NullPointerException();
            }
            internalGetMutableLevel().getMutableMap()
                    .put(key, value);
            return this;
        }

        /**
         * <code>map&lt;uint32, .v2ray.core.app.policy.Policy&gt; level = 1;</code>
         */

        public Builder putAllLevel(
                java.util.Map<Integer, Policy> values) {
            internalGetMutableLevel().getMutableMap()
                    .putAll(values);
            return this;
        }

        private SystemPolicy system_;
        private com.google.protobuf.SingleFieldBuilderV3<
                SystemPolicy, SystemPolicy.Builder, SystemPolicyOrBuilder> systemBuilder_;

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public boolean hasSystem() {
            return systemBuilder_ != null || system_ != null;
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public SystemPolicy getSystem() {
            if (systemBuilder_ == null) {
                return system_ == null ? SystemPolicy.getDefaultInstance() : system_;
            } else {
                return systemBuilder_.getMessage();
            }
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public Builder setSystem(SystemPolicy value) {
            if (systemBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                system_ = value;
                onChanged();
            } else {
                systemBuilder_.setMessage(value);
            }

            return this;
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public Builder setSystem(
                SystemPolicy.Builder builderForValue) {
            if (systemBuilder_ == null) {
                system_ = builderForValue.build();
                onChanged();
            } else {
                systemBuilder_.setMessage(builderForValue.build());
            }

            return this;
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public Builder mergeSystem(SystemPolicy value) {
            if (systemBuilder_ == null) {
                if (system_ != null) {
                    system_ =
                            SystemPolicy.newBuilder(system_).mergeFrom(value).buildPartial();
                } else {
                    system_ = value;
                }
                onChanged();
            } else {
                systemBuilder_.mergeFrom(value);
            }

            return this;
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public Builder clearSystem() {
            if (systemBuilder_ == null) {
                system_ = null;
                onChanged();
            } else {
                system_ = null;
                systemBuilder_ = null;
            }

            return this;
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public SystemPolicy.Builder getSystemBuilder() {

            onChanged();
            return getSystemFieldBuilder().getBuilder();
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        public SystemPolicyOrBuilder getSystemOrBuilder() {
            if (systemBuilder_ != null) {
                return systemBuilder_.getMessageOrBuilder();
            } else {
                return system_ == null ?
                        SystemPolicy.getDefaultInstance() : system_;
            }
        }

        /**
         * <code>.v2ray.core.app.policy.SystemPolicy system = 2;</code>
         */
        private com.google.protobuf.SingleFieldBuilderV3<
                SystemPolicy, SystemPolicy.Builder, SystemPolicyOrBuilder>
        getSystemFieldBuilder() {
            if (systemBuilder_ == null) {
                systemBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                        SystemPolicy, SystemPolicy.Builder, SystemPolicyOrBuilder>(
                        getSystem(),
                        getParentForChildren(),
                        isClean());
                system_ = null;
            }
            return systemBuilder_;
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


        // @@protoc_insertion_point(builder_scope:v2ray.core.app.policy.Config)
    }

    // @@protoc_insertion_point(class_scope:v2ray.core.app.policy.Config)
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
