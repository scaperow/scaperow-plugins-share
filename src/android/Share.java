
package com.scaperow.cordova;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.soexample.R;
import com.umeng.soexample.activity.SocialHomeActivity;
import com.umeng.soexample.commons.Constants;
import com.umeng.soexample.widget.ActionBar;
import com.umeng.soexample.widget.ActionBar.IntentAction;


public class Share(){
	// 首先在您的Activity中添加如下成员变量
	final UMSocialService service = UMServiceFactory.getUMSocialService("com.umeng.share");
	
	public Share(){
		
	}
	
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
	
	 public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("ShareContext")) {
			String content = args.getString(0);
			//String media = args.getString(1);
			// 设置分享内容
			service.setShareContent(content);
			// 设置分享图片, 参数2为图片的url地址
			service.setShareMedia(new UMImage( cordova.getActivity(), "http://www.baidu.com/img/bdlogo.png"));
			service.openShare( cordova.getActivity(), false);
			
            callbackContext.success(r);
        }
        else {
            return false;
        }
		
        return true;
    }


}