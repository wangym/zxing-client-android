/**
 * 
 */
package me.yumin.android.example.zxing;

import com.google.zxing.client.android.CaptureActivity;
import android.os.Bundle;
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
		Intent intent = new Intent();
		intent.setClass(this, CaptureActivity.class);
		startActivity(intent);
		finish();
	}
}