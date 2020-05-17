package eric.com.smartmusic.net

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import eric.com.smartmusic.model.HomeItemBean
import eric.com.smartmusic.util.ThreadUtil
import eric.com.smartmusic.util.URLProviderUtils
import okhttp3.*
import java.io.IOException

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/17
 */
class NetManager private constructor(){
    val client by lazy { OkHttpClient() }

    companion object {
        val netManager by lazy { NetManager() }
    }

    fun <RESPONSE>sendRequest(req:MRequest<RESPONSE>) {
        var request = Request.Builder().apply {
            url(req.url)
            get()
        }.build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                req.handler.onFailure(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                var result: String? = response?.let {
                    if (it.code() == 200) {
                        it.body().toString()
                    }else{
                        println("result:${it.code()}")
                        null
                    }
                }
                if (request == null) {
                    ThreadUtil.runOnMainUiThread {
                        req.handler.onFailure("response code:${response.code()}message:${response.message()}")
                    }
                    return
                }

                val parseResult = req.parseResult(result)
                ThreadUtil.runOnMainUiThread{
                    req.handler.onSuccess(parseResult)
                }
            }
        })
    }
}