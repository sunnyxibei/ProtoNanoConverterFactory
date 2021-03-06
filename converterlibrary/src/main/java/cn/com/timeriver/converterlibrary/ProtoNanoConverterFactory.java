package cn.com.timeriver.converterlibrary;

import android.support.annotation.Nullable;

import com.google.protobuf.nano.MessageNano;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by xibeisunny on 2018/1/2.
 * Protocol Buffer javanano 转换工厂
 */

public class ProtoNanoConverterFactory<T extends MessageNano> extends Converter.Factory {

    public static ProtoNanoConverterFactory<MessageNano> create() {
        return new ProtoNanoConverterFactory<>();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (!(type instanceof Class<?>)) {
            return null;
        }
        Class<?> c = (Class<?>) type;
        if (!MessageNano.class.isAssignableFrom(c)) {
            return null;
        }
        return new ProtoNanoResponseBodyConverter<>(c);
    }

    @Override
    public Converter<T, RequestBody> requestBodyConverter
            (Type type, Annotation[] parameterAnnotations,
             Annotation[] methodAnnotations, Retrofit retrofit) {
        if (!(type instanceof Class<?>)) {
            return null;
        }
        if (!MessageNano.class.isAssignableFrom((Class<?>) type)) {
            return null;
        }
        return new ProtoNanoRequestBodyConverter<>();
    }
}
