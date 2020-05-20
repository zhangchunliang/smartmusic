package eric.com.smartmusic.net

import eric.com.smartmusic.model.HomeItemBean

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/17
 */
abstract class HomeResponseHandler<RESPONSE> :ResponseHandler<RESPONSE> {

    var handlerType = 0

    override fun onFailure(message: String?) {
        homeFailure(message)
    }

    override fun onSuccess(response: RESPONSE) {
//        homeSuccess(handlerType, response)
        //TEST DATA
        var listData = listOf<HomeItemBean>(
            HomeItemBean("", 1, "一张图片",
                "第一张美女图片", "http://ww2.sinaimg.cn/bmiddle/904c2a35jw1emu3ec7kf8j20c10epjsn.jpg", "123", "123",
                "", 1,1,1, 1, "", "",""),
            HomeItemBean("", 1, "一张图片",
                "第二张美女图片", "http://ww2.sinaimg.cn/bmiddle/98719e4agw1e5j49zmf21j20c80c8mxi.jpg", "123", "123",
                "", 1,1,1, 1, "", "",""),
            HomeItemBean("", 1, "一张图片",
                "第三张美女图片", "http://ww2.sinaimg.cn/bmiddle/67307b53jw1epqq3bmwr6j20c80axmy5.jpg", "123", "123",
                "", 1,1,1, 1, "", "",""),
            HomeItemBean("", 1, "一张图片",
                "第四张美女图片", "http://ww2.sinaimg.cn/bmiddle/9ecab84ejw1emgd5nd6eaj20c80c8q4a.jpg", "123", "123",
                "", 1,1,1, 1, "", "",""),
            HomeItemBean("", 1, "一张图片",
                "第五张美女图片", "http://ww2.sinaimg.cn/bmiddle/642beb18gw1ep3629gfm0g206o050b2a.gif", "123", "123",
                "", 1,1,1, 1, "", "","")
        )

        homeSuccess(handlerType, listData)
    }

    abstract fun homeFailure(message: String?)

    abstract fun homeSuccess(type: Int, response: List<HomeItemBean>)
}