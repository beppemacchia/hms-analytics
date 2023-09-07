# hms-analytics

A native plugin for HMS Analytics.

## Install

```bash
npm install hms-analytics
npx cap sync
```

## API

<docgen-index>

* [`setUserId(...)`](#setuserid)
* [`setUserProfile(...)`](#setuserprofile)
* [`getAppInstanceId()`](#getappinstanceid)
* [`reset()`](#reset)
* [`onEvent(...)`](#onevent)
* [`setSessionDuration(...)`](#setsessionduration)
* [`enable()`](#enable)
* [`disable()`](#disable)
* [`enableLog()`](#enablelog)
* [`enableLogWithLevel(...)`](#enablelogwithlevel)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### setUserId(...)

```typescript
setUserId(options: { userId: string; }) => Promise<void>
```

| Param         | Type                             |
| ------------- | -------------------------------- |
| **`options`** | <code>{ userId: string; }</code> |

--------------------


### setUserProfile(...)

```typescript
setUserProfile(options: { name: string; value: string; }) => Promise<void>
```

| Param         | Type                                          |
| ------------- | --------------------------------------------- |
| **`options`** | <code>{ name: string; value: string; }</code> |

--------------------


### getAppInstanceId()

```typescript
getAppInstanceId() => Promise<{ instanceId: string; }>
```

**Returns:** <code>Promise&lt;{ instanceId: string; }&gt;</code>

--------------------


### reset()

```typescript
reset() => Promise<void>
```

--------------------


### onEvent(...)

```typescript
onEvent(options: { name: string; params: any; }) => Promise<void>
```

| Param         | Type                                        |
| ------------- | ------------------------------------------- |
| **`options`** | <code>{ name: string; params: any; }</code> |

--------------------


### setSessionDuration(...)

```typescript
setSessionDuration(options: { duration: number; }) => Promise<void>
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ duration: number; }</code> |

--------------------


### enable()

```typescript
enable() => Promise<void>
```

--------------------


### disable()

```typescript
disable() => Promise<void>
```

--------------------


### enableLog()

```typescript
enableLog() => Promise<void>
```

--------------------


### enableLogWithLevel(...)

```typescript
enableLogWithLevel(options: { logLevel: string; }) => Promise<void>
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ logLevel: string; }</code> |

--------------------

</docgen-api>
