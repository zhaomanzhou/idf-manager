// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/stats/command/command.proto

package com.v2ray.core.app.stats.command;

public final class Command {
    private Command() {
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
            internal_static_v2ray_core_app_stats_command_GetStatsRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_stats_command_GetStatsRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_stats_command_Stat_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_stats_command_Stat_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_stats_command_GetStatsResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_stats_command_GetStatsResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_stats_command_Config_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_stats_command_Config_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n.v2ray.com/core/app/stats/command/comma" +
                        "nd.proto\022\034v2ray.core.app.stats.command\"." +
                        "\n\017GetStatsRequest\022\014\n\004name\030\001 \001(\t\022\r\n\005reset" +
                        "\030\002 \001(\010\"#\n\004Stat\022\014\n\004name\030\001 \001(\t\022\r\n\005value\030\002 " +
                        "\001(\003\"D\n\020GetStatsResponse\0220\n\004stat\030\001 \001(\0132\"." +
                        "v2ray.core.app.stats.command.Stat\"\010\n\006Con" +
                        "fig2{\n\014StatsService\022k\n\010GetStats\022-.v2ray." +
                        "core.app.stats.command.GetStatsRequest\032." +
                        ".v2ray.core.app.stats.command.GetStatsRe" +
                        "sponse\"\000BL\n com.v2ray.core.app.stats.com" +
                        "mandP\001Z\007command\252\002\034V2Ray.Core.App.Stats.C" +
                        "ommandb\006proto3"
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
        internal_static_v2ray_core_app_stats_command_GetStatsRequest_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_v2ray_core_app_stats_command_GetStatsRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_stats_command_GetStatsRequest_descriptor,
                new String[]{"Name", "Reset",});
        internal_static_v2ray_core_app_stats_command_Stat_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_v2ray_core_app_stats_command_Stat_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_stats_command_Stat_descriptor,
                new String[]{"Name", "Value",});
        internal_static_v2ray_core_app_stats_command_GetStatsResponse_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_v2ray_core_app_stats_command_GetStatsResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_stats_command_GetStatsResponse_descriptor,
                new String[]{"Stat",});
        internal_static_v2ray_core_app_stats_command_Config_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_v2ray_core_app_stats_command_Config_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_stats_command_Config_descriptor,
                new String[]{});
    }

    // @@protoc_insertion_point(outer_class_scope)
}