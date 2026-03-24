import { Redirect } from "expo-router";

export default function Index() {
  // Redirect to auth screen by default
  return <Redirect href="/auth" />;
}
