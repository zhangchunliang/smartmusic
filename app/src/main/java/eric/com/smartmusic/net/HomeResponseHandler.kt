package eric.com.smartmusic.net

import eric.com.smartmusic.model.HomeItemBean

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/17
 */
abstract class HomeResponseHandler<T>:ResponseHandler<List<HomeItemBean>> {

    var handlerType = 0

    override fun onFailure(message: String?) {
        homeFailure(message)
    }

    override fun onSuccess(response: List<HomeItemBean>) {
        homeSuccess(handlerType, response)
    }

    abstract fun homeFailure(message: String?)

    abstract fun homeSuccess(type: Int, response: List<HomeItemBean>)
}