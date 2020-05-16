package eric.com.smartmusic.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Description:
 *
 * @author Eric(zhangchunliang1@gmail.com)
 * @since 2020/5/15
 */
abstract class BaseFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView()
    }

    abstract fun initView():View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    protected open fun init() {

    }

    protected open fun initListener(){

    }

    protected open fun initData(){

    }

    fun showToast(msg:String) {
        activity?.let {
            it.runOnUiThread{
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
            }
        }
    }
}