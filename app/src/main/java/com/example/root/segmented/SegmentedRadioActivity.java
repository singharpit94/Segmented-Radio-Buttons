/*
 * Copyright (C) 2011 Make Ramen, LLC
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

package com.example.root.segmented;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.OutputStreamWriter;
public class SegmentedRadioActivity extends Activity implements OnCheckedChangeListener {

	com.example.root.segmented.SegmentedRadioGroup segmentText;
	com.example.root.segmented.SegmentedRadioGroup segmentText2;
	com.example.root.segmented.SegmentedRadioGroup segmentImg;
	Toast mToast;
	String x;
	String y;
	String content ="Response";

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		segmentText = (com.example.root.segmented.SegmentedRadioGroup) findViewById(R.id.segment_text);
		segmentText.setOnCheckedChangeListener(this);
		//segmentImg = (com.example.root.segmented.SegmentedRadioGroup) findViewById(R.id.segment_img);
		//segmentImg.setOnCheckedChangeListener(this);
		segmentText2 = (com.example.root.segmented.SegmentedRadioGroup) findViewById(R.id.segment_text2);
		segmentText2.setOnCheckedChangeListener(this);

		mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (group == segmentText) {
			if (checkedId == R.id.button_one) {
				mToast.setText("XOne");
				mToast.show();
				x="Xone";
			} else if (checkedId == R.id.button_two) {
				mToast.setText("XTwo");
				mToast.show();
				x="XTwo";
			} else if (checkedId == R.id.button_four) {
				mToast.setText("XThree");
				mToast.show();
				x="XThree";
			} else if (checkedId == R.id.button_three) {
				mToast.setText("XFour");
				mToast.show();
				x="Xfour";

			} else if (checkedId == R.id.button_five) {
				mToast.setText("XFive");
				mToast.show();
				x="XFive";

			}
		} /*else if (group == segmentImg) {
			if (checkedId == R.id.button_add) {
				mToast.setText("Add");
				mToast.show();
			} else if (checkedId == R.id.button_call) {
				mToast.setText("Call");
				mToast.show();
			} else if (checkedId == R.id.button_camera) {
				mToast.setText("Camera");
				mToast.show();
			}
		}*/ else if (group == segmentText2) {
			if (checkedId == R.id.button_one2) {
				mToast.setText("YOne");
				mToast.show();
				y="Yone";
			} else if (checkedId == R.id.button_two2) {
				mToast.setText("YTwo");
				mToast.show();
				y="Ytwo";
			} else if (checkedId == R.id.button_four2) {
				mToast.setText("YThree");
				mToast.show();
				y="Ythree";
			} else if (checkedId == R.id.button_three2) {
				mToast.setText("YFour");
				mToast.show();
				y="Yfour";

			} else if (checkedId == R.id.button_five2) {
				mToast.setText("YFive");
				mToast.show();
				y="Yfive";

			}
		}

	}
	public void SaveText(View view){

		try {

			File myFile = new File("/sdcard/mysdfile.txt");
			myFile.createNewFile();
			FileOutputStream fOut = new FileOutputStream(myFile,true);
			OutputStreamWriter myOutWriter =
					new OutputStreamWriter(fOut);
			myOutWriter.append(content);
			myOutWriter.append("\n");
			myOutWriter.append(x);
			myOutWriter.append("\n");
			myOutWriter.append(y);
			myOutWriter.append("\n");

			myOutWriter.close();
			fOut.close();

			Toast.makeText(this,"Text Saved !",Toast.LENGTH_LONG).show();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}



}