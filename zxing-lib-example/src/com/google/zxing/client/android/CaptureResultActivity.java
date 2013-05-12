/**
 * 
 */
package com.google.zxing.client.android;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author yumin
 * 
 */
public class CaptureResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		String format = extras.getString(ZXingConstant.K_FORMAT);
		String qrCode = extras.getString(ZXingConstant.K_QR_CODE);
		System.out.println(format + "-" + qrCode);
	}
}