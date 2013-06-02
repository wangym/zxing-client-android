/**
 * 
 */
package me.yumin.android.zxing.etc;

import java.util.Collection;
import java.util.EnumSet;
import com.google.zxing.BarcodeFormat;

/**
 * @author yumin
 * 
 */
public final class ZXingConstant {

	/* ##### zxing ##### */
	// key
	public static final String KEY_PLAY_BEEP = "preferences_play_beep";
	public static final String KEY_VIBRATE = "preferences_vibrate";
	public static final String KEY_FRONT_LIGHT_MODE = "preferences_front_light_mode";
	public static final String KEY_AUTO_FOCUS = "preferences_auto_focus";
	public static final String KEY_INVERT_SCAN = "preferences_invert_scan";
	public static final String KEY_DISABLE_CONTINUOUS_FOCUS = "preferences_disable_continuous_focus";
	// decode format
	public static final Collection<BarcodeFormat> PRODUCT_FORMATS;
	public static final Collection<BarcodeFormat> ONE_D_FORMATS;
	public static final Collection<BarcodeFormat> QR_CODE_FORMATS = EnumSet.of(BarcodeFormat.QR_CODE);
	public static final Collection<BarcodeFormat> DATA_MATRIX_FORMATS = EnumSet.of(BarcodeFormat.DATA_MATRIX);
	static {
		PRODUCT_FORMATS = EnumSet.of(
				BarcodeFormat.UPC_A, 
				BarcodeFormat.UPC_E,
				BarcodeFormat.EAN_13, 
				BarcodeFormat.EAN_8,
				BarcodeFormat.RSS_14, 
				BarcodeFormat.RSS_EXPANDED);
		ONE_D_FORMATS = EnumSet.of(
				BarcodeFormat.CODE_39,
				BarcodeFormat.CODE_93, 
				BarcodeFormat.CODE_128,
				BarcodeFormat.ITF, 
				BarcodeFormat.CODABAR);
		ONE_D_FORMATS.addAll(PRODUCT_FORMATS);
	}

	/* ##### yumin ##### */
	public static final String K_INPUT = "input";
	public static final String K_OUTPUT = "output";
}
