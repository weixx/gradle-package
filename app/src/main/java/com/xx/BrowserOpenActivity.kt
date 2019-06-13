package com.xx

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 浏览器打开APP
 * 1、Scheme打开方式
 *  <a href="xx://open/card?card_id=66">Scheme打开App</a>
 * 2、Intent打开方式
 *  见[createUri]
 *
 * 同时对应的[AndroidManifest.xml]中的配置，此配置为必须项
 */
class BrowserOpenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser_open)
        Log.d("open_uri",intent.toUri(0))
        val uri = intent.data
        Log.d("open_uri", uri.toString())
        Log.d("open_uri", intent.scheme)
        Log.d("open_uri", intent.dataString)
        Log.d("open_uri", intent.extras.toString())
//        createUri()
    }

    /**
     * 创建启动格式
     * 将该方法的输出放在html中即可
     * <a href="intent://open/card?card_id=99#Intent;scheme=xx;category=android.intent.category.DEFAULT;category=android.intent.category.BROWSABLE;end">
            Intent打开App</a>
     * href的值即是
     */
    fun createUri(){
        val i = Intent()
        i.action = "android.intent.action.VIEW"
        i.addCategory("android.intent.category.BROWSABLE")
        i.addCategory("android.intent.category.DEFAULT")
        i.data = Uri.parse("xx://open/card?card_id=99")
        Log.d("create_uri", i.toUri(Intent.URI_INTENT_SCHEME))
    }
}
