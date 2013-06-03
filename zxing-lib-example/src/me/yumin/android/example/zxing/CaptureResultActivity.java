/**
 * 
 */
package me.yumin.android.example.zxing;

import me.yumin.android.zxing.etc.ZXingConstant;
import me.yumin.android.zxing.etc.ZXingOutput;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
		ZXingOutput output = (ZXingOutput) extras.getSerializable(ZXingConstant.K_OUTPUT);
		if (null != output) {
			Log.v("CaptureResultActivity", output.toString());
			TextView tvFormat = (TextView) findViewById(R.id.tv_result_format);
			tvFormat.setText(output.getBarcodeFormat().name());
			TextView tvText = (TextView) findViewById(R.id.tv_result_text);
			tvText.setText(output.getText());
		}
	}
}
