import EventSource from "eventsource";

/* =========================
   Config
========================= */
const ENDPOINT = "http://localhost:8080/api/ai/summary/stream";
const SYMBOL = "AAPL";
const DESCRIPTION = "Unusual volume detected";
const RECONNECT_DELAY = 3000;

/* =========================
   Colors
========================= */
const COLORS = {
  reset: "\x1b[0m",
  bold: "\x1b[1m",
  green: "\x1b[32m",
  yellow: "\x1b[33m",
  red: "\x1b[31m",
  cyan: "\x1b[36m",
  gray: "\x1b[90m"
};

const line = "────────────────────────────────────────";

/* =========================
   Helpers
========================= */
function println(color, text = "") {
  console.log(color + text + COLORS.reset);
}

function header() {
  console.clear();
  println(COLORS.cyan + COLORS.bold, "📈 MarketPulse AI Terminal");
  println(COLORS.gray, line);
  println(COLORS.gray, "Mode: Live AI Market Summary (Streaming)");
  println(COLORS.gray, `Symbol: ${SYMBOL}`);
  println(COLORS.gray, line + "\n");
}

/* =========================
   Streaming logic
========================= */
function connect() {
  header();
  println(COLORS.yellow, "🟡 Connecting to AI…\n");

  const url =
    `${ENDPOINT}?symbol=${SYMBOL}&description=` +
    encodeURIComponent(DESCRIPTION);

  const es = new EventSource(url);

  es.addEventListener("start", (e) => {
    println(COLORS.cyan, "▶️ " + e.data + "\n");
  });

  es.addEventListener("chunk", (e) => {
    println(COLORS.reset, "• " + e.data.trim());
  });

  es.addEventListener("end", (e) => {
    println("\n" + COLORS.green, "✅ " + e.data);
    println(COLORS.gray, line);
    es.close();
  });

  es.onerror = () => {
    println(COLORS.red, "\n⚠️ Connection lost. Reconnecting…");
    es.close();
    setTimeout(connect, RECONNECT_DELAY);
  };
}

connect();