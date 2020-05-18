package eric.com.smartmusic.net

import com.google.gson.Gson
import eric.com.smartmusic.model.HomeItemBean
import java.lang.reflect.ParameterizedType

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/17
 */
open class MRequest<RESPONSE>(val url:String, val handler: ResponseHandler<RESPONSE>)  {
    fun parseResult(result: String?): RESPONSE {
        val gson = Gson()
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return gson.fromJson(result, type)
    }

    fun execute(){
        NetManager.netManager.sendRequest(this)
    }
}