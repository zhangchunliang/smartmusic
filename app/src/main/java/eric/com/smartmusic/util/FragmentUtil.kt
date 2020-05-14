package eric.com.smartmusic.util

import eric.com.smartmusic.R
import eric.com.smartmusic.ui.*

/**
 * Description:
 *
 * @author Eric(zhangchunliang1@gmail.com)
 * @since 2020/5/15
 */
class FragmentUtil private constructor(){
    private val homeFragment by lazy { HomeFragment() }
    private val mvFragment by lazy { MVFragment() }
    private val mvListFragment by lazy { MVListFragment() }
    private val vListFragment by lazy { VListFragment() }

    companion object {
        val fragmentUtil by lazy {
            FragmentUtil()
        }
    }

    fun getFragment(tabId:Int):BaseFragment?{
        return when(tabId){
            R.id.tab_home -> homeFragment
            R.id.tab_mv -> mvFragment
            R.id.tab_vlist -> mvListFragment
            R.id.tab_mvlist -> vListFragment
            else -> null
        }
    }
}