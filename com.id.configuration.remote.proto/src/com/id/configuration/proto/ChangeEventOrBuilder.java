// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: remote_configuration.proto

package com.id.configuration.proto;

public interface ChangeEventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ChangeEvent)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ValueOption option = 1;</code>
   */
  boolean hasOption();
  /**
   * <code>.ValueOption option = 1;</code>
   */
  com.id.configuration.proto.ValueOption getOption();
  /**
   * <code>.ValueOption option = 1;</code>
   */
  com.id.configuration.proto.ValueOptionOrBuilder getOptionOrBuilder();

  /**
   * <code>.Operation operation = 2;</code>
   */
  int getOperationValue();
  /**
   * <code>.Operation operation = 2;</code>
   */
  com.id.configuration.proto.Operation getOperation();
}
