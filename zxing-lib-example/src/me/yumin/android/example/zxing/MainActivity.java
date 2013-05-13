/**
 * 
 */
package me.yumin.android.example.zxing;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.ZXingConstant;
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

		Button btnNext = (Button) findViewById(R.id.btn_next);
		btnNext.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				doNext();
			}
		});
	}

	private void doNext() {

		Bundle extras = new Bundle();
		extras.putSerializable(ZXingConstant.K_RESULT_ACTIVITY, CaptureResultActivity.class);
		Intent intent = new Intent();
		intent.putExtras(extras);
		intent.setClass(this, CaptureActivity.class);
		startActivity(intent);
	}
}