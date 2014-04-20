/*
 * Copyright (C) 2013 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.client.android;

import java.util.EnumMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.DecodeHintType;

/**
 * @author Lachezar Dobrev
 */
final class DecodeHintManager {

    private static final String TAG = DecodeHintManager.class.getSimpleName();

    private DecodeHintManager() {
    }

    static Map<DecodeHintType, Object> parseDecodeHints(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        Map<DecodeHintType, Object> hints = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);

        for (DecodeHintType hintType : DecodeHintType.values()) {

            if (hintType == DecodeHintType.CHARACTER_SET ||
                    hintType == DecodeHintType.NEED_RESULT_POINT_CALLBACK ||
                    hintType == DecodeHintType.POSSIBLE_FORMATS) {
                continue; // This hint is specified in another way
            }

            String hintName = hintType.name();
            if (extras.containsKey(hintName)) {
                if (hintType.getValueType().equals(Void.class)) {
                    // Void hints are just flags: use the constant specified by the DecodeHintType
                    hints.put(hintType, Boolean.TRUE);
                } else {
                    Object hintData = extras.get(hintName);
                    if (hintType.getValueType().isInstance(hintData)) {
                        hints.put(hintType, hintData);
                    } else {
                        Log.w(TAG, "Ignoring hint " + hintType + " because it is not assignable from " + hintData);
                    }
                }
            }
        }

        Log.i(TAG, "Hints from the Intent: " + hints);
        return hints;
    }

}
