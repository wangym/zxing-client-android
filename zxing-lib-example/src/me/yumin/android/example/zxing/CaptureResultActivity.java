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
		String format = extras.getString(ZXingConstant.K_RESULT_CONTENT_FORMAT);
		TextView tvFormat = (TextView) findViewById(R.id.tv_result_format);
		tvFormat.setText(format);
		String content = extras.getString(ZXingConstant.K_RESULT_CONTENT);
		TextView tvContent = (TextView) findViewById(R.id.tv_result_content);
		tvContent.setText(content);
	}
}
