package myapp.kshetti.shaadiassignment.custom_layouts

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.qualifiers.ActivityContext
import myapp.kshetti.shaadiassignment.R
import myapp.kshetti.trialapp.model.Results


class CustomizedTabLayout : TabLayout {

    lateinit var positionCallback: (Int, Int) -> Unit

    var previousPosition = 0

    constructor(@ActivityContext activityContext: Context) : super(activityContext) {
        initTabSelectedListener()
    }

    constructor(@ActivityContext activityContext: Context, attributeSet: AttributeSet) : super(
        activityContext, attributeSet
    ) {
        initTabSelectedListener()
    }

    constructor(
        @ActivityContext activityContext: Context,
        attributeSet: AttributeSet,
        defStyleAttr: Int
    ) : super(
        activityContext, attributeSet, defStyleAttr
    ) {
        initTabSelectedListener()
    }

    fun setCallback(function: (Int, Int) -> Unit){
        positionCallback = function
    }

    fun initTabSelectedListener() {

        addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: Tab?) {
                with(tab){
                    if(this !=null  && customView !=null){
                        val tab_layout_text: TextView = customView!!.findViewById(R.id.tab_layout_text)
                        tab_layout_text.setTextColor(Color.WHITE)
                        tab_layout_text.setBackgroundResource(R.drawable.tablayout_item_pressed)
                        positionCallback.invoke(position, previousPosition)

                    }
                }
            }

            override fun onTabUnselected(tab: Tab?) {
                with(tab){
                    if(this !=null  && customView !=null){
                        val tab_layout_text: TextView = customView!!.findViewById(R.id.tab_layout_text)
                        tab_layout_text.setTextColor(Color.BLACK)
                        tab_layout_text.setBackgroundResource(R.drawable.tablayout_item_elevated)

                        previousPosition = position;
                    }
                }
            }

            //Implementation not required
            override fun onTabReselected(tab: Tab?) {}



        })
    }

    fun setTitle(titles : ArrayList<String>){

        for (title in titles) {
            val tab = newTab()
            tab.setCustomView(R.layout.tab_layout_item)
            if (tab.customView != null) {
                val text = tab.customView!!.findViewById<TextView>(R.id.tab_layout_text)
                text.text = title
            }
            this.addTab(tab)
        }


    }


}

