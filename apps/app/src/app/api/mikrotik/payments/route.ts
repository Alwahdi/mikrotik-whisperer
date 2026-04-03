import { NextResponse } from "next/server";
import { withRouter, getPayments } from "@repo/mikrotik/server";
import { getRouterSession } from "@repo/mikrotik/session";

export async function GET() {
  try {
    const session = await getRouterSession();
    if (!session.isLoggedIn || !session.router) {
      return NextResponse.json({ error: "Not connected" }, { status: 401 });
    }

    const { host, port, user, password } = session.router;

    const data = await withRouter(host, port, user, password, async (api, version) =>
      getPayments(api, version)
    );

    return NextResponse.json(data);
  } catch (error: unknown) {
    const message = error instanceof Error ? error.message : JSON.stringify(error);
    return NextResponse.json({ error: message }, { status: 500 });
  }
}
