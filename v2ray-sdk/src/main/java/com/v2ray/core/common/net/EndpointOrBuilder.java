// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/common/net/destination.proto

package com.v2ray.core.common.net;

public interface EndpointOrBuilder extends
        // @@protoc_insertion_point(interface_extends:v2ray.core.common.net.Endpoint)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.v2ray.core.common.net.Network network = 1;</code>
     */
    int getNetworkValue();

    /**
     * <code>.v2ray.core.common.net.Network network = 1;</code>
     */
    Network getNetwork();

    /**
     * <code>.v2ray.core.common.net.IPOrDomain address = 2;</code>
     */
    boolean hasAddress();

    /**
     * <code>.v2ray.core.common.net.IPOrDomain address = 2;</code>
     */
    IPOrDomain getAddress();

    /**
     * <code>.v2ray.core.common.net.IPOrDomain address = 2;</code>
     */
    IPOrDomainOrBuilder getAddressOrBuilder();

    /**
     * <code>uint32 port = 3;</code>
     */
    int getPort();
}
