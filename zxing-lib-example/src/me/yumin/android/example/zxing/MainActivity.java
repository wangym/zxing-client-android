/**
 * 
 */
package me.yumin.android.example.zxing;

import java.io.Serializable;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.ZXingConstant;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

/**
 * @author yumin
 * 
 */
public class MainActivity extends Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6877902062702174923L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = new Bundle();
		extras.putSerializable(ZXingConstant.K_RESULT_ACTIVITY, CaptureResultActivity.class);
		Intent intent = new Intent();
		intent.putExtras(extras);
		intent.setClass(this, CaptureActivity.class);
		startActivity(intent);
		finish();
	}
}