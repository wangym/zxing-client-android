/**
 * 
 */
package me.yumin.android.zxing.etc;

import java.io.Serializable;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;

/**
 * @author yumin
 * 
 */
public class ZXingOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3414963827290108159L;

	/**
	 * 
	 */
	private String text;
	private byte[] rawBytes;
	private BarcodeFormat barcodeFormat;
	private Map<ResultMetadataType, Object> resultMetadata;
	private long timestamp;

	@Override
	public String toString() {

		String delimiter = "\t";
		String string = new StringBuilder(text).
				append(delimiter).append(String.valueOf(rawBytes)).
				append(delimiter).append(String.valueOf(barcodeFormat)).
				append(delimiter).append(String.valueOf(resultMetadata)).
				append(delimiter).append(timestamp).
				toString();

		return string;
	}

	/**
	 * 
	 */
	public ZXingOutput(Result rawResult) {

		if (null == rawResult) {
			throw new IllegalArgumentException("Argument 'rawResult' must not be null!");
		}
		setText(rawResult.getText());
		setRawBytes(rawResult.getRawBytes());
		setBarcodeFormat(rawResult.getBarcodeFormat());
		setResultMetadata(rawResult.getResultMetadata());
		setTimestamp(rawResult.getTimestamp());
	}

	/**
	 * 
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getRawBytes() {
		return rawBytes;
	}

	public void setRawBytes(byte[] rawBytes) {
		this.rawBytes = rawBytes;
	}

	public BarcodeFormat getBarcodeFormat() {
		return barcodeFormat;
	}

	public void setBarcodeFormat(BarcodeFormat barcodeFormat) {
		this.barcodeFormat = barcodeFormat;
	}

	public Map<ResultMetadataType, Object> getResultMetadata() {
		return resultMetadata;
	}

	public void setResultMetadata(Map<ResultMetadataType, Object> resultMetadata) {
		this.resultMetadata = resultMetadata;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
