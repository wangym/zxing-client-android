/**
 * 
 */
package me.yumin.android.example.zxing;

/*import java.util.EnumMap;
import java.util.Map;
import com.google.zxing.DecodeHintType; */
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

		Button btnNext = (Button) findViewById(R.id.btn_next);
		btnNext.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				doNext();
			}
		});
	}

	private void doNext() {

		ZXingInput input = new ZXingInput(CaptureResultActivity.class);
		/*input.setDecodeFormats(ZXingConstant.QR_CODE_FORMATS);
		Map<DecodeHintType, Object> decodeHints = new EnumMap<DecodeHintType,Object>(DecodeHintType.class);
		decodeHints.put(DecodeHintType.ALLOWED_LENGTHS, 2);
		input.setDecodeHints(decodeHints);
		input.setCharacterSet("GBK");*/

		Bundle bundle = new Bundle();
		bundle.putSerializable(ZXingConstant.K_INPUT, input);

		Intent intent = new Intent();
		intent.putExtras(bundle);
		intent.setClass(this, CaptureActivity.class);

		startActivity(intent);
	}
}
