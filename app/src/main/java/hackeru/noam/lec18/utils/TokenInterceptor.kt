package hackeru.noam.lec18.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor (
    private val queryParam: String = "api_key",
    private val queryValue: String = "0f2fabaa4f090581ea7036990910cc72"
) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val original:Request = chain.request()

        val url =
            original
                .url.newBuilder()
                .addQueryParameter(queryParam, queryValue)
                .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}