package com.id.configuration.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: remote_configuration.proto")
public final class ConfigurationServiceGrpc {

  private ConfigurationServiceGrpc() {}

  public static final String SERVICE_NAME = "ConfigurationService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Path,
      com.id.configuration.proto.ValueOption> METHOD_GET_GLOBAL_CONFIG_OPTION =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Path, com.id.configuration.proto.ValueOption>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "getGlobalConfigOption"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Path.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.ValueOption.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Option,
      com.id.configuration.proto.ValueOption> METHOD_GET_LEVELED_CONFIG_OPTION =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Option, com.id.configuration.proto.ValueOption>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "getLeveledConfigOption"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Option.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.ValueOption.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Option,
      com.id.configuration.proto.ValueOption> METHOD_GET_LEVELED_CONFIG_OPTIONS =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Option, com.id.configuration.proto.ValueOption>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "getLeveledConfigOptions"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Option.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.ValueOption.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Path,
      com.id.configuration.proto.ValueOption> METHOD_GET_GLOBAL_CONFIG_OPTIONS =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Path, com.id.configuration.proto.ValueOption>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "getGlobalConfigOptions"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Path.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.ValueOption.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.ValueOption,
      com.id.configuration.proto.Empty> METHOD_SET_CONFIG_OPTION =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.ValueOption, com.id.configuration.proto.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "setConfigOption"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.ValueOption.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Option,
      com.id.configuration.proto.Empty> METHOD_UNSET_LEVELED_CONFIG_OPTION =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Option, com.id.configuration.proto.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "unsetLeveledConfigOption"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Option.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Path,
      com.id.configuration.proto.Empty> METHOD_UNSET_GLOBAL_CONFIG_OPTION =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Path, com.id.configuration.proto.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "unsetGlobalConfigOption"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Path.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Option,
      com.id.configuration.proto.NameList> METHOD_GET_LEVELED_NAME_LIST =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Option, com.id.configuration.proto.NameList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "getLeveledNameList"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Option.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.NameList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Path,
      com.id.configuration.proto.NameList> METHOD_GET_GLOBAL_NAME_LIST =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Path, com.id.configuration.proto.NameList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "getGlobalNameList"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Path.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.NameList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Level,
      com.id.configuration.proto.ValueOption> METHOD_GET_LEVEL =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Level, com.id.configuration.proto.ValueOption>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "getLevel"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Level.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.ValueOption.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.id.configuration.proto.Empty,
      com.id.configuration.proto.ChangeEvent> METHOD_LISTEN =
      io.grpc.MethodDescriptor.<com.id.configuration.proto.Empty, com.id.configuration.proto.ChangeEvent>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "ConfigurationService", "listen"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.id.configuration.proto.ChangeEvent.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigurationServiceStub newStub(io.grpc.Channel channel) {
    return new ConfigurationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigurationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConfigurationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigurationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConfigurationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ConfigurationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public void getGlobalConfigOption(com.id.configuration.proto.Path request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_GLOBAL_CONFIG_OPTION, responseObserver);
    }

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public void getLeveledConfigOption(com.id.configuration.proto.Option request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_LEVELED_CONFIG_OPTION, responseObserver);
    }

    /**
     * <pre>
     * Get a list of options
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.id.configuration.proto.Option> getLeveledConfigOptions(
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_LEVELED_CONFIG_OPTIONS, responseObserver);
    }

    /**
     * <pre>
     * Get a list of options
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.id.configuration.proto.Path> getGlobalConfigOptions(
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_GLOBAL_CONFIG_OPTIONS, responseObserver);
    }

    /**
     * <pre>
     * Set an option
     * </pre>
     */
    public void setConfigOption(com.id.configuration.proto.ValueOption request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_CONFIG_OPTION, responseObserver);
    }

    /**
     * <pre>
     * Unset an option at given level
     * </pre>
     */
    public void unsetLeveledConfigOption(com.id.configuration.proto.Option request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNSET_LEVELED_CONFIG_OPTION, responseObserver);
    }

    /**
     * <pre>
     * Unset an option at all levels
     * </pre>
     */
    public void unsetGlobalConfigOption(com.id.configuration.proto.Path request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNSET_GLOBAL_CONFIG_OPTION, responseObserver);
    }

    /**
     * <pre>
     * Get namelist for given level
     * </pre>
     */
    public void getLeveledNameList(com.id.configuration.proto.Option request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.NameList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_LEVELED_NAME_LIST, responseObserver);
    }

    /**
     * <pre>
     * Get namelist over all levels
     * </pre>
     */
    public void getGlobalNameList(com.id.configuration.proto.Path request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.NameList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_GLOBAL_NAME_LIST, responseObserver);
    }

    /**
     * <pre>
     * Get all options for given level
     * </pre>
     */
    public void getLevel(com.id.configuration.proto.Level request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_LEVEL, responseObserver);
    }

    /**
     * <pre>
     * Listen for configuration changes
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> listen(
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ChangeEvent> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_LISTEN, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_GLOBAL_CONFIG_OPTION,
            asyncUnaryCall(
              new MethodHandlers<
                com.id.configuration.proto.Path,
                com.id.configuration.proto.ValueOption>(
                  this, METHODID_GET_GLOBAL_CONFIG_OPTION)))
          .addMethod(
            METHOD_GET_LEVELED_CONFIG_OPTION,
            asyncUnaryCall(
              new MethodHandlers<
                com.id.configuration.proto.Option,
                com.id.configuration.proto.ValueOption>(
                  this, METHODID_GET_LEVELED_CONFIG_OPTION)))
          .addMethod(
            METHOD_GET_LEVELED_CONFIG_OPTIONS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.id.configuration.proto.Option,
                com.id.configuration.proto.ValueOption>(
                  this, METHODID_GET_LEVELED_CONFIG_OPTIONS)))
          .addMethod(
            METHOD_GET_GLOBAL_CONFIG_OPTIONS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.id.configuration.proto.Path,
                com.id.configuration.proto.ValueOption>(
                  this, METHODID_GET_GLOBAL_CONFIG_OPTIONS)))
          .addMethod(
            METHOD_SET_CONFIG_OPTION,
            asyncUnaryCall(
              new MethodHandlers<
                com.id.configuration.proto.ValueOption,
                com.id.configuration.proto.Empty>(
                  this, METHODID_SET_CONFIG_OPTION)))
          .addMethod(
            METHOD_UNSET_LEVELED_CONFIG_OPTION,
            asyncUnaryCall(
              new MethodHandlers<
                com.id.configuration.proto.Option,
                com.id.configuration.proto.Empty>(
                  this, METHODID_UNSET_LEVELED_CONFIG_OPTION)))
          .addMethod(
            METHOD_UNSET_GLOBAL_CONFIG_OPTION,
            asyncUnaryCall(
              new MethodHandlers<
                com.id.configuration.proto.Path,
                com.id.configuration.proto.Empty>(
                  this, METHODID_UNSET_GLOBAL_CONFIG_OPTION)))
          .addMethod(
            METHOD_GET_LEVELED_NAME_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                com.id.configuration.proto.Option,
                com.id.configuration.proto.NameList>(
                  this, METHODID_GET_LEVELED_NAME_LIST)))
          .addMethod(
            METHOD_GET_GLOBAL_NAME_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                com.id.configuration.proto.Path,
                com.id.configuration.proto.NameList>(
                  this, METHODID_GET_GLOBAL_NAME_LIST)))
          .addMethod(
            METHOD_GET_LEVEL,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.id.configuration.proto.Level,
                com.id.configuration.proto.ValueOption>(
                  this, METHODID_GET_LEVEL)))
          .addMethod(
            METHOD_LISTEN,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.id.configuration.proto.Empty,
                com.id.configuration.proto.ChangeEvent>(
                  this, METHODID_LISTEN)))
          .build();
    }
  }

  /**
   */
  public static final class ConfigurationServiceStub extends io.grpc.stub.AbstractStub<ConfigurationServiceStub> {
    private ConfigurationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigurationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigurationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public void getGlobalConfigOption(com.id.configuration.proto.Path request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_GLOBAL_CONFIG_OPTION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public void getLeveledConfigOption(com.id.configuration.proto.Option request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LEVELED_CONFIG_OPTION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a list of options
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.id.configuration.proto.Option> getLeveledConfigOptions(
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_LEVELED_CONFIG_OPTIONS, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Get a list of options
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.id.configuration.proto.Path> getGlobalConfigOptions(
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_GLOBAL_CONFIG_OPTIONS, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Set an option
     * </pre>
     */
    public void setConfigOption(com.id.configuration.proto.ValueOption request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_CONFIG_OPTION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unset an option at given level
     * </pre>
     */
    public void unsetLeveledConfigOption(com.id.configuration.proto.Option request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNSET_LEVELED_CONFIG_OPTION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unset an option at all levels
     * </pre>
     */
    public void unsetGlobalConfigOption(com.id.configuration.proto.Path request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNSET_GLOBAL_CONFIG_OPTION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get namelist for given level
     * </pre>
     */
    public void getLeveledNameList(com.id.configuration.proto.Option request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.NameList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LEVELED_NAME_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get namelist over all levels
     * </pre>
     */
    public void getGlobalNameList(com.id.configuration.proto.Path request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.NameList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_GLOBAL_NAME_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all options for given level
     * </pre>
     */
    public void getLevel(com.id.configuration.proto.Level request,
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_LEVEL, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Listen for configuration changes
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty> listen(
        io.grpc.stub.StreamObserver<com.id.configuration.proto.ChangeEvent> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_LISTEN, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ConfigurationServiceBlockingStub extends io.grpc.stub.AbstractStub<ConfigurationServiceBlockingStub> {
    private ConfigurationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigurationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigurationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public com.id.configuration.proto.ValueOption getGlobalConfigOption(com.id.configuration.proto.Path request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_GLOBAL_CONFIG_OPTION, getCallOptions(), request);
    }

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public com.id.configuration.proto.ValueOption getLeveledConfigOption(com.id.configuration.proto.Option request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_LEVELED_CONFIG_OPTION, getCallOptions(), request);
    }

    /**
     * <pre>
     * Set an option
     * </pre>
     */
    public com.id.configuration.proto.Empty setConfigOption(com.id.configuration.proto.ValueOption request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_CONFIG_OPTION, getCallOptions(), request);
    }

    /**
     * <pre>
     * Unset an option at given level
     * </pre>
     */
    public com.id.configuration.proto.Empty unsetLeveledConfigOption(com.id.configuration.proto.Option request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNSET_LEVELED_CONFIG_OPTION, getCallOptions(), request);
    }

    /**
     * <pre>
     * Unset an option at all levels
     * </pre>
     */
    public com.id.configuration.proto.Empty unsetGlobalConfigOption(com.id.configuration.proto.Path request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNSET_GLOBAL_CONFIG_OPTION, getCallOptions(), request);
    }

    /**
     * <pre>
     * Get namelist for given level
     * </pre>
     */
    public com.id.configuration.proto.NameList getLeveledNameList(com.id.configuration.proto.Option request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_LEVELED_NAME_LIST, getCallOptions(), request);
    }

    /**
     * <pre>
     * Get namelist over all levels
     * </pre>
     */
    public com.id.configuration.proto.NameList getGlobalNameList(com.id.configuration.proto.Path request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_GLOBAL_NAME_LIST, getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all options for given level
     * </pre>
     */
    public java.util.Iterator<com.id.configuration.proto.ValueOption> getLevel(
        com.id.configuration.proto.Level request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_LEVEL, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConfigurationServiceFutureStub extends io.grpc.stub.AbstractStub<ConfigurationServiceFutureStub> {
    private ConfigurationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigurationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigurationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.id.configuration.proto.ValueOption> getGlobalConfigOption(
        com.id.configuration.proto.Path request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_GLOBAL_CONFIG_OPTION, getCallOptions()), request);
    }

    /**
     * <pre>
     * Get an option
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.id.configuration.proto.ValueOption> getLeveledConfigOption(
        com.id.configuration.proto.Option request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LEVELED_CONFIG_OPTION, getCallOptions()), request);
    }

    /**
     * <pre>
     * Set an option
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.id.configuration.proto.Empty> setConfigOption(
        com.id.configuration.proto.ValueOption request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_CONFIG_OPTION, getCallOptions()), request);
    }

    /**
     * <pre>
     * Unset an option at given level
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.id.configuration.proto.Empty> unsetLeveledConfigOption(
        com.id.configuration.proto.Option request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNSET_LEVELED_CONFIG_OPTION, getCallOptions()), request);
    }

    /**
     * <pre>
     * Unset an option at all levels
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.id.configuration.proto.Empty> unsetGlobalConfigOption(
        com.id.configuration.proto.Path request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNSET_GLOBAL_CONFIG_OPTION, getCallOptions()), request);
    }

    /**
     * <pre>
     * Get namelist for given level
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.id.configuration.proto.NameList> getLeveledNameList(
        com.id.configuration.proto.Option request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LEVELED_NAME_LIST, getCallOptions()), request);
    }

    /**
     * <pre>
     * Get namelist over all levels
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.id.configuration.proto.NameList> getGlobalNameList(
        com.id.configuration.proto.Path request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_GLOBAL_NAME_LIST, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_GLOBAL_CONFIG_OPTION = 0;
  private static final int METHODID_GET_LEVELED_CONFIG_OPTION = 1;
  private static final int METHODID_SET_CONFIG_OPTION = 2;
  private static final int METHODID_UNSET_LEVELED_CONFIG_OPTION = 3;
  private static final int METHODID_UNSET_GLOBAL_CONFIG_OPTION = 4;
  private static final int METHODID_GET_LEVELED_NAME_LIST = 5;
  private static final int METHODID_GET_GLOBAL_NAME_LIST = 6;
  private static final int METHODID_GET_LEVEL = 7;
  private static final int METHODID_GET_LEVELED_CONFIG_OPTIONS = 8;
  private static final int METHODID_GET_GLOBAL_CONFIG_OPTIONS = 9;
  private static final int METHODID_LISTEN = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConfigurationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConfigurationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_GLOBAL_CONFIG_OPTION:
          serviceImpl.getGlobalConfigOption((com.id.configuration.proto.Path) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption>) responseObserver);
          break;
        case METHODID_GET_LEVELED_CONFIG_OPTION:
          serviceImpl.getLeveledConfigOption((com.id.configuration.proto.Option) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption>) responseObserver);
          break;
        case METHODID_SET_CONFIG_OPTION:
          serviceImpl.setConfigOption((com.id.configuration.proto.ValueOption) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty>) responseObserver);
          break;
        case METHODID_UNSET_LEVELED_CONFIG_OPTION:
          serviceImpl.unsetLeveledConfigOption((com.id.configuration.proto.Option) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty>) responseObserver);
          break;
        case METHODID_UNSET_GLOBAL_CONFIG_OPTION:
          serviceImpl.unsetGlobalConfigOption((com.id.configuration.proto.Path) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.Empty>) responseObserver);
          break;
        case METHODID_GET_LEVELED_NAME_LIST:
          serviceImpl.getLeveledNameList((com.id.configuration.proto.Option) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.NameList>) responseObserver);
          break;
        case METHODID_GET_GLOBAL_NAME_LIST:
          serviceImpl.getGlobalNameList((com.id.configuration.proto.Path) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.NameList>) responseObserver);
          break;
        case METHODID_GET_LEVEL:
          serviceImpl.getLevel((com.id.configuration.proto.Level) request,
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LEVELED_CONFIG_OPTIONS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getLeveledConfigOptions(
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption>) responseObserver);
        case METHODID_GET_GLOBAL_CONFIG_OPTIONS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getGlobalConfigOptions(
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.ValueOption>) responseObserver);
        case METHODID_LISTEN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.listen(
              (io.grpc.stub.StreamObserver<com.id.configuration.proto.ChangeEvent>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ConfigurationServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.id.configuration.proto.RemoteConfiguration.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConfigurationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigurationServiceDescriptorSupplier())
              .addMethod(METHOD_GET_GLOBAL_CONFIG_OPTION)
              .addMethod(METHOD_GET_LEVELED_CONFIG_OPTION)
              .addMethod(METHOD_GET_LEVELED_CONFIG_OPTIONS)
              .addMethod(METHOD_GET_GLOBAL_CONFIG_OPTIONS)
              .addMethod(METHOD_SET_CONFIG_OPTION)
              .addMethod(METHOD_UNSET_LEVELED_CONFIG_OPTION)
              .addMethod(METHOD_UNSET_GLOBAL_CONFIG_OPTION)
              .addMethod(METHOD_GET_LEVELED_NAME_LIST)
              .addMethod(METHOD_GET_GLOBAL_NAME_LIST)
              .addMethod(METHOD_GET_LEVEL)
              .addMethod(METHOD_LISTEN)
              .build();
        }
      }
    }
    return result;
  }
}
