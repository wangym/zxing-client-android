/**
 * 
 */
package me.yumin.android.example.zxing;

import com.google.zxing.client.android.ZXingConstant;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author yumin
 * 
 */
public class CaptureResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capture_result);
		initActivity();

	}

	private void initActivity() {

		Bundle extras = getIntent().getExtras();
		String format = extras.getString(ZXingConstant.K_FORMAT);
		TextView tvFormat = (TextView) findViewById(R.id.tv_format);
		tvFormat.setText(format);
		String qrCode = extras.getString(ZXingConstant.K_QR_CODE);
		TextView tvQRCode = (TextView) findViewById(R.id.tv_qr_code);
		tvQRCode.setText(qrCode);
	}
}