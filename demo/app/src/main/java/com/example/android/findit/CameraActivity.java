/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.findit;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewGroup;
/** Main {@code Activity} class for the Camera app. */
public class CameraActivity extends Activity {
    public static final String MYPRE ="myprefile";
    SharedPreferences settings;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);

      settings = getSharedPreferences(MYPRE ,0);

        if (null == savedInstanceState) {
          getFragmentManager()
                  .beginTransaction()
                  .replace(R.id.container, Camera2BasicFragment.newInstance())
                  .commit();
        }
      }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edit = settings.edit();
        edit.putInt("scores",Camera2BasicFragment.score);
        edit.commit();
        Camera2BasicFragment.score = 0;

    }


}
