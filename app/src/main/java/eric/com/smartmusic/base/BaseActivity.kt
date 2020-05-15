package eric.com.smartmusic.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Description:
 *
 * @author Eric(zhangchunliang1@gmail.com)
 * @since 2020/5/12
 */
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        initListener()
        initData()
    }

    abstract fun getLayoutId():Int

    protected open fun initListener() = Unit

    protected open fun initData() = Unit

    protected fun ShowToast(msg:String) {
        runOnUiThread{
            Toast.makeText(this, msg,Toast.LENGTH_SHORT).show()
        }
    }
}