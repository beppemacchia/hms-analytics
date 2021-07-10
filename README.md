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
setUserId(options: { userId: string; }) => any
```

| Param         | Type                             |
| ------------- | -------------------------------- |
| **`options`** | <code>{ userId: string; }</code> |

**Returns:** <code>any</code>

--------------------


### setUserProfile(...)

```typescript
setUserProfile(options: { name: string; value: string; }) => any
```

| Param         | Type                                          |
| ------------- | --------------------------------------------- |
| **`options`** | <code>{ name: string; value: string; }</code> |

**Returns:** <code>any</code>

--------------------


### getAppInstanceId()

```typescript
getAppInstanceId() => any
```

**Returns:** <code>any</code>

--------------------


### reset()

```typescript
reset() => any
```

**Returns:** <code>any</code>

--------------------


### onEvent(...)

```typescript
onEvent(options: { name: string; params: any; }) => any
```

| Param         | Type                                        |
| ------------- | ------------------------------------------- |
| **`options`** | <code>{ name: string; params: any; }</code> |

**Returns:** <code>any</code>

--------------------


### setSessionDuration(...)

```typescript
setSessionDuration(options: { duration: number; }) => any
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ duration: number; }</code> |

**Returns:** <code>any</code>

--------------------


### enable()

```typescript
enable() => any
```

**Returns:** <code>any</code>

--------------------


### disable()

```typescript
disable() => any
```

**Returns:** <code>any</code>

--------------------


### enableLog()

```typescript
enableLog() => any
```

**Returns:** <code>any</code>

--------------------


### enableLogWithLevel(...)

```typescript
enableLogWithLevel(options: { logLevel: string; }) => any
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ logLevel: string; }</code> |

**Returns:** <code>any</code>

--------------------

</docgen-api>
