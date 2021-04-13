// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/transport/internet/http/config.proto

package com.v2ray.core.transport.internet.http;

/**
 * Protobuf type {@code v2ray.core.transport.internet.http.Config}
 */
public  final class Config extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:v2ray.core.transport.internet.http.Config)
    ConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Config.newBuilder() to construct.
  private Config(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Config() {
    host_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    path_ = "";
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
            String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              host_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            host_.add(s);
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            path_ = s;
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
        host_ = host_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ConfigOuterClass.internal_static_v2ray_core_transport_internet_http_Config_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ConfigOuterClass.internal_static_v2ray_core_transport_internet_http_Config_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Config.class, Builder.class);
  }

  private int bitField0_;
  public static final int HOST_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList host_;
  /**
   * <code>repeated string host = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getHostList() {
    return host_;
  }
  /**
   * <code>repeated string host = 1;</code>
   */
  public int getHostCount() {
    return host_.size();
  }
  /**
   * <code>repeated string host = 1;</code>
   */
  public String getHost(int index) {
    return host_.get(index);
  }
  /**
   * <code>repeated string host = 1;</code>
   */
  public com.google.protobuf.ByteString
      getHostBytes(int index) {
    return host_.getByteString(index);
  }

  public static final int PATH_FIELD_NUMBER = 2;
  private volatile Object path_;
  /**
   * <code>string path = 2;</code>
   */
  public String getPath() {
    Object ref = path_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      path_ = s;
      return s;
    }
  }
  /**
   * <code>string path = 2;</code>
   */
  public com.google.protobuf.ByteString
      getPathBytes() {
    Object ref = path_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      path_ = b;
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
    for (int i = 0; i < host_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, host_.getRaw(i));
    }
    if (!getPathBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, path_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < host_.size(); i++) {
        dataSize += computeStringSizeNoTag(host_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getHostList().size();
    }
    if (!getPathBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, path_);
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

    if (!getHostList()
        .equals(other.getHostList())) return false;
    if (!getPath()
        .equals(other.getPath())) return false;
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
    if (getHostCount() > 0) {
      hash = (37 * hash) + HOST_FIELD_NUMBER;
      hash = (53 * hash) + getHostList().hashCode();
    }
    hash = (37 * hash) + PATH_FIELD_NUMBER;
    hash = (53 * hash) + getPath().hashCode();
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
  public Builder newBuilderForType() { return newBuilder(); }
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
   * Protobuf type {@code v2ray.core.transport.internet.http.Config}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:v2ray.core.transport.internet.http.Config)
      ConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ConfigOuterClass.internal_static_v2ray_core_transport_internet_http_Config_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ConfigOuterClass.internal_static_v2ray_core_transport_internet_http_Config_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Config.class, Builder.class);
    }

    // Construct using com.v2ray.core.transport.internet.http.Config.newBuilder()
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
      host_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      path_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ConfigOuterClass.internal_static_v2ray_core_transport_internet_http_Config_descriptor;
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
      if (((bitField0_ & 0x00000001) != 0)) {
        host_ = host_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.host_ = host_;
      result.path_ = path_;
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
        return mergeFrom((Config)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Config other) {
      if (other == Config.getDefaultInstance()) return this;
      if (!other.host_.isEmpty()) {
        if (host_.isEmpty()) {
          host_ = other.host_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureHostIsMutable();
          host_.addAll(other.host_);
        }
        onChanged();
      }
      if (!other.getPath().isEmpty()) {
        path_ = other.path_;
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

    private com.google.protobuf.LazyStringList host_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureHostIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        host_ = new com.google.protobuf.LazyStringArrayList(host_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getHostList() {
      return host_.getUnmodifiableView();
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public int getHostCount() {
      return host_.size();
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public String getHost(int index) {
      return host_.get(index);
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public com.google.protobuf.ByteString
        getHostBytes(int index) {
      return host_.getByteString(index);
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public Builder setHost(
        int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureHostIsMutable();
      host_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public Builder addHost(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureHostIsMutable();
      host_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public Builder addAllHost(
        Iterable<String> values) {
      ensureHostIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, host_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public Builder clearHost() {
      host_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string host = 1;</code>
     */
    public Builder addHostBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureHostIsMutable();
      host_.add(value);
      onChanged();
      return this;
    }

    private Object path_ = "";
    /**
     * <code>string path = 2;</code>
     */
    public String getPath() {
      Object ref = path_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        path_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string path = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPathBytes() {
      Object ref = path_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        path_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string path = 2;</code>
     */
    public Builder setPath(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      path_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string path = 2;</code>
     */
    public Builder clearPath() {
      
      path_ = getDefaultInstance().getPath();
      onChanged();
      return this;
    }
    /**
     * <code>string path = 2;</code>
     */
    public Builder setPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      path_ = value;
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


    // @@protoc_insertion_point(builder_scope:v2ray.core.transport.internet.http.Config)
  }

  // @@protoc_insertion_point(class_scope:v2ray.core.transport.internet.http.Config)
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

