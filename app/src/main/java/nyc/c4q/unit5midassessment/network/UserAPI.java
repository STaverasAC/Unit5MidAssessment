package nyc.c4q.unit5midassessment.network;

import nyc.c4q.unit5midassessment.model.Results;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Shant on 1/24/2018.
 */

public interface UserAPI {

    @GET()
    Call<Results> getResults();


}
