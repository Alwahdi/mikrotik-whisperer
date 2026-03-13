import * as Haptics from "expo-haptics";

/** Light tap — used for toggles, chip selection, tab switches */
export const lightTap = () => Haptics.impactAsync(Haptics.ImpactFeedbackStyle.Light);

/** Medium tap — used for buttons, list items */
export const mediumTap = () => Haptics.impactAsync(Haptics.ImpactFeedbackStyle.Medium);

/** Heavy tap — used for destructive actions */
export const heavyTap = () => Haptics.impactAsync(Haptics.ImpactFeedbackStyle.Heavy);

/** Success notification — used on successful operations */
export const notifySuccess = () =>
  Haptics.notificationAsync(Haptics.NotificationFeedbackType.Success);

/** Error notification — used on failed operations */
export const notifyError = () =>
  Haptics.notificationAsync(Haptics.NotificationFeedbackType.Error);

/** Warning notification — used for caution-worthy actions */
export const notifyWarning = () =>
  Haptics.notificationAsync(Haptics.NotificationFeedbackType.Warning);

/** Selection changed — used for picker/filter changes */
export const selectionChanged = () => Haptics.selectionAsync();
