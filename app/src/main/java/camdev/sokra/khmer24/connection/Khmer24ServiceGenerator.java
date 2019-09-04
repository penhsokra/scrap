package camdev.sokra.khmer24.connection;

import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class Khmer24ServiceGenerator {
    private static final String BASE_URL = "https://www.khmer24.com/en/";
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(JspoonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    public static <S> S createService(Class<S> serviceClass){
        return builder.build().create(serviceClass);
    }
}
