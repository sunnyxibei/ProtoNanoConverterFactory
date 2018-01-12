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

    private T msg;

    public ProtoNanoResponseBodyConverter(T msg) {
        this.msg = msg;
    }

    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        return T.mergeFrom(msg, value.bytes());
    }
}
