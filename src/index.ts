import { registerPlugin } from "@capacitor/core";

import type { HmsAnalyticsPlugin } from "./definitions";

const HmsAnalytics = registerPlugin<HmsAnalyticsPlugin>(
  "HmsAnalytics",
  {
    web: () => null,
  }
);

export * from "./definitions";
export { HmsAnalytics };
