export interface HmsAnalyticsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
