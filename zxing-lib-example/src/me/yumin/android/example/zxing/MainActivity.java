/**
 * 
 */
package me.yumin.android.example.zxing;

import me.yumin.android.zxing.etc.ZXingConstant;
import me.yumin.android.zxing.etc.ZXingInput;
import com.google.zxing.client.android.CaptureActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

/**
 * @author yumin
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initActivity();
	}

	private void initActivity() {

		Button btnScan = (Button) findViewById(R.id.scan);
		btnScan.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				doZXing(null);
			}
		});

		Button btnScanGbk = (Button) findViewById(R.id.scan_gbk);
		btnScanGbk.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				doZXing("GBK");
			}
		});

		Button btnScanUtf8 = (Button) findViewById(R.id.scan_utf_8);
		btnScanUtf8.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				doZXing("UTF-8");
			}
		});
	}

	private void doZXing(String characterSet) {

		ZXingInput input = new ZXingInput(CaptureResultActivity.class);
		if (null != characterSet) {
			input.setCharacterSet(characterSet);
		}

		Bundle bundle = new Bundle();
		bundle.putSerializable(ZXingConstant.K_INPUT, input);
		Intent intent = new Intent();
		intent.putExtras(bundle);
		intent.setClass(this, CaptureActivity.class);
		startActivity(intent);
	}
}
