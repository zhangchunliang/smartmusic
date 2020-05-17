package eric.com.smartmusic.net

import eric.com.smartmusic.model.HomeItemBean
import eric.com.smartmusic.util.URLProviderUtils

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/17
 */
class HomeRequest(offset:Int, handler: HomeResponseHandler<List<HomeItemBean>>) :
    MRequest<List<HomeItemBean>>(URLProviderUtils.getHomeUrl(offset, 20), handler) {
}