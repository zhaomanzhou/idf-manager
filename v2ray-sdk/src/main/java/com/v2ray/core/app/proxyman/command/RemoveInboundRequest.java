// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/proxyman/command/command.proto

package com.v2ray.core.app.proxyman.command;

/**
 * Protobuf type {@code v2ray.core.app.proxyman.command.RemoveInboundRequest}
 */
public final class RemoveInboundRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:v2ray.core.app.proxyman.command.RemoveInboundRequest)
        RemoveInboundRequestOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use RemoveInboundRequest.newBuilder() to construct.
    private RemoveInboundRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RemoveInboundRequest() {
        tag_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private RemoveInboundRequest(
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
                        String s = input.readStringRequireUtf8();

                        tag_ = s;
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
        return Command.internal_static_v2ray_core_app_proxyman_command_RemoveInboundRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return Command.internal_static_v2ray_core_app_proxyman_command_RemoveInboundRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        RemoveInboundRequest.class, Builder.class);
    }

    public static final int TAG_FIELD_NUMBER = 1;
    private volatile Object tag_;

    /**
     * <code>string tag = 1;</code>
     */
    public String getTag() {
        Object ref = tag_;
        if (ref instanceof String) {
            return (String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            String s = bs.toStringUtf8();
            tag_ = s;
            return s;
        }
    }

    /**
     * <code>string tag = 1;</code>
     */
    public com.google.protobuf.ByteString
    getTagBytes() {
        Object ref = tag_;
        if (ref instanceof String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (String) ref);
            tag_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
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
        if (!getTagBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, tag_);
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (!getTagBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, tag_);
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
        if (!(obj instanceof RemoveInboundRequest)) {
            return super.equals(obj);
        }
        RemoveInboundRequest other = (RemoveInboundRequest) obj;

        if (!getTag()
                .equals(other.getTag())) return false;
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
        hash = (37 * hash) + TAG_FIELD_NUMBER;
        hash = (53 * hash) + getTag().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static RemoveInboundRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RemoveInboundRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RemoveInboundRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RemoveInboundRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RemoveInboundRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RemoveInboundRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RemoveInboundRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static RemoveInboundRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static RemoveInboundRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static RemoveInboundRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static RemoveInboundRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static RemoveInboundRequest parseFrom(
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

    public static Builder newBuilder(RemoveInboundRequest prototype) {
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
     * Protobuf type {@code v2ray.core.app.proxyman.command.RemoveInboundRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:v2ray.core.app.proxyman.command.RemoveInboundRequest)
            RemoveInboundRequestOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return Command.internal_static_v2ray_core_app_proxyman_command_RemoveInboundRequest_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return Command.internal_static_v2ray_core_app_proxyman_command_RemoveInboundRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            RemoveInboundRequest.class, Builder.class);
        }

        // Construct using com.v2ray.core.app.proxyman.command.RemoveInboundRequest.newBuilder()
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
            tag_ = "";

            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return Command.internal_static_v2ray_core_app_proxyman_command_RemoveInboundRequest_descriptor;
        }

        @Override
        public RemoveInboundRequest getDefaultInstanceForType() {
            return RemoveInboundRequest.getDefaultInstance();
        }

        @Override
        public RemoveInboundRequest build() {
            RemoveInboundRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public RemoveInboundRequest buildPartial() {
            RemoveInboundRequest result = new RemoveInboundRequest(this);
            result.tag_ = tag_;
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
            if (other instanceof RemoveInboundRequest) {
                return mergeFrom((RemoveInboundRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(RemoveInboundRequest other) {
            if (other == RemoveInboundRequest.getDefaultInstance()) return this;
            if (!other.getTag().isEmpty()) {
                tag_ = other.tag_;
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
            RemoveInboundRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (RemoveInboundRequest) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private Object tag_ = "";

        /**
         * <code>string tag = 1;</code>
         */
        public String getTag() {
            Object ref = tag_;
            if (!(ref instanceof String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                tag_ = s;
                return s;
            } else {
                return (String) ref;
            }
        }

        /**
         * <code>string tag = 1;</code>
         */
        public com.google.protobuf.ByteString
        getTagBytes() {
            Object ref = tag_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                tag_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string tag = 1;</code>
         */
        public Builder setTag(
                String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            tag_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string tag = 1;</code>
         */
        public Builder clearTag() {

            tag_ = getDefaultInstance().getTag();
            onChanged();
            return this;
        }

        /**
         * <code>string tag = 1;</code>
         */
        public Builder setTagBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            tag_ = value;
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


        // @@protoc_insertion_point(builder_scope:v2ray.core.app.proxyman.command.RemoveInboundRequest)
    }

    // @@protoc_insertion_point(class_scope:v2ray.core.app.proxyman.command.RemoveInboundRequest)
    private static final RemoveInboundRequest DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new RemoveInboundRequest();
    }

    public static RemoveInboundRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RemoveInboundRequest>
            PARSER = new com.google.protobuf.AbstractParser<RemoveInboundRequest>() {
        @Override
        public RemoveInboundRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new RemoveInboundRequest(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<RemoveInboundRequest> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<RemoveInboundRequest> getParserForType() {
        return PARSER;
    }

    @Override
    public RemoveInboundRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}

