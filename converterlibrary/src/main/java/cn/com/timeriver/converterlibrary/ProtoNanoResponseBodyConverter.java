package cn.com.timeriver.converterlibrary;

import android.support.annotation.NonNull;

import com.google.protobuf.nano.MessageNano;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by xibeisunny on 2018/1/2.
 */

final class ProtoNanoResponseBodyConverter<T extends MessageNano>
        implements Converter<ResponseBody, T> {

    private Class<?> c;

    public ProtoNanoResponseBodyConverter(Class<?> c) {
        this.c = c;
    }

    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        T msg = null;
        try {
            //noinspection unchecked
            msg = (T) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assert msg != null;
        return T.mergeFrom(msg, value.bytes());
    }
}
