package eric.com.smartmusic.net

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/17
 */
interface ResponseHandler<RESPONSE> {

    fun onFailure(message: String?)

    fun onSuccess(response: RESPONSE)
}