package camdev.sokra.khmer24.service;

import camdev.sokra.khmer24.model.pests.PaginationRespone;
import camdev.sokra.khmer24.model.pests.PetsRespone;
import camdev.sokra.khmer24.model.pests.detail.ContentRespone;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Khmer24Service {

    @GET("c-pets.html/")
    Flowable<PetsRespone> getPets(@Query("per_page") int per_page);

    @GET("c-pets.html/")
    Flowable<PaginationRespone> getPagenate(@Query("per_page") int per_page);

    @GET("{url}")
    Flowable<ContentRespone> getDetail(@Path("url") String url);
}
