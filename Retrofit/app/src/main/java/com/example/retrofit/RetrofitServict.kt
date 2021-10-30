import retrofit2.Call
import retrofit2.http.*

data class ResponseDTO(val placeName: String, val grade: Int, val emotion: Int)


interface RetrofitService {

    @GET("api/users")
    //fun getRequest(@Query("name") name: String): Call<ResponseDTO>
    fun getRequest(): Call<List<ResponseDTO>>   //

}