package cn.com.timeriver.converterlibrary;

import android.support.annotation.NonNull;

import com.google.protobuf.nano.MessageNano;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by xibeisunny on 2018/1/2.
 */

class ProtoNanoRequestBodyConverter<T extends MessageNano> implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/x-protobuf");

    @Override
    public RequestBody convert(@NonNull T value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, MessageNano.toByteArray(value));
    }
}
