/**
 * 
 */
package me.yumin.android.example.zxing;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;
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

	private static final int REQUEST_CODE = 200;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initActivity();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (null != data && requestCode == REQUEST_CODE) {
			switch (resultCode) {
			case Activity.RESULT_OK:
				data.setClass(this, CaptureResultActivity.class);
				startActivity(data);
				break;
			default:
				break;
			}
		}
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

		Intent intent = new Intent();
		intent.setAction(Intents.Scan.ACTION);
		// intent.putExtra(Intents.Scan.MODE, Intents.Scan.QR_CODE_MODE);
		intent.putExtra(Intents.Scan.CHARACTER_SET, characterSet);
		intent.putExtra(Intents.Scan.WIDTH, 600);
		intent.putExtra(Intents.Scan.HEIGHT, 600);
		intent.putExtra(Intents.Scan.PROMPT_MESSAGE, "type your prompt message");
		intent.setClass(this, CaptureActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
	}
}
