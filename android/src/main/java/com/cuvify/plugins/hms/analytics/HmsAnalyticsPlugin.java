package com.cuvify.plugins.hms.analytics;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import com.getcapacitor.annotation.Permission;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

import org.json.JSONObject;

import java.util.Iterator;

@CapacitorPlugin(
        name = "HmsAnalytics",
        permissions = {
                @Permission(
                        strings = { Manifest.permission.ACCESS_NETWORK_STATE },
                        alias = "network"
                ),
                @Permission(strings = { Manifest.permission.INTERNET }, alias = "internet"),
                @Permission(
                        strings = { Manifest.permission.WAKE_LOCK },
                        alias = "wakelock"
                ),
        }
)
public class HmsAnalyticsPlugin extends Plugin {

    private HiAnalyticsInstance analyticsInstance;

    private final String MISSING_REF_MSSG = "HMS analytics is not initialized";

    @Override
    public void load() {
        super.load();

        // Obtain the FirebaseAnalytics instance.
        analyticsInstance = HiAnalytics.getInstance(getActivity().getApplicationContext());
    }

    /**
     * Sets the user ID property.
     * @param call - userId: unique identifier of the user to log
     */
    @PluginMethod
    public void setUserId(PluginCall call) {
        try {
            if (analyticsInstance == null) {
                call.reject(MISSING_REF_MSSG);
                return;
            }

            if (!call.hasOption("userId")) {
                call.reject("userId property is missing");
                return;
            }

            String userId = call.getString("userId");
            analyticsInstance.setUserId(userId);
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage());
        }
    }

    /**
     * Sets a user property to a given value.
     * @param call - name: The name of the user property to set.
     *               value: The value of the user property.
     */
    @PluginMethod
    public void setUserProfile(PluginCall call) {
        try {
            if (analyticsInstance == null) {
                call.reject(MISSING_REF_MSSG);
                return;
            }

            if (!call.hasOption("name")) {
                call.reject("name property is missing");
                return;
            }

            if (!call.hasOption("value")) {
                call.reject("value property is missing");
                return;
            }

            String name = call.getString("name");
            String value = call.getString("value");

            analyticsInstance.setUserProfile(name, value);
            call.resolve();
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage());
        }
    }

    /**
     * Retrieves the app instance id from the service.
     * @param call - instanceId: current instance if of the app
     */
    @PluginMethod
    public void getAppInstanceId(final PluginCall call) {
        try {
            if (analyticsInstance == null) {
                call.reject(MISSING_REF_MSSG);
                return;
            }

            analyticsInstance.getAAID().addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String aaid) {
                    JSObject result = new JSObject();
                    result.put("instanceId", aaid);
                    call.resolve(result);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(Exception ex) {
                    call.reject(ex.getLocalizedMessage());
                }
            });

        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage());
        }
    }

    /**
     * Clears all analytics data for this app from the device and resets the app instance id.
     * @param call
     */
    @PluginMethod
    public void reset(PluginCall call) {
        try {
            if (analyticsInstance == null) {
                call.reject(MISSING_REF_MSSG);
                return;
            }

            analyticsInstance.clearCachedData();
            call.resolve();
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage());
        }
    }

    /**
     * Logs an app event.
     * @param call - name: unique name of the event
     *               params: the map of event parameters.
     */
    @PluginMethod
    public void onEvent(PluginCall call) {

        try {
            if (analyticsInstance == null) {
                call.reject(MISSING_REF_MSSG);
                return;
            }

            if (!call.hasOption("name")) {
                call.reject("name property is missing");
                return;
            }

            String name = call.getString("name");
            JSObject data = call.getData();
            JSONObject params = data.getJSObject("params");
            Bundle bundle = new Bundle();

            if (params != null) {
                Iterator<String> keys = params.keys();

                while (keys.hasNext()) {
                    String key = keys.next();
                    Object value = params.get(key);

                    if (value instanceof String) {
                        bundle.putString(key, (String) value);
                    } else if (value instanceof Integer) {
                        bundle.putInt(key, (Integer) value);
                    } else if (value instanceof Double) {
                        bundle.putDouble(key, (Double) value);
                    } else if (value instanceof Long) {
                        bundle.putLong(key, (Long) value);
                    } else {
                        call.reject("value for " + key + " is missing");
                    }
                }
            }

            analyticsInstance.onEvent(name, bundle);
            call.resolve();
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage());
        }
    }

    /**
     * Enable analytics collection for this app on this device.
     * @param call - enabled: boolean true/false to enable/disable logging
     */
    @PluginMethod
    public void enable(PluginCall call) {
        if (analyticsInstance == null) {
            call.reject(MISSING_REF_MSSG);
            return;
        }

        analyticsInstance.setAnalyticsEnabled(true);
        call.resolve();
    }

    /**
     * Disable analytics collection for this app on this device.
     * @param call
     */
    @PluginMethod
    public void disable(PluginCall call) {
        if (analyticsInstance == null) {
            call.reject(MISSING_REF_MSSG);
            return;
        }

        analyticsInstance.setAnalyticsEnabled(false);
        call.resolve();
    }

    /**
     * Sets the duration of inactivity that terminates the current session.
     * @param call: options - duration: duration of inactivity
     */
    @PluginMethod
    public void setSessionDuration(PluginCall call) {
        if (analyticsInstance == null) {
            call.reject(MISSING_REF_MSSG);
            return;
        }

        int duration = call.getInt("duration", 1800);

        analyticsInstance.setSessionDuration(duration);
        call.resolve();
    }

    //---------------------------------------------------------------------------------------------
    // HiAnalyticsTools
    //---------------------------------------------------------------------------------------------

    @PluginMethod
    public void enableLog(PluginCall call) {
        HiAnalyticsTools.enableLog();
        call.resolve();
    }

    @PluginMethod
    public void enableLogWithLevel(PluginCall call) {
        String level = call.getString("logLevel");

        Integer intValueOfLevel;

        try {
            intValueOfLevel = Integer.valueOf(level).intValue();
        } catch (IllegalArgumentException ex) {
            Log.e("HMS_ANALYTICS", "Invalid log level. level = " + level);
            call.reject("Invalid log level. level = " + level);
            return;
        }
        HiAnalyticsTools.enableLog(intValueOfLevel);
        call.resolve();
    }
}
