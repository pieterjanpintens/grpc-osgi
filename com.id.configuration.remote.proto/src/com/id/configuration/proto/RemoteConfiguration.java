// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: remote_configuration.proto

package com.id.configuration.proto;

public final class RemoteConfiguration {
  private RemoteConfiguration() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Level_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Level_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Path_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Path_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Option_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Option_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TypedOption_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TypedOption_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ValueOption_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ValueOption_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_NameList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_NameList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangeEvent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangeEvent_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032remote_configuration.proto\"\007\n\005Empty\"\026\n" +
      "\005Level\022\r\n\005level\030\001 \001(\005\"\024\n\004Path\022\014\n\004path\030\001 " +
      "\001(\t\"%\n\006Option\022\014\n\004path\030\001 \001(\t\022\r\n\005level\030\002 \001" +
      "(\005\"?\n\013TypedOption\022\014\n\004path\030\001 \001(\t\022\r\n\005level" +
      "\030\002 \001(\005\022\023\n\004type\030\003 \001(\0162\005.Type\"M\n\013ValueOpti" +
      "on\022\014\n\004path\030\001 \001(\t\022\r\n\005level\030\002 \001(\005\022\023\n\004type\030" +
      "\003 \001(\0162\005.Type\022\014\n\004data\030\004 \001(\014\"%\n\010NameList\022\031" +
      "\n\010namelist\030\001 \003(\0132\007.Option\"J\n\013ChangeEvent" +
      "\022\034\n\006option\030\001 \001(\0132\014.ValueOption\022\035\n\toperat" +
      "ion\030\002 \001(\0162\n.Operation*.\n\004Type\022\t\n\005VALUE\020\000",
      "\022\r\n\tENCRYPTED\020\001\022\014\n\010FRAGMENT\020\002*/\n\tOperati" +
      "on\022\007\n\003SET\020\000\022\n\n\006REMOVE\020\001\022\r\n\tREMOVEALL\020\0022\215" +
      "\004\n\024ConfigurationService\022.\n\025getGlobalConf" +
      "igOption\022\005.Path\032\014.ValueOption\"\000\0221\n\026getLe" +
      "veledConfigOption\022\007.Option\032\014.ValueOption" +
      "\"\000\0226\n\027getLeveledConfigOptions\022\007.Option\032\014" +
      ".ValueOption\"\000(\0010\001\0223\n\026getGlobalConfigOpt" +
      "ions\022\005.Path\032\014.ValueOption\"\000(\0010\001\022)\n\017setCo" +
      "nfigOption\022\014.ValueOption\032\006.Empty\"\000\022-\n\030un" +
      "setLeveledConfigOption\022\007.Option\032\006.Empty\"",
      "\000\022*\n\027unsetGlobalConfigOption\022\005.Path\032\006.Em" +
      "pty\"\000\022*\n\022getLeveledNameList\022\007.Option\032\t.N" +
      "ameList\"\000\022\'\n\021getGlobalNameList\022\005.Path\032\t." +
      "NameList\"\000\022$\n\010getLevel\022\006.Level\032\014.ValueOp" +
      "tion\"\0000\001\022$\n\006listen\022\006.Empty\032\014.ChangeEvent" +
      "\"\000(\0010\001B\036\n\032com.id.configuration.protoP\001b\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_Level_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Level_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Level_descriptor,
        new java.lang.String[] { "Level", });
    internal_static_Path_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Path_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Path_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_Option_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Option_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Option_descriptor,
        new java.lang.String[] { "Path", "Level", });
    internal_static_TypedOption_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_TypedOption_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TypedOption_descriptor,
        new java.lang.String[] { "Path", "Level", "Type", });
    internal_static_ValueOption_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ValueOption_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ValueOption_descriptor,
        new java.lang.String[] { "Path", "Level", "Type", "Data", });
    internal_static_NameList_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_NameList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_NameList_descriptor,
        new java.lang.String[] { "Namelist", });
    internal_static_ChangeEvent_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ChangeEvent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangeEvent_descriptor,
        new java.lang.String[] { "Option", "Operation", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
