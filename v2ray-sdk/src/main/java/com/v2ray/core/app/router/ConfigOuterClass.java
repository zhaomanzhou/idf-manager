// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/router/config.proto

package com.v2ray.core.app.router;

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
            internal_static_v2ray_core_app_router_Domain_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_Domain_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_router_CIDR_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_CIDR_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_router_GeoIP_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_GeoIP_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_router_GeoIPList_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_GeoIPList_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_router_GeoSite_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_GeoSite_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_router_GeoSiteList_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_GeoSiteList_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_router_RoutingRule_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_RoutingRule_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_v2ray_core_app_router_Config_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_v2ray_core_app_router_Config_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n&v2ray.com/core/app/router/config.proto" +
                        "\022\025v2ray.core.app.router\032$v2ray.com/core/" +
                        "common/net/port.proto\032\'v2ray.com/core/co" +
                        "mmon/net/network.proto\"s\n\006Domain\0220\n\004type" +
                        "\030\001 \001(\0162\".v2ray.core.app.router.Domain.Ty" +
                        "pe\022\r\n\005value\030\002 \001(\t\"(\n\004Type\022\t\n\005Plain\020\000\022\t\n\005" +
                        "Regex\020\001\022\n\n\006Domain\020\002\"\"\n\004CIDR\022\n\n\002ip\030\001 \001(\014\022" +
                        "\016\n\006prefix\030\002 \001(\r\"H\n\005GeoIP\022\024\n\014country_code" +
                        "\030\001 \001(\t\022)\n\004cidr\030\002 \003(\0132\033.v2ray.core.app.ro" +
                        "uter.CIDR\"8\n\tGeoIPList\022+\n\005entry\030\001 \003(\0132\034." +
                        "v2ray.core.app.router.GeoIP\"N\n\007GeoSite\022\024" +
                        "\n\014country_code\030\001 \001(\t\022-\n\006domain\030\002 \003(\0132\035.v" +
                        "2ray.core.app.router.Domain\"<\n\013GeoSiteLi" +
                        "st\022-\n\005entry\030\001 \003(\0132\036.v2ray.core.app.route" +
                        "r.GeoSite\"\277\002\n\013RoutingRule\022\013\n\003tag\030\001 \001(\t\022-" +
                        "\n\006domain\030\002 \003(\0132\035.v2ray.core.app.router.D" +
                        "omain\022)\n\004cidr\030\003 \003(\0132\033.v2ray.core.app.rou" +
                        "ter.CIDR\0224\n\nport_range\030\004 \001(\0132 .v2ray.cor" +
                        "e.common.net.PortRange\0228\n\014network_list\030\005" +
                        " \001(\0132\".v2ray.core.common.net.NetworkList" +
                        "\0220\n\013source_cidr\030\006 \003(\0132\033.v2ray.core.app.r" +
                        "outer.CIDR\022\022\n\nuser_email\030\007 \003(\t\022\023\n\013inboun" +
                        "d_tag\030\010 \003(\t\"\312\001\n\006Config\022E\n\017domain_strateg" +
                        "y\030\001 \001(\0162,.v2ray.core.app.router.Config.D" +
                        "omainStrategy\0220\n\004rule\030\002 \003(\0132\".v2ray.core" +
                        ".app.router.RoutingRule\"G\n\016DomainStrateg" +
                        "y\022\010\n\004AsIs\020\000\022\t\n\005UseIp\020\001\022\020\n\014IpIfNonMatch\020\002" +
                        "\022\016\n\nIpOnDemand\020\003B=\n\031com.v2ray.core.app.r" +
                        "outerP\001Z\006router\252\002\025V2Ray.Core.App.Routerb" +
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
                                com.v2ray.core.common.net.Port.getDescriptor(),
                                com.v2ray.core.common.net.NetworkOuterClass.getDescriptor(),
                        }, assigner);
        internal_static_v2ray_core_app_router_Domain_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_v2ray_core_app_router_Domain_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_Domain_descriptor,
                new String[]{"Type", "Value",});
        internal_static_v2ray_core_app_router_CIDR_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_v2ray_core_app_router_CIDR_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_CIDR_descriptor,
                new String[]{"Ip", "Prefix",});
        internal_static_v2ray_core_app_router_GeoIP_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_v2ray_core_app_router_GeoIP_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_GeoIP_descriptor,
                new String[]{"CountryCode", "Cidr",});
        internal_static_v2ray_core_app_router_GeoIPList_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_v2ray_core_app_router_GeoIPList_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_GeoIPList_descriptor,
                new String[]{"Entry",});
        internal_static_v2ray_core_app_router_GeoSite_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_v2ray_core_app_router_GeoSite_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_GeoSite_descriptor,
                new String[]{"CountryCode", "Domain",});
        internal_static_v2ray_core_app_router_GeoSiteList_descriptor =
                getDescriptor().getMessageTypes().get(5);
        internal_static_v2ray_core_app_router_GeoSiteList_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_GeoSiteList_descriptor,
                new String[]{"Entry",});
        internal_static_v2ray_core_app_router_RoutingRule_descriptor =
                getDescriptor().getMessageTypes().get(6);
        internal_static_v2ray_core_app_router_RoutingRule_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_RoutingRule_descriptor,
                new String[]{"Tag", "Domain", "Cidr", "PortRange", "NetworkList", "SourceCidr", "UserEmail", "InboundTag",});
        internal_static_v2ray_core_app_router_Config_descriptor =
                getDescriptor().getMessageTypes().get(7);
        internal_static_v2ray_core_app_router_Config_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_v2ray_core_app_router_Config_descriptor,
                new String[]{"DomainStrategy", "Rule",});
        com.v2ray.core.common.net.Port.getDescriptor();
        com.v2ray.core.common.net.NetworkOuterClass.getDescriptor();
    }

    // @@protoc_insertion_point(outer_class_scope)
}
