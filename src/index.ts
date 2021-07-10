import { registerPlugin } from '@capacitor/core';

import type { HmsAnalyticsPlugin } from './definitions';

const HmsAnalytics = registerPlugin<HmsAnalyticsPlugin>('HmsAnalytics', {
  web: () => import('./web').then(m => new m.HmsAnalyticsWeb()),
});

export * from './definitions';
export { HmsAnalytics };
