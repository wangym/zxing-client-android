/**
 * 
 */
package me.yumin.android.example.zxing;

import com.google.zxing.client.android.ZXingConstant;
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
		setContentView(R.layout.activity_capture_result);
		Bundle extras = getIntent().getExtras();
		String format = extras.getString(ZXingConstant.K_FORMAT);
		String qrCode = extras.getString(ZXingConstant.K_QR_CODE);
		System.out.println(format + "-" + qrCode);
	}
}