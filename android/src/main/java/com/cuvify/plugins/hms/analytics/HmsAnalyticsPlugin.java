package com.cuvify.plugins.hms.analytics;

import android.Manifest;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import com.getcapacitor.annotation.Permission;

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

    private final String MISSING_REF_MSSG = "HMS analytics is not initialized";

    @Override
    public void load() {
        super.load();
    }

    /**
     * Sets the user ID property.
     * @param call - userId: unique identifier of the user to log
     */
    @PluginMethod
    public void setUserId(PluginCall call) {
       call.resolve();
    }

    /**
     * Sets a user property to a given value.
     * @param call - name: The name of the user property to set.
     *               value: The value of the user property.
     */
    @PluginMethod
    public void setUserProfile(PluginCall call) {
        call.resolve();
    }

    /**
     * Retrieves the app instance id from the service.
     * @param call - instanceId: current instance if of the app
     */
    @PluginMethod
    public void getAppInstanceId(final PluginCall call) {
        JSObject result = new JSObject();
        result.put("instanceId", "0");
        call.resolve(result);
    }

    /**
     * Clears all analytics data for this app from the device and resets the app instance id.
     * @param call
     */
    @PluginMethod
    public void reset(PluginCall call) {
        call.resolve();
    }

    /**
     * Logs an app event.
     * @param call - name: unique name of the event
     *               params: the map of event parameters.
     */
    @PluginMethod
    public void onEvent(PluginCall call) {
        call.resolve();
    }

    /**
     * Enable analytics collection for this app on this device.
     * @param call - enabled: boolean true/false to enable/disable logging
     */
    @PluginMethod
    public void enable(PluginCall call) {
        call.resolve();
    }

    /**
     * Disable analytics collection for this app on this device.
     * @param call
     */
    @PluginMethod
    public void disable(PluginCall call) {
        call.resolve();
    }

    /**
     * Sets the duration of inactivity that terminates the current session.
     * @param call: options - duration: duration of inactivity
     */
    @PluginMethod
    public void setSessionDuration(PluginCall call) {
        call.resolve();
    }

    //---------------------------------------------------------------------------------------------
    // HiAnalyticsTools
    //---------------------------------------------------------------------------------------------

    @PluginMethod
    public void enableLog(PluginCall call) {
        call.resolve();
    }

    @PluginMethod
    public void enableLogWithLevel(PluginCall call) {
        call.resolve();
    }
}
