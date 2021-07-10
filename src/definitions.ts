export interface HmsAnalyticsPlugin {
  setUserId(options: {
    userId: string;
  }): Promise<void>;
  setUserProfile(options: {
    name: string;
    value: string;
  }): Promise<void>;
  getAppInstanceId(): Promise<{
    instanceId: string;
  }>;
  reset(): Promise<void>;
  onEvent(options: {
    name: string;
    params: any;
  }): Promise<void>;
  setSessionDuration(options: {
    duration: number;
  }): Promise<void>;
  enable(): Promise<void>;
  disable(): Promise<void>;
  // HiAnalyticsTools
  enableLog(): Promise<void>;
  enableLogWithLevel(options: {
    logLevel: string;
  }): Promise<void>;
}
