/**
 * 
 */
package me.yumin.android.zxing.etc;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import android.app.Activity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;

/**
 * @author yumin
 * 
 */
public class ZXingInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -629260583218698687L;

	/**
	 * 
	 */
	private Class<Activity> resultActivity;
	private Collection<BarcodeFormat> decodeFormats;
	private Map<DecodeHintType, ?> decodeHints;
	private String characterSet;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ZXingInput(Serializable resultActivity) {

		if (null == resultActivity) {
			throw new IllegalArgumentException("Argument 'resultActivity' must not be null!");
		}
		setResultActivity((Class<Activity>) resultActivity);
	}

	/**
	 * 
	 */
	public Class<Activity> getResultActivity() {
		return resultActivity;
	}

	public void setResultActivity(Class<Activity> resultActivity) {
		this.resultActivity = resultActivity;
	}

	public Collection<BarcodeFormat> getDecodeFormats() {
		return decodeFormats;
	}

	public void setDecodeFormats(Collection<BarcodeFormat> decodeFormats) {

		this.decodeFormats = EnumSet.noneOf(BarcodeFormat.class);
		this.decodeFormats.addAll(decodeFormats);
	}

	public Map<DecodeHintType, ?> getDecodeHints() {
		return decodeHints;
	}

	public void setDecodeHints(Map<DecodeHintType, ?> decodeHints) {
		this.decodeHints = decodeHints;
	}

	public String getCharacterSet() {
		return characterSet;
	}

	public void setCharacterSet(String characterSet) {
		this.characterSet = characterSet;
	}
}
