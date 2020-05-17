package eric.com.smartmusic.presenter.Interf

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/16
 */
interface HomePresenter {
    companion object {
        var TYPE_INIT_OR_REFRESH = 0
        var TYPE_LOAD_MORE = 1
    }
    fun loadDatas()
    fun loadMore(position: Int)
}