package com.example.tutorial1

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.Switch
import java.lang.reflect.Field

@SuppressLint("AppCompatCustomView")
class MyToggle @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = R.style.MySwitchStyle
) :
    Switch(context, attr, defStyleAttr, defStyleRes) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        try {
            val clazz = Class.forName(Switch::class.java.name)
            val switchWidth: Field? = clazz.getDeclaredField("mSwitchWidth")
            if (switchWidth != null) {
                switchWidth.isAccessible = true
                val width: Int = resources.getDimensionPixelOffset(R.dimen.minWidth)
                switchWidth.set(this, width)
                setMeasuredDimension(width, measuredHeight)
                invalidate()
            }
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }
    }
}
