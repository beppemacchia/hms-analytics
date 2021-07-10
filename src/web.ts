import { WebPlugin } from '@capacitor/core';

import type { HmsAnalyticsPlugin } from './definitions';

export class HmsAnalyticsWeb extends WebPlugin implements HmsAnalyticsPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
