// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/router/config.proto

package com.v2ray.core.app.router;

public interface GeoSiteListOrBuilder extends
        // @@protoc_insertion_point(interface_extends:v2ray.core.app.router.GeoSiteList)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .v2ray.core.app.router.GeoSite entry = 1;</code>
     */
    java.util.List<GeoSite>
    getEntryList();

    /**
     * <code>repeated .v2ray.core.app.router.GeoSite entry = 1;</code>
     */
    GeoSite getEntry(int index);

    /**
     * <code>repeated .v2ray.core.app.router.GeoSite entry = 1;</code>
     */
    int getEntryCount();

    /**
     * <code>repeated .v2ray.core.app.router.GeoSite entry = 1;</code>
     */
    java.util.List<? extends GeoSiteOrBuilder>
    getEntryOrBuilderList();

    /**
     * <code>repeated .v2ray.core.app.router.GeoSite entry = 1;</code>
     */
    GeoSiteOrBuilder getEntryOrBuilder(
            int index);
}