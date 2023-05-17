/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}"],
  theme: {
    fontFamily: {
      dm: ["'DM Sans'", "sans-serif"],
      "dm-bold": ["'DM Sans Bold'", "sans-serif"],
    },
    colors: {
      transparent: "transparent",
      primary: "#121212",
      surface: "#232323",
      accent: "#1ed760",
      error: "#ff1245",
      "on-primary": "#eeeeee",
      "on-surface": "#e0e0e0",
      "on-accent": "#121212",
    },
    extend: {},
  },
  plugins: [],
};
