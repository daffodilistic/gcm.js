//
//   Copyright 2013 jordi domenech <http://iamyellow.net, jordi@iamyellow.net>
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//

package net.iamyellow.gcmjs;

import org.appcelerator.kroll.KrollRuntime;
import org.appcelerator.titanium.TiApplication.ActivityTransitionListener;

public class AppStateListener implements ActivityTransitionListener  {
	public boolean oneActivityIsResumed = true;

	@Override
	public void onActivityTransition (boolean state) {
		oneActivityIsResumed = !state;
		GcmjsModule.logd(">>>>>>>>>>>>> App is in " + (oneActivityIsResumed ? "FG" : "BG"));
	}

	public boolean isInFg () {
		if (!KrollRuntime.isInitialized()) {
			return false;
		}

		if (oneActivityIsResumed) {
			return true;
		}

		return false;
	}
}
