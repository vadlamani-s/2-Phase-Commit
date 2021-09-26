package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: Coordinator.proto")
public final class CoordinatorGrpc {

  private CoordinatorGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.Coordinator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
      com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getDictionaryCoordinatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dictionaryCoordinator",
      requestType = com.example.grpc.CoordinatorOuterClass.RequestCoordinator.class,
      responseType = com.example.grpc.CoordinatorOuterClass.ResponseCoordinator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
      com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getDictionaryCoordinatorMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator, com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getDictionaryCoordinatorMethod;
    if ((getDictionaryCoordinatorMethod = CoordinatorGrpc.getDictionaryCoordinatorMethod) == null) {
      synchronized (CoordinatorGrpc.class) {
        if ((getDictionaryCoordinatorMethod = CoordinatorGrpc.getDictionaryCoordinatorMethod) == null) {
          CoordinatorGrpc.getDictionaryCoordinatorMethod = getDictionaryCoordinatorMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CoordinatorOuterClass.RequestCoordinator, com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dictionaryCoordinator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CoordinatorOuterClass.RequestCoordinator.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CoordinatorOuterClass.ResponseCoordinator.getDefaultInstance()))
              .setSchemaDescriptor(new CoordinatorMethodDescriptorSupplier("dictionaryCoordinator"))
              .build();
        }
      }
    }
    return getDictionaryCoordinatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
      com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getInitializationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initialization",
      requestType = com.example.grpc.CoordinatorOuterClass.RequestCoordinator.class,
      responseType = com.example.grpc.CoordinatorOuterClass.ResponseCoordinator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
      com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getInitializationMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator, com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getInitializationMethod;
    if ((getInitializationMethod = CoordinatorGrpc.getInitializationMethod) == null) {
      synchronized (CoordinatorGrpc.class) {
        if ((getInitializationMethod = CoordinatorGrpc.getInitializationMethod) == null) {
          CoordinatorGrpc.getInitializationMethod = getInitializationMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CoordinatorOuterClass.RequestCoordinator, com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "initialization"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CoordinatorOuterClass.RequestCoordinator.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CoordinatorOuterClass.ResponseCoordinator.getDefaultInstance()))
              .setSchemaDescriptor(new CoordinatorMethodDescriptorSupplier("initialization"))
              .build();
        }
      }
    }
    return getInitializationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
      com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getInitPrepareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initPrepare",
      requestType = com.example.grpc.CoordinatorOuterClass.RequestCoordinator.class,
      responseType = com.example.grpc.CoordinatorOuterClass.ResponseCoordinator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
      com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getInitPrepareMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.CoordinatorOuterClass.RequestCoordinator, com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> getInitPrepareMethod;
    if ((getInitPrepareMethod = CoordinatorGrpc.getInitPrepareMethod) == null) {
      synchronized (CoordinatorGrpc.class) {
        if ((getInitPrepareMethod = CoordinatorGrpc.getInitPrepareMethod) == null) {
          CoordinatorGrpc.getInitPrepareMethod = getInitPrepareMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CoordinatorOuterClass.RequestCoordinator, com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "initPrepare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CoordinatorOuterClass.RequestCoordinator.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CoordinatorOuterClass.ResponseCoordinator.getDefaultInstance()))
              .setSchemaDescriptor(new CoordinatorMethodDescriptorSupplier("initPrepare"))
              .build();
        }
      }
    }
    return getInitPrepareMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CoordinatorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoordinatorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoordinatorStub>() {
        @java.lang.Override
        public CoordinatorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoordinatorStub(channel, callOptions);
        }
      };
    return CoordinatorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CoordinatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoordinatorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoordinatorBlockingStub>() {
        @java.lang.Override
        public CoordinatorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoordinatorBlockingStub(channel, callOptions);
        }
      };
    return CoordinatorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CoordinatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoordinatorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoordinatorFutureStub>() {
        @java.lang.Override
        public CoordinatorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoordinatorFutureStub(channel, callOptions);
        }
      };
    return CoordinatorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CoordinatorImplBase implements io.grpc.BindableService {

    /**
     */
    public void dictionaryCoordinator(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request,
        io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDictionaryCoordinatorMethod(), responseObserver);
    }

    /**
     */
    public void initialization(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request,
        io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitializationMethod(), responseObserver);
    }

    /**
     */
    public void initPrepare(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request,
        io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitPrepareMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDictionaryCoordinatorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
                com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>(
                  this, METHODID_DICTIONARY_COORDINATOR)))
          .addMethod(
            getInitializationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
                com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>(
                  this, METHODID_INITIALIZATION)))
          .addMethod(
            getInitPrepareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.CoordinatorOuterClass.RequestCoordinator,
                com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>(
                  this, METHODID_INIT_PREPARE)))
          .build();
    }
  }

  /**
   */
  public static final class CoordinatorStub extends io.grpc.stub.AbstractAsyncStub<CoordinatorStub> {
    private CoordinatorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoordinatorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoordinatorStub(channel, callOptions);
    }

    /**
     */
    public void dictionaryCoordinator(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request,
        io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDictionaryCoordinatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void initialization(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request,
        io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void initPrepare(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request,
        io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitPrepareMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CoordinatorBlockingStub extends io.grpc.stub.AbstractBlockingStub<CoordinatorBlockingStub> {
    private CoordinatorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoordinatorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoordinatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.CoordinatorOuterClass.ResponseCoordinator dictionaryCoordinator(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDictionaryCoordinatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.CoordinatorOuterClass.ResponseCoordinator initialization(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.CoordinatorOuterClass.ResponseCoordinator initPrepare(com.example.grpc.CoordinatorOuterClass.RequestCoordinator request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitPrepareMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CoordinatorFutureStub extends io.grpc.stub.AbstractFutureStub<CoordinatorFutureStub> {
    private CoordinatorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoordinatorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoordinatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> dictionaryCoordinator(
        com.example.grpc.CoordinatorOuterClass.RequestCoordinator request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDictionaryCoordinatorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> initialization(
        com.example.grpc.CoordinatorOuterClass.RequestCoordinator request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator> initPrepare(
        com.example.grpc.CoordinatorOuterClass.RequestCoordinator request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitPrepareMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DICTIONARY_COORDINATOR = 0;
  private static final int METHODID_INITIALIZATION = 1;
  private static final int METHODID_INIT_PREPARE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CoordinatorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CoordinatorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DICTIONARY_COORDINATOR:
          serviceImpl.dictionaryCoordinator((com.example.grpc.CoordinatorOuterClass.RequestCoordinator) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>) responseObserver);
          break;
        case METHODID_INITIALIZATION:
          serviceImpl.initialization((com.example.grpc.CoordinatorOuterClass.RequestCoordinator) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>) responseObserver);
          break;
        case METHODID_INIT_PREPARE:
          serviceImpl.initPrepare((com.example.grpc.CoordinatorOuterClass.RequestCoordinator) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.CoordinatorOuterClass.ResponseCoordinator>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CoordinatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CoordinatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.CoordinatorOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Coordinator");
    }
  }

  private static final class CoordinatorFileDescriptorSupplier
      extends CoordinatorBaseDescriptorSupplier {
    CoordinatorFileDescriptorSupplier() {}
  }

  private static final class CoordinatorMethodDescriptorSupplier
      extends CoordinatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CoordinatorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CoordinatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CoordinatorFileDescriptorSupplier())
              .addMethod(getDictionaryCoordinatorMethod())
              .addMethod(getInitializationMethod())
              .addMethod(getInitPrepareMethod())
              .build();
        }
      }
    }
    return result;
  }
}
