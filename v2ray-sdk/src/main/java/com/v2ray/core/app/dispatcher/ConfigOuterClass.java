// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/dispatcher/config.proto

package com.v2ray.core.app.dispatcher;

public final class ConfigOuterClass {
    private ConfigOuterClass() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_dispatcher_SessionConfig_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_dispatcher_SessionConfig_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_dispatcher_Config_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_dispatcher_Config_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n*v2ray.com/core/app/dispatcher/config.p" +
                        "roto\022\031v2ray.core.app.dispatcher\"\025\n\rSessi" +
                        "onConfigJ\004\010\001\020\002\"D\n\006Config\022:\n\010settings\030\001 \001" +
                        "(\0132(.v2ray.core.app.dispatcher.SessionCo" +
                        "nfigBI\n\035com.v2ray.core.app.dispatcherP\001Z" +
                        "\ndispatcher\252\002\031V2Ray.Core.App.Dispatcherb" +
                        "\006proto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        }, assigner);
        internal_static_v2ray_core_app_dispatcher_SessionConfig_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_v2ray_core_app_dispatcher_SessionConfig_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_dispatcher_SessionConfig_descriptor,
                new String[]{});
        internal_static_v2ray_core_app_dispatcher_Config_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_v2ray_core_app_dispatcher_Config_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_dispatcher_Config_descriptor,
                new String[]{"Settings",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
