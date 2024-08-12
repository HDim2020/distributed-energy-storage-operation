package com.hd.daq.transportapi.proto;

public final class TransportApiProtos {
    private TransportApiProtos() {}
    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }
    public interface ClaimDeviceOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.ClaimDevice)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string secretKey = 1;</code>
         * @return The secretKey.
         */
        java.lang.String getSecretKey();
        /**
         * <code>string secretKey = 1;</code>
         * @return The bytes for secretKey.
         */
        com.google.protobuf.ByteString
        getSecretKeyBytes();

        /**
         * <code>int64 durationMs = 2;</code>
         * @return The durationMs.
         */
        long getDurationMs();
    }
    /**
     * Protobuf type {@code transportapi.ClaimDevice}
     */
    public  static final class ClaimDevice extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.ClaimDevice)
            ClaimDeviceOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ClaimDevice.newBuilder() to construct.
        private ClaimDevice(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ClaimDevice() {
            secretKey_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new ClaimDevice();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ClaimDevice(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            secretKey_ = s;
                            break;
                        }
                        case 16: {

                            durationMs_ = input.readInt64();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDevice_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDevice_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.class, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder.class);
        }

        public static final int SECRETKEY_FIELD_NUMBER = 1;
        private volatile java.lang.Object secretKey_;
        /**
         * <code>string secretKey = 1;</code>
         * @return The secretKey.
         */
        public java.lang.String getSecretKey() {
            java.lang.Object ref = secretKey_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                secretKey_ = s;
                return s;
            }
        }
        /**
         * <code>string secretKey = 1;</code>
         * @return The bytes for secretKey.
         */
        public com.google.protobuf.ByteString
        getSecretKeyBytes() {
            java.lang.Object ref = secretKey_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                secretKey_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int DURATIONMS_FIELD_NUMBER = 2;
        private long durationMs_;
        /**
         * <code>int64 durationMs = 2;</code>
         * @return The durationMs.
         */
        public long getDurationMs() {
            return durationMs_;
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getSecretKeyBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, secretKey_);
            }
            if (durationMs_ != 0L) {
                output.writeInt64(2, durationMs_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getSecretKeyBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, secretKey_);
            }
            if (durationMs_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, durationMs_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice other = (com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice) obj;

            if (!getSecretKey()
                    .equals(other.getSecretKey())) return false;
            if (getDurationMs()
                    != other.getDurationMs()) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + SECRETKEY_FIELD_NUMBER;
            hash = (53 * hash) + getSecretKey().hashCode();
            hash = (37 * hash) + DURATIONMS_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getDurationMs());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.ClaimDevice}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.ClaimDevice)
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDevice_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDevice_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.class, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                secretKey_ = "";

                durationMs_ = 0L;

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDevice_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice result = new com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice(this);
                result.secretKey_ = secretKey_;
                result.durationMs_ = durationMs_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.getDefaultInstance()) return this;
                if (!other.getSecretKey().isEmpty()) {
                    secretKey_ = other.secretKey_;
                    onChanged();
                }
                if (other.getDurationMs() != 0L) {
                    setDurationMs(other.getDurationMs());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object secretKey_ = "";
            /**
             * <code>string secretKey = 1;</code>
             * @return The secretKey.
             */
            public java.lang.String getSecretKey() {
                java.lang.Object ref = secretKey_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    secretKey_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string secretKey = 1;</code>
             * @return The bytes for secretKey.
             */
            public com.google.protobuf.ByteString
            getSecretKeyBytes() {
                java.lang.Object ref = secretKey_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    secretKey_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string secretKey = 1;</code>
             * @param value The secretKey to set.
             * @return This builder for chaining.
             */
            public Builder setSecretKey(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                secretKey_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string secretKey = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearSecretKey() {

                secretKey_ = getDefaultInstance().getSecretKey();
                onChanged();
                return this;
            }
            /**
             * <code>string secretKey = 1;</code>
             * @param value The bytes for secretKey to set.
             * @return This builder for chaining.
             */
            public Builder setSecretKeyBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                secretKey_ = value;
                onChanged();
                return this;
            }

            private long durationMs_ ;
            /**
             * <code>int64 durationMs = 2;</code>
             * @return The durationMs.
             */
            public long getDurationMs() {
                return durationMs_;
            }
            /**
             * <code>int64 durationMs = 2;</code>
             * @param value The durationMs to set.
             * @return This builder for chaining.
             */
            public Builder setDurationMs(long value) {

                durationMs_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 durationMs = 2;</code>
             * @return This builder for chaining.
             */
            public Builder clearDurationMs() {

                durationMs_ = 0L;
                onChanged();
                return this;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.ClaimDevice)
        }

        // @@protoc_insertion_point(class_scope:transportapi.ClaimDevice)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ClaimDevice>
                PARSER = new com.google.protobuf.AbstractParser<ClaimDevice>() {
            @java.lang.Override
            public ClaimDevice parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ClaimDevice(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ClaimDevice> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ClaimDevice> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface AttributesRequestOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.AttributesRequest)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string clientKeys = 1;</code>
         * @return The clientKeys.
         */
        java.lang.String getClientKeys();
        /**
         * <code>string clientKeys = 1;</code>
         * @return The bytes for clientKeys.
         */
        com.google.protobuf.ByteString
        getClientKeysBytes();

        /**
         * <code>string sharedKeys = 2;</code>
         * @return The sharedKeys.
         */
        java.lang.String getSharedKeys();
        /**
         * <code>string sharedKeys = 2;</code>
         * @return The bytes for sharedKeys.
         */
        com.google.protobuf.ByteString
        getSharedKeysBytes();
    }
    /**
     * Protobuf type {@code transportapi.AttributesRequest}
     */
    public  static final class AttributesRequest extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.AttributesRequest)
            AttributesRequestOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use AttributesRequest.newBuilder() to construct.
        private AttributesRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private AttributesRequest() {
            clientKeys_ = "";
            sharedKeys_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new AttributesRequest();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private AttributesRequest(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            clientKeys_ = s;
                            break;
                        }
                        case 18: {
                            java.lang.String s = input.readStringRequireUtf8();

                            sharedKeys_ = s;
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest.class, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest.Builder.class);
        }

        public static final int CLIENTKEYS_FIELD_NUMBER = 1;
        private volatile java.lang.Object clientKeys_;
        /**
         * <code>string clientKeys = 1;</code>
         * @return The clientKeys.
         */
        public java.lang.String getClientKeys() {
            java.lang.Object ref = clientKeys_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                clientKeys_ = s;
                return s;
            }
        }
        /**
         * <code>string clientKeys = 1;</code>
         * @return The bytes for clientKeys.
         */
        public com.google.protobuf.ByteString
        getClientKeysBytes() {
            java.lang.Object ref = clientKeys_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                clientKeys_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int SHAREDKEYS_FIELD_NUMBER = 2;
        private volatile java.lang.Object sharedKeys_;
        /**
         * <code>string sharedKeys = 2;</code>
         * @return The sharedKeys.
         */
        public java.lang.String getSharedKeys() {
            java.lang.Object ref = sharedKeys_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                sharedKeys_ = s;
                return s;
            }
        }
        /**
         * <code>string sharedKeys = 2;</code>
         * @return The bytes for sharedKeys.
         */
        public com.google.protobuf.ByteString
        getSharedKeysBytes() {
            java.lang.Object ref = sharedKeys_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                sharedKeys_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getClientKeysBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, clientKeys_);
            }
            if (!getSharedKeysBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, sharedKeys_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getClientKeysBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, clientKeys_);
            }
            if (!getSharedKeysBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, sharedKeys_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest other = (com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest) obj;

            if (!getClientKeys()
                    .equals(other.getClientKeys())) return false;
            if (!getSharedKeys()
                    .equals(other.getSharedKeys())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + CLIENTKEYS_FIELD_NUMBER;
            hash = (53 * hash) + getClientKeys().hashCode();
            hash = (37 * hash) + SHAREDKEYS_FIELD_NUMBER;
            hash = (53 * hash) + getSharedKeys().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.AttributesRequest}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.AttributesRequest)
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequestOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesRequest_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesRequest_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest.class, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                clientKeys_ = "";

                sharedKeys_ = "";

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesRequest_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest result = new com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest(this);
                result.clientKeys_ = clientKeys_;
                result.sharedKeys_ = sharedKeys_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest.getDefaultInstance()) return this;
                if (!other.getClientKeys().isEmpty()) {
                    clientKeys_ = other.clientKeys_;
                    onChanged();
                }
                if (!other.getSharedKeys().isEmpty()) {
                    sharedKeys_ = other.sharedKeys_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object clientKeys_ = "";
            /**
             * <code>string clientKeys = 1;</code>
             * @return The clientKeys.
             */
            public java.lang.String getClientKeys() {
                java.lang.Object ref = clientKeys_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    clientKeys_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string clientKeys = 1;</code>
             * @return The bytes for clientKeys.
             */
            public com.google.protobuf.ByteString
            getClientKeysBytes() {
                java.lang.Object ref = clientKeys_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    clientKeys_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string clientKeys = 1;</code>
             * @param value The clientKeys to set.
             * @return This builder for chaining.
             */
            public Builder setClientKeys(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                clientKeys_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string clientKeys = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearClientKeys() {

                clientKeys_ = getDefaultInstance().getClientKeys();
                onChanged();
                return this;
            }
            /**
             * <code>string clientKeys = 1;</code>
             * @param value The bytes for clientKeys to set.
             * @return This builder for chaining.
             */
            public Builder setClientKeysBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                clientKeys_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object sharedKeys_ = "";
            /**
             * <code>string sharedKeys = 2;</code>
             * @return The sharedKeys.
             */
            public java.lang.String getSharedKeys() {
                java.lang.Object ref = sharedKeys_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    sharedKeys_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string sharedKeys = 2;</code>
             * @return The bytes for sharedKeys.
             */
            public com.google.protobuf.ByteString
            getSharedKeysBytes() {
                java.lang.Object ref = sharedKeys_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    sharedKeys_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string sharedKeys = 2;</code>
             * @param value The sharedKeys to set.
             * @return This builder for chaining.
             */
            public Builder setSharedKeys(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                sharedKeys_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string sharedKeys = 2;</code>
             * @return This builder for chaining.
             */
            public Builder clearSharedKeys() {

                sharedKeys_ = getDefaultInstance().getSharedKeys();
                onChanged();
                return this;
            }
            /**
             * <code>string sharedKeys = 2;</code>
             * @param value The bytes for sharedKeys to set.
             * @return This builder for chaining.
             */
            public Builder setSharedKeysBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                sharedKeys_ = value;
                onChanged();
                return this;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.AttributesRequest)
        }

        // @@protoc_insertion_point(class_scope:transportapi.AttributesRequest)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<AttributesRequest>
                PARSER = new com.google.protobuf.AbstractParser<AttributesRequest>() {
            @java.lang.Override
            public AttributesRequest parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new AttributesRequest(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<AttributesRequest> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<AttributesRequest> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface RpcRequestOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.RpcRequest)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string method = 1;</code>
         * @return The method.
         */
        java.lang.String getMethod();
        /**
         * <code>string method = 1;</code>
         * @return The bytes for method.
         */
        com.google.protobuf.ByteString
        getMethodBytes();

        /**
         * <code>string params = 2;</code>
         * @return The params.
         */
        java.lang.String getParams();
        /**
         * <code>string params = 2;</code>
         * @return The bytes for params.
         */
        com.google.protobuf.ByteString
        getParamsBytes();
    }
    /**
     * Protobuf type {@code transportapi.RpcRequest}
     */
    public  static final class RpcRequest extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.RpcRequest)
            RpcRequestOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use RpcRequest.newBuilder() to construct.
        private RpcRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private RpcRequest() {
            method_ = "";
            params_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new RpcRequest();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private RpcRequest(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            method_ = s;
                            break;
                        }
                        case 18: {
                            java.lang.String s = input.readStringRequireUtf8();

                            params_ = s;
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_RpcRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_RpcRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest.class, com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest.Builder.class);
        }

        public static final int METHOD_FIELD_NUMBER = 1;
        private volatile java.lang.Object method_;
        /**
         * <code>string method = 1;</code>
         * @return The method.
         */
        public java.lang.String getMethod() {
            java.lang.Object ref = method_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                method_ = s;
                return s;
            }
        }
        /**
         * <code>string method = 1;</code>
         * @return The bytes for method.
         */
        public com.google.protobuf.ByteString
        getMethodBytes() {
            java.lang.Object ref = method_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                method_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int PARAMS_FIELD_NUMBER = 2;
        private volatile java.lang.Object params_;
        /**
         * <code>string params = 2;</code>
         * @return The params.
         */
        public java.lang.String getParams() {
            java.lang.Object ref = params_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                params_ = s;
                return s;
            }
        }
        /**
         * <code>string params = 2;</code>
         * @return The bytes for params.
         */
        public com.google.protobuf.ByteString
        getParamsBytes() {
            java.lang.Object ref = params_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                params_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getMethodBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, method_);
            }
            if (!getParamsBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, params_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getMethodBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, method_);
            }
            if (!getParamsBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, params_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest other = (com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest) obj;

            if (!getMethod()
                    .equals(other.getMethod())) return false;
            if (!getParams()
                    .equals(other.getParams())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + METHOD_FIELD_NUMBER;
            hash = (53 * hash) + getMethod().hashCode();
            hash = (37 * hash) + PARAMS_FIELD_NUMBER;
            hash = (53 * hash) + getParams().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.RpcRequest}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.RpcRequest)
                com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequestOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_RpcRequest_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_RpcRequest_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest.class, com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                method_ = "";

                params_ = "";

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_RpcRequest_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest result = new com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest(this);
                result.method_ = method_;
                result.params_ = params_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest.getDefaultInstance()) return this;
                if (!other.getMethod().isEmpty()) {
                    method_ = other.method_;
                    onChanged();
                }
                if (!other.getParams().isEmpty()) {
                    params_ = other.params_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object method_ = "";
            /**
             * <code>string method = 1;</code>
             * @return The method.
             */
            public java.lang.String getMethod() {
                java.lang.Object ref = method_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    method_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string method = 1;</code>
             * @return The bytes for method.
             */
            public com.google.protobuf.ByteString
            getMethodBytes() {
                java.lang.Object ref = method_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    method_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string method = 1;</code>
             * @param value The method to set.
             * @return This builder for chaining.
             */
            public Builder setMethod(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                method_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string method = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearMethod() {

                method_ = getDefaultInstance().getMethod();
                onChanged();
                return this;
            }
            /**
             * <code>string method = 1;</code>
             * @param value The bytes for method to set.
             * @return This builder for chaining.
             */
            public Builder setMethodBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                method_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object params_ = "";
            /**
             * <code>string params = 2;</code>
             * @return The params.
             */
            public java.lang.String getParams() {
                java.lang.Object ref = params_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    params_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string params = 2;</code>
             * @return The bytes for params.
             */
            public com.google.protobuf.ByteString
            getParamsBytes() {
                java.lang.Object ref = params_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    params_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string params = 2;</code>
             * @param value The params to set.
             * @return This builder for chaining.
             */
            public Builder setParams(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                params_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string params = 2;</code>
             * @return This builder for chaining.
             */
            public Builder clearParams() {

                params_ = getDefaultInstance().getParams();
                onChanged();
                return this;
            }
            /**
             * <code>string params = 2;</code>
             * @param value The bytes for params to set.
             * @return This builder for chaining.
             */
            public Builder setParamsBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                params_ = value;
                onChanged();
                return this;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.RpcRequest)
        }

        // @@protoc_insertion_point(class_scope:transportapi.RpcRequest)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<RpcRequest>
                PARSER = new com.google.protobuf.AbstractParser<RpcRequest>() {
            @java.lang.Override
            public RpcRequest parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new RpcRequest(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<RpcRequest> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<RpcRequest> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.RpcRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface DisconnectMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.DisconnectMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();
    }
    /**
     * Protobuf type {@code transportapi.DisconnectMsg}
     */
    public  static final class DisconnectMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.DisconnectMsg)
            DisconnectMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use DisconnectMsg.newBuilder() to construct.
        private DisconnectMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private DisconnectMsg() {
            deviceName_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new DisconnectMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private DisconnectMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_DisconnectMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_DisconnectMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.DisconnectMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.DisconnectMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_DisconnectMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_DisconnectMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_DisconnectMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg(this);
                result.deviceName_ = deviceName_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.DisconnectMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.DisconnectMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<DisconnectMsg>
                PARSER = new com.google.protobuf.AbstractParser<DisconnectMsg>() {
            @java.lang.Override
            public DisconnectMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new DisconnectMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<DisconnectMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<DisconnectMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.DisconnectMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ConnectMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.ConnectMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>string deviceType = 2;</code>
         * @return The deviceType.
         */
        java.lang.String getDeviceType();
        /**
         * <code>string deviceType = 2;</code>
         * @return The bytes for deviceType.
         */
        com.google.protobuf.ByteString
        getDeviceTypeBytes();
    }
    /**
     * Protobuf type {@code transportapi.ConnectMsg}
     */
    public  static final class ConnectMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.ConnectMsg)
            ConnectMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ConnectMsg.newBuilder() to construct.
        private ConnectMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ConnectMsg() {
            deviceName_ = "";
            deviceType_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new ConnectMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ConnectMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 18: {
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceType_ = s;
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ConnectMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ConnectMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int DEVICETYPE_FIELD_NUMBER = 2;
        private volatile java.lang.Object deviceType_;
        /**
         * <code>string deviceType = 2;</code>
         * @return The deviceType.
         */
        public java.lang.String getDeviceType() {
            java.lang.Object ref = deviceType_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceType_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceType = 2;</code>
         * @return The bytes for deviceType.
         */
        public com.google.protobuf.ByteString
        getDeviceTypeBytes() {
            java.lang.Object ref = deviceType_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceType_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (!getDeviceTypeBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, deviceType_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (!getDeviceTypeBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, deviceType_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (!getDeviceType()
                    .equals(other.getDeviceType())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            hash = (37 * hash) + DEVICETYPE_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceType().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.ConnectMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.ConnectMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ConnectMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ConnectMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                deviceType_ = "";

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ConnectMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg(this);
                result.deviceName_ = deviceName_;
                result.deviceType_ = deviceType_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (!other.getDeviceType().isEmpty()) {
                    deviceType_ = other.deviceType_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object deviceType_ = "";
            /**
             * <code>string deviceType = 2;</code>
             * @return The deviceType.
             */
            public java.lang.String getDeviceType() {
                java.lang.Object ref = deviceType_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceType_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceType = 2;</code>
             * @return The bytes for deviceType.
             */
            public com.google.protobuf.ByteString
            getDeviceTypeBytes() {
                java.lang.Object ref = deviceType_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceType_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceType = 2;</code>
             * @param value The deviceType to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceType(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceType_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceType = 2;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceType() {

                deviceType_ = getDefaultInstance().getDeviceType();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceType = 2;</code>
             * @param value The bytes for deviceType to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceTypeBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceType_ = value;
                onChanged();
                return this;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.ConnectMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.ConnectMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ConnectMsg>
                PARSER = new com.google.protobuf.AbstractParser<ConnectMsg>() {
            @java.lang.Override
            public ConnectMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ConnectMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ConnectMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ConnectMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.ConnectMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TelemetryMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.TelemetryMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>.transport.PostTelemetryMsg msg = 3;</code>
         * @return Whether the msg field is set.
         */
        boolean hasMsg();
        /**
         * <code>.transport.PostTelemetryMsg msg = 3;</code>
         * @return The msg.
         */
        com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg getMsg();
        /**
         * <code>.transport.PostTelemetryMsg msg = 3;</code>
         */
        com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsgOrBuilder getMsgOrBuilder();
    }
    /**
     * Protobuf type {@code transportapi.TelemetryMsg}
     */
    public  static final class TelemetryMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.TelemetryMsg)
            TelemetryMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use TelemetryMsg.newBuilder() to construct.
        private TelemetryMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private TelemetryMsg() {
            deviceName_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new TelemetryMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private TelemetryMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 26: {
                            com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.Builder subBuilder = null;
                            if (msg_ != null) {
                                subBuilder = msg_.toBuilder();
                            }
                            msg_ = input.readMessage(com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(msg_);
                                msg_ = subBuilder.buildPartial();
                            }

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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_TelemetryMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_TelemetryMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int MSG_FIELD_NUMBER = 3;
        private com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg msg_;
        /**
         * <code>.transport.PostTelemetryMsg msg = 3;</code>
         * @return Whether the msg field is set.
         */
        public boolean hasMsg() {
            return msg_ != null;
        }
        /**
         * <code>.transport.PostTelemetryMsg msg = 3;</code>
         * @return The msg.
         */
        public com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg getMsg() {
            return msg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.getDefaultInstance() : msg_;
        }
        /**
         * <code>.transport.PostTelemetryMsg msg = 3;</code>
         */
        public com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsgOrBuilder getMsgOrBuilder() {
            return getMsg();
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (msg_ != null) {
                output.writeMessage(3, getMsg());
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (msg_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(3, getMsg());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (hasMsg() != other.hasMsg()) return false;
            if (hasMsg()) {
                if (!getMsg()
                        .equals(other.getMsg())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            if (hasMsg()) {
                hash = (37 * hash) + MSG_FIELD_NUMBER;
                hash = (53 * hash) + getMsg().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.TelemetryMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.TelemetryMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_TelemetryMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_TelemetryMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                if (msgBuilder_ == null) {
                    msg_ = null;
                } else {
                    msg_ = null;
                    msgBuilder_ = null;
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_TelemetryMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg(this);
                result.deviceName_ = deviceName_;
                if (msgBuilder_ == null) {
                    result.msg_ = msg_;
                } else {
                    result.msg_ = msgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.hasMsg()) {
                    mergeMsg(other.getMsg());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg msg_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg, com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsgOrBuilder> msgBuilder_;
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             * @return Whether the msg field is set.
             */
            public boolean hasMsg() {
                return msgBuilder_ != null || msg_ != null;
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             * @return The msg.
             */
            public com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg getMsg() {
                if (msgBuilder_ == null) {
                    return msg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.getDefaultInstance() : msg_;
                } else {
                    return msgBuilder_.getMessage();
                }
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             */
            public Builder setMsg(com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    msg_ = value;
                    onChanged();
                } else {
                    msgBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             */
            public Builder setMsg(
                    com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    msg_ = builderForValue.build();
                    onChanged();
                } else {
                    msgBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             */
            public Builder mergeMsg(com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg value) {
                if (msgBuilder_ == null) {
                    if (msg_ != null) {
                        msg_ =
                                com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.newBuilder(msg_).mergeFrom(value).buildPartial();
                    } else {
                        msg_ = value;
                    }
                    onChanged();
                } else {
                    msgBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             */
            public Builder clearMsg() {
                if (msgBuilder_ == null) {
                    msg_ = null;
                    onChanged();
                } else {
                    msg_ = null;
                    msgBuilder_ = null;
                }

                return this;
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.Builder getMsgBuilder() {

                onChanged();
                return getMsgFieldBuilder().getBuilder();
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsgOrBuilder getMsgOrBuilder() {
                if (msgBuilder_ != null) {
                    return msgBuilder_.getMessageOrBuilder();
                } else {
                    return msg_ == null ?
                            com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.getDefaultInstance() : msg_;
                }
            }
            /**
             * <code>.transport.PostTelemetryMsg msg = 3;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg, com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsgOrBuilder>
            getMsgFieldBuilder() {
                if (msgBuilder_ == null) {
                    msgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg, com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.PostTelemetryMsgOrBuilder>(
                            getMsg(),
                            getParentForChildren(),
                            isClean());
                    msg_ = null;
                }
                return msgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.TelemetryMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.TelemetryMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<TelemetryMsg>
                PARSER = new com.google.protobuf.AbstractParser<TelemetryMsg>() {
            @java.lang.Override
            public TelemetryMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TelemetryMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TelemetryMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TelemetryMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface AttributesMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.AttributesMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>.transport.PostAttributeMsg msg = 2;</code>
         * @return Whether the msg field is set.
         */
        boolean hasMsg();
        /**
         * <code>.transport.PostAttributeMsg msg = 2;</code>
         * @return The msg.
         */
        com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg getMsg();
        /**
         * <code>.transport.PostAttributeMsg msg = 2;</code>
         */
        com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsgOrBuilder getMsgOrBuilder();
    }
    /**
     * Protobuf type {@code transportapi.AttributesMsg}
     */
    public  static final class AttributesMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.AttributesMsg)
            AttributesMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use AttributesMsg.newBuilder() to construct.
        private AttributesMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private AttributesMsg() {
            deviceName_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new AttributesMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private AttributesMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 18: {
                            com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.Builder subBuilder = null;
                            if (msg_ != null) {
                                subBuilder = msg_.toBuilder();
                            }
                            msg_ = input.readMessage(com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(msg_);
                                msg_ = subBuilder.buildPartial();
                            }

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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int MSG_FIELD_NUMBER = 2;
        private com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg msg_;
        /**
         * <code>.transport.PostAttributeMsg msg = 2;</code>
         * @return Whether the msg field is set.
         */
        public boolean hasMsg() {
            return msg_ != null;
        }
        /**
         * <code>.transport.PostAttributeMsg msg = 2;</code>
         * @return The msg.
         */
        public com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg getMsg() {
            return msg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.getDefaultInstance() : msg_;
        }
        /**
         * <code>.transport.PostAttributeMsg msg = 2;</code>
         */
        public com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsgOrBuilder getMsgOrBuilder() {
            return getMsg();
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (msg_ != null) {
                output.writeMessage(2, getMsg());
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (msg_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getMsg());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (hasMsg() != other.hasMsg()) return false;
            if (hasMsg()) {
                if (!getMsg()
                        .equals(other.getMsg())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            if (hasMsg()) {
                hash = (37 * hash) + MSG_FIELD_NUMBER;
                hash = (53 * hash) + getMsg().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.AttributesMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.AttributesMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                if (msgBuilder_ == null) {
                    msg_ = null;
                } else {
                    msg_ = null;
                    msgBuilder_ = null;
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_AttributesMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg(this);
                result.deviceName_ = deviceName_;
                if (msgBuilder_ == null) {
                    result.msg_ = msg_;
                } else {
                    result.msg_ = msgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.hasMsg()) {
                    mergeMsg(other.getMsg());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg msg_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg, com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsgOrBuilder> msgBuilder_;
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             * @return Whether the msg field is set.
             */
            public boolean hasMsg() {
                return msgBuilder_ != null || msg_ != null;
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             * @return The msg.
             */
            public com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg getMsg() {
                if (msgBuilder_ == null) {
                    return msg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.getDefaultInstance() : msg_;
                } else {
                    return msgBuilder_.getMessage();
                }
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             */
            public Builder setMsg(com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    msg_ = value;
                    onChanged();
                } else {
                    msgBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             */
            public Builder setMsg(
                    com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    msg_ = builderForValue.build();
                    onChanged();
                } else {
                    msgBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             */
            public Builder mergeMsg(com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg value) {
                if (msgBuilder_ == null) {
                    if (msg_ != null) {
                        msg_ =
                                com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.newBuilder(msg_).mergeFrom(value).buildPartial();
                    } else {
                        msg_ = value;
                    }
                    onChanged();
                } else {
                    msgBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             */
            public Builder clearMsg() {
                if (msgBuilder_ == null) {
                    msg_ = null;
                    onChanged();
                } else {
                    msg_ = null;
                    msgBuilder_ = null;
                }

                return this;
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.Builder getMsgBuilder() {

                onChanged();
                return getMsgFieldBuilder().getBuilder();
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsgOrBuilder getMsgOrBuilder() {
                if (msgBuilder_ != null) {
                    return msgBuilder_.getMessageOrBuilder();
                } else {
                    return msg_ == null ?
                            com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.getDefaultInstance() : msg_;
                }
            }
            /**
             * <code>.transport.PostAttributeMsg msg = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg, com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsgOrBuilder>
            getMsgFieldBuilder() {
                if (msgBuilder_ == null) {
                    msgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg, com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.PostAttributeMsgOrBuilder>(
                            getMsg(),
                            getParentForChildren(),
                            isClean());
                    msg_ = null;
                }
                return msgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.AttributesMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.AttributesMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<AttributesMsg>
                PARSER = new com.google.protobuf.AbstractParser<AttributesMsg>() {
            @java.lang.Override
            public AttributesMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new AttributesMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<AttributesMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<AttributesMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ClaimDeviceMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.ClaimDeviceMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
         * @return Whether the claimRequest field is set.
         */
        boolean hasClaimRequest();
        /**
         * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
         * @return The claimRequest.
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice getClaimRequest();
        /**
         * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceOrBuilder getClaimRequestOrBuilder();
    }
    /**
     * Protobuf type {@code transportapi.ClaimDeviceMsg}
     */
    public  static final class ClaimDeviceMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.ClaimDeviceMsg)
            ClaimDeviceMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ClaimDeviceMsg.newBuilder() to construct.
        private ClaimDeviceMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ClaimDeviceMsg() {
            deviceName_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new ClaimDeviceMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ClaimDeviceMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 18: {
                            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder subBuilder = null;
                            if (claimRequest_ != null) {
                                subBuilder = claimRequest_.toBuilder();
                            }
                            claimRequest_ = input.readMessage(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(claimRequest_);
                                claimRequest_ = subBuilder.buildPartial();
                            }

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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDeviceMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDeviceMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int CLAIMREQUEST_FIELD_NUMBER = 2;
        private com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice claimRequest_;
        /**
         * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
         * @return Whether the claimRequest field is set.
         */
        public boolean hasClaimRequest() {
            return claimRequest_ != null;
        }
        /**
         * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
         * @return The claimRequest.
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice getClaimRequest() {
            return claimRequest_ == null ? com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.getDefaultInstance() : claimRequest_;
        }
        /**
         * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceOrBuilder getClaimRequestOrBuilder() {
            return getClaimRequest();
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (claimRequest_ != null) {
                output.writeMessage(2, getClaimRequest());
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (claimRequest_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getClaimRequest());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (hasClaimRequest() != other.hasClaimRequest()) return false;
            if (hasClaimRequest()) {
                if (!getClaimRequest()
                        .equals(other.getClaimRequest())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            if (hasClaimRequest()) {
                hash = (37 * hash) + CLAIMREQUEST_FIELD_NUMBER;
                hash = (53 * hash) + getClaimRequest().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.ClaimDeviceMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.ClaimDeviceMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDeviceMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDeviceMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                if (claimRequestBuilder_ == null) {
                    claimRequest_ = null;
                } else {
                    claimRequest_ = null;
                    claimRequestBuilder_ = null;
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_ClaimDeviceMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg(this);
                result.deviceName_ = deviceName_;
                if (claimRequestBuilder_ == null) {
                    result.claimRequest_ = claimRequest_;
                } else {
                    result.claimRequest_ = claimRequestBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.hasClaimRequest()) {
                    mergeClaimRequest(other.getClaimRequest());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice claimRequest_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceOrBuilder> claimRequestBuilder_;
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             * @return Whether the claimRequest field is set.
             */
            public boolean hasClaimRequest() {
                return claimRequestBuilder_ != null || claimRequest_ != null;
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             * @return The claimRequest.
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice getClaimRequest() {
                if (claimRequestBuilder_ == null) {
                    return claimRequest_ == null ? com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.getDefaultInstance() : claimRequest_;
                } else {
                    return claimRequestBuilder_.getMessage();
                }
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             */
            public Builder setClaimRequest(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice value) {
                if (claimRequestBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    claimRequest_ = value;
                    onChanged();
                } else {
                    claimRequestBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             */
            public Builder setClaimRequest(
                    com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder builderForValue) {
                if (claimRequestBuilder_ == null) {
                    claimRequest_ = builderForValue.build();
                    onChanged();
                } else {
                    claimRequestBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             */
            public Builder mergeClaimRequest(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice value) {
                if (claimRequestBuilder_ == null) {
                    if (claimRequest_ != null) {
                        claimRequest_ =
                                com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.newBuilder(claimRequest_).mergeFrom(value).buildPartial();
                    } else {
                        claimRequest_ = value;
                    }
                    onChanged();
                } else {
                    claimRequestBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             */
            public Builder clearClaimRequest() {
                if (claimRequestBuilder_ == null) {
                    claimRequest_ = null;
                    onChanged();
                } else {
                    claimRequest_ = null;
                    claimRequestBuilder_ = null;
                }

                return this;
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder getClaimRequestBuilder() {

                onChanged();
                return getClaimRequestFieldBuilder().getBuilder();
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceOrBuilder getClaimRequestOrBuilder() {
                if (claimRequestBuilder_ != null) {
                    return claimRequestBuilder_.getMessageOrBuilder();
                } else {
                    return claimRequest_ == null ?
                            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.getDefaultInstance() : claimRequest_;
                }
            }
            /**
             * <code>.transportapi.ClaimDevice claimRequest = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceOrBuilder>
            getClaimRequestFieldBuilder() {
                if (claimRequestBuilder_ == null) {
                    claimRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDevice.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceOrBuilder>(
                            getClaimRequest(),
                            getParentForChildren(),
                            isClean());
                    claimRequest_ = null;
                }
                return claimRequestBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.ClaimDeviceMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.ClaimDeviceMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ClaimDeviceMsg>
                PARSER = new com.google.protobuf.AbstractParser<ClaimDeviceMsg>() {
            @java.lang.Override
            public ClaimDeviceMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ClaimDeviceMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ClaimDeviceMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ClaimDeviceMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayTelemetryMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayTelemetryMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg>
        getMsgList();
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg getMsg(int index);
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        int getMsgCount();
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder>
        getMsgOrBuilderList();
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder getMsgOrBuilder(
                int index);
    }
    /**
     * Protobuf type {@code transportapi.GatewayTelemetryMsg}
     */
    public  static final class GatewayTelemetryMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayTelemetryMsg)
            GatewayTelemetryMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayTelemetryMsg.newBuilder() to construct.
        private GatewayTelemetryMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayTelemetryMsg() {
            msg_ = java.util.Collections.emptyList();
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayTelemetryMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayTelemetryMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
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
                            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                                msg_ = new java.util.ArrayList<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg>();
                                mutable_bitField0_ |= 0x00000001;
                            }
                            msg_.add(
                                    input.readMessage(com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.parser(), extensionRegistry));
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
                    msg_ = java.util.Collections.unmodifiableList(msg_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayTelemetryMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayTelemetryMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg.Builder.class);
        }

        public static final int MSG_FIELD_NUMBER = 1;
        private java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg> msg_;
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg> getMsgList() {
            return msg_;
        }
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        public java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder>
        getMsgOrBuilderList() {
            return msg_;
        }
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        public int getMsgCount() {
            return msg_.size();
        }
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg getMsg(int index) {
            return msg_.get(index);
        }
        /**
         * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder getMsgOrBuilder(
                int index) {
            return msg_.get(index);
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            for (int i = 0; i < msg_.size(); i++) {
                output.writeMessage(1, msg_.get(i));
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < msg_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, msg_.get(i));
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg) obj;

            if (!getMsgList()
                    .equals(other.getMsgList())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getMsgCount() > 0) {
                hash = (37 * hash) + MSG_FIELD_NUMBER;
                hash = (53 * hash) + getMsgList().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayTelemetryMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayTelemetryMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayTelemetryMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayTelemetryMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getMsgFieldBuilder();
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (msgBuilder_ == null) {
                    msg_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    msgBuilder_.clear();
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayTelemetryMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg(this);
                int from_bitField0_ = bitField0_;
                if (msgBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0)) {
                        msg_ = java.util.Collections.unmodifiableList(msg_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.msg_ = msg_;
                } else {
                    result.msg_ = msgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance()) return this;
                if (msgBuilder_ == null) {
                    if (!other.msg_.isEmpty()) {
                        if (msg_.isEmpty()) {
                            msg_ = other.msg_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureMsgIsMutable();
                            msg_.addAll(other.msg_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.msg_.isEmpty()) {
                        if (msgBuilder_.isEmpty()) {
                            msgBuilder_.dispose();
                            msgBuilder_ = null;
                            msg_ = other.msg_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            msgBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getMsgFieldBuilder() : null;
                        } else {
                            msgBuilder_.addAllMessages(other.msg_);
                        }
                    }
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg> msg_ =
                    java.util.Collections.emptyList();
            private void ensureMsgIsMutable() {
                if (!((bitField0_ & 0x00000001) != 0)) {
                    msg_ = new java.util.ArrayList<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg>(msg_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder> msgBuilder_;

            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg> getMsgList() {
                if (msgBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(msg_);
                } else {
                    return msgBuilder_.getMessageList();
                }
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public int getMsgCount() {
                if (msgBuilder_ == null) {
                    return msg_.size();
                } else {
                    return msgBuilder_.getCount();
                }
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg getMsg(int index) {
                if (msgBuilder_ == null) {
                    return msg_.get(index);
                } else {
                    return msgBuilder_.getMessage(index);
                }
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder setMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.set(index, value);
                    onChanged();
                } else {
                    msgBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder setMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder addMsg(com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.add(value);
                    onChanged();
                } else {
                    msgBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder addMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.add(index, value);
                    onChanged();
                } else {
                    msgBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder addMsg(
                    com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.add(builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder addMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder addAllMsg(
                    java.lang.Iterable<? extends com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg> values) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, msg_);
                    onChanged();
                } else {
                    msgBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder clearMsg() {
                if (msgBuilder_ == null) {
                    msg_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    msgBuilder_.clear();
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public Builder removeMsg(int index) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.remove(index);
                    onChanged();
                } else {
                    msgBuilder_.remove(index);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder getMsgBuilder(
                    int index) {
                return getMsgFieldBuilder().getBuilder(index);
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder getMsgOrBuilder(
                    int index) {
                if (msgBuilder_ == null) {
                    return msg_.get(index);  } else {
                    return msgBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder>
            getMsgOrBuilderList() {
                if (msgBuilder_ != null) {
                    return msgBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(msg_);
                }
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder addMsgBuilder() {
                return getMsgFieldBuilder().addBuilder(
                        com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.getDefaultInstance());
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder addMsgBuilder(
                    int index) {
                return getMsgFieldBuilder().addBuilder(
                        index, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.getDefaultInstance());
            }
            /**
             * <code>repeated .transportapi.TelemetryMsg msg = 1;</code>
             */
            public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder>
            getMsgBuilderList() {
                return getMsgFieldBuilder().getBuilderList();
            }
            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder>
            getMsgFieldBuilder() {
                if (msgBuilder_ == null) {
                    msgBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.TelemetryMsgOrBuilder>(
                            msg_,
                            ((bitField0_ & 0x00000001) != 0),
                            getParentForChildren(),
                            isClean());
                    msg_ = null;
                }
                return msgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayTelemetryMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayTelemetryMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayTelemetryMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayTelemetryMsg>() {
            @java.lang.Override
            public GatewayTelemetryMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayTelemetryMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayTelemetryMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayTelemetryMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayTelemetryMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayClaimMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayClaimMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg>
        getMsgList();
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg getMsg(int index);
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        int getMsgCount();
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder>
        getMsgOrBuilderList();
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder getMsgOrBuilder(
                int index);
    }
    /**
     * Protobuf type {@code transportapi.GatewayClaimMsg}
     */
    public  static final class GatewayClaimMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayClaimMsg)
            GatewayClaimMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayClaimMsg.newBuilder() to construct.
        private GatewayClaimMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayClaimMsg() {
            msg_ = java.util.Collections.emptyList();
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayClaimMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayClaimMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
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
                            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                                msg_ = new java.util.ArrayList<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg>();
                                mutable_bitField0_ |= 0x00000001;
                            }
                            msg_.add(
                                    input.readMessage(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.parser(), extensionRegistry));
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
                    msg_ = java.util.Collections.unmodifiableList(msg_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayClaimMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayClaimMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg.Builder.class);
        }

        public static final int MSG_FIELD_NUMBER = 1;
        private java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg> msg_;
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg> getMsgList() {
            return msg_;
        }
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        public java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder>
        getMsgOrBuilderList() {
            return msg_;
        }
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        public int getMsgCount() {
            return msg_.size();
        }
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg getMsg(int index) {
            return msg_.get(index);
        }
        /**
         * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder getMsgOrBuilder(
                int index) {
            return msg_.get(index);
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            for (int i = 0; i < msg_.size(); i++) {
                output.writeMessage(1, msg_.get(i));
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < msg_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, msg_.get(i));
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg) obj;

            if (!getMsgList()
                    .equals(other.getMsgList())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getMsgCount() > 0) {
                hash = (37 * hash) + MSG_FIELD_NUMBER;
                hash = (53 * hash) + getMsgList().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayClaimMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayClaimMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayClaimMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayClaimMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getMsgFieldBuilder();
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (msgBuilder_ == null) {
                    msg_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    msgBuilder_.clear();
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayClaimMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg(this);
                int from_bitField0_ = bitField0_;
                if (msgBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0)) {
                        msg_ = java.util.Collections.unmodifiableList(msg_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.msg_ = msg_;
                } else {
                    result.msg_ = msgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg.getDefaultInstance()) return this;
                if (msgBuilder_ == null) {
                    if (!other.msg_.isEmpty()) {
                        if (msg_.isEmpty()) {
                            msg_ = other.msg_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureMsgIsMutable();
                            msg_.addAll(other.msg_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.msg_.isEmpty()) {
                        if (msgBuilder_.isEmpty()) {
                            msgBuilder_.dispose();
                            msgBuilder_ = null;
                            msg_ = other.msg_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            msgBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getMsgFieldBuilder() : null;
                        } else {
                            msgBuilder_.addAllMessages(other.msg_);
                        }
                    }
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg> msg_ =
                    java.util.Collections.emptyList();
            private void ensureMsgIsMutable() {
                if (!((bitField0_ & 0x00000001) != 0)) {
                    msg_ = new java.util.ArrayList<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg>(msg_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder> msgBuilder_;

            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg> getMsgList() {
                if (msgBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(msg_);
                } else {
                    return msgBuilder_.getMessageList();
                }
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public int getMsgCount() {
                if (msgBuilder_ == null) {
                    return msg_.size();
                } else {
                    return msgBuilder_.getCount();
                }
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg getMsg(int index) {
                if (msgBuilder_ == null) {
                    return msg_.get(index);
                } else {
                    return msgBuilder_.getMessage(index);
                }
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder setMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.set(index, value);
                    onChanged();
                } else {
                    msgBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder setMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder addMsg(com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.add(value);
                    onChanged();
                } else {
                    msgBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder addMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.add(index, value);
                    onChanged();
                } else {
                    msgBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder addMsg(
                    com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.add(builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder addMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder addAllMsg(
                    java.lang.Iterable<? extends com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg> values) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, msg_);
                    onChanged();
                } else {
                    msgBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder clearMsg() {
                if (msgBuilder_ == null) {
                    msg_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    msgBuilder_.clear();
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public Builder removeMsg(int index) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.remove(index);
                    onChanged();
                } else {
                    msgBuilder_.remove(index);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder getMsgBuilder(
                    int index) {
                return getMsgFieldBuilder().getBuilder(index);
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder getMsgOrBuilder(
                    int index) {
                if (msgBuilder_ == null) {
                    return msg_.get(index);  } else {
                    return msgBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder>
            getMsgOrBuilderList() {
                if (msgBuilder_ != null) {
                    return msgBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(msg_);
                }
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder addMsgBuilder() {
                return getMsgFieldBuilder().addBuilder(
                        com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.getDefaultInstance());
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder addMsgBuilder(
                    int index) {
                return getMsgFieldBuilder().addBuilder(
                        index, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.getDefaultInstance());
            }
            /**
             * <code>repeated .transportapi.ClaimDeviceMsg msg = 1;</code>
             */
            public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder>
            getMsgBuilderList() {
                return getMsgFieldBuilder().getBuilderList();
            }
            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder>
            getMsgFieldBuilder() {
                if (msgBuilder_ == null) {
                    msgBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.ClaimDeviceMsgOrBuilder>(
                            msg_,
                            ((bitField0_ & 0x00000001) != 0),
                            getParentForChildren(),
                            isClean());
                    msg_ = null;
                }
                return msgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayClaimMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayClaimMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayClaimMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayClaimMsg>() {
            @java.lang.Override
            public GatewayClaimMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayClaimMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayClaimMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayClaimMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayClaimMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayAttributesMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayAttributesMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg>
        getMsgList();
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg getMsg(int index);
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        int getMsgCount();
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder>
        getMsgOrBuilderList();
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder getMsgOrBuilder(
                int index);
    }
    /**
     * Protobuf type {@code transportapi.GatewayAttributesMsg}
     */
    public  static final class GatewayAttributesMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayAttributesMsg)
            GatewayAttributesMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayAttributesMsg.newBuilder() to construct.
        private GatewayAttributesMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayAttributesMsg() {
            msg_ = java.util.Collections.emptyList();
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayAttributesMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayAttributesMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
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
                            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                                msg_ = new java.util.ArrayList<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg>();
                                mutable_bitField0_ |= 0x00000001;
                            }
                            msg_.add(
                                    input.readMessage(com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.parser(), extensionRegistry));
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
                    msg_ = java.util.Collections.unmodifiableList(msg_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg.Builder.class);
        }

        public static final int MSG_FIELD_NUMBER = 1;
        private java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg> msg_;
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg> getMsgList() {
            return msg_;
        }
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        public java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder>
        getMsgOrBuilderList() {
            return msg_;
        }
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        public int getMsgCount() {
            return msg_.size();
        }
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg getMsg(int index) {
            return msg_.get(index);
        }
        /**
         * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
         */
        public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder getMsgOrBuilder(
                int index) {
            return msg_.get(index);
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            for (int i = 0; i < msg_.size(); i++) {
                output.writeMessage(1, msg_.get(i));
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < msg_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, msg_.get(i));
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg) obj;

            if (!getMsgList()
                    .equals(other.getMsgList())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getMsgCount() > 0) {
                hash = (37 * hash) + MSG_FIELD_NUMBER;
                hash = (53 * hash) + getMsgList().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayAttributesMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayAttributesMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getMsgFieldBuilder();
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (msgBuilder_ == null) {
                    msg_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    msgBuilder_.clear();
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg(this);
                int from_bitField0_ = bitField0_;
                if (msgBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0)) {
                        msg_ = java.util.Collections.unmodifiableList(msg_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.msg_ = msg_;
                } else {
                    result.msg_ = msgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg.getDefaultInstance()) return this;
                if (msgBuilder_ == null) {
                    if (!other.msg_.isEmpty()) {
                        if (msg_.isEmpty()) {
                            msg_ = other.msg_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureMsgIsMutable();
                            msg_.addAll(other.msg_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.msg_.isEmpty()) {
                        if (msgBuilder_.isEmpty()) {
                            msgBuilder_.dispose();
                            msgBuilder_ = null;
                            msg_ = other.msg_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            msgBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getMsgFieldBuilder() : null;
                        } else {
                            msgBuilder_.addAllMessages(other.msg_);
                        }
                    }
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg> msg_ =
                    java.util.Collections.emptyList();
            private void ensureMsgIsMutable() {
                if (!((bitField0_ & 0x00000001) != 0)) {
                    msg_ = new java.util.ArrayList<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg>(msg_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder> msgBuilder_;

            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg> getMsgList() {
                if (msgBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(msg_);
                } else {
                    return msgBuilder_.getMessageList();
                }
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public int getMsgCount() {
                if (msgBuilder_ == null) {
                    return msg_.size();
                } else {
                    return msgBuilder_.getCount();
                }
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg getMsg(int index) {
                if (msgBuilder_ == null) {
                    return msg_.get(index);
                } else {
                    return msgBuilder_.getMessage(index);
                }
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder setMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.set(index, value);
                    onChanged();
                } else {
                    msgBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder setMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder addMsg(com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.add(value);
                    onChanged();
                } else {
                    msgBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder addMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg value) {
                if (msgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMsgIsMutable();
                    msg_.add(index, value);
                    onChanged();
                } else {
                    msgBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder addMsg(
                    com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.add(builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder addMsg(
                    int index, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder builderForValue) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    msgBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder addAllMsg(
                    java.lang.Iterable<? extends com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg> values) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, msg_);
                    onChanged();
                } else {
                    msgBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder clearMsg() {
                if (msgBuilder_ == null) {
                    msg_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    msgBuilder_.clear();
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public Builder removeMsg(int index) {
                if (msgBuilder_ == null) {
                    ensureMsgIsMutable();
                    msg_.remove(index);
                    onChanged();
                } else {
                    msgBuilder_.remove(index);
                }
                return this;
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder getMsgBuilder(
                    int index) {
                return getMsgFieldBuilder().getBuilder(index);
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder getMsgOrBuilder(
                    int index) {
                if (msgBuilder_ == null) {
                    return msg_.get(index);  } else {
                    return msgBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public java.util.List<? extends com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder>
            getMsgOrBuilderList() {
                if (msgBuilder_ != null) {
                    return msgBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(msg_);
                }
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder addMsgBuilder() {
                return getMsgFieldBuilder().addBuilder(
                        com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.getDefaultInstance());
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder addMsgBuilder(
                    int index) {
                return getMsgFieldBuilder().addBuilder(
                        index, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.getDefaultInstance());
            }
            /**
             * <code>repeated .transportapi.AttributesMsg msg = 1;</code>
             */
            public java.util.List<com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder>
            getMsgBuilderList() {
                return getMsgFieldBuilder().getBuilderList();
            }
            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder>
            getMsgFieldBuilder() {
                if (msgBuilder_ == null) {
                    msgBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsg.Builder, com.hd.daq.transportapi.proto.TransportApiProtos.AttributesMsgOrBuilder>(
                            msg_,
                            ((bitField0_ & 0x00000001) != 0),
                            getParentForChildren(),
                            isClean());
                    msg_ = null;
                }
                return msgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayAttributesMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayAttributesMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayAttributesMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayAttributesMsg>() {
            @java.lang.Override
            public GatewayAttributesMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayAttributesMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayAttributesMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayAttributesMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayRpcResponseMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayRpcResponseMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>int32 id = 2;</code>
         * @return The id.
         */
        int getId();

        /**
         * <code>string data = 3;</code>
         * @return The data.
         */
        java.lang.String getData();
        /**
         * <code>string data = 3;</code>
         * @return The bytes for data.
         */
        com.google.protobuf.ByteString
        getDataBytes();
    }
    /**
     * Protobuf type {@code transportapi.GatewayRpcResponseMsg}
     */
    public  static final class GatewayRpcResponseMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayRpcResponseMsg)
            GatewayRpcResponseMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayRpcResponseMsg.newBuilder() to construct.
        private GatewayRpcResponseMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayRpcResponseMsg() {
            deviceName_ = "";
            data_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayRpcResponseMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayRpcResponseMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 16: {

                            id_ = input.readInt32();
                            break;
                        }
                        case 26: {
                            java.lang.String s = input.readStringRequireUtf8();

                            data_ = s;
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayRpcResponseMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayRpcResponseMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int ID_FIELD_NUMBER = 2;
        private int id_;
        /**
         * <code>int32 id = 2;</code>
         * @return The id.
         */
        public int getId() {
            return id_;
        }

        public static final int DATA_FIELD_NUMBER = 3;
        private volatile java.lang.Object data_;
        /**
         * <code>string data = 3;</code>
         * @return The data.
         */
        public java.lang.String getData() {
            java.lang.Object ref = data_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                data_ = s;
                return s;
            }
        }
        /**
         * <code>string data = 3;</code>
         * @return The bytes for data.
         */
        public com.google.protobuf.ByteString
        getDataBytes() {
            java.lang.Object ref = data_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                data_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (id_ != 0) {
                output.writeInt32(2, id_);
            }
            if (!getDataBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, data_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (id_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, id_);
            }
            if (!getDataBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, data_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (getId()
                    != other.getId()) return false;
            if (!getData()
                    .equals(other.getData())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            hash = (37 * hash) + ID_FIELD_NUMBER;
            hash = (53 * hash) + getId();
            hash = (37 * hash) + DATA_FIELD_NUMBER;
            hash = (53 * hash) + getData().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayRpcResponseMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayRpcResponseMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayRpcResponseMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayRpcResponseMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                id_ = 0;

                data_ = "";

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayRpcResponseMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg(this);
                result.deviceName_ = deviceName_;
                result.id_ = id_;
                result.data_ = data_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (!other.getData().isEmpty()) {
                    data_ = other.data_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private int id_ ;
            /**
             * <code>int32 id = 2;</code>
             * @return The id.
             */
            public int getId() {
                return id_;
            }
            /**
             * <code>int32 id = 2;</code>
             * @param value The id to set.
             * @return This builder for chaining.
             */
            public Builder setId(int value) {

                id_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int32 id = 2;</code>
             * @return This builder for chaining.
             */
            public Builder clearId() {

                id_ = 0;
                onChanged();
                return this;
            }

            private java.lang.Object data_ = "";
            /**
             * <code>string data = 3;</code>
             * @return The data.
             */
            public java.lang.String getData() {
                java.lang.Object ref = data_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    data_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string data = 3;</code>
             * @return The bytes for data.
             */
            public com.google.protobuf.ByteString
            getDataBytes() {
                java.lang.Object ref = data_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    data_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string data = 3;</code>
             * @param value The data to set.
             * @return This builder for chaining.
             */
            public Builder setData(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                data_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string data = 3;</code>
             * @return This builder for chaining.
             */
            public Builder clearData() {

                data_ = getDefaultInstance().getData();
                onChanged();
                return this;
            }
            /**
             * <code>string data = 3;</code>
             * @param value The bytes for data to set.
             * @return This builder for chaining.
             */
            public Builder setDataBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                data_ = value;
                onChanged();
                return this;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayRpcResponseMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayRpcResponseMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayRpcResponseMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayRpcResponseMsg>() {
            @java.lang.Override
            public GatewayRpcResponseMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayRpcResponseMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayRpcResponseMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayRpcResponseMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayRpcResponseMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayAttributeResponseMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayAttributeResponseMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
         * @return Whether the responseMsg field is set.
         */
        boolean hasResponseMsg();
        /**
         * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
         * @return The responseMsg.
         */
        com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg getResponseMsg();
        /**
         * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
         */
        com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsgOrBuilder getResponseMsgOrBuilder();
    }
    /**
     * Protobuf type {@code transportapi.GatewayAttributeResponseMsg}
     */
    public  static final class GatewayAttributeResponseMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayAttributeResponseMsg)
            GatewayAttributeResponseMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayAttributeResponseMsg.newBuilder() to construct.
        private GatewayAttributeResponseMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayAttributeResponseMsg() {
            deviceName_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayAttributeResponseMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayAttributeResponseMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 18: {
                            com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.Builder subBuilder = null;
                            if (responseMsg_ != null) {
                                subBuilder = responseMsg_.toBuilder();
                            }
                            responseMsg_ = input.readMessage(com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(responseMsg_);
                                responseMsg_ = subBuilder.buildPartial();
                            }

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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeResponseMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeResponseMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int RESPONSEMSG_FIELD_NUMBER = 2;
        private com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg responseMsg_;
        /**
         * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
         * @return Whether the responseMsg field is set.
         */
        public boolean hasResponseMsg() {
            return responseMsg_ != null;
        }
        /**
         * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
         * @return The responseMsg.
         */
        public com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg getResponseMsg() {
            return responseMsg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.getDefaultInstance() : responseMsg_;
        }
        /**
         * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
         */
        public com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsgOrBuilder getResponseMsgOrBuilder() {
            return getResponseMsg();
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (responseMsg_ != null) {
                output.writeMessage(2, getResponseMsg());
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (responseMsg_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getResponseMsg());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (hasResponseMsg() != other.hasResponseMsg()) return false;
            if (hasResponseMsg()) {
                if (!getResponseMsg()
                        .equals(other.getResponseMsg())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            if (hasResponseMsg()) {
                hash = (37 * hash) + RESPONSEMSG_FIELD_NUMBER;
                hash = (53 * hash) + getResponseMsg().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayAttributeResponseMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayAttributeResponseMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeResponseMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeResponseMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                if (responseMsgBuilder_ == null) {
                    responseMsg_ = null;
                } else {
                    responseMsg_ = null;
                    responseMsgBuilder_ = null;
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeResponseMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg(this);
                result.deviceName_ = deviceName_;
                if (responseMsgBuilder_ == null) {
                    result.responseMsg_ = responseMsg_;
                } else {
                    result.responseMsg_ = responseMsgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.hasResponseMsg()) {
                    mergeResponseMsg(other.getResponseMsg());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg responseMsg_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg, com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsgOrBuilder> responseMsgBuilder_;
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             * @return Whether the responseMsg field is set.
             */
            public boolean hasResponseMsg() {
                return responseMsgBuilder_ != null || responseMsg_ != null;
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             * @return The responseMsg.
             */
            public com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg getResponseMsg() {
                if (responseMsgBuilder_ == null) {
                    return responseMsg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.getDefaultInstance() : responseMsg_;
                } else {
                    return responseMsgBuilder_.getMessage();
                }
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             */
            public Builder setResponseMsg(com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg value) {
                if (responseMsgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    responseMsg_ = value;
                    onChanged();
                } else {
                    responseMsgBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             */
            public Builder setResponseMsg(
                    com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.Builder builderForValue) {
                if (responseMsgBuilder_ == null) {
                    responseMsg_ = builderForValue.build();
                    onChanged();
                } else {
                    responseMsgBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             */
            public Builder mergeResponseMsg(com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg value) {
                if (responseMsgBuilder_ == null) {
                    if (responseMsg_ != null) {
                        responseMsg_ =
                                com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.newBuilder(responseMsg_).mergeFrom(value).buildPartial();
                    } else {
                        responseMsg_ = value;
                    }
                    onChanged();
                } else {
                    responseMsgBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             */
            public Builder clearResponseMsg() {
                if (responseMsgBuilder_ == null) {
                    responseMsg_ = null;
                    onChanged();
                } else {
                    responseMsg_ = null;
                    responseMsgBuilder_ = null;
                }

                return this;
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.Builder getResponseMsgBuilder() {

                onChanged();
                return getResponseMsgFieldBuilder().getBuilder();
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsgOrBuilder getResponseMsgOrBuilder() {
                if (responseMsgBuilder_ != null) {
                    return responseMsgBuilder_.getMessageOrBuilder();
                } else {
                    return responseMsg_ == null ?
                            com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.getDefaultInstance() : responseMsg_;
                }
            }
            /**
             * <code>.transport.GetAttributeResponseMsg responseMsg = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg, com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsgOrBuilder>
            getResponseMsgFieldBuilder() {
                if (responseMsgBuilder_ == null) {
                    responseMsgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg, com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.GetAttributeResponseMsgOrBuilder>(
                            getResponseMsg(),
                            getParentForChildren(),
                            isClean());
                    responseMsg_ = null;
                }
                return responseMsgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayAttributeResponseMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayAttributeResponseMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayAttributeResponseMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayAttributeResponseMsg>() {
            @java.lang.Override
            public GatewayAttributeResponseMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayAttributeResponseMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayAttributeResponseMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayAttributeResponseMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeResponseMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayAttributeUpdateNotificationMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayAttributeUpdateNotificationMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
         * @return Whether the notificationMsg field is set.
         */
        boolean hasNotificationMsg();
        /**
         * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
         * @return The notificationMsg.
         */
        com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg getNotificationMsg();
        /**
         * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
         */
        com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsgOrBuilder getNotificationMsgOrBuilder();
    }
    /**
     * Protobuf type {@code transportapi.GatewayAttributeUpdateNotificationMsg}
     */
    public  static final class GatewayAttributeUpdateNotificationMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayAttributeUpdateNotificationMsg)
            GatewayAttributeUpdateNotificationMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayAttributeUpdateNotificationMsg.newBuilder() to construct.
        private GatewayAttributeUpdateNotificationMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayAttributeUpdateNotificationMsg() {
            deviceName_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayAttributeUpdateNotificationMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayAttributeUpdateNotificationMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 18: {
                            com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.Builder subBuilder = null;
                            if (notificationMsg_ != null) {
                                subBuilder = notificationMsg_.toBuilder();
                            }
                            notificationMsg_ = input.readMessage(com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(notificationMsg_);
                                notificationMsg_ = subBuilder.buildPartial();
                            }

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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int NOTIFICATIONMSG_FIELD_NUMBER = 2;
        private com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg notificationMsg_;
        /**
         * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
         * @return Whether the notificationMsg field is set.
         */
        public boolean hasNotificationMsg() {
            return notificationMsg_ != null;
        }
        /**
         * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
         * @return The notificationMsg.
         */
        public com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg getNotificationMsg() {
            return notificationMsg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance() : notificationMsg_;
        }
        /**
         * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
         */
        public com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsgOrBuilder getNotificationMsgOrBuilder() {
            return getNotificationMsg();
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (notificationMsg_ != null) {
                output.writeMessage(2, getNotificationMsg());
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (notificationMsg_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getNotificationMsg());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (hasNotificationMsg() != other.hasNotificationMsg()) return false;
            if (hasNotificationMsg()) {
                if (!getNotificationMsg()
                        .equals(other.getNotificationMsg())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            if (hasNotificationMsg()) {
                hash = (37 * hash) + NOTIFICATIONMSG_FIELD_NUMBER;
                hash = (53 * hash) + getNotificationMsg().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayAttributeUpdateNotificationMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayAttributeUpdateNotificationMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                if (notificationMsgBuilder_ == null) {
                    notificationMsg_ = null;
                } else {
                    notificationMsg_ = null;
                    notificationMsgBuilder_ = null;
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg(this);
                result.deviceName_ = deviceName_;
                if (notificationMsgBuilder_ == null) {
                    result.notificationMsg_ = notificationMsg_;
                } else {
                    result.notificationMsg_ = notificationMsgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.hasNotificationMsg()) {
                    mergeNotificationMsg(other.getNotificationMsg());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg notificationMsg_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg, com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsgOrBuilder> notificationMsgBuilder_;
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             * @return Whether the notificationMsg field is set.
             */
            public boolean hasNotificationMsg() {
                return notificationMsgBuilder_ != null || notificationMsg_ != null;
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             * @return The notificationMsg.
             */
            public com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg getNotificationMsg() {
                if (notificationMsgBuilder_ == null) {
                    return notificationMsg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance() : notificationMsg_;
                } else {
                    return notificationMsgBuilder_.getMessage();
                }
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             */
            public Builder setNotificationMsg(com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg value) {
                if (notificationMsgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    notificationMsg_ = value;
                    onChanged();
                } else {
                    notificationMsgBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             */
            public Builder setNotificationMsg(
                    com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.Builder builderForValue) {
                if (notificationMsgBuilder_ == null) {
                    notificationMsg_ = builderForValue.build();
                    onChanged();
                } else {
                    notificationMsgBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             */
            public Builder mergeNotificationMsg(com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg value) {
                if (notificationMsgBuilder_ == null) {
                    if (notificationMsg_ != null) {
                        notificationMsg_ =
                                com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.newBuilder(notificationMsg_).mergeFrom(value).buildPartial();
                    } else {
                        notificationMsg_ = value;
                    }
                    onChanged();
                } else {
                    notificationMsgBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             */
            public Builder clearNotificationMsg() {
                if (notificationMsgBuilder_ == null) {
                    notificationMsg_ = null;
                    onChanged();
                } else {
                    notificationMsg_ = null;
                    notificationMsgBuilder_ = null;
                }

                return this;
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.Builder getNotificationMsgBuilder() {

                onChanged();
                return getNotificationMsgFieldBuilder().getBuilder();
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsgOrBuilder getNotificationMsgOrBuilder() {
                if (notificationMsgBuilder_ != null) {
                    return notificationMsgBuilder_.getMessageOrBuilder();
                } else {
                    return notificationMsg_ == null ?
                            com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance() : notificationMsg_;
                }
            }
            /**
             * <code>.transport.AttributeUpdateNotificationMsg notificationMsg = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg, com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsgOrBuilder>
            getNotificationMsgFieldBuilder() {
                if (notificationMsgBuilder_ == null) {
                    notificationMsgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg, com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.AttributeUpdateNotificationMsgOrBuilder>(
                            getNotificationMsg(),
                            getParentForChildren(),
                            isClean());
                    notificationMsg_ = null;
                }
                return notificationMsgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayAttributeUpdateNotificationMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayAttributeUpdateNotificationMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayAttributeUpdateNotificationMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayAttributeUpdateNotificationMsg>() {
            @java.lang.Override
            public GatewayAttributeUpdateNotificationMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayAttributeUpdateNotificationMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayAttributeUpdateNotificationMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayAttributeUpdateNotificationMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributeUpdateNotificationMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayDeviceRpcRequestMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayDeviceRpcRequestMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
         * @return Whether the rpcRequestMsg field is set.
         */
        boolean hasRpcRequestMsg();
        /**
         * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
         * @return The rpcRequestMsg.
         */
        com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg getRpcRequestMsg();
        /**
         * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
         */
        com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsgOrBuilder getRpcRequestMsgOrBuilder();
    }
    /**
     * Protobuf type {@code transportapi.GatewayDeviceRpcRequestMsg}
     */
    public  static final class GatewayDeviceRpcRequestMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayDeviceRpcRequestMsg)
            GatewayDeviceRpcRequestMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayDeviceRpcRequestMsg.newBuilder() to construct.
        private GatewayDeviceRpcRequestMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayDeviceRpcRequestMsg() {
            deviceName_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayDeviceRpcRequestMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayDeviceRpcRequestMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
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
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 18: {
                            com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.Builder subBuilder = null;
                            if (rpcRequestMsg_ != null) {
                                subBuilder = rpcRequestMsg_.toBuilder();
                            }
                            rpcRequestMsg_ = input.readMessage(com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(rpcRequestMsg_);
                                rpcRequestMsg_ = subBuilder.buildPartial();
                            }

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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayDeviceRpcRequestMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayDeviceRpcRequestMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg.Builder.class);
        }

        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 1;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 1;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int RPCREQUESTMSG_FIELD_NUMBER = 2;
        private com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg_;
        /**
         * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
         * @return Whether the rpcRequestMsg field is set.
         */
        public boolean hasRpcRequestMsg() {
            return rpcRequestMsg_ != null;
        }
        /**
         * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
         * @return The rpcRequestMsg.
         */
        public com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg getRpcRequestMsg() {
            return rpcRequestMsg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance() : rpcRequestMsg_;
        }
        /**
         * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
         */
        public com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsgOrBuilder getRpcRequestMsgOrBuilder() {
            return getRpcRequestMsg();
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceName_);
            }
            if (rpcRequestMsg_ != null) {
                output.writeMessage(2, getRpcRequestMsg());
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceName_);
            }
            if (rpcRequestMsg_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getRpcRequestMsg());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg) obj;

            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (hasRpcRequestMsg() != other.hasRpcRequestMsg()) return false;
            if (hasRpcRequestMsg()) {
                if (!getRpcRequestMsg()
                        .equals(other.getRpcRequestMsg())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            if (hasRpcRequestMsg()) {
                hash = (37 * hash) + RPCREQUESTMSG_FIELD_NUMBER;
                hash = (53 * hash) + getRpcRequestMsg().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayDeviceRpcRequestMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayDeviceRpcRequestMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayDeviceRpcRequestMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayDeviceRpcRequestMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                deviceName_ = "";

                if (rpcRequestMsgBuilder_ == null) {
                    rpcRequestMsg_ = null;
                } else {
                    rpcRequestMsg_ = null;
                    rpcRequestMsgBuilder_ = null;
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayDeviceRpcRequestMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg(this);
                result.deviceName_ = deviceName_;
                if (rpcRequestMsgBuilder_ == null) {
                    result.rpcRequestMsg_ = rpcRequestMsg_;
                } else {
                    result.rpcRequestMsg_ = rpcRequestMsgBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance()) return this;
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.hasRpcRequestMsg()) {
                    mergeRpcRequestMsg(other.getRpcRequestMsg());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 1;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 1;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg, com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsgOrBuilder> rpcRequestMsgBuilder_;
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             * @return Whether the rpcRequestMsg field is set.
             */
            public boolean hasRpcRequestMsg() {
                return rpcRequestMsgBuilder_ != null || rpcRequestMsg_ != null;
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             * @return The rpcRequestMsg.
             */
            public com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg getRpcRequestMsg() {
                if (rpcRequestMsgBuilder_ == null) {
                    return rpcRequestMsg_ == null ? com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance() : rpcRequestMsg_;
                } else {
                    return rpcRequestMsgBuilder_.getMessage();
                }
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             */
            public Builder setRpcRequestMsg(com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg value) {
                if (rpcRequestMsgBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    rpcRequestMsg_ = value;
                    onChanged();
                } else {
                    rpcRequestMsgBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             */
            public Builder setRpcRequestMsg(
                    com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.Builder builderForValue) {
                if (rpcRequestMsgBuilder_ == null) {
                    rpcRequestMsg_ = builderForValue.build();
                    onChanged();
                } else {
                    rpcRequestMsgBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             */
            public Builder mergeRpcRequestMsg(com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg value) {
                if (rpcRequestMsgBuilder_ == null) {
                    if (rpcRequestMsg_ != null) {
                        rpcRequestMsg_ =
                                com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.newBuilder(rpcRequestMsg_).mergeFrom(value).buildPartial();
                    } else {
                        rpcRequestMsg_ = value;
                    }
                    onChanged();
                } else {
                    rpcRequestMsgBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             */
            public Builder clearRpcRequestMsg() {
                if (rpcRequestMsgBuilder_ == null) {
                    rpcRequestMsg_ = null;
                    onChanged();
                } else {
                    rpcRequestMsg_ = null;
                    rpcRequestMsgBuilder_ = null;
                }

                return this;
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.Builder getRpcRequestMsgBuilder() {

                onChanged();
                return getRpcRequestMsgFieldBuilder().getBuilder();
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             */
            public com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsgOrBuilder getRpcRequestMsgOrBuilder() {
                if (rpcRequestMsgBuilder_ != null) {
                    return rpcRequestMsgBuilder_.getMessageOrBuilder();
                } else {
                    return rpcRequestMsg_ == null ?
                            com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance() : rpcRequestMsg_;
                }
            }
            /**
             * <code>.transport.ToDeviceRpcRequestMsg rpcRequestMsg = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg, com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsgOrBuilder>
            getRpcRequestMsgFieldBuilder() {
                if (rpcRequestMsgBuilder_ == null) {
                    rpcRequestMsgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg, com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsg.Builder, com.hd.daq.transportapi.proto.TransportProtos.ToDeviceRpcRequestMsgOrBuilder>(
                            getRpcRequestMsg(),
                            getParentForChildren(),
                            isClean());
                    rpcRequestMsg_ = null;
                }
                return rpcRequestMsgBuilder_;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayDeviceRpcRequestMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayDeviceRpcRequestMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayDeviceRpcRequestMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayDeviceRpcRequestMsg>() {
            @java.lang.Override
            public GatewayDeviceRpcRequestMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayDeviceRpcRequestMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayDeviceRpcRequestMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayDeviceRpcRequestMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayDeviceRpcRequestMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface GatewayAttributesRequestMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transportapi.GatewayAttributesRequestMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>int32 id = 1;</code>
         * @return The id.
         */
        int getId();

        /**
         * <code>string deviceName = 2;</code>
         * @return The deviceName.
         */
        java.lang.String getDeviceName();
        /**
         * <code>string deviceName = 2;</code>
         * @return The bytes for deviceName.
         */
        com.google.protobuf.ByteString
        getDeviceNameBytes();

        /**
         * <code>bool client = 3;</code>
         * @return The client.
         */
        boolean getClient();

        /**
         * <code>repeated string keys = 4;</code>
         * @return A list containing the keys.
         */
        java.util.List<java.lang.String>
        getKeysList();
        /**
         * <code>repeated string keys = 4;</code>
         * @return The count of keys.
         */
        int getKeysCount();
        /**
         * <code>repeated string keys = 4;</code>
         * @param index The index of the element to return.
         * @return The keys at the given index.
         */
        java.lang.String getKeys(int index);
        /**
         * <code>repeated string keys = 4;</code>
         * @param index The index of the value to return.
         * @return The bytes of the keys at the given index.
         */
        com.google.protobuf.ByteString
        getKeysBytes(int index);
    }
    /**
     * Protobuf type {@code transportapi.GatewayAttributesRequestMsg}
     */
    public  static final class GatewayAttributesRequestMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:transportapi.GatewayAttributesRequestMsg)
            GatewayAttributesRequestMsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use GatewayAttributesRequestMsg.newBuilder() to construct.
        private GatewayAttributesRequestMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private GatewayAttributesRequestMsg() {
            deviceName_ = "";
            keys_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new GatewayAttributesRequestMsg();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private GatewayAttributesRequestMsg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
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
                        case 8: {

                            id_ = input.readInt32();
                            break;
                        }
                        case 18: {
                            java.lang.String s = input.readStringRequireUtf8();

                            deviceName_ = s;
                            break;
                        }
                        case 24: {

                            client_ = input.readBool();
                            break;
                        }
                        case 34: {
                            java.lang.String s = input.readStringRequireUtf8();
                            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                                keys_ = new com.google.protobuf.LazyStringArrayList();
                                mutable_bitField0_ |= 0x00000001;
                            }
                            keys_.add(s);
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
                    keys_ = keys_.getUnmodifiableView();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesRequestMsg_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesRequestMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg.Builder.class);
        }

        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        /**
         * <code>int32 id = 1;</code>
         * @return The id.
         */
        public int getId() {
            return id_;
        }

        public static final int DEVICENAME_FIELD_NUMBER = 2;
        private volatile java.lang.Object deviceName_;
        /**
         * <code>string deviceName = 2;</code>
         * @return The deviceName.
         */
        public java.lang.String getDeviceName() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                deviceName_ = s;
                return s;
            }
        }
        /**
         * <code>string deviceName = 2;</code>
         * @return The bytes for deviceName.
         */
        public com.google.protobuf.ByteString
        getDeviceNameBytes() {
            java.lang.Object ref = deviceName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                deviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int CLIENT_FIELD_NUMBER = 3;
        private boolean client_;
        /**
         * <code>bool client = 3;</code>
         * @return The client.
         */
        public boolean getClient() {
            return client_;
        }

        public static final int KEYS_FIELD_NUMBER = 4;
        private com.google.protobuf.LazyStringList keys_;
        /**
         * <code>repeated string keys = 4;</code>
         * @return A list containing the keys.
         */
        public com.google.protobuf.ProtocolStringList
        getKeysList() {
            return keys_;
        }
        /**
         * <code>repeated string keys = 4;</code>
         * @return The count of keys.
         */
        public int getKeysCount() {
            return keys_.size();
        }
        /**
         * <code>repeated string keys = 4;</code>
         * @param index The index of the element to return.
         * @return The keys at the given index.
         */
        public java.lang.String getKeys(int index) {
            return keys_.get(index);
        }
        /**
         * <code>repeated string keys = 4;</code>
         * @param index The index of the value to return.
         * @return The bytes of the keys at the given index.
         */
        public com.google.protobuf.ByteString
        getKeysBytes(int index) {
            return keys_.getByteString(index);
        }

        private byte memoizedIsInitialized = -1;
        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (id_ != 0) {
                output.writeInt32(1, id_);
            }
            if (!getDeviceNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, deviceName_);
            }
            if (client_ != false) {
                output.writeBool(3, client_);
            }
            for (int i = 0; i < keys_.size(); i++) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 4, keys_.getRaw(i));
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (id_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(1, id_);
            }
            if (!getDeviceNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, deviceName_);
            }
            if (client_ != false) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBoolSize(3, client_);
            }
            {
                int dataSize = 0;
                for (int i = 0; i < keys_.size(); i++) {
                    dataSize += computeStringSizeNoTag(keys_.getRaw(i));
                }
                size += dataSize;
                size += 1 * getKeysList().size();
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg)) {
                return super.equals(obj);
            }
            com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg other = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg) obj;

            if (getId()
                    != other.getId()) return false;
            if (!getDeviceName()
                    .equals(other.getDeviceName())) return false;
            if (getClient()
                    != other.getClient()) return false;
            if (!getKeysList()
                    .equals(other.getKeysList())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + ID_FIELD_NUMBER;
            hash = (53 * hash) + getId();
            hash = (37 * hash) + DEVICENAME_FIELD_NUMBER;
            hash = (53 * hash) + getDeviceName().hashCode();
            hash = (37 * hash) + CLIENT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
                    getClient());
            if (getKeysCount() > 0) {
                hash = (37 * hash) + KEYS_FIELD_NUMBER;
                hash = (53 * hash) + getKeysList().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code transportapi.GatewayAttributesRequestMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:transportapi.GatewayAttributesRequestMsg)
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesRequestMsg_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesRequestMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg.class, com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg.Builder.class);
            }

            // Construct using com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @java.lang.Override
            public Builder clear() {
                super.clear();
                id_ = 0;

                deviceName_ = "";

                client_ = false;

                keys_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000001);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.internal_static_transportapi_GatewayAttributesRequestMsg_descriptor;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg getDefaultInstanceForType() {
                return com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance();
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg build() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg buildPartial() {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg result = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg(this);
                int from_bitField0_ = bitField0_;
                result.id_ = id_;
                result.deviceName_ = deviceName_;
                result.client_ = client_;
                if (((bitField0_ & 0x00000001) != 0)) {
                    keys_ = keys_.getUnmodifiableView();
                    bitField0_ = (bitField0_ & ~0x00000001);
                }
                result.keys_ = keys_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }
            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }
            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }
            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg) {
                    return mergeFrom((com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg other) {
                if (other == com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance()) return this;
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (!other.getDeviceName().isEmpty()) {
                    deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (other.getClient() != false) {
                    setClient(other.getClient());
                }
                if (!other.keys_.isEmpty()) {
                    if (keys_.isEmpty()) {
                        keys_ = other.keys_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                    } else {
                        ensureKeysIsMutable();
                        keys_.addAll(other.keys_);
                    }
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private int id_ ;
            /**
             * <code>int32 id = 1;</code>
             * @return The id.
             */
            public int getId() {
                return id_;
            }
            /**
             * <code>int32 id = 1;</code>
             * @param value The id to set.
             * @return This builder for chaining.
             */
            public Builder setId(int value) {

                id_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int32 id = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearId() {

                id_ = 0;
                onChanged();
                return this;
            }

            private java.lang.Object deviceName_ = "";
            /**
             * <code>string deviceName = 2;</code>
             * @return The deviceName.
             */
            public java.lang.String getDeviceName() {
                java.lang.Object ref = deviceName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    deviceName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string deviceName = 2;</code>
             * @return The bytes for deviceName.
             */
            public com.google.protobuf.ByteString
            getDeviceNameBytes() {
                java.lang.Object ref = deviceName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    deviceName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string deviceName = 2;</code>
             * @param value The deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                deviceName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 2;</code>
             * @return This builder for chaining.
             */
            public Builder clearDeviceName() {

                deviceName_ = getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }
            /**
             * <code>string deviceName = 2;</code>
             * @param value The bytes for deviceName to set.
             * @return This builder for chaining.
             */
            public Builder setDeviceNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                deviceName_ = value;
                onChanged();
                return this;
            }

            private boolean client_ ;
            /**
             * <code>bool client = 3;</code>
             * @return The client.
             */
            public boolean getClient() {
                return client_;
            }
            /**
             * <code>bool client = 3;</code>
             * @param value The client to set.
             * @return This builder for chaining.
             */
            public Builder setClient(boolean value) {

                client_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bool client = 3;</code>
             * @return This builder for chaining.
             */
            public Builder clearClient() {

                client_ = false;
                onChanged();
                return this;
            }

            private com.google.protobuf.LazyStringList keys_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            private void ensureKeysIsMutable() {
                if (!((bitField0_ & 0x00000001) != 0)) {
                    keys_ = new com.google.protobuf.LazyStringArrayList(keys_);
                    bitField0_ |= 0x00000001;
                }
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @return A list containing the keys.
             */
            public com.google.protobuf.ProtocolStringList
            getKeysList() {
                return keys_.getUnmodifiableView();
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @return The count of keys.
             */
            public int getKeysCount() {
                return keys_.size();
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @param index The index of the element to return.
             * @return The keys at the given index.
             */
            public java.lang.String getKeys(int index) {
                return keys_.get(index);
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @param index The index of the value to return.
             * @return The bytes of the keys at the given index.
             */
            public com.google.protobuf.ByteString
            getKeysBytes(int index) {
                return keys_.getByteString(index);
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @param index The index to set the value at.
             * @param value The keys to set.
             * @return This builder for chaining.
             */
            public Builder setKeys(
                    int index, java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureKeysIsMutable();
                keys_.set(index, value);
                onChanged();
                return this;
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @param value The keys to add.
             * @return This builder for chaining.
             */
            public Builder addKeys(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureKeysIsMutable();
                keys_.add(value);
                onChanged();
                return this;
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @param values The keys to add.
             * @return This builder for chaining.
             */
            public Builder addAllKeys(
                    java.lang.Iterable<java.lang.String> values) {
                ensureKeysIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, keys_);
                onChanged();
                return this;
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @return This builder for chaining.
             */
            public Builder clearKeys() {
                keys_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000001);
                onChanged();
                return this;
            }
            /**
             * <code>repeated string keys = 4;</code>
             * @param value The bytes of the keys to add.
             * @return This builder for chaining.
             */
            public Builder addKeysBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);
                ensureKeysIsMutable();
                keys_.add(value);
                onChanged();
                return this;
            }
            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transportapi.GatewayAttributesRequestMsg)
        }

        // @@protoc_insertion_point(class_scope:transportapi.GatewayAttributesRequestMsg)
        private static final com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg();
        }

        public static com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<GatewayAttributesRequestMsg>
                PARSER = new com.google.protobuf.AbstractParser<GatewayAttributesRequestMsg>() {
            @java.lang.Override
            public GatewayAttributesRequestMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new GatewayAttributesRequestMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<GatewayAttributesRequestMsg> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<GatewayAttributesRequestMsg> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public com.hd.daq.transportapi.proto.TransportApiProtos.GatewayAttributesRequestMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_ClaimDevice_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_ClaimDevice_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_AttributesRequest_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_AttributesRequest_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_RpcRequest_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_RpcRequest_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_DisconnectMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_DisconnectMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_ConnectMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_ConnectMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_TelemetryMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_TelemetryMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_AttributesMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_AttributesMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_ClaimDeviceMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_ClaimDeviceMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayTelemetryMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayTelemetryMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayClaimMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayClaimMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayAttributesMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayAttributesMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayRpcResponseMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayRpcResponseMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayAttributeResponseMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayAttributeResponseMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayDeviceRpcRequestMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayDeviceRpcRequestMsg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transportapi_GatewayAttributesRequestMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transportapi_GatewayAttributesRequestMsg_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static  com.google.protobuf.Descriptors.FileDescriptor
            descriptor;
    static {
        java.lang.String[] descriptorData = {
                "\n\017transport.proto\022\014transportapi\032\013queue.p" +
                        "roto\"4\n\013ClaimDevice\022\021\n\tsecretKey\030\001 \001(\t\022\022" +
                        "\n\ndurationMs\030\002 \001(\003\";\n\021AttributesRequest\022" +
                        "\022\n\nclientKeys\030\001 \001(\t\022\022\n\nsharedKeys\030\002 \001(\t\"" +
                        ",\n\nRpcRequest\022\016\n\006method\030\001 \001(\t\022\016\n\006params\030" +
                        "\002 \001(\t\"#\n\rDisconnectMsg\022\022\n\ndeviceName\030\001 \001" +
                        "(\t\"4\n\nConnectMsg\022\022\n\ndeviceName\030\001 \001(\t\022\022\n\n" +
                        "deviceType\030\002 \001(\t\"L\n\014TelemetryMsg\022\022\n\ndevi" +
                        "ceName\030\001 \001(\t\022(\n\003msg\030\003 \001(\0132\033.transport.Po" +
                        "stTelemetryMsg\"M\n\rAttributesMsg\022\022\n\ndevic" +
                        "eName\030\001 \001(\t\022(\n\003msg\030\002 \001(\0132\033.transport.Pos" +
                        "tAttributeMsg\"U\n\016ClaimDeviceMsg\022\022\n\ndevic" +
                        "eName\030\001 \001(\t\022/\n\014claimRequest\030\002 \001(\0132\031.tran" +
                        "sportapi.ClaimDevice\">\n\023GatewayTelemetry" +
                        "Msg\022\'\n\003msg\030\001 \003(\0132\032.transportapi.Telemetr" +
                        "yMsg\"<\n\017GatewayClaimMsg\022)\n\003msg\030\001 \003(\0132\034.t" +
                        "ransportapi.ClaimDeviceMsg\"@\n\024GatewayAtt" +
                        "ributesMsg\022(\n\003msg\030\001 \003(\0132\033.transportapi.A" +
                        "ttributesMsg\"E\n\025GatewayRpcResponseMsg\022\022\n" +
                        "\ndeviceName\030\001 \001(\t\022\n\n\002id\030\002 \001(\005\022\014\n\004data\030\003 " +
                        "\001(\t\"j\n\033GatewayAttributeResponseMsg\022\022\n\nde" +
                        "viceName\030\001 \001(\t\0227\n\013responseMsg\030\002 \001(\0132\".tr" +
                        "ansport.GetAttributeResponseMsg\"\177\n%Gatew" +
                        "ayAttributeUpdateNotificationMsg\022\022\n\ndevi" +
                        "ceName\030\001 \001(\t\022B\n\017notificationMsg\030\002 \001(\0132)." +
                        "transport.AttributeUpdateNotificationMsg" +
                        "\"i\n\032GatewayDeviceRpcRequestMsg\022\022\n\ndevice" +
                        "Name\030\001 \001(\t\0227\n\rrpcRequestMsg\030\002 \001(\0132 .tran" +
                        "sport.ToDeviceRpcRequestMsg\"[\n\033GatewayAt" +
                        "tributesRequestMsg\022\n\n\002id\030\001 \001(\005\022\022\n\ndevice" +
                        "Name\030\002 \001(\t\022\016\n\006client\030\003 \001(\010\022\014\n\004keys\030\004 \003(\t" +
                        "B:\n$com.hd.daq.transportapi.proto" +
                        "B\022TransportApiProtosb\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[] {
                                com.hd.daq.transportapi.proto.TransportProtos.getDescriptor(),
                        });
        internal_static_transportapi_ClaimDevice_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_transportapi_ClaimDevice_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_ClaimDevice_descriptor,
                new java.lang.String[] { "SecretKey", "DurationMs", });
        internal_static_transportapi_AttributesRequest_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_transportapi_AttributesRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_AttributesRequest_descriptor,
                new java.lang.String[] { "ClientKeys", "SharedKeys", });
        internal_static_transportapi_RpcRequest_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_transportapi_RpcRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_RpcRequest_descriptor,
                new java.lang.String[] { "Method", "Params", });
        internal_static_transportapi_DisconnectMsg_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_transportapi_DisconnectMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_DisconnectMsg_descriptor,
                new java.lang.String[] { "DeviceName", });
        internal_static_transportapi_ConnectMsg_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_transportapi_ConnectMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_ConnectMsg_descriptor,
                new java.lang.String[] { "DeviceName", "DeviceType", });
        internal_static_transportapi_TelemetryMsg_descriptor =
                getDescriptor().getMessageTypes().get(5);
        internal_static_transportapi_TelemetryMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_TelemetryMsg_descriptor,
                new java.lang.String[] { "DeviceName", "Msg", });
        internal_static_transportapi_AttributesMsg_descriptor =
                getDescriptor().getMessageTypes().get(6);
        internal_static_transportapi_AttributesMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_AttributesMsg_descriptor,
                new java.lang.String[] { "DeviceName", "Msg", });
        internal_static_transportapi_ClaimDeviceMsg_descriptor =
                getDescriptor().getMessageTypes().get(7);
        internal_static_transportapi_ClaimDeviceMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_ClaimDeviceMsg_descriptor,
                new java.lang.String[] { "DeviceName", "ClaimRequest", });
        internal_static_transportapi_GatewayTelemetryMsg_descriptor =
                getDescriptor().getMessageTypes().get(8);
        internal_static_transportapi_GatewayTelemetryMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayTelemetryMsg_descriptor,
                new java.lang.String[] { "Msg", });
        internal_static_transportapi_GatewayClaimMsg_descriptor =
                getDescriptor().getMessageTypes().get(9);
        internal_static_transportapi_GatewayClaimMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayClaimMsg_descriptor,
                new java.lang.String[] { "Msg", });
        internal_static_transportapi_GatewayAttributesMsg_descriptor =
                getDescriptor().getMessageTypes().get(10);
        internal_static_transportapi_GatewayAttributesMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayAttributesMsg_descriptor,
                new java.lang.String[] { "Msg", });
        internal_static_transportapi_GatewayRpcResponseMsg_descriptor =
                getDescriptor().getMessageTypes().get(11);
        internal_static_transportapi_GatewayRpcResponseMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayRpcResponseMsg_descriptor,
                new java.lang.String[] { "DeviceName", "Id", "Data", });
        internal_static_transportapi_GatewayAttributeResponseMsg_descriptor =
                getDescriptor().getMessageTypes().get(12);
        internal_static_transportapi_GatewayAttributeResponseMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayAttributeResponseMsg_descriptor,
                new java.lang.String[] { "DeviceName", "ResponseMsg", });
        internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_descriptor =
                getDescriptor().getMessageTypes().get(13);
        internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayAttributeUpdateNotificationMsg_descriptor,
                new java.lang.String[] { "DeviceName", "NotificationMsg", });
        internal_static_transportapi_GatewayDeviceRpcRequestMsg_descriptor =
                getDescriptor().getMessageTypes().get(14);
        internal_static_transportapi_GatewayDeviceRpcRequestMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayDeviceRpcRequestMsg_descriptor,
                new java.lang.String[] { "DeviceName", "RpcRequestMsg", });
        internal_static_transportapi_GatewayAttributesRequestMsg_descriptor =
                getDescriptor().getMessageTypes().get(15);
        internal_static_transportapi_GatewayAttributesRequestMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transportapi_GatewayAttributesRequestMsg_descriptor,
                new java.lang.String[] { "Id", "DeviceName", "Client", "Keys", });
        com.hd.daq.transportapi.proto.TransportProtos.getDescriptor();
    }

    // @@protoc_insertion_point(outer_class_scope)
}
