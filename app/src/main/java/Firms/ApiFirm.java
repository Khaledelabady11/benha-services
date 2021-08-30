package Firms;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFirm {
    @GET("firms")
    public  Call<List<Firmsitem>>getFirm(@Query("category_id")int id);
}
